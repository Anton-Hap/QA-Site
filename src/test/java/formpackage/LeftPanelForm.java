package formpackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import org.openqa.selenium.By;

public class LeftPanelForm extends BaseForm {

    private Button button;

    private final String buttonFormat = "//span[text()='%s']";
    private final String groupButtonFormat = "//div[text()='%s']";

    public LeftPanelForm() {
        super(new Button(By.xpath("//div[text()='Elements']"), "UniqueElementByLeftPanelForm"), "LeftPanelForm");
    }

    public void switchingToNewPageByButton(String nameButton) {
        button = new Button(By.xpath(String.format(buttonFormat, nameButton)), nameButton + "MenuButton");
        button.click();
    }

    public void openingMenuByButton(String nameButton) {
        button = new Button(By.xpath(String.format(groupButtonFormat, nameButton)), nameButton + "GroupMenuButton");
        button.click();
    }
}
