package framework.objectbrowserpackage;

import framework.utilpackage.logger.Log;
import framework.driverpackage.DriverSingleton;
import org.openqa.selenium.By;

public class Frame {

    public static void enterById(String id) {
        Log.getLogger().info("Entering Frame by id");

        DriverSingleton.getDriver().switchTo().frame(id);
    }

    public static void exit() {
        Log.getLogger().info("Exiting Frame");

        DriverSingleton.getDriver().switchTo().defaultContent();
    }

    public static void enterByIndex(int index) {
        Log.getLogger().info("Entering Frame by index");

        DriverSingleton.getDriver().switchTo().frame(index);
    }

    public static String getTextFromLocator(By locator) {
        Log.getLogger().info("Getting text from frame");

        return DriverSingleton.getDriver().findElement(locator).getText();
    }
}
