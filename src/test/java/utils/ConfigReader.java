package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties file not found");
            }

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to laod config.properties", e);
        }
    }

    public static String getBrowser() {
        return System.getProperty("browser",
                properties.getProperty("browser"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(
                System.getProperty("headless",
                        properties.getProperty("headless")));
    }

    public static String getEnvironment() {
        return System.getProperty("env",
                properties.getProperty("env"));
    }

    public static String getBaseUrl() {
        String environment = getEnvironment();
        return properties.getProperty(environment + ".url");
    }
}
