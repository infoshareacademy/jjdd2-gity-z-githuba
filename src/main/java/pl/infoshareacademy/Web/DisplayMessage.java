package pl.infoshareacademy.Web;

import pl.infoshareacademy.mail.ContactFinder;
import pl.infoshareacademy.mail.Email;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        MailBox mailBox = new MailBox();

        if (filePath.getTempFilePath().endsWith("mbox")) {
            MboxParser mboxParser = new MboxParser(filePath.getTempFilePath());
            mboxParser.run(mailBox);
        } else if (filePath.getTempFilePath().endsWith("eml")) {
            EmlParser.parseEml(filePath.getTempFilePath(), mailBox);
        }

        ContactFinder finder= new ContactFinder();
        List<String> lista = filePath.getKeywordsFromServletForm();
        Set<Email> displaylist = new HashSet<>();


        for (int i = 0; i <lista.size(); i++) {
            Set<Email> mail = finder.findQA(mailBox, lista.get(i));
            displaylist.addAll(mail);
        }
        if (displaylist.isEmpty()) {
            Email emptyEmail =new Email();
            emptyEmail.setMessage("Not found emails matches criteria");
            displaylist.add(emptyEmail);
        }

        req.setAttribute("question",displaylist);
        req.setAttribute("keywords",lista);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/display.jsp");
        dispatcher.forward(req, resp);
    }
}