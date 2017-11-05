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
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/pieChart"})
public class PieChartServlet extends HttpServlet {
    @Inject
    StatisticBean statisticBean;

    static JFreeChart chart;
    static BufferedImage bufferedImage;

    public PieChartServlet() {
        super();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        try {

            List<File> files = new ArrayList<>();
            List<HashMap> hashMaps = new ArrayList<>();

            HashMap<String, Integer> map = (HashMap<String, Integer>) statisticBean.getMapEmails();
            hashMaps.add(map);
            HashMap<String, Integer> map2 = (HashMap<String, Integer>) statisticBean.getMapKeyWords();
            hashMaps.add(map2);
            HashMap<String, Integer> map3 = (HashMap<String, Integer>) statisticBean.getMapPhone();
            hashMaps.add(map3);
            HashMap<String, Integer> map4 = (HashMap<String, Integer>) statisticBean.getMapWebsite();
            hashMaps.add(map4);

            String to = "gityzgithuba@gmail.com";
            String from = "gityzgithuba@gmail.com";
            String body = "";

            final int WIDTH = 500;
            final int HEIGHT = 400;
            BufferedImage chartsImage = new BufferedImage(
                    WIDTH, (HEIGHT * hashMaps.size()),
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = chartsImage.getGraphics();
            int x = 0, y = 0;
            for (int i = 0; i < 4; i++) {
                String title = "Report";

                chart = createChart(createDatasetFromHMap(hashMaps.get(i), 5), title);

                try {
                    File pieChart = new File("chart" + String.valueOf(i + 1) + ".png");
                    files.add(pieChart);
                    ChartUtilities.saveChartAsJPEG(pieChart, chart, WIDTH, HEIGHT);
                    try (InputStream imageInputStream = new FileInputStream(pieChart)) {

                        BufferedImage bi = ImageIO.read(imageInputStream);
                        g.drawImage(bi, 0, y, null);

                        y += bi.getHeight();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            MailUtilGmail.sendMail(to, from, "Report", body, true, files);
            ServletOutputStream os = response.getOutputStream();
            response.setContentType("image/jpg");
            ImageIO.write(chartsImage, "png", os);
            os.flush();
            os.close();
            response.sendRedirect("display");
        } catch (MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(PieChartServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("display");
        }
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

}