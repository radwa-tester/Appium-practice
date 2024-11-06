package bbb;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class sendingphotos {
	public AndroidDriver driver;
	private static By accountlistarrow=By.id("com.google.android.apps.photos:id/account_list_arrow");
	private static By usewithoutaccount=By.xpath("//android.widget.TextView[@text=\"Use without an account\"]");
	private static By Notnowbtn=By.id("com.google.android.apps.photos:id/negative_button");
	private static By backupBtn=By.id("com.google.android.apps.photos:id/not_now_button");
	private static By photo=By.xpath("//android.view.ViewGroup[contains(@content-desc.'photo taken')]");
	File classpath,imageDir,img;
	String imgName="81z6Hgjh3ML._AC_SX466_.jpg";
	@BeforeTest
    public void SetUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.apps.photos");
        caps.setCapability("appActivity", "com.google.android.apps.photos.home.HomeActivity");
        
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }
	@Test
	public void testslider() throws IOException {
		classpath=new File(System.getProperty("user.dir"));
		imageDir=new File(classpath,"/resources/images");
		img=new File(imageDir.getCanonicalFile(),imgName);
		WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(backupBtn)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(accountlistarrow)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(usewithoutaccount)).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(Notnowbtn)).click();
		//String Android_photo_path="mnt/sdcard/Pictures";
		String Android_photo_path="storage/0EED-3B13/Download";
		driver.pushFile(Android_photo_path+"/"+img.getName(),img);
		org.openqa.selenium.support.ui.ExpectedCondition<List<WebElement>> condition= ExpectedConditions.numberOfElementsToBe(photo, 1);
	}
	@AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }}
}
