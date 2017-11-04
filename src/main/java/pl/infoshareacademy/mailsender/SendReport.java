package pl.infoshareacademy.mailsender;

import pl.infoshareacademy.mail.StatisticBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@WebServlet("/email")
public class SendReport extends HttpServlet {
    @Inject
    StatisticBean statisticBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties prop = System.getProperties ();
        prop.put ("awt.toolkit", "com.eteks.awt.PJAToolkit");
        prop.put ("java.awt.headless", "true");
        System.setProperties (prop);
        try {
            PieChart.SendHasmap((HashMap<String, Integer>) statisticBean.getMapKeyWords());

        } catch (Exception ex) {

        }
    }
}