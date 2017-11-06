package pl.infoshareacademy.Web.portal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.mail.mailparser.EmlParser;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;
import pl.infoshareacademy.service.LogDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;
    private static final String UPLOAD_DIR = "uploads";
    private static final Logger logger = LogManager.getLogger(FileUploadServlet.class.getName());

    @Inject
    TempFilePath filePath;

    @Inject
    LogDAO logDAO;



    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Set<String> uploadStatusOK = new HashSet<>();
        Set<String> uploadStatusNotOK = new HashSet<>();
        Set<String> uploadStatusOKButWarn = new HashSet<>();
        Set<String> isParsableCheck = new HashSet<>();

        String applicationPath = request.getServletContext().getRealPath("");
        logDAO.saveLogToDatabase("INFO", "Aplication Path: " + applicationPath);
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            logDAO.saveLogToDatabase("INFO", "Upload folder does not exist. Creating new one");
            fileSaveDir.mkdirs();
        }

        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if (isValidMailFile(part, uploadStatusNotOK, uploadStatusOK)) {
                try {
                    part.write(uploadFilePath + File.separator + fileName);
                    isParsableCheck.add(uploadFilePath + File.separator + fileName);
                    logger.info("Saved {} on upload directory!", fileName);
                } catch (FileAlreadyExistsException e) {
                    uploadStatusNotOK.add(part.getSubmittedFileName() +
                            ": that file is already on the list");
                }
            }
        }

        filePath.setUploadStatusOK(uploadStatusOK);
        filePath.setUploadStatusOKButWarn(uploadStatusOKButWarn);
        filePath.setUploadStatusNotOK(uploadStatusNotOK);
        filePath.setIsParsableCheck(isParsableCheck);
        filePath.setTempFilePath(uploadFilePath + File.separator + fileName);

        HttpSession session = request.getSession();
        session.setAttribute("fileOK", uploadStatusOK);
        session.setAttribute("fileNotOK", uploadStatusNotOK);
        session.setAttribute("fileWarn", uploadStatusOKButWarn);
//        getServletContext().getRequestDispatcher("/shared/check_files.jsp").forward(
//                request, response);
        response.sendRedirect("checkFiles");
    }

    private boolean isValidMailFile(Part part, Set<String> uploadStatusNotOK, Set<String> uploadStatusOK) {
        if (part.getSubmittedFileName() == null) {
            uploadStatusNotOK.add("File to upload not selected");
            logDAO.saveLogToDatabase("WARNING", "Upload with no files selected");
            return false;
        }

        if (!((part.getContentType().contains("mbox")) || (part.getContentType().contains("rfc822")))) {
            uploadStatusNotOK.add(part.getSubmittedFileName() + ": is not an mbox/eml file type");
            logDAO.saveLogToDatabase("INFO", "Added {} to NotOK:not an mbox/eml file type!" + part.getSubmittedFileName());
            return false;
        }

        if (part.getSize() == 0) {
            uploadStatusNotOK.add(part.getSubmittedFileName() + ": is empty");
            logDAO.saveLogToDatabase("INFO", "Added {} to NotOK:empty" + part.getSubmittedFileName());
            return false;
        }

        uploadStatusOK.add(part.getSubmittedFileName() + ": uploaded");
        return true;
    }

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