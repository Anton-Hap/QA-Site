package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Label;
import framework.objectbrowserpackage.PopUpMessages;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {

    private Button button;

    private final String buttonFormat = "//button[@id='%s']";

    private Label resultLabel;

    public AlertsPage() {
        super(new Button(By.xpath("//button[@id='promtButton']"), "UniqueElementByAlertsPage"), "AlertsPage");
    }

    public void openPopUpMessageByButton(String type) {
        button = new Button(By.xpath(String.format(buttonFormat, type)), type);
        button.click();
    }

    public void acceptPopUpMessage() {
        PopUpMessages.accept();
    }

    public String getPopUpMessageText() {
        return PopUpMessages.getText();
    }

    public boolean isPopUpMessage() {
        return PopUpMessages.isPopUpMessages();
    }

    public void setPopUpMessageText(String text) {
        PopUpMessages.setText(text);
    }

    public String getResultByPopUpMessage(String popUpMessage) {
        resultLabel = new Label(By.xpath(String.format("//span[@id='%s']", popUpMessage)), popUpMessage + "Label");
        return resultLabel.getText();
    }
}
