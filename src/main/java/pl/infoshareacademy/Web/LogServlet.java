package pl.infoshareacademy.Web;

import pl.infoshareacademy.service.LogDAOImpl;
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
    LogDAOImpl logDAO;

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "getbyid":
                String getId = req.getParameter("getbyid_ID");
                System.out.println("Mam atrybuty: " + action + getId);
                req.setAttribute("header", "Get by id result:" + getId);
                req.setAttribute("body", logDAO.getLogById(Integer.parseInt(getId)));
                req.getRequestDispatcher("jsp/logresponse.jsp").include(req, resp);
                break;
            case "getbyrange":
                Integer idMin = Integer.parseInt(req.getParameter("getbyrangemin"));
                Integer idMax = Integer.parseInt(req.getParameter("getbyrangemax"));
                logDAO.getLogsByIdRange(idMin, idMax);
                break;
            case "getall":
                logDAO.getAllLogs();
                break;
            case "deletebyid":
                Integer deleteId = Integer.parseInt(req.getParameter("deletebyid"));
                logDAO.deleteLogById(deleteId);
            case "deleteall":
                logDAO.deleteAllLogs();
        }
    }
}