package framework.utilpackage.manager;

import framework.utilpackage.logger.Log;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataManager {

    private static Properties properties;

    public TestDataManager() {
        start();
    }

    public static void start() {
        properties = new Properties();
        fileConnection();
    }

    private static void fileConnection() {
        try {
            Log.getLogger().info("TestData File has been read");
            properties.load(new FileReader("src/test/java/resources/TestData"));
        } catch (IOException e) {
            throw new RuntimeException("TestData File not read");
        }
    }

    private static Properties getProperties() {
        if (properties == null) {
            start();
        }

        return properties;
    }

    public static String getFirstName() {
        return getProperties().getProperty("FirstName");
    }

    public static String getLastName() {
        return getProperties().getProperty("LastName");
    }

    public static String getEmail() {
        return getProperties().getProperty("Email");
    }

    public static String getAge() {
        return getProperties().getProperty("Age");
    }

    public static String getSalary() {
        return getProperties().getProperty("Salary");
    }

    public static String getDepartment() {
        return getProperties().getProperty("Department");
    }

    public static String getCorrectDate() {
        return getProperties().getProperty("CorrectDate");
    }

    public static String getAddressFile() {
        return getProperties().getProperty("AddressFile");
    }

    public static String getSelectedDate() {
        return getProperties().getProperty("SelectedDate");
    }

    public static String getNumberMonth() {
        return getProperties().getProperty("NumberMonth");
    }

    public static String getDateFormatForDateAndTimePicker() {
        return getProperties().getProperty("DateFormatForDateAndTimePicker");
    }

    public static String getDateFormatForDatePicker() {
        return getProperties().getProperty("DateFormatForDatePicker");
    }

    public static String getEngineersAge() {
        return getProperties().getProperty("EngineersAge");
    }

    public static int getMinValueSlider() {
        return Integer.parseInt(getProperties().getProperty("MinValueSlider"));
    }

    public static int getMaxValueSlider() {
        return Integer.parseInt(getProperties().getProperty("MaxValueSlider"));
    }

    public static String getUrlNewTab() {
        return getProperties().getProperty("UrlNewTab");
    }

    public static int getSizeRandomNumber() {
        return Integer.parseInt(getProperties().getProperty("SizeRandomNumber"));
    }

    public static String getIdByNumber(int number) {
        return getProperties().getProperty("UserID_" + number);
    }

    public static String getFirstNameByNumber(String number) {
        return getProperties().getProperty("FirstName_" + number);
    }

    public static String getLastNameByNumber(String number) {
        return getProperties().getProperty("LastName_" + number);
    }

    public static String getEmailByNumber(String number) {
        return getProperties().getProperty("Email_" + number);
    }

    public static String getAgeByNumber(String number) {
        return getProperties().getProperty("Age_" + number);
    }

    public static String getSalaryByNumber(String number) {
        return getProperties().getProperty("Salary_" + number);
    }

    public static String getDepartmentByNumber(String number) {
        return getProperties().getProperty("Department_" + number);
    }
}
