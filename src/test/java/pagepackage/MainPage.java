package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Image;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private final String buttonFormat = "//h5[contains(text(),'%s')]";

    private Button button;

    public MainPage() {
        super(new Image(By.xpath("//img[contains(@class,'banner')]"), "UniqueElementByMainPage"), "MainPage");
    }

    public void switchingToNewPageByButton(String nameButton) {
        button = new Button(By.xpath(String.format(buttonFormat, nameButton)), nameButton + "Button");
        button.click();
    }
}
