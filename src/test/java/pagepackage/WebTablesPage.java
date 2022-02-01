package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Table;
import org.openqa.selenium.By;
import formpackage.RegistrationForm;

public class WebTablesPage extends BaseForm {

    private final Button addButton = new Button(By.xpath("//button[contains(@id,'add')]"), "addButton");
    private final Button adCloseButton = new Button(By.xpath("//img[contains(@alt,'adplus')]"), "adCloseButton");

    public final RegistrationForm registrationForm = new RegistrationForm();

    private final By cellTable = By.xpath(".//div[@class='rt-td']");

    private final String deleteUserFormat = "//div[@class='rt-td' and text()='%s']//following-sibling::div//span[@title='Delete']";

    private Button deleteButton;

    private final Table table = new Table(By.xpath("//div[@class='rt-table']"), "Table");

    public WebTablesPage() {
        super(new Button(By.xpath("//button[contains(@id,'add')]"), "UniqueElementByWebTablesPage"), "WebTablesPage");
    }

    public void openRegistrationForm() {
        addButton.click();
    }

    public void closeAd() {
        adCloseButton.click();
    }

    public void deleteUserFromTableByEmail(String email) {
        deleteButton = new Button(By.xpath(String.format(deleteUserFormat, email)), "DeleteButton");
        deleteButton.click();
    }

    public boolean isField(String text) {
        return table.isFieldWithText(cellTable, text);
    }

    public int getCount() {
        return table.getCountElementWithText(cellTable, "@");
    }
}
