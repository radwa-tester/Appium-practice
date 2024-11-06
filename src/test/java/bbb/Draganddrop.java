package bbb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class Draganddrop {

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
    public  void drag_drop()
    {
        // click on views
        AndroidElement views= (AndroidElement) driver.findElementByAccessibilityId("Views");
        actions=new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();
        //click on Drag and drop
        AndroidElement drag_drop= (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        actions.tap(ElementOption.element(drag_drop)).perform();
        AndroidElement drag=(AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        AndroidElement drop=(AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
        actions.longPress(ElementOption.element(drag)).waitAction().moveTo(ElementOption.element(drop)).release().perform();
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");
    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}

