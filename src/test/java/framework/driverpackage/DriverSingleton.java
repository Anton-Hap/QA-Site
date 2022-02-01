package framework.driverpackage;

import framework.utilpackage.logger.Log;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.createDriver();
        }

        return driver;
    }

    public static void setNullDriver() {
        Log.getLogger().info("Set driver null");

        driver = null;
    }
}
