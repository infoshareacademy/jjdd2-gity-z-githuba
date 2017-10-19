package pl.infoshareacademy.Web;

import pl.infoshareacademy.mail.TempFilePath;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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
        String CheckboxWord = req.getParameter("searchword");
        String CheckboxWebsite = req.getParameter("Websites");
        String CheckboxPhone = req.getParameter("Phonenumbers");
        String CheckboxEmails = req.getParameter("Emails");

        if (fourAnswer.isEmpty()) {
            listOfSearchKeywords.add("Empty box");
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        } else {
            String[] listofwords =fourAnswer.split(",");
            listOfSearchKeywords.addAll(Arrays.asList(listofwords));
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        }
        System.out.println(CheckboxWord);
        req.setAttribute("searchword",CheckboxWord);
        resp.sendRedirect("display");

    }
}