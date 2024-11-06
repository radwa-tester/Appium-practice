package bbb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class Datewidget {
	AppiumDriver driver;
	private static By pickers1=By.xpath("//android.widget.LinearLayout[@resource-id=\"android:id/timePickerLayout\"]/android.widget.LinearLayout/android.widget.NumberPicker[1]");
	private static By pickers2=By.xpath("//android.widget.LinearLayout[@resource-id=\"android:id/timePickerLayout\"]/android.widget.LinearLayout/android.widget.NumberPicker[2]");
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
	    public void choosedate_test() {
	        AndroidElement views= (AndroidElement) driver.findElementByAccessibilityId("Views");
	//Tap
	        WebDriverWait wait=new WebDriverWait(driver,10);
	        actions=new AndroidTouchAction(driver);
	        actions.tap(ElementOption.element(views)).perform();
	        AndroidElement Datewidgets= (AndroidElement) driver.findElementByAccessibilityId("Date Widgets");
	        actions.tap(ElementOption.element(Datewidgets)).perform();
	        AndroidElement Dialog= (AndroidElement) driver.findElementByAccessibilityId("1. Dialog");
	        actions.tap(ElementOption.element(Dialog)).perform(); 
	        AndroidElement spinner= (AndroidElement) driver.findElementByAccessibilityId("change the time (spinner)");
	        actions.tap(ElementOption.element(spinner)).perform(); 
	        List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickers1));
	        pickerEls.get(0).sendKeys("1");
	        List<WebElement> pickerEls2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickers2));
	        AndroidElement Second= (AndroidElement) pickerEls2.get(1);
	        		Second.sendKeys("02");
	        		
	     
	        System.out.println(Second);
	        
	        
	        
	        
	    }

}
