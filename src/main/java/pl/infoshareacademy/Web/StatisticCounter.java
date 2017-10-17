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
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> e61dbbae79ead5a8c5c567331c7c8e565c84ff02

@WebServlet("/home")
public class StatisticCounter extends HttpServlet {

    @Inject
    MailBox mailBox;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
        ArrayList<Email> emails = mailBox.getMailbox();
=======
        List<Email> emails = mailBox.getMailbox();
>>>>>>> e61dbbae79ead5a8c5c567331c7c8e565c84ff02
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/Index.html");
        dispatcher.forward(req, resp);
    }
}