package pl.infoshareacademy.Web;


import pl.infoshareacademy.mail.TempFilePath;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/sender")

public class SearchingBySenderServlet extends HttpServlet {

    @Inject
    TempFilePath filePath;

    @Inject
    TempFilePath listOfKeywords;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Searching by sender</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}