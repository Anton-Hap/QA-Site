package pagepackage;

import framework.elementspackage.Label;
import org.openqa.selenium.By;
import formpackage.LeftPanelForm;
import framework.baseformpackage.BaseForm;

public class AlertsFramesWindowsPage extends BaseForm {

    public final LeftPanelForm leftPanelForm = new LeftPanelForm();

    public AlertsFramesWindowsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Alerts')]"), "UniqueElementByAlertsFramesWindowsPage"), "AlertsFramesWindowsPage");
    }
}
