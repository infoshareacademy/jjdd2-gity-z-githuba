package pl.infoshareacademy.Web.portal;

import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.service.LogDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/checkFiles")
public class FileCheckServlet extends HttpServlet {

    @Inject
    TempFilePath filePath;

    @Inject
    LogDAO logDAO;

    private static final String UPLOAD_DIR = "/uploads";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String absolutePathToUpload = getServletContext().getRealPath(UPLOAD_DIR);
        File fileSaveDir = new File(absolutePathToUpload);
        if (!fileSaveDir.exists()) {
            logDAO.saveLogToDatabase("WARNING", "Upload folder does not exist");
            req.setAttribute("Error", "UPLOAD FOLDER DOES NOT EXIST!");
            req.getRequestDispatcher("/shared/check_files.jsp").forward(req, resp);
        }
        File[] listOfFilesInUploadFolder = fileSaveDir.listFiles();
        if (listOfFilesInUploadFolder == null) {
            logDAO.saveLogToDatabase("WARNING", "List of uploaded files is empty");
            resp.sendError(404);
            return;
        }
        ArrayList<String> positiveFiles = new ArrayList<>();
        ArrayList<String> negativeFiles = new ArrayList<>();
        for (int i = 0; i < listOfFilesInUploadFolder.length; i++) {
            if (listOfFilesInUploadFolder[i].getName().contains(".eml")
                    || listOfFilesInUploadFolder[i].getName().contains(".mbox")) {
                positiveFiles.add(listOfFilesInUploadFolder[i].getName());
            } else {
                negativeFiles.add(listOfFilesInUploadFolder[i].getName());
            }
        }*/
        req.setAttribute("fileOK", filePath.getUploadStatusOK());
        req.setAttribute("fileNotOK", filePath.getUploadStatusNotOK());
        req.setAttribute("fileWarn", filePath.getUploadStatusOKButWarn());
        getServletContext().getRequestDispatcher("/shared/check_files.jsp").forward(req, resp);
    }
}