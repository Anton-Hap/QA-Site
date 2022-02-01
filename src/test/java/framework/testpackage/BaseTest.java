package framework.testpackage;

import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.logger.Log;
import framework.driverpackage.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import framework.utilpackage.manager.ConfigManager;

import java.time.Duration;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        if (ConfigManager.getMaximize()) {
            BrowserManager.maximizeWindow();
        }
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigManager.getTimeWait()));
    }

    @AfterMethod
    public void close() {
        Log.getLogger().info("Browser was closed");
        DriverSingleton.getDriver().quit();
        DriverSingleton.setNullDriver();
    }
}
