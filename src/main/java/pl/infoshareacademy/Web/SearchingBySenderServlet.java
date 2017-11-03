package pl.infoshareacademy.Web;

import pl.infoshareacademy.TranslateAPI.GoogleTranslate;
import pl.infoshareacademy.mail.TempFilePath;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/sender")
public class SearchingBySenderServlet extends HttpServlet {

    @Inject
    TempFilePath filePath;

    @Inject
    TempFilePath listOfKeywords;

    String toLanguage;
    String fromLanguage;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCheckBox(req);

        fromLanguage = req.getParameter("fromLanguage");
        toLanguage = req.getParameter("toLanguage");
        String fourAnswer = req.getParameter("sender");

        addSearchingWordtoArrayBean(fourAnswer);
        doTranslate("KEY");

        resp.sendRedirect("display");
    }

    private void addSearchingWordtoArrayBean(String fourAnswer) {
        List<String> listOfSearchKeywords = new ArrayList<>();
        if (fourAnswer.isEmpty()) {
            listOfSearchKeywords.add("Empty");
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        } else {
            String[] listofwords = fourAnswer.split(",");
            listOfSearchKeywords.addAll(Arrays.asList(listofwords));
            listOfKeywords.setKeywordsFromServletForm(listOfSearchKeywords);
        }
    }

    private void setCheckBox(HttpServletRequest req) {
        filePath.setCheckboxWord(req.getParameter("searchWord"));
        filePath.setCheckboxWebsite(req.getParameter("Websites"));
        filePath.setCheckboxPhone(req.getParameter("Phonenumbers"));
        filePath.setCheckboxEmails(req.getParameter("Emails"));
    }
    private List<String>  doTranslate(String API_KEY) {
        GoogleTranslate googleTranslate = new GoogleTranslate(API_KEY);
        List<String> listOfSearchKeywords = new ArrayList<>();
        for (String list:listOfSearchKeywords) {
            listOfSearchKeywords.add(googleTranslate.translate(list,fromLanguage,toLanguage));
        }
        return listOfSearchKeywords;
    }
}