package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    private static final Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resources/testdata.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load testdata properties",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }


}
