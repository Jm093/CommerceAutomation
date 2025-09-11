package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) throw new RuntimeException("config.properties not found in classpath");
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
    public static int getExplicitWait(){
        return Integer.parseInt(properties.getProperty("explicitWait","10"));
    }
}
