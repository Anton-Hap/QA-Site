package framework.utilpackage.manager;

import framework.driverpackage.DriverSingleton;
import framework.utilpackage.logger.Log;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileManager {

    private static File file;

    public static void setFileByAddress(String address) {
        file = new File(address);
    }

    public static boolean existsFile() {
        Log.getLogger().info("File was downloaded");

        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(ConfigManager.getTimeWait()));

        return wait.until(x -> file.exists());
    }
}
