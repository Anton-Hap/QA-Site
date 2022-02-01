package framework.utilpackage.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    private final static Logger logger = LogManager.getLogger(Log.class);
    private static boolean isProperty = false;

    public static Logger getLogger() {
        if (!isProperty) {
            setProperty();
        }

        return logger;
    }

    private static void setProperty() {
        PropertyConfigurator.configure("src/test/java/resources/log4j");
        isProperty = true;
    }
}
