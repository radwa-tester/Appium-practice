package bbb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class swipe {
	AppiumDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void SetUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", System.getProperty("user.dir") + "/APP/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }
    @Test
    public void swipe_test()
    {
        // click on views
        AndroidElement views= (AndroidElement) driver.findElementByAccessibilityId("Views");
        actions=new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();
        // click on Gallery
        AndroidElement Gallery= (AndroidElement) driver.findElementByAccessibilityId("Gallery");
        actions=new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(Gallery)).perform();
        // click on photos
        AndroidElement PHOTOS= (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
        actions=new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(PHOTOS)).perform();
        AndroidElement pic1=(AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
        actions.press(ElementOption.element(pic1)).waitAction()
                .moveTo(PointOption.point(-20,2000))
                .release()
                .perform();

    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}


