package pl.infoshareacademy.Web.LoginAuth;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.StatisticBean;

import javax.ejb.SessionBean;
import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/callback")
public class CallbackServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CallbackServlet.class.getName());

    @Inject
    StatisticBean statisticBean;
    private String redirectOnSuccess = "portal/index";
    private String redirectOnFail = "/login";
    private AuthenticationController authenticationController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            logger.fatal("Couldn't create the AuthenticationController instance. Check the configuration.", e);
            throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        handle(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        handle(req, res);
    }

    private void handle(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Tokens tokens = authenticationController.handle(req);
            SessionUtils.set(req, "accessToken", tokens.getAccessToken());
            SessionUtils.set(req, "idToken", tokens.getIdToken());
            String token = tokens.getIdToken();
            statisticBean.addAdmintoList();
            if (statisticBean.isAdmin(ParseToken.parseId(token))) {
                req.getSession().setAttribute("isAdmin", "true");
            }
            res.sendRedirect(redirectOnSuccess);
        } catch (IdentityVerificationException e) {
            logger.warn("Identity Verification Failed!", e);
            res.sendRedirect(redirectOnFail);
        }
    }
}