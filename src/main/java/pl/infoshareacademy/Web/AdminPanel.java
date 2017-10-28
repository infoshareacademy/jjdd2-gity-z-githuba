package pl.infoshareacademy.Web;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import pl.infoshareacademy.mailsender.EmailConfig;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HeaderParam;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
@WebServlet("/admin")
public class AdminPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String getUserInfo(@HeaderParam("Authorization") String authorization);

        Properties p = System.getProperties();
        req.setAttribute("Settings",p);

        EmailConfig send = new EmailConfig("gityzgithuba@gmail.com","hahaadmin","smtp.gmail.com",465);
        try {
            send.send("gityzgithuba@gmail.com","Dupa","sdsdsdsdsdsdsdsd");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/adminPanel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
