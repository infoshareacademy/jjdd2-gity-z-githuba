package pl.infoshareacademy.Web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.mail.mailparser.EmlParser;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "uploads";
    private static final Logger logger = LogManager.getLogger(FileUploadServlet.class.getName());

    Set<String> uploadStatusOK = new HashSet<>();
    Set<String> uploadStatusNotOK = new HashSet<>();
    Set<String> uploadStatusOKButWarn = new HashSet<>();
    Set<String> isParsableCheck = new HashSet<>();

    @Inject
    TempFilePath filePath;
    @Inject
    MailBox mailBox;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
            logger.warn("Folder {} does not exist! Creating new one...", UPLOAD_DIR);
        }

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if (isOK(part)) {
                try {
                    part.write(uploadFilePath + File.separator + fileName);
                    isParsableCheck.add(uploadFilePath + File.separator + fileName);
                    logger.info("Saved {} on upload directory!", fileName);
                    //isParsable();
                } catch (FileAlreadyExistsException e) {
                    uploadStatusNotOK.add(part.getSubmittedFileName().toUpperCase() +
                            ": that file is already on the list");
                }
                if (!isParsable()) {
                    uploadStatusOKButWarn.add(part.getSubmittedFileName().toUpperCase() +
                            ": contains some lock markers that can cause our program to display messages incorrectly");
                }
            }
        }

        filePath.setTempFilePath(uploadFilePath + File.separator + fileName);

        request.setAttribute("fileOK", uploadStatusOK);
        request.setAttribute("fileNotOK", uploadStatusNotOK);
        request.setAttribute("fileWarn", uploadStatusOKButWarn);
        getServletContext().getRequestDispatcher("/jsp/choice.jsp").forward(
                request, response);
    }

    private boolean isOK(Part part) {
        if(part.getSubmittedFileName() == null) {
            uploadStatusNotOK.add("File to upload not selected");
            logger.info("upload with no file selected");
            return false;
        }

        if (!((part.getContentType().contains("mbox")) || (part.getContentType().contains("rfc822")))) {
            uploadStatusNotOK.add(part.getSubmittedFileName().toUpperCase() + ": is not an mbox/eml file type");
            logger.info("Added {} to NotOK:not an mbox/eml file type!", part.getSubmittedFileName());
            return false;
        }

        if (part.getSize() == 0) {
            uploadStatusNotOK.add(part.getSubmittedFileName().toUpperCase() + ": is empty");
            logger.info("Added {} to NotOK:empty", part.getSubmittedFileName());
            return false;
        }

        uploadStatusOK.add(part.getSubmittedFileName().toUpperCase() + ": uploaded");
        return true;
    }

    private boolean isParsable() {
        for (String parse : isParsableCheck) {
            if (parse.endsWith("mbox")) {
                MboxParser mboxParser = new MboxParser(parse);
                try {
                    mboxParser.run(mailBox);
                } catch (Exception e) {
                    logger.warn("cant parse mbox: {}", parse);
                    return false;
                }
            } else /*if (parse.endsWith("eml")) */{
                try {
                    EmlParser.parseEml(parse, mailBox);
                } catch (Exception e) {
                    logger.warn("cant parse eml: {}", parse);
                    return false;
                }
            } /*else {
                logger.error("Invalid parsableCheck: {}", parse);
            }*/
        }
        return true;
    }

    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
