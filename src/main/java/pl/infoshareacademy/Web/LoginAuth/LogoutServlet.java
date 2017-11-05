package pl.infoshareacademy.Web.LoginAuth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/logout"})
public class LogoutServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() != null) {
            logger.info("User has logged out!");
            request.getSession().invalidate();
        }
//        response.sendRedirect("jsp/exit.jsp");
        request.getSession().invalidate();
     /*   RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("jsp/home.jsp");
        dispatcher.forward(request, response);}*/
        request.getRequestDispatcher("jsp/exit.jsp").include(request, response);
    }
}