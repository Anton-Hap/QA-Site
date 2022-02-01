package framework.utilpackage.manager;

import framework.driverpackage.DriverSingleton;
import framework.utilpackage.logger.Log;
import org.openqa.selenium.JavascriptExecutor;

public class BrowserManager {

    public static void changeHandleTab() {
        Log.getLogger().info("Handle was changed");

        String originalWindow = DriverSingleton.getDriver().getWindowHandle();

        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void scrollToDown() {
        JavascriptExecutor executor = (JavascriptExecutor) DriverSingleton.getDriver();
        executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static String getUrl() {
        return DriverSingleton.getDriver().getCurrentUrl();
    }

    public static void closePage() {
        Log.getLogger().info("Page was closed");

        DriverSingleton.getDriver().close();
    }

    public static String getHandle() {
        return DriverSingleton.getDriver().getWindowHandle();
    }

    public static void maximizeWindow() {
        Log.getLogger().info("Window was made maximum");

        DriverSingleton.getDriver().manage().window().maximize();
    }

    public static void goToWindowByHandle(String handle) {
        Log.getLogger().info("Switching to window with handle " + handle);

        DriverSingleton.getDriver().switchTo().window(handle);
    }

}
