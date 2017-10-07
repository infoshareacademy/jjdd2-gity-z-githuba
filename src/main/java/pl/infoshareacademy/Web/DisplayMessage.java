package pl.infoshareacademy.Web;


import pl.infoshareacademy.mail.ContactFinder;
import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.TempFilePath;
import pl.infoshareacademy.mail.mailparser.MailBox;
import pl.infoshareacademy.mail.mailparser.MboxParser;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@WebServlet("/display")

public class DisplayMessage extends HttpServlet {

    @Inject
    TempFilePath filePath;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        MailBox mailBox = new MailBox();
        MboxParser mboxParser = new MboxParser(filePath.getTempFilePath());
        mboxParser.run(mailBox);
        ContactFinder finder= new ContactFinder();
        ArrayList<String> lista = new ArrayList<>();
        lista.add("test");
        lista.add("michal");
        Set<Email> displaylist = new HashSet<>();

        for (int i = 0; i <lista.size(); i++) {
            Set<Email> mail = finder.FindQA(mailBox, lista.get(i));
            displaylist.addAll(mail);
        }

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Searching by sender</h1>");
        writer.println("<p>"+filePath.getTempFilePath()+"</p>");
      //  mailBox.getMailbox().forEach(e->writer.println("ds"+e.getMessage()));
        displaylist.forEach(e->writer.println(e.getMessage()));
   //     writer.println("<p>" + mail +"</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}