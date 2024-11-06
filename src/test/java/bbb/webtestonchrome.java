package bbb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.Immutable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;

public class webtestonchrome {
	AppiumDriver driver;

	    @BeforeTest
	    public void SetUP() throws MalformedURLException {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("platformVersion", "12.0");
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("browserName","Chrome");
	        caps.setCapability("chromedriverExecutable",System.getProperty("user.dir") + "/driver/chromedriver.exe");
	        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
	        
	    }
	    @Test
	    public void userLogin()
	    {
	    	driver.get("https://the-internet.herokuapp.com/login");
	    	driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	    	WebElement username=driver.findElementByCssSelector("input#username");
	    	username.sendKeys("tomsmith");
	    	WebElement password=driver.findElementByCssSelector("input#password");
	    	password.sendKeys("SuperSecretPassword!");
	    	WebElement loginbtn=driver.findElementByCssSelector("button.radius");
	    	loginbtn.click();
	    	WebDriverWait wait=new WebDriverWait(driver, 10);
	    	wait.until(ExpectedConditions.urlContains("secure"));
	    }
	    @AfterTest
	    public void tearDown() {
	        if (null != driver) {
	            driver.quit();
	        }
	    }
}
