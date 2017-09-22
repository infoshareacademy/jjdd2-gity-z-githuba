package pl.infoshareacademy.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigureSave {
    private static final Logger logger = LogManager.getLogger(ContactFinder.class.getName());
    private static String configPath = "jjdd2-gity-z-githuba/src/main/resources/config.properties";

    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(configPath);
            prop.setProperty("Database", "Localhost");
            prop.setProperty("dbuser", "admin");
            prop.store(output, null);
        } catch (IOException e) {
            logger.fatal("File not found! Was looking for {} but file does not exists!", configPath);
        } finally {
            if (output == null) {
                try {
                    output.close();
                } catch (IOException e) {
                    logger.fatal("Output == null! Closing output stream.");
                }
            }
        }
    }
}
