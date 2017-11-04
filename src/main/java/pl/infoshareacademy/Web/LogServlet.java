package pl.infoshareacademy.Web;

import pl.infoshareacademy.service.LogDAOImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import java.io.IOException;

@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {

    @Inject
    LogDAOImpl logDAO;

    @QueryParam("action") public String action;
    @QueryParam("getbyid_ID") int getId;
    @QueryParam("getbyrangemin") int idMin;
    @QueryParam("getbyrangemax") int idMax;
    @QueryParam("id") int deleteId;*/

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Atrbuted i got" + action + getId);
        req.getAttribute("id");
        switch (action) {
            case "getbyid":
                req.setAttribute("header", "Get by id result:" + getId);
                req.setAttribute("body", logDAO.getLogById(getId));
                req.getRequestDispatcher("/logresponse.jsp").include(req, resp);
            case "getbyrange":
                logDAO.getLogsByIdRange(idMin, idMax);
            case "getall":
                logDAO.getAllLogs();
            case "deletebyid":
                logDAO.deleteLogById(deleteId);
            case "deleteall":
                logDAO.deleteAllLogs();
        }

    }
}