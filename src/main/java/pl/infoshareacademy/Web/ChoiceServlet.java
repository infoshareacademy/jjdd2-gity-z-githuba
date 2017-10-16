package pl.infoshareacademy.Web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/choice")
public class ChoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>What do you want to do?</h1>");
        writer.println("<a href=\"sender\"/>1.Show me messages with certain word.</a>");
        writer.println("<form method=\"get\" action=\"keywords\">");
        writer.println("<a href=\"keywords\"/>2.What keywords should I use to find my email?</a>");
        writer.println("</form>");
        writer.println("<a href=\"home\"/>3. Let me upload another file</a>");
        writer.println("</body>");
        writer.println("</html>");
    }
}