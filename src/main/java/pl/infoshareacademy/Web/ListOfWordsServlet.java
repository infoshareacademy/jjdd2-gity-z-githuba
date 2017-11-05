package pl.infoshareacademy.Web;

import pl.infoshareacademy.mail.QuestionsAndAnswers;
import pl.infoshareacademy.mail.TempFilePath;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/words")
public class ListOfWordsServlet extends HttpServlet {

    @Inject
    TempFilePath listOfKeywords;

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        QuestionsAndAnswers question = new QuestionsAndAnswers();
        String firstAnswer = req.getParameter("question1");
        String secondAnswer = req.getParameter("question2");
        String thirdAnswer = req.getParameter("question3");

        ArrayList<String> listOfSearchKeywords = new ArrayList<>();

        switch (firstAnswer) {
            case "Yes":
                req.setAttribute("question1Yes", question.getListOfAnswersIfYes().get(0));
                listOfSearchKeywords.addAll(question.getListOfAnswersIfYes().get(0));
                break;
            case "No":
                req.setAttribute("question1No", question.getListOfAnswersIfNo().get(0));
                listOfSearchKeywords.addAll((question.getListOfAnswersIfNo().get(0)));
                break;
        }

        switch (secondAnswer) {
            case "Yes":
                req.setAttribute("question2Yes", question.getListOfAnswersIfYes().get(1));
                listOfSearchKeywords.addAll((question.getListOfAnswersIfYes().get(1)));
                break;
            case "No":
                req.setAttribute("question2No", question.getListOfAnswersIfNo().get(1));
                listOfSearchKeywords.addAll((question.getListOfAnswersIfNo().get(1)));
                break;
        }

        switch (thirdAnswer) {
            case "Yes":
                req.setAttribute("question3Yes", question.getListOfAnswersIfYes().get(2));
                listOfSearchKeywords.addAll((question.getListOfAnswersIfYes().get(2)));
                break;
            case "No":
                req.setAttribute("question3No", question.getListOfAnswersIfNo().get(2));
                listOfSearchKeywords.addAll((question.getListOfAnswersIfNo().get(2)));
                break;
        }
        listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        resp.sendRedirect("display");
    }
}