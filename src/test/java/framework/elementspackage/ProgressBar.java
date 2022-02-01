package framework.elementspackage;

import framework.driverpackage.DriverSingleton;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ProgressBar extends BaseElement {

    public ProgressBar(By locator, String name) {
        super(locator, name);
    }

    public boolean waitLoadByPercentAndAttribute(String percent, String attribute) {
        Wait<WebDriver> wait = new FluentWait<>(DriverSingleton.getDriver())
                .withTimeout(Duration.ofSeconds(ConfigManager.getTimeWait()))
                .pollingEvery(Duration.ofNanos(10));

        try {
            while (!wait.until(ExpectedConditions.attributeToBe(locator, attribute, percent))) {}
        } catch (Exception e) {
            Log.getLogger().warn("Excessive waiting for " + name + " to load");
            return false;
        }

        return true;
    }
}
