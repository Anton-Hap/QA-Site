package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import org.openqa.selenium.By;
import formpackage.LeftPanelForm;

public class BrowserWindowsPage extends BaseForm {

    public final LeftPanelForm leftPanelForm = new LeftPanelForm();

    private final Button tabButton = new Button(By.xpath("//button[@id='tabButton']"), "tabButton");

    public BrowserWindowsPage() {
        super(new Button(By.xpath("//button[@id='tabButton']"), "UniqueElementByBrowserWindowsPage"), "BrowserWindowsPage");
    }

    public void openSamplePage() {
        tabButton.click();
    }
}
