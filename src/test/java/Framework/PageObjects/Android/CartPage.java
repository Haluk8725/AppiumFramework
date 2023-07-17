package Framework.PageObjects.Android;

import Framework.PageObjects.Utils.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class CartPage extends AndroidAction  {
AndroidDriver driver;
    public CartPage(AndroidDriver driver) {
        super(driver); // We use super because of using common driver. This is important when we extend any class.

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement longPressElement;
    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceed;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButton;
    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")
    private List<WebElement> productList;

    public List<WebElement> getProductList() {
        return productList;
    }
    public double getProductSum(){
        double totalSum=0;
        for (WebElement price : getProductList()) {
            double value = getFormatAmount(price.getText().substring(1));
            totalSum += value;
        }
        System.err.println(totalSum);
        return totalSum;
    }
    public double getFormatAmount(String amount){
        Double price= Double.parseDouble(amount);
        return price;
    }
    public double getTotalAmount(){
        double total=getFormatAmount(totalAmount.getText().substring(1));
        return total;
    }

    public void setLongPressElement() throws InterruptedException {
        longPressAction(longPressElement);
    }
    public void clickAcceptButton(){
        acceptButton.click();
    }

    public void submitOrder(){
        checkBox.click();
        proceed.click();
    }
}
