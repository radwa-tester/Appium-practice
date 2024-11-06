package bbb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class scrolldown {

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
	private void scrollDown(){
	    Dimension dimension=driver.manage().window().getSize();
	    int scrollstart= (int) (dimension.getHeight()*0.8);
	    int scrollend=(int) (dimension.getHeight()*0.1);
	    actions=new AndroidTouchAction(driver);
	    actions.press(PointOption.point(0,scrollstart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	            .moveTo(PointOption.point(0,scrollend)).release().perform();
	}
	    @Test
	    public void scroll_test() {
	        AndroidElement views= (AndroidElement) driver.findElementByAccessibilityId("Views");
	//Tap
	        actions=new AndroidTouchAction(driver);
	        actions.tap(ElementOption.element(views)).perform();
	        //scroll
	scrollDown();
	        AndroidElement Lists= (AndroidElement) driver.findElementByAccessibilityId("Lists");
	    actions.tap(ElementOption.element(Lists)).perform();
	    }
	    @AfterTest
	    public void tearDown() {
	        if (null != driver) {
	            driver.quit();
	        }
	    }
	}


