package bbb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;

public class clipboard {
	
	private AndroidDriver<WebElement>driver1;

	    @BeforeTest
	    public void SetUP() throws MalformedURLException {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("platformVersion", "12.0");
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("app", System.getProperty("user.dir") +"/APP/selendroid-test-app-0.17.0.apk");
	        caps.setCapability("noReset", true);
	        driver1 = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

	    }
	    @Test
	    public void clipboardtest()
	    {
	    	String txt="hello radwa";
	    	driver1.setClipboardText(txt);;
	    	MobileElement nametxt=(MobileElement) driver1.findElement(By.id("io.selendroid.testapp:id/my_text_field"));
	    	nametxt.clear();
	    	nametxt.sendKeys(driver1.getClipboardText());
	    	Assert.assertEquals(txt,nametxt.getText());
	    }
	    @AfterTest
	    public void tearDown() {
	        if (null != driver1) {
	            driver1.quit();
	        }
}
}
