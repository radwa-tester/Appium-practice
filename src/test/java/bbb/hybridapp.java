package bbb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class hybridapp {
	AppiumDriver driver;
private static By chromebtn=MobileBy.id("io.selendroid.testapp:id/buttonStartWebview");
private static By gotoHomebtn=MobileBy.id("io.selendroid.testapp:id/goBack");
private static By nameinput=MobileBy.cssSelector("#name_input");
private static By webframe=MobileBy.id("io.selendroid.testapp:id/tableRowWebview");
    @BeforeTest
    public void SetUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "emulator-5554");
        
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("app",System.getProperty("user.dir") + "/APP/selendroid-test-app-0.17.0.apk");
        caps.setCapability("noReset", true);
        caps.setCapability("chromedriverExecutable",System.getProperty("user.dir") + "/driver/chromedriver.exe");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        
    }
    public void switchtowebview() {
    	Set<String>contexts=driver.getContextHandles();
    	boolean webViewFound = false;
    	for (String context:contexts) {
    		System.out.println("Available context: " + context);
    		if(context.contains("WEBVIEW")) {
    			driver.context(context);
    			webViewFound = true;
    			break;
    		}
    	}
    	if (!webViewFound) {
            System.out.println("No WebView context found.");}	
    
    	}
    	
    @Test
    public void HybridTest()
    {
    	WebDriverWait wait=new WebDriverWait(driver,100);
    	wait.until(ExpectedConditions.presenceOfElementLocated(chromebtn)).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(webframe)).click();
    	
    	//switchtowebview();
    	Set<String>contexts=driver.getContextHandles();
    	boolean webViewFound = false;
    	for (String context : contexts) {
    	    if (context.contains("WEBVIEW")) {
    	        driver.context(context);
    	        System.out.println("Switched to context: " + context);
    	        break;
    	    }
    	}
    	//wait.until(ExpectedConditions.presenceOfElementLocated(nameinput)).click();
    	WebElement nameinput=driver.findElement(By.cssSelector("#name_input"));
    	 nameinput.clear();
    	String name="radwa";
    	nameinput.sendKeys(name);
    	driver.context("NATIVE_APP");
    	driver.findElement(gotoHomebtn).click();
    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
