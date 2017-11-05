package pl.infoshareacademy.Web.LoginAuth;

import pl.infoshareacademy.service.LogDAO;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/logout"})
public class LogoutServlet extends HttpServlet {

    @Inject
    LogDAO logDAO;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() != null) {
            logDAO.saveLogToDatabase("INFO", "User has logged out!");
            request.getSession().invalidate();
        }
        response.sendRedirect("jsp/exit.jsp");
    }
}