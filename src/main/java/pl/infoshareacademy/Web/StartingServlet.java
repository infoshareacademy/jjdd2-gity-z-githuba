package pl.infoshareacademy.Web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.infoshareacademy.service.CreateFile;
import pl.infoshareacademy.service.LogPatternDemo;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class StartingServlet extends HttpServlet {

    private Logger log = LoggerFactory.getLogger(StartingServlet.class);

    @Inject
    CreateFile createFile;

    @Inject
    LogPatternDemo logPatternDemo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Jestem w klasie Starting Servlet!");

        logPatternDemo.saveLog();


        log.info("Wywołałem createFile.test();;)");

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp/index3.jsp");
        dispatcher.forward(req, resp);
    }
}