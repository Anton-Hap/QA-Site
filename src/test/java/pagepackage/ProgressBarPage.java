package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.ProgressBar;
import org.openqa.selenium.By;

public class ProgressBarPage extends BaseForm {

    private final Button startStopButton = new Button(By.xpath("//button[@id='startStopButton']"), "startStopButton");

    private final ProgressBar progressBar = new ProgressBar(By.xpath("//div[contains(@class,'progress-bar')]"), "progressBar");

    public ProgressBarPage() {
        super(new Button(By.xpath("//button[@id='startStopButton']"), "UniqueElementByProgressBarPage"), "ProgressBarPage");
    }

    public void startStopProgressBar() {
        startStopButton.click();
    }

    public boolean waitLoadByPercent(String percent) {
        return progressBar.waitLoadByPercentAndAttribute(percent, "aria-valuenow");
    }

    public String getTextProgressBar() {
        return progressBar.getText();
    }
}
