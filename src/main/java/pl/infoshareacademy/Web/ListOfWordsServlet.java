package pl.infoshareacademy.Web;


import pl.infoshareacademy.mail.QuestionsAndAnswers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/words")

public class ListOfWordsServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();

//        QuestionsAndAnswers question = new QuestionsAndAnswers();

        String firstAnswer = (String) session.getAttribute("firstAnswer");
        String secondAnswer = (String)session.getAttribute("secondAnswer");
        String thirdAnswer = (String)session.getAttribute("thirdAnswer");

        writer.println(firstAnswer);
        writer.println(secondAnswer);
        writer.println(thirdAnswer);

        writer.println("These keywords might be helpful for you: ");

/*        switch (firstAnswer) {
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
        }*/

    }
}