package testpackage;

import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.logger.Log;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.manager.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepackage.MainPage;
import pagepackage.ProgressBarPage;
import pagepackage.SliderPage;
import pagepackage.WidgetsPage;

public class BarTest extends BaseTest {

    @Test(priority = 5)
    public void barTest() {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Widgets");

        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.leftPanelForm.switchingToNewPageByButton("Slider");

        SliderPage sliderPage = new SliderPage();
        Assert.assertTrue(sliderPage.isPageOpen(), "SliderPage is not open");

        int newNumber = (int) (Math.random() * TestDataManager.getMaxValueSlider()) + TestDataManager.getMinValueSlider();
        Log.getLogger().info(newNumber + " - random value");
        int oldNumber = Integer.parseInt(sliderPage.getValueBySlider());
        Log.getLogger().info(oldNumber + " - old value by slider");
        sliderPage.moveSliderToNumber(newNumber - oldNumber);
        Assert.assertEquals(newNumber, Integer.parseInt(sliderPage.getValueBySliderField()), "Random value and Slider value are not equal");

        BrowserManager.scrollToDown();
        sliderPage.leftPanelForm.switchingToNewPageByButton("Progress Bar");

        ProgressBarPage progressBarPage = new ProgressBarPage();
        Assert.assertTrue(progressBarPage.isPageOpen(), "ProgressBarPage is not open");

        progressBarPage.startStopProgressBar();
        if (progressBarPage.waitLoadByPercent(TestDataManager.getEngineersAge())) {
            progressBarPage.startStopProgressBar();

        }
        Assert.assertTrue(progressBarPage.getTextProgressBar().contains(TestDataManager.getEngineersAge()), "ProgressBar didn't load successfully");
    }
}
