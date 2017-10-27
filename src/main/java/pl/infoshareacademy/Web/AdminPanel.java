package pl.infoshareacademy.Web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HeaderParam;
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

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/adminPanel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
