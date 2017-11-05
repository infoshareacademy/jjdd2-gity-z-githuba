package pl.infoshareacademy.mailsender;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import pl.infoshareacademy.mail.StatisticBean;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/pieChart"})
public class PieChartServlet extends HttpServlet {

    static JFreeChart chart;
    static BufferedImage bufferedImage;
    @Inject
    StatisticBean statisticBean;

    public PieChartServlet() {
        super();

    }

    private static HashMap<String, Integer> fitToMax(HashMap<String, Integer> hashMap, int max) {
        HashMap<String, Integer> temp = new HashMap<>(hashMap);

        boolean repeat = true;

        // the purpose of this while loop is to loop through
        // the original hash map more than one time
        while (repeat) {
            // looping through the hashmap
            for (Entry e : hashMap.entrySet()) {
                // check if the value of the entery is the least value in the temp map
                if (e.getValue() == Collections.min(temp.values())) {
                    // remove the least value
                    temp.remove(e.getKey());

                    // if we meet the max size then the hashmap fits the specified max value
                    // and we exit the loops
                    if (temp.size() == max) {
                        repeat = false;
                        break;
                    }

                }

            }
            // if the loop through the hashMap is finished
            // and the size of temp is still greater than the max value
            // we start the loop again
            // here the boolean repeat = true
        }
        return temp;
    }

    private static PieDataset createDatasetFromHMap(HashMap<String, Integer> hashMap, int max) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        if (hashMap.size() > max) {

            hashMap = fitToMax(hashMap, max);

        }

        for (Entry e : hashMap.entrySet()) {
            dataset.setValue((Comparable) e.getKey(), (int) e.getValue());
        }

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset, String chartTitle) {

        JFreeChart chart = ChartFactory.createPieChart(
                chartTitle, // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("A1", 10);
        map.put("A2", 60);
        map.put("A3", 90);
        map.put("A4", 50);
        map.put("A5", 30);
        map.put("A6", 80);
        map.put("A7", 20);
        map.put("A8", 70);
        map.put("A9", 40);

        String title = "Chart from HashMap";

        chart = createChart(createDatasetFromHMap(map, 5), title);
        bufferedImage = chart.createBufferedImage(600, 800);

        RenderedImage chartImage = chart.createBufferedImage(800, 600);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(chartImage, "png", os);

        File pieChart = new File("PieChart.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(pieChart, chart, 800, 600);
            InputStream imageInputStream = new FileInputStream(pieChart);

            String to = "gityzgithuba@gmail.com";
            String from = "gityzgithuba@gmail.com";
            String body = "";
            try {
                MailUtilGmail.sendMail(to, from, title, body, true, pieChart);
                pieChart.delete();
            } catch (MessagingException | UnsupportedEncodingException ex) {
                Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        os.flush();
        os.close();
    }

}
