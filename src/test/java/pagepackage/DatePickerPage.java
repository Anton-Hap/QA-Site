package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Field;
import org.openqa.selenium.By;

public class DatePickerPage extends BaseForm {

    private final Field datePickerField = new Field(By.xpath("//input[@id='datePickerMonthYearInput']"), "datePickerField");
    private final Field dateAndTimePickerField = new Field(By.xpath("//input[@id='dateAndTimePickerInput']"), "dateAndTimePickerField");

    private final String monthYearTypeFormat = "//select[contains(@class,'%s')]";
    private final String dayFormat = "//div[contains(@aria-label,'%s')]";
    private final String monthYearFormat = "//option[@value='%s']";

    private Button button;

    public DatePickerPage() {
        super(new Field(By.xpath("//input[@id='datePickerMonthYearInput']"), "UniqueElementByDatePickerPage"), "datePickerPage");
    }

    public void openDatePicker() {
        datePickerField.click();
    }

    public String getValueWithDateAndTime() {
        return dateAndTimePickerField.getValue();
    }

    public String getValueWithDate() {
        return datePickerField.getValue();
    }

    public void setMonthYearTypeButton(String type) {
        button = new Button(By.xpath(String.format(monthYearTypeFormat, type)), "MonthYearTypeButton");
        button.click();
    }

    public void setMonthYearButton(String monthYear) {
        button = new Button(By.xpath(String.format(monthYearFormat, monthYear)), "MonthYearButton");
        button.click();
    }

    public void setMonthAndDayButton(String monthAndDay) {
        button = new Button(By.xpath(String.format(dayFormat, monthAndDay)), "MonthAndDayButton");
        button.click();
    }
}
