package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Label;
import formpackage.LeftPanelForm;
import framework.objectbrowserpackage.Frame;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {

    private final Button adCloseButton = new Button(By.xpath("//img[contains(@alt,'adplus')]"), "adCloseButton");

    public final LeftPanelForm leftPanelForm = new LeftPanelForm();

    public NestedFramesPage() {
        super(new Label(By.xpath("//div[@class='main-header' and text()='Nested Frames']"), "UniqueElementByNestedFramesPage"), "NestedFramePage");
    }

    public String getTextByChildFrame() {
        Frame.enterByIndex(0);
        return Frame.getTextFromLocator(By.xpath("//p"));
    }

    public String getTextByParentFrame() {
        Frame.enterById("frame1");
        return Frame.getTextFromLocator(By.xpath("//body"));
    }

    public void closeAd() {
        adCloseButton.click();
    }

    public void exitFromFrame() {
        Frame.exit();
    }
}
