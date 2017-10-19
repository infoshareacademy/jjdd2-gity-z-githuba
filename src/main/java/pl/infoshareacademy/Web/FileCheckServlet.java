package pl.infoshareacademy.Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/checkFiles")
public class FileCheckServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "/uploads";
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String absolutePathToUpload = getServletContext().getRealPath(UPLOAD_DIR);
        File fileSaveDir = new File(absolutePathToUpload);
        if (!fileSaveDir.exists()) {
            req.setAttribute("Error", "UPLOAD FOLDER DOES NOT EXISTS!");
            req.getRequestDispatcher("/shared/check_files.jsp").forward(req, resp);
        }
        File[] listOfFilesInUploadFolder = fileSaveDir.listFiles();
        ArrayList<String> positiveFiles = new ArrayList<>();
        ArrayList<String> negativeFiles = new ArrayList<>();
        for (int i = 0; i < listOfFilesInUploadFolder.length; i++) {
            if (listOfFilesInUploadFolder[i].getName().contains(".eml")
                    || listOfFilesInUploadFolder[i].getName().contains(".mbox")) {
                positiveFiles.add(listOfFilesInUploadFolder[i].getName());
            } else {
                negativeFiles.add(listOfFilesInUploadFolder[i].getName());
            }
        }
        req.setAttribute("positiveFiles", positiveFiles);
        req.setAttribute("negativeFiles", negativeFiles);
        getServletContext().getRequestDispatcher("/shared/check_files.jsp").forward(req, resp);
    }


}
