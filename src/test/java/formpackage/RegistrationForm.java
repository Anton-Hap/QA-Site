package formpackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Button;
import framework.elementspackage.Field;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {

    private final Button submitButton = new Button(By.xpath("//button[@id='submit']"), "submitButton");

    private final String fieldFormat = "//input[@id='%s']";

    public RegistrationForm() {
        super(new Field(By.xpath("//input[@id='firstName']"), "UniqueElementByRegistrationForm"), "RegistrationForm");
    }

    public void setTextInField(String text, String nameField) {
        Field field = new Field(By.xpath(String.format(fieldFormat, nameField)), nameField + "FieldByRegistration");
        field.setText(text);
    }

    public void submit() {
        submitButton.click();
    }
}
