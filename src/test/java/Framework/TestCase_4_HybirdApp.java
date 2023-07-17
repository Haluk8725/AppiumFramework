package Framework;

import Framework.PageObjects.Android.CartPage;
import Framework.PageObjects.Android.FormPage;
import Framework.PageObjects.Android.ProductCatalogue;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestCase_4_HybirdApp extends BasePage {
    @Test
    public void AddChart() throws InterruptedException {

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        formPage.setNameField("Deniz Seven");
        formPage.setGender("female");
        formPage.setCountry("Argentina");
        formPage.submitButton.click();
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogue.goCartPage();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        cartPage.getProductList();
        cartPage.getProductSum();
        System.out.println(cartPage.getTotalAmount());
        cartPage.setLongPressElement();
        cartPage.clickAcceptButton();
        cartPage.submitOrder();

        Thread.sleep(10000);
        Set<String> context = driver.getContextHandles();
        for (String each : context) {
            System.out.println(each);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Haluk Ural");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


    }
}