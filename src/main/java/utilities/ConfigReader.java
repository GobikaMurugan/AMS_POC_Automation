package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Error: Failed to load config.properties from path: " + CONFIG_FILE_PATH);
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("Warning: Property key '" + key + "' not found in config.properties");
        }
        return value;
    }

    public static int getTimeout() {
        String timeoutValue = getProperty("timeout");
        if (timeoutValue != null) {
            try {
                return Integer.parseInt(timeoutValue.trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid timeout format in config.properties. Defaulting to 10 seconds.");
            }
        }
        return 10;
    }
}
