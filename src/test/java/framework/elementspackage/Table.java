package framework.elementspackage;

import framework.utilpackage.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table extends BaseElement {

    public Table(By locator, String name) {
        super(locator, name);
    }

    public int getCountElementWithText(By cellLocator, String text) {
        Log.getLogger().info("Getting the number of elements in " + name);

        List<WebElement> list = getCells(cellLocator);
        int count = 0;
        for (WebElement webElement : list) {
            if (webElement.getText().contains(text)) {
                count++;
            }
        }

        return count;
    }

    protected List<WebElement> getCells(By cellLocator) {
        return getElement().findElements(cellLocator);
    }

    public boolean isFieldWithText(By cellLocator, String text) {
        Log.getLogger().info("Field with text " + text + " is exists");

        List<WebElement> list = getCells(cellLocator);
        for (WebElement webElement : list) {
            if (webElement.getText().equals(text)) {
                return true;
            }
        }

        return false;
    }
}
