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


        resp.setContentType("text/html;charset=UTF-8");
        String CheckboxWord = req.getParameter("  System.out.println(CheckboxWord);");
        String CheckboxWebsite = req.getParameter("Websites");
        String CheckboxPhone = req.getParameter("Phonenumbers");
        String CheckboxEmails = req.getParameter("Emails");

        if (filePath.getTempFilePath().endsWith("mbox")) {
            MboxParser mboxParser = new MboxParser(filePath.getTempFilePath());
            mboxParser.run(mailBox);
        } else if (filePath.getTempFilePath().endsWith("eml")) {
            EmlParser.parseEml(filePath.getTempFilePath(), mailBox);
        }

        ContactFinder finder= new ContactFinder();
        List<String> lista = filePath.getKeywordsFromServletForm();


        statisticBean.countWords(lista);
        System.out.println(CheckboxWord);
        Set<Email> displaylist =ReturnSearchWords(finder, lista, CheckboxWord);

        req.setAttribute("value",CheckboxWord);
        req.setAttribute("question",displaylist);
        req.setAttribute("keywords",lista);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/display.jsp");
        dispatcher.forward(req, resp);
    }

    public Set<Email> ReturnSearchWords(ContactFinder finder, List<String> lista, String checkboxWord) {

        logger.warn("Here", checkboxWord);
        System.out.println(checkboxWord);

        Set<Email> displaylist = new HashSet<>();
        if (checkboxWord != null) {
            for (int i = 0; i <lista.size(); i++) {
                Set<Email> mail = finder.findQA(mailBox, lista.get(i));
                displaylist.addAll(mail);
            }
            if (displaylist.isEmpty()) {
                Email emptyEmail =new Email();
                emptyEmail.setMessage("No e-mails found matching provided criteria");
                emptyEmail.setFrom("No e-mails found matching provided criteria");
                emptyEmail.setSubject("No e-mails found matching provided criteria");
                displaylist.add(emptyEmail);
            }
        }
        return displaylist;
    }
}