package pl.infoshareacademy.Web.portal;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.services.gmail.GmailScopes;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.infoshareacademy.mail.StatisticBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@WebServlet(urlPatterns = {"/oauth"})
public class OauthServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(OauthServlet.class.getName());


    private String clientSecret = "xKQQmLnzjgKiNfm-7kZ2Ytup";
    private String clientId = "904227267851-34jmqkr6rtovh3qs4m6alqmlk08sqgn8.apps.googleusercontent.com";

    GoogleClientSecrets clientSecrets;
    @Inject
    StatisticBean statisticBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String redirectUri = request.getScheme()+request.getServerName() +request.getServletContext().getContextPath() + "/login";
        StringBuilder redirectUri = new StringBuilder();
        redirectUri.append(request.getScheme()).append("://");
        redirectUri.append(request.getServerName());
        if (request.getServerPort() != 80) {
            redirectUri.append(":").append(request.getServerPort());
        }
        redirectUri.append(request.getContextPath()).append("/redirect-servlet");
        String srch = request.getParameter("srch");
        statisticBean.setListofgmailwords(srch);

        AuthorizationCodeRequestUrl authorizationUrl;
        if (Constants.flow == null) {
            try {
                Details web = new Details();
                web.setClientId(clientId);
                web.setClientSecret(clientSecret);
                clientSecrets = new GoogleClientSecrets().setWeb(web);
                Constants.httpTransport = GoogleNetHttpTransport.newTrustedTransport();
                Constants.flow = new GoogleAuthorizationCodeFlow.Builder(Constants.httpTransport, Constants.JSON_FACTORY, clientSecrets,
                        Collections.singleton(GmailScopes.GMAIL_READONLY)).build();
            } catch (GeneralSecurityException ex) {
                logger.info(ex);
            }
        }
        authorizationUrl = Constants.flow.newAuthorizationUrl().setRedirectUri(String.valueOf(redirectUri)).setState(Base64.encode(srch.getBytes()));
        response.sendRedirect(authorizationUrl.build());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}