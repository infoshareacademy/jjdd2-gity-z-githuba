package pl.infoshareacademy.Web;

import pl.infoshareacademy.model.Log;
import pl.infoshareacademy.service.LogDAO;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {

    @Inject
    private LogDAO logDAO;

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "getbyid":
                String getId = req.getParameter("getbyid_ID");
                System.out.println("Mam atrybuty: " + action + getId);
                req.setAttribute("header", "Get by id result:" + getId);
                req.setAttribute("body", logDAO.getLogById(Integer.parseInt(getId)));
                req.getRequestDispatcher("jsp/logresponse_single.jsp").forward(req, resp);
                break;
            case "getbyrange":
                String idMin = req.getParameter("getbyrangemin");
                String idMax = req.getParameter("getbyrangemax");
                System.out.println();
                System.out.println("              " + idMin + "    " + idMax);
                req.setAttribute("header", "Get Logs by range " + idMin + " - " + idMax);
                req.setAttribute("body", logDAO.getLogsByIdRange((Integer.parseInt(idMin)), (Integer.parseInt(idMax))));
                req.getRequestDispatcher("jsp/logresponse_multi.jsp").include(req, resp);
                break;
            case "getall":
                req.setAttribute("body", logDAO.getAllLogs());
                req.setAttribute("header", "Get all logs:");
                req.getRequestDispatcher("jsp/logresponse_multi.jsp").forward(req, resp);
                break;
            case "deletebyid":
                Integer deleteId = Integer.parseInt(req.getParameter("id"));
                logDAO.deleteLogById(deleteId);
                break;
            case "deleteall":
                Log log = new Log();
                log.setTime(LocalTime.now());
                log.setLevel("WARNING");
                log.setMessage("Custom LOG");
                logDAO.saveLogToDatabase(log);
                break;
        }
    }
}