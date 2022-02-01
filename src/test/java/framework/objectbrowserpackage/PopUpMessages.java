package framework.objectbrowserpackage;

import framework.driverpackage.DriverSingleton;
import framework.utilpackage.logger.Log;
import org.openqa.selenium.NoAlertPresentException;

public class PopUpMessages {

    public static String getText() {
        Log.getLogger().info("Getting text from popup message");

        return DriverSingleton.getDriver().switchTo().alert().getText();
    }

    public static void accept() {
        Log.getLogger().info("Accept popup message");

        DriverSingleton.getDriver().switchTo().alert().accept();
    }

    public static boolean isPopUpMessages() {
        try {
            DriverSingleton.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException exception) {
            return false;
        }
    }

    public static void setText(String message) {
        Log.getLogger().info("Setting " + message + " to popup message");
        DriverSingleton.getDriver().switchTo().alert().sendKeys(message);
    }
}
