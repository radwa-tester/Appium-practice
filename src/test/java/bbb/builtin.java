package bbb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class builtin {

	 AppiumDriver driver;

	    @BeforeTest
	    public void SetUP() throws MalformedURLException {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("platformVersion", "14.0");
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("appPackage","com.google.android.calculator");
	        caps.setCapability("appActivity","com.android.calculator2.Calculator");
	        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

	    }
	    @Test
	public void click_test()
	    {
	       // WebDriverWait wait = new WebDriverWait(driver, 10);
	       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/digit_1"))).click();
	driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
	       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/op_add"))).click();
	        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
	       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/digit_3"))).click();
	        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
	        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/eq"))).click();
	        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
	        Assert.assertEquals(driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText(),4);
	    }
	    @AfterTest
	    public void tearDown() {
	        if (null != driver) {
	            driver.quit();
	        }
	    }

	}

