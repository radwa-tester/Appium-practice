package bbb;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class sendingsms {

	AndroidDriver driver;

    @BeforeTest
    public void SetUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

    @Test
    public void sendsms() {
driver.sendSMS("650-555-1212","hello radwa");
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
