package pl.infoshareacademy.Web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.services.gmail.GmailScopes;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.GeneralSecurityException;
import java.util.Collections;

@WebServlet(urlPatterns = {"/oauth"})
public class OauthServlet extends HttpServlet {

    private String redirectUri = "http://localhost:8080/EMailApp/redirect-servlet";
    private String clientSecret = "xKQQmLnzjgKiNfm-7kZ2Ytup";
    private String clientId = "904227267851-34jmqkr6rtovh3qs4m6alqmlk08sqgn8.apps.googleusercontent.com";

    GoogleClientSecrets clientSecrets;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String srch = request.getParameter("srch");
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
                ex.printStackTrace();
            }
        }
        authorizationUrl = Constants.flow.newAuthorizationUrl().setRedirectUri(redirectUri).setState(Base64.encode(srch.getBytes()));
        response.sendRedirect(authorizationUrl.build());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
