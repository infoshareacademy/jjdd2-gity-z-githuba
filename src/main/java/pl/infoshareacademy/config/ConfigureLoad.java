package pl.infoshareacademy.config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureLoad {
    private static final Logger logger = LogManager.getLogger(ConfigureSave.class.getName());
    private static String configPath = "src/main/resources/config.properties";
    private Properties prop = new Properties();

    public Properties loadConfigurationFile() {
        Properties prop = new Properties();
        try {
            FileInputStream in = new FileInputStream(configPath);
            prop.load(in);
            in.close();
        } catch (IOException e) {
            logger.fatal("Failed while loading config file! File path was: {}", configPath);
        }
        this.prop = prop;
        return prop;
    }

    public String getConfigurationValue(String key) {
        return prop.getProperty(key);
    }

    public static void main(String[] args) {
        ConfigureLoad conf = new ConfigureLoad();
        System.out.println("Hello World!");
        conf.loadConfigurationFile();
        System.out.println(conf.getConfigurationValue("pedal"));
        System.out.println(conf.getConfigurationValue("country"));
        System.out.println(conf.getConfigurationValue("dbuser"));

    }
}

