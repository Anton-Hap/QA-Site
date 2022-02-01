package testpackage;

import framework.utilpackage.manager.BrowserManager;
import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.manager.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepackage.*;

public class WindowsTest extends BaseTest {

    @Test(priority = 4)
    public void windowsTest() {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Alerts, Frame & Windows");

        AlertsFramesWindowsPage alertsFramesWindowsPage = new AlertsFramesWindowsPage();
        alertsFramesWindowsPage.leftPanelForm.switchingToNewPageByButton("Browser Windows");

        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isPageOpen(), "Form is not open");

        String oldPage = BrowserManager.getHandle();
        browserWindowsPage.openSamplePage();

        SamplePage samplePage = new SamplePage();
        BrowserManager.changeHandleTab();
        Assert.assertTrue(BrowserManager.getUrl().contains(TestDataManager.getUrlNewTab()), "Url doesn't contains /sample");
        Assert.assertTrue(samplePage.isPageOpen(), "SamplePage is not open");

        BrowserManager.closePage();
        BrowserManager.goToWindowByHandle(oldPage);
        Assert.assertTrue(browserWindowsPage.isPageOpen(), "Form is not open");

        browserWindowsPage.leftPanelForm.openingMenuByButton("Elements");
        browserWindowsPage.leftPanelForm.switchingToNewPageByButton("Links");

        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpen(), "LinkPage is not open");

        linksPage.openHomePage();
        BrowserManager.changeHandleTab();
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.changeHandleTab();
        Assert.assertTrue(linksPage.isPageOpen(), "LinkPage is not open");
    }
}
