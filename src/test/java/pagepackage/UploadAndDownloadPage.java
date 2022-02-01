package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Label;
import org.openqa.selenium.By;

public class UploadAndDownloadPage extends BaseForm {

    private final Button downloadButton = new Button(By.xpath("//a[@id='downloadButton']"), "downloadButton");

    private final Button loadFileButton = new Button(By.xpath("//input[@id='uploadFile']"), "LoadFileButton");
    private final Label loadFilePathLabel = new Label(By.xpath("//p[@id='uploadedFilePath']"), "LoadFilePathLabel");

    public UploadAndDownloadPage() {
        super(new Button(By.xpath("//a[@id='downloadButton']"), "UniqueElementByUploadAndDownloadPage"), "UploadAndDownloadPage");
    }

    public String getNameFile() {
        return downloadButton.getValueByAttribute("download");
    }

    public void downloadFile() {
        downloadButton.click();
    }

    public void loadFileByAddress(String address) {
        loadFileButton.setText(address);
    }

    public String getLoadPath() {
        return loadFilePathLabel.getText();
    }
}
