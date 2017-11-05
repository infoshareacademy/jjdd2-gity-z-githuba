package pl.infoshareacademy.Web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;
import pl.infoshareacademy.service.LogDAO;
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
import java.util.List;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;
    private static final String UPLOAD_DIR = "uploads";

    @Inject
    TempFilePath filePath;

    @Inject
    LogDAO logDAO;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String uploadStatus;
        String applicationPath = request.getServletContext().getRealPath("");
        logDAO.saveLogToDatabase("INFO", "Aplication Path: " + applicationPath);
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            logDAO.saveLogToDatabase("INFO", "Upload folder does not exist. Creating new one " + UPLOAD_DIR);
            fileSaveDir.mkdirs();
        }
        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
        logDAO.saveLogToDatabase("INFO", "Saved file to upload directory! " + fileName);
        filePath.setTempFilePath(uploadFilePath + File.separator + fileName);
        MailBox mailBox = new MailBox();
        MboxParser mboxParser = new MboxParser(filePath.getTempFilePath());
        mboxParser.run(mailBox);
        List<Email> testUploadFile = mailBox.getMailbox();
        if (!(filePath.getTempFilePath().endsWith("mbox") || filePath.getTempFilePath().endsWith("eml"))) {
            uploadStatus = fileName + " is not an mbox/eml file";
        } else if (testUploadFile.isEmpty()){
            uploadStatus = fileName + " contains unsupported markers or is corrupted";
        } else {
            uploadStatus = fileName + " uploaded successfully!";
        }
        request.setAttribute("message", uploadStatus);
        request.setAttribute("message2", uploadFilePath + File.separator + fileName);
        response.sendRedirect("jsp/choice.jsp");
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