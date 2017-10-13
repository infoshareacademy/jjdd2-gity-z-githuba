package pl.infoshareacademy.Web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/keywords")
public class SearchingByKeyWordsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Is this an urgent message?");
        writer.println("<br>");
        writer.println("<form method=\"post\" action=\"keywords\">");
        writer.println("<select name=\"question1\">");
        writer.println("<option value=\"Yes\">Yes</option>");
        writer.println("<option value=\"No\">No</option>");
        writer.println("</select>"); 
        writer.println("<br>");
        writer.println("Is this a formal message?");
        writer.println("<br>");
        writer.println("<form method=\"post\" action=\"keywords\">");
        writer.println("<select name=\"question2\">");
        writer.println("<option value=\"Yes\">Yes</option>");
        writer.println("<option value=\"No\">No</option>");
        writer.println("</select>");
        writer.println("<br>");
        writer.println("Is this an important message");
        writer.println("<br>");
        writer.println("<form method=\"post\" action=\"keywords\">");
        writer.println("<select name=\"question3\">");
        writer.println("<option value=\"Yes\">Yes</option>");
        writer.println("<option value=\"No\">No</option>");
        writer.println("</select>");
        writer.println("<br><br>");
        writer.println("<button type=\"submit\">Give me the list of keywords!</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstAnswer = req.getParameter("question1");
        String secondAnswer = req.getParameter("question2");
        String thirdAnswer = req.getParameter("question3");
        req.setAttribute("firstAnswer", firstAnswer);
        req.setAttribute("secondAnswer", secondAnswer);
        req.setAttribute("thirdAnswer", thirdAnswer);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/words");
        dispatcher.forward(req, resp);
    }

}