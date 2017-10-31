package pl.infoshareacademy.Web.LoginAuth;

import com.auth0.AuthenticationController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.Main;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LoginServlet.class.getName());

    private AuthenticationController authenticationController;
    private String domain;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        domain = config.getServletContext().getInitParameter("com.auth0.domain");
        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            logger.error("Couldn't create the AuthenticationController instance. Check the configuration.");
            throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        String redirectUri;
        if (req.getServerPort() == 80) {
            redirectUri = req.getScheme() + "://" + req.getServerName() + req.getContextPath() + "/callback";
        } else {
            redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/callback";
        }

        String authorizeUrl = authenticationController.buildAuthorizeUrl(req, redirectUri)
                .withAudience(String.format("https://%s/userinfo", domain))
                .build();
        res.sendRedirect(authorizeUrl);
    }

}
