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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCheckBox(req);
        String toLanguage = req.getParameter("tolanguage");
        String fourAnswer = req.getParameter("sender");
        addSearchingWordtoArrayBean(fourAnswer);
        doTranslate("AIzaSyBBA8MWaqJbghdmVE6ven-yX6Oma0OSZ3A",fourAnswer,toLanguage);

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
    private void doTranslate(String API_KEY, String word,String toLanguage) {
        if (toLanguage.equals("no")) {
        }else {
            GoogleTranslate googleTranslate = new GoogleTranslate(API_KEY);
            List<String> keywordsFromServletForm = listOfKeywords.getKeywordsFromServletForm();
            keywordsFromServletForm.add(googleTranslate.translate(word,"",toLanguage));
            listOfKeywords.setKeywordsFromServletForm(keywordsFromServletForm);
        }
    }
}