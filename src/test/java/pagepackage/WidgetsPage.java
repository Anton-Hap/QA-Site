package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Label;
import org.openqa.selenium.By;
import formpackage.LeftPanelForm;

public class WidgetsPage extends BaseForm {

    public final LeftPanelForm leftPanelForm = new LeftPanelForm();

    public WidgetsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Widgets')]"), "UniqueElementByWidgetsPage"), "WidgetsPage");
    }
}
