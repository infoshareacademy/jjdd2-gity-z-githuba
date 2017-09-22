package pl.infoshareacademy.config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.LongLongSeqHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigureSave {
    private static final Logger logger = LogManager.getLogger(ConfigureSave.class.getName());
    private static String configPath = "jjdd2-gity-z-githuba/src/main/resources/config.properties";

    public static void main(String[] args) {
        setSettingsValue("LOL");
     /*   Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(configPath);
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
        }*/

    }

    public static void setSettingsValue(String key) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            FileInputStream in = new FileInputStream(configPath);
            prop.load(in);
            in.close();
        } catch (IOException e) {
            logger.fatal("File not found! {}", configPath);
        }
        try {
            FileOutputStream out = new FileOutputStream(configPath);
            prop.setProperty("pedal", "cwel");
            prop.store(out, null);
            out.close();
        } catch (IOException e) {
            logger.fatal("File not found! {}", configPath);
        }
    }
}
