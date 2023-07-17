package Framework.PageObjects.Android;

import Framework.PageObjects.Utils.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidAction {
    AndroidDriver driver;

    public ProductCatalogue(AndroidDriver driver) {
        super(driver); // We use super because of using common driver. This is important when we extend any class.

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> elements;
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cartElement;


    public void addItemToCartByIndex(int index){
    elements.get(index).click();
    }
    public CartPage goCartPage() throws InterruptedException {
        cartElement.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }
}
