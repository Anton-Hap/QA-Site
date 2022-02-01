package framework.elementspackage;

import framework.utilpackage.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Slider extends BaseElement {

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void moveToNumber(int number) {
        Log.getLogger().info(name + " movement on the " + number);

        if (number >= 0) {
            for (int i = 0; i < number; i++)
                getElement().sendKeys(Keys.ARROW_RIGHT);
        } else {
            for (int i = number; i < 0; i++)
                getElement().sendKeys(Keys.ARROW_LEFT);
        }
    }
}
