package pl.infoshareacademy.Web;


import pl.infoshareacademy.mail.ContactFinder;
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
        Set mail = finder.FindQA(mailBox, "test");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Searching by sender</h1>");
        writer.println("<p>"+filePath.getTempFilePath()+"</p>");
        mailBox.getMailbox().forEach(e->writer.println("ds"+e.getMessage()));
        mail.forEach(e->e.toString());
        writer.println("<p>" + mail.isEmpty()+"</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}