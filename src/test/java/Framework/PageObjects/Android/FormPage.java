package Framework.PageObjects.Android;

import Framework.PageObjects.Utils.AndroidAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidAction {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver); // We use super because of using common driver. This is important when we extend any class.

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    //   driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Deniz Seven");
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    public WebElement femaleRadio;
    // driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    public WebElement maleRadio;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement Country;
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public WebElement submitButton;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard(); //  it enable us hide the keyboard.
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female"))
            femaleRadio.click();
        else
            maleRadio.click();
    }
    public void setCountry(String country){
        Country.click();
      scrollText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\'"+country+"\']")).click();
    }

    public void submitForm(){

    }
}
