package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        try {
            FileInputStream input = new FileInputStream("src/test/java/resources/config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }
    public static String getBrowser(){
        return System.getProperty("browser", properties.getProperty("browser","chrome"));
    }
    public static String getBaseURL(){
        return properties.getProperty("baseUrl");
    }
    public static int getImplicitWait(){
        return Integer.parseInt(properties.getProperty("implicitWait","10"));
    }
}
