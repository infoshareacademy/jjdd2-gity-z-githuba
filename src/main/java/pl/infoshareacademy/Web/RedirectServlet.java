package pl.infoshareacademy.Web;

import com.google.api.client.auth.oauth2.Credential;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(urlPatterns = {"/redirect-servlet"})
public class RedirectServlet extends HttpServlet {

    private static final String APPLICATION_NAME = "EMailApp";
    private String redirectUri = "http://localhost:8080/EMailApp/redirect-servlet";
    Credential credential;
    private static com.google.api.services.gmail.Gmail client;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        JSONObject json = new JSONObject();
        JSONArray arr = new JSONArray();
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

            List<Message> messages = new ArrayList<>();
            System.out.println("Total messages found " + MsgResponse.getMessages().size());
            for (Message msg : MsgResponse.getMessages()) {
                try{
                    messages.add(msg);
                    Message message = client.users().messages().get(userId, msg.getId()).execute();
                    System.out.println(message.getSnippet());
                    arr.put(message);
                }catch(Exception e){}
            }
            json.put("response", "Success");
            json.put("data", arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print(json);
        out.close();
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
