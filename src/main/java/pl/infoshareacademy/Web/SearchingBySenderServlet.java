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
        setCheckBox(req);
        String fourAnswer = req.getParameter("sender");
        addSearchingWordtoArrayBean(fourAnswer);
        resp.sendRedirect("display");
    }

    private void addSearchingWordtoArrayBean(String fourAnswer) {
        ArrayList<String> listOfSearchKeywords = new ArrayList<>();
        if (fourAnswer.isEmpty()|| fourAnswer==null) {
            listOfSearchKeywords.add("Empty");
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        } else {
            String[] listOfWords = fourAnswer.split(",");
            listOfSearchKeywords.addAll(Arrays.asList(listOfWords));
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        }
    }

    private void setCheckBox(HttpServletRequest req) {
        filePath.setCheckboxWord(req.getParameter("searchWord"));
        filePath.setCheckboxWebsite(req.getParameter("Websites"));
        filePath.setCheckboxPhone(req.getParameter("Phonenumbers"));
        filePath.setCheckboxEmails(req.getParameter("Emails"));
    }
}