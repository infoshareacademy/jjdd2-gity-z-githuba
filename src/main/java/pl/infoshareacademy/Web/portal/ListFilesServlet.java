package pl.infoshareacademy.Web.portal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/list")
public class ListFilesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String relativePath = "/uploads";
        String absoluteDiskPath = getServletContext()
                .getRealPath(relativePath);

        File folder = new File(absoluteDiskPath);
        File[] listOfFiles = folder.listFiles();
        final PrintWriter writer = response.getWriter();
        writer.println(absoluteDiskPath);

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                writer.println("File: "
                        + listOfFiles[i].getName()
                        + "     "
                        + listOfFiles[i].toPath());
            } else if (listOfFiles[i].isDirectory()) {
                writer.println("Directory: "
                        + listOfFiles[i].getName());
            }
        }
    }
}
