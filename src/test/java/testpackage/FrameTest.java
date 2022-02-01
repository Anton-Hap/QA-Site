package testpackage;

import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.manager.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepackage.AlertsFramesWindowsPage;
import pagepackage.FramesPage;
import pagepackage.MainPage;
import pagepackage.NestedFramesPage;

public class FrameTest extends BaseTest {

    @Test(priority = 2)
    public void frameTest() {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Alerts, Frame & Windows");

        AlertsFramesWindowsPage alertsFramesWindowsPage = new AlertsFramesWindowsPage();
        alertsFramesWindowsPage.leftPanelForm.switchingToNewPageByButton("Nested Frames");

        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isPageOpen(), "Form is not open");
        Assert.assertEquals(nestedFramesPage.getTextByParentFrame(), "Parent frame", "There is no Parent text");
        Assert.assertEquals(nestedFramesPage.getTextByChildFrame(), "Child Iframe", "There is no Child text");

        nestedFramesPage.exitFromFrame();
        nestedFramesPage.closeAd();
        BrowserManager.scrollToDown();
        nestedFramesPage.leftPanelForm.switchingToNewPageByButton("Frames");

        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpen(), "Form is not open");
        String upText = framesPage.getTextByFirstFrame();
        framesPage.exitFromFrame();
        String downText = framesPage.getTextBySecondFrame();
        Assert.assertEquals(upText, downText, "The Text does not match");
    }
}
