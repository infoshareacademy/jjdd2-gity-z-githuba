package pl.infoshareacademy.Web;

import pl.infoshareacademy.mail.Email;
import pl.infoshareacademy.mail.mailparser.MailBox;

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
import java.util.List;

@WebServlet("/des")
public class StatisticCounter extends HttpServlet {

    @Inject
    MailBox mailBox;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Email> emails = mailBox.getMailbox();
        Long counter =emails.stream()
                .map(email -> email.getMessage())
                .count();



    }
}