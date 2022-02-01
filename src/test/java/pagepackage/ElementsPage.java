package pagepackage;

import framework.elementspackage.Label;
import org.openqa.selenium.By;
import formpackage.LeftPanelForm;
import framework.baseformpackage.BaseForm;

public class ElementsPage extends BaseForm {

    public final LeftPanelForm leftPanelForm = new LeftPanelForm();

    public ElementsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and text()='Elements']"), "UniqueElementByElementsPage"), "ElementsPage");
    }
}
