package pl.infoshareacademy.Web;

import com.auth0.SessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/portal/index")
public class StartingServlet extends HttpServlet {

    /*private Logger log = LoggerFactory.getLogger(StartingServlet.class);

    @Inject
    LogPatternDemo logPatternDemo;*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String accessToken = (String) SessionUtils.get(req, "accessToken");
        final String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken != null) {
            req.setAttribute("userId", accessToken);
        } else if (idToken != null) {
            req.setAttribute("userId", idToken);
        }
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/file_upload.jsp");
        dispatcher.forward(req, resp);
    }
}