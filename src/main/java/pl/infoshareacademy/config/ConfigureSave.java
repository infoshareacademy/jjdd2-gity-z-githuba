package pl.infoshareacademy.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigureSave {
    private static final Logger logger = LogManager.getLogger(ConfigureSave.class.getName());
    private static String configPath = "src/main/resources/config.properties";

    public static void setSettingsValue(String key, String value) {
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
            prop.setProperty(key, value);
            prop.store(out, null);
            out.close();
        } catch (IOException e) {
            logger.fatal("File not found! {}", configPath);
        }
    }
}

