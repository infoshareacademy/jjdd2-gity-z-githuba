package pl.infoshareacademy.Web;


import pl.infoshareacademy.mail.QuestionsAndAnswers;

import javax.print.DocFlavor;
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

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
//
        QuestionsAndAnswers question = new QuestionsAndAnswers();

        String firstAnswer = req.getParameter("question1");
        String secondAnswer = req.getParameter("question2");
        String thirdAnswer = req.getParameter("question3");

        writer.println("These keywords might be helpful for you: ");

        switch (firstAnswer) {
            case "Yes":
                writer.println("<br>");
                writer.println(question.getListOfAnswersIfYes().get(0));
                break;
            case "No":
                writer.println("<br>");
                writer.println(question.getListOfAnswersIfNo().get(0));
                break;
        }

        switch (secondAnswer) {
            case "Yes":
                writer.println("<br>");
                writer.println(question.getListOfAnswersIfYes().get(1));
                break;
            case "No":
                writer.println("<br>");
                writer.println(question.getListOfAnswersIfNo().get(1));
                break;
        }

        switch (thirdAnswer) {
            case "Yes":
                writer.println("<br>");
                writer.println(question.getListOfAnswersIfYes().get(2));
                break;
            case "No":
                writer.println("<br>");
                writer.println(question.getListOfAnswersIfNo().get(2));
                break;
        }

    }
}