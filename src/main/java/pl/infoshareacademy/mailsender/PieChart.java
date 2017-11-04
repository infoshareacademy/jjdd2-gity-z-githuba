package pl.infoshareacademy.mailsender;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.mail.MessagingException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class PieChart extends ApplicationFrame {

        static JFreeChart chart;
        static BufferedImage bufferedImage;

        private static HashMap<String, Integer> fitToMax(HashMap<String, Integer> hashMap, int max) {
            HashMap<String, Integer> temp = new HashMap<>(hashMap);

            boolean repeat = true;
            while (repeat) {
                for (Entry e : hashMap.entrySet()) {
                    if (e.getValue() == Collections.min(temp.values())) {
                        // remove the least value
                        temp.remove(e.getKey());

                        if (temp.size() == max) {
                            repeat = false;
                            break;
                        }

                    }

                }
            }
            return temp;
        }

        public PieChart(String title, HashMap<String, Integer> hashDset, int max) {
            super(title);
            setContentPane(createChartPanel(hashDset, max));
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



        public static void SendHasmap(HashMap<String, Integer> maptoPrint) {

            HashMap<String, Integer> map = maptoPrint;

            String title = "Chart of words";
            PieChart demo = new PieChart(title, map, 20);

            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(false);
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
                    Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        private Container createChartPanel(HashMap<String, Integer> hashDset, int max) {

            this.chart = createChart(createDatasetFromHMap(hashDset, max), "Chart from Hash Map");
            bufferedImage = chart.createBufferedImage(600, 800);
            return new ChartPanel(chart);
        }

    }