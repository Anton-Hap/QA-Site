package pagepackage;

import framework.baseformpackage.BaseForm;
import framework.elementspackage.Field;
import framework.elementspackage.Slider;
import org.openqa.selenium.By;
import formpackage.LeftPanelForm;

public class SliderPage extends BaseForm {

    public final LeftPanelForm leftPanelForm = new LeftPanelForm();

    private final Slider slider = new Slider(By.xpath("//input[@type='range']"), "slider");

    private final Field sliderValueField = new Field(By.xpath("//input[@id='sliderValue']"), "sliderValueField");

    public SliderPage() {
        super(new Slider(By.xpath("//input[@type='range']"), "UniqueElementBySliderPage"), "SliderPage");
    }

    public void moveSliderToNumber(int number) {
        slider.moveToNumber(number);
    }

    public String getValueBySliderField() {
        return sliderValueField.getValue();
    }

    public String getValueBySlider() {
        return slider.getValue();
    }
}
