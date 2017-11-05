package pl.infoshareacademy.Web.portal;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePartHeader;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import pl.infoshareacademy.mail.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/redirect-servlet"})
public class RedirectServlet extends HttpServlet {

    private static final String APPLICATION_NAME = "EMailApp";
    private String redirectUri = "http://localhost:4040/EMailApp/redirect-servlet";
    Credential credential;
    private static com.google.api.services.gmail.Gmail client;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("application/json");
        ArrayList<Email> emails = new ArrayList();
        try {
            String code = req.getParameter("code");
            TokenResponse response = Constants.flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
            credential = Constants.flow.createAndStoreCredential(response, "userID");

            client = new com.google.api.services.gmail.Gmail.Builder(Constants.httpTransport, Constants.JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME).build();
            String userId = "me";
            System.out.println(req.getParameter("state"));
            String query = new String(Base64.decode(req.getParameter("state").getBytes()));
            ListMessagesResponse MsgResponse = client.users().messages().list(userId).setQ(query).execute();
            for (Message msg : MsgResponse.getMessages()) {
                try {
                    Message message = client.users().messages().get(userId, msg.getId()).execute();
                    List<MessagePartHeader> headers = message.getPayload().getHeaders();
                    Email object = new Email();
                    for (int i = 0; i < headers.size(); i++) {
                        if (headers.get(i).getName().equals("To")) {
                            object.setTo(headers.get(i).getValue());
                        }
                        if (headers.get(i).getName().equals("From")) {
                            object.setFrom(headers.get(i).getValue());
                        }
                        if (headers.get(i).getName().equals("Subject")) {
                            object.setSubject(headers.get(i).getValue());
                        }
                    }
                    object.setReply(message.getId());
                    object.setMessage(message.getSnippet());
                    Date d = new Date(message.getInternalDate() * 1000);
                    object.setDate(d);
                    emails.add(object);

                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("question",emails);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/display.jsp");
        dispatcher.forward(req, res);}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
