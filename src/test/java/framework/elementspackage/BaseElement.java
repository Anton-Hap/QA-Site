package framework.elementspackage;

import framework.utilpackage.logger.Log;
import framework.driverpackage.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.utilpackage.manager.ConfigManager;

import java.time.Duration;
import java.util.List;

public abstract class BaseElement {

    protected By locator;
    protected String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isExist() {
        return getElements().size() > 0;
    }

    public boolean isNotExist() {
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(ConfigManager.getTimeWait()));

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void click() {
        Log.getLogger().info(name + " was clicked");

        waitForElementIsClickable().click();
    }

    protected WebElement waitForElementIsClickable() {
        return (new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(ConfigManager.getTimeWait()))
                .until(ExpectedConditions.elementToBeClickable(locator)));
    }

    protected WebElement getElement() {
        return DriverSingleton.getDriver().findElement(locator);
    }

    protected List<WebElement> getElements() {
        return DriverSingleton.getDriver().findElements(locator);
    }

    public String getValue() {
        Log.getLogger().info("Get value from " + name + " with attribute value");

        return getElement().getAttribute("value");
    }

    public String getValueByAttribute(String attribute) {
        Log.getLogger().info("Get value from " + name + " with attribute " + attribute);

        return getElement().getAttribute(attribute);
    }

    public String getText() {
        Log.getLogger().info("Get text from " + name);

        return getElement().getText();
    }

    public void setText(String text) {
        Log.getLogger().info(text + " entered in " + name);

        getElement().sendKeys(text);
    }
}
