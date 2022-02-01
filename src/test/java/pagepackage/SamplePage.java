package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Label;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {

    public SamplePage() {
        super(new Label(By.xpath("//h1[@id='sampleHeading']"), "UniqueElementBySamplePage"), "SamplePage");
    }
}
