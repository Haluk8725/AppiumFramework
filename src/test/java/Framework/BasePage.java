package Framework;

import Framework.PageObjects.Android.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
/*  *****For installation****
C:\Users\haluk\AppData\Local\Android\Sdk\platform-tools>
adb install C:\Users\haluk\IdeaProjects\AppiumFreamwork\src\test\resources\file\General-Store.apk
 */

        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\haluk\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").withTimeout(Duration.ofSeconds(3000)).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Last");
        options.setChromedriverExecutable("C:\\Users\\haluk\\Desktop\\chromedriver_win32\\chromedriver.exe");
        options.setApp("C:\\Users\\haluk\\IdeaProjects\\AppiumFreamwork\\src\\test\\resources\\file\\General-Store.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        formPage=new FormPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();}

}
