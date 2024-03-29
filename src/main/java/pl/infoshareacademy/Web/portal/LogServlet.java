package pl.infoshareacademy.Web.portal;

import pl.infoshareacademy.service.LogDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                req.setAttribute("header", "Get by id result:" + getId);
                req.setAttribute("body", logDAO.getLogById(Integer.parseInt(getId)));
                req.getRequestDispatcher("jsp/logresponse_single.jsp").forward(req, resp);
                break;
            case "getbyrange":
                String idMin = req.getParameter("getbyrangemin");
                String idMax = req.getParameter("getbyrangemax");
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
                resp.sendError(200, "Log has been deleted.");
                break;
            case "deleteall":
                logDAO.deleteAllLogs();
                resp.sendError(200, "All logs has been deleted.");
                break;
            default:
                resp.sendError(200, "Unexpected action! Are you really trying to break me? :(");
                break;
        }
    }
}