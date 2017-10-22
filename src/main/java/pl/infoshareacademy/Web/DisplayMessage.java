package pl.infoshareacademy.Web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.ContactFinder;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.StatisticBean;
import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.mail.mailparser.EmlParser;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/display")
public class DisplayMessage extends HttpServlet {
    @Inject
    TempFilePath filePath;
    @Inject
    MailBox mailBox;
    @Inject
    StatisticBean statisticBean;
    private static final Logger logger = LogManager.getLogger(FileUploadServlet.class.getName());

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (filePath.getTempFilePath().endsWith("mbox")) {
            MboxParser mboxParser = new MboxParser(filePath.getTempFilePath());
            mboxParser.run(mailBox);
        } else if (filePath.getTempFilePath().endsWith("eml")) {
            EmlParser.parseEml(filePath.getTempFilePath(), mailBox);
        }

        ContactFinder finder = new ContactFinder();
        List<String> lista = filePath.getKeywordsFromServletForm();
        Set<Email> displaylist = returnSearchWords(finder, lista);
        Set<String> foundEmails = returnEmails(finder);
        Set<String> foundWebsites = returnWebsite(finder);
        Set<String> foundPhone = returnPhone(finder);

        if (filePath.getCheckboxWord() != "null") {
            statisticBean.countWords(lista,statisticBean.getMapKeyWords());
        }
        if (filePath.getCheckboxWebsite() != "null") {
            statisticBean.countWords(foundWebsites,statisticBean.getMapWebsite());
        }if (filePath.getCheckboxPhone() != "null") {
            statisticBean.countWords(foundPhone,statisticBean.getMapPhone());
        }if (filePath.getCheckboxEmails() != "null") {
            statisticBean.countWords(foundEmails,statisticBean.getMapEmails());
        }
        System.out.println(statisticBean.getMapEmails());
        System.out.println(statisticBean.getMapWebsite());


        req.setAttribute("question", displaylist);
        req.setAttribute("foundEmails", foundEmails);
        req.setAttribute("foundWebsites", foundWebsites);
        req.setAttribute("foundPhone", foundPhone);
        req.setAttribute("keywords", lista);
        req.setAttribute("file", filePath.getTempFilePath());

        filePath.setNullforCheckbox();
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/display.jsp");
        dispatcher.forward(req, resp);
    }

    private Set<Email> returnSearchWords(ContactFinder finder, List<String> lista) {

        Set<Email> displaylist = new HashSet<>();
        if (filePath.getCheckboxWord() != "null") {
            for (int i = 0; i < lista.size(); i++) {
                Set<Email> mail = finder.findQA(mailBox, lista.get(i));
                displaylist.addAll(mail);
            }
        }
        return displaylist;
    }

    private Set<String> returnEmails(ContactFinder finder) {
        Set<String> mail = new HashSet<>();
        if (filePath.getCheckboxEmails() != "null") {
            mail = finder.findMail(mailBox);
            return mail;
        } else
            return mail;
    }

    private Set<String> returnWebsite(ContactFinder finder) {
        Set<String> website = new HashSet<>();
        if (filePath.getCheckboxWebsite() != "null") {
            website = finder.findWebsite(mailBox);
            return website;
        } else
            return website;
    }

    private Set<String> returnPhone(ContactFinder finder) {
        Set<String> phone = new HashSet<>();
        if (filePath.getCheckboxPhone() != "null") {
            phone = finder.findPhoneNo(mailBox);
            return phone;
        } else
            return phone;
    }

}