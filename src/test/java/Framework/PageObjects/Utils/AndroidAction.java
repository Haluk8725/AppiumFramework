package Framework.PageObjects.Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AndroidAction {
    AndroidDriver driver;

    public AndroidAction(AndroidDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement element) throws InterruptedException {
        Actions action = new Actions(driver);
        action.clickAndHold(element);
        action.perform();
        Thread.sleep(2000);
    }
    public void scrollText(String text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));


    }
}
