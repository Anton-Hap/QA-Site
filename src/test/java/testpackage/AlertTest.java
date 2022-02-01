package testpackage;

import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.logger.Log;
import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.manager.TestDataManager;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepackage.AlertsFramesWindowsPage;
import pagepackage.AlertsPage;
import pagepackage.MainPage;

public class AlertTest extends BaseTest {

    @Test(priority = 1)
    public void alertTest() {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Alerts, Frame & Windows");

        AlertsFramesWindowsPage alertsFramesWindowsPage = new AlertsFramesWindowsPage();
        alertsFramesWindowsPage.leftPanelForm.switchingToNewPageByButton("Alerts");

        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isPageOpen(), "AlertsPage is not open");

        alertsPage.openPopUpMessageByButton("alertButton");
        Assert.assertEquals(alertsPage.getPopUpMessageText(), "You clicked a button", "Alert is not open");

        alertsPage.acceptPopUpMessage();
        Assert.assertFalse(alertsPage.isPopUpMessage(), "Alert is not closed");

        alertsPage.openPopUpMessageByButton("confirmButton");
        Assert.assertEquals(alertsPage.getPopUpMessageText(), "Do you confirm action?", "Confirm is not open");

        alertsPage.acceptPopUpMessage();
        Assert.assertFalse(alertsPage.isPopUpMessage(), "Confirm is not closed");
        Assert.assertTrue(alertsPage.getResultByPopUpMessage("confirmResult").contains("You selected Ok"), "ConfirmResult is not OK");

        alertsPage.openPopUpMessageByButton("promtButton");
        Assert.assertEquals(alertsPage.getPopUpMessageText(), "Please enter your name", "Prompt is not open");

        String randomText = RandomStringUtils.randomAlphanumeric(TestDataManager.getSizeRandomNumber());
        Log.getLogger().info("Random text is " + randomText);
        alertsPage.setPopUpMessageText(randomText);
        alertsPage.acceptPopUpMessage();
        Assert.assertFalse(alertsPage.isPopUpMessage(), "Prompt is not close");
        Assert.assertTrue(alertsPage.getResultByPopUpMessage("promptResult").contains(randomText), "PromptResult is not OK");
    }
}
