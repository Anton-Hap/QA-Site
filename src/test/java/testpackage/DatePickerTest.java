package testpackage;

import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.logger.Log;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.manager.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagepackage.DatePickerPage;
import pagepackage.MainPage;
import pagepackage.WidgetsPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePickerTest extends BaseTest {

    @Test(priority = 6)
    public void datePickerTest() {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Widgets");

        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.leftPanelForm.switchingToNewPageByButton("Date Picker");

        DatePickerPage datePickerPage = new DatePickerPage();
        Assert.assertTrue(datePickerPage.isPageOpen(), "DatePickerPage is not open");

        Date date = new Date();
        DateFormat dateFormatForDatePicker = new SimpleDateFormat(TestDataManager.getDateFormatForDatePicker());
        DateFormat dateFormatForDateAndTimePicker = new SimpleDateFormat(TestDataManager.getDateFormatForDateAndTimePicker(), Locale.ENGLISH);
        Assert.assertEquals(datePickerPage.getValueWithDate(), dateFormatForDatePicker.format(date), "Date does not match");
        Assert.assertEquals(datePickerPage.getValueWithDateAndTime(), dateFormatForDateAndTimePicker.format(date), "Date and Time do not match");

        DateFormat dateFormatForYear = new SimpleDateFormat("yyyy");
        int leapYear = Integer.parseInt(dateFormatForYear.format(date));
        while (leapYear % 4 != 0) {
            leapYear++;
        }
        Log.getLogger().info("Leap year is " + leapYear);

        datePickerPage.openDatePicker();

        datePickerPage.setMonthYearTypeButton("year");
        datePickerPage.setMonthYearButton(String.valueOf(leapYear));

        datePickerPage.setMonthYearTypeButton("month");
        datePickerPage.setMonthYearButton(TestDataManager.getNumberMonth());

        datePickerPage.setMonthAndDayButton(TestDataManager.getSelectedDate());
        Assert.assertEquals(datePickerPage.getValueWithDate(), TestDataManager.getCorrectDate(), "Date does not match");
    }
}
