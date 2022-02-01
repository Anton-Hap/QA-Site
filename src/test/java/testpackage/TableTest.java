package testpackage;

import framework.driverpackage.DriverSingleton;
import framework.testpackage.BaseTest;
import framework.utilpackage.manager.BrowserManager;
import framework.utilpackage.manager.ConfigManager;
import framework.utilpackage.manager.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import modelspackage.User;
import pagepackage.ElementsPage;
import pagepackage.MainPage;
import pagepackage.WebTablesPage;

public class TableTest extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] userForTableTest() {
        return new Object[][] {
                new Object[] {new User(TestDataManager.getIdByNumber(1))},
                new Object[] {new User(TestDataManager.getIdByNumber(2))}
        };
    }

    @Test(dataProvider = "users", priority = 3)
    public void tableTest(User user) {
        MainPage mainPage = new MainPage();
        DriverSingleton.getDriver().get(ConfigManager.getUrlFirstPage());
        Assert.assertTrue(mainPage.isPageOpen(), "It's not MainPage");

        BrowserManager.scrollToDown();
        mainPage.switchingToNewPageByButton("Elements");

        ElementsPage elementsPage = new ElementsPage();
        BrowserManager.scrollToDown();
        elementsPage.leftPanelForm.switchingToNewPageByButton("Web Tables");

        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isPageOpen(), "It's not WebTablesPage");

        webTablesPage.openRegistrationForm();
        Assert.assertTrue(webTablesPage.registrationForm.isPageOpen(), "RegistrationForm is not open");

        webTablesPage.registrationForm.setTextInField(user.getFirstName(), TestDataManager.getFirstName());
        webTablesPage.registrationForm.setTextInField(user.getLastName(), TestDataManager.getLastName());
        webTablesPage.registrationForm.setTextInField(user.getEmail(), TestDataManager.getEmail());
        webTablesPage.registrationForm.setTextInField(user.getAge(), TestDataManager.getAge());
        webTablesPage.registrationForm.setTextInField(user.getSalary(), TestDataManager.getSalary());
        webTablesPage.registrationForm.setTextInField(user.getDepartment(), TestDataManager.getDepartment());

        webTablesPage.closeAd();
        webTablesPage.registrationForm.submit();
        Assert.assertTrue(webTablesPage.registrationForm.isPageNotOpen(), "RegistrationForm is not closed");

        Assert.assertTrue(webTablesPage.isField(user.getFirstName()), "FirstName is not displayed");
        Assert.assertTrue(webTablesPage.isField(user.getLastName()), "LastName is not displayed");
        Assert.assertTrue(webTablesPage.isField(user.getEmail()), "Email is not displayed");
        Assert.assertTrue(webTablesPage.isField(user.getAge()), "Age is not displayed");
        Assert.assertTrue(webTablesPage.isField(user.getSalary()), "Salary is not displayed");
        Assert.assertTrue(webTablesPage.isField(user.getDepartment()), "Department is not displayed");

        int firstCountInTable = webTablesPage.getCount();
        webTablesPage.deleteUserFromTableByEmail(user.getEmail());
        Assert.assertTrue(firstCountInTable > webTablesPage.getCount(), "The number of records has not decreased");
        Assert.assertFalse(webTablesPage.isField(user.getEmail()), "User has not been deleted");
    }
}
