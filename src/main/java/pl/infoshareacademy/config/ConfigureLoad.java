package pl.infoshareacademy.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureLoad {
    private static final Logger logger = LogManager.getLogger(ConfigureLoad.class.getName());
    private static String configPath = "jjdd2-gity-z-githuba/src/main/resources/config.properties";
    private Properties prop = new Properties();

    public Properties loadConfigurationFile() {
        Properties prop = new Properties();
        try {
            FileInputStream in = new FileInputStream(configPath);
            prop.load(in);
            in.close();
        } catch (IOException e) {
            logger.error("Failed while loading config file! File path was: {}", configPath);
        }
        this.prop = prop;
        return prop;
    }

    public String getConfigurationValue(String key) {
        return prop.getProperty(key);
    }

}

