package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Label;
import framework.objectbrowserpackage.Frame;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {

    public FramesPage() {
        super(new Label(By.xpath("//div[@class='main-header' and text()='Frames']"), "UniqueElementByFramesPage"), "FramesPage");
    }

    public String getTextByFirstFrame() {
        Frame.enterById("frame1");
        return Frame.getTextFromLocator(By.xpath("//h1"));
    }

    public String getTextBySecondFrame() {
        Frame.enterById("frame2");
        return Frame.getTextFromLocator(By.xpath("//h1"));
    }

    public void exitFromFrame() {
        Frame.exit();
    }
}
