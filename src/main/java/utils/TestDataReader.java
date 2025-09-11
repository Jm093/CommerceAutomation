package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    private static final Properties properties;

    static {
        try (InputStream input = TestDataReader.class.getClassLoader()
                .getResourceAsStream("testdata.properties")) {

            if (input == null) {
                throw new RuntimeException("testdata.properties not found in classpath");
            }
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load testdata properties",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }


}
