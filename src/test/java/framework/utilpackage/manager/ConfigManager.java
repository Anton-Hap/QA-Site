package framework.utilpackage.manager;

import framework.utilpackage.logger.Log;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;

    public ConfigManager() {
        start();
    }

    public static void start() {
        properties = new Properties();
        fileConnection();
    }

    private static void fileConnection() {
        try {
            Log.getLogger().info("Config File has been read");
            properties.load(new FileReader("src/test/java/resources/Config"));
        } catch (IOException e) {
            throw new RuntimeException("Config File not read");
        }
    }

    private static Properties getProperties() {
        if (properties == null) {
            start();
        }

        return properties;
    }

    public static int getTimeWait() {
        return Integer.parseInt(getProperties().getProperty("timeWait"));
    }

    public static String getBrowser() {
        return getProperties().getProperty("browser");
    }

    public static int getWidthWindow() {
        return Integer.parseInt(getProperties().getProperty("widthWindow"));
    }

    public static int getHeightWindow() {
        return Integer.parseInt(getProperties().getProperty("heightWindow"));
    }

    public static String getUrlFirstPage() {
        return getProperties().getProperty("urlFirstPage");
    }

    public static boolean getMaximize() {
        return Boolean.parseBoolean(getProperties().getProperty("maximize"));
    }
}

