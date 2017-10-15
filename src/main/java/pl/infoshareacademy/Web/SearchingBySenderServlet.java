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
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/sender")
public class SearchingBySenderServlet extends HttpServlet {

    @Inject
    TempFilePath filePath;

    @Inject
    TempFilePath listOfKeywords;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> listOfSearchKeywords = new ArrayList<>();
        String fourAnswer =req.getParameter("sender");
        PrintWriter out =resp.getWriter();

        if (fourAnswer.isEmpty()) {
            listOfSearchKeywords.add("Empty box");
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        } else {
            String[] listofwords =fourAnswer.split(",");
            listOfSearchKeywords.addAll(Arrays.asList(listofwords));
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("You enter<br>");
        out.println(fourAnswer);
        out.println("<br>");
        out.println("<A HREF=\"display\">Display result</A>");
        out.println("<A HREF=\"sender\">Change words</A>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Searching by keywords</h1>");
        writer.println("<form method=\"post\" action=\"sender\">");
        writer.println("<input type=\"text\" name=\"sender\"><br>");
        writer.println("<button type=\"submit\">Give me mail with keywords</button>");
        writer.println("<p>"+filePath.getTempFilePath()+"</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}