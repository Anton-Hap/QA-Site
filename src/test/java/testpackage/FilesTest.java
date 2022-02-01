package testpackage;

import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.manager.FileManager;
import framework.utilpackage.manager.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepackage.*;

public class FilesTest extends BaseTest {

    @Test(priority = 7)
    public void filesTest() {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Elements");

        ElementsPage elementsPage = new ElementsPage();
        elementsPage.leftPanelForm.switchingToNewPageByButton("Upload and Download");

        UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();
        Assert.assertTrue(uploadAndDownloadPage.isPageOpen(), "UploadAndDownloadPage is not open");

        String nameFile = uploadAndDownloadPage.getNameFile();
        FileManager.setFileByAddress(TestDataManager.getAddressFile() + nameFile);
        uploadAndDownloadPage.downloadFile();
        Assert.assertTrue(FileManager.existsFile(), "File was not downloaded");

        uploadAndDownloadPage.loadFileByAddress(TestDataManager.getAddressFile() + nameFile);
        Assert.assertTrue(uploadAndDownloadPage.getLoadPath().contains(nameFile), "The path is not correct");
    }
}
