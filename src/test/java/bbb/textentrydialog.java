package bbb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class textentrydialog {
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
	    public void Alert_test() throws InterruptedException {
	        AndroidElement APP= (AndroidElement) driver.findElementByAccessibilityId("App");
	        actions=new AndroidTouchAction(driver);
	        actions.tap(ElementOption.element(APP)).perform();
	        AndroidElement Alertdialog= (AndroidElement) driver.findElementByAccessibilityId("Alert Dialogs");
	        actions.tap(ElementOption.element(Alertdialog)).perform();
	        driver.findElementByAccessibilityId("Text Entry dialog").click();
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.alertIsPresent());
	        WebElement firstTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/username_edit")));
	        firstTextBox.sendKeys("Your text for first box");
	        
	        WebElement secondTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/password_edit")));
	        secondTextBox.sendKeys("Your text for second box");
	        
	        
	        driver.switchTo().alert().accept();

}
	    @AfterTest
	    public void tearDown() {
	        if (null != driver) {
	            driver.quit();
	        }
	    }
}
