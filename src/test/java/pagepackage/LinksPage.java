package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Link;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {

    private final Link homeLink = new Link(By.xpath("//a[@id='simpleLink']"), "homeLink");

    public LinksPage() {
        super(new Link(By.xpath("//a[@id='simpleLink']"), "UniqueElementByLinksPage"), "LinksPage");
    }

    public void openHomePage() {
        homeLink.click();
    }
}
