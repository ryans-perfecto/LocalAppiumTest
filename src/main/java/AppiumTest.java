import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest {
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static IOSDriver<IOSElement> driver;
//	public static AndroidDriver<AndroidElement> driver;

	@BeforeSuite
	public void setupAppium() throws MalformedURLException {

		System.out.println("Starting Test");

		final String URL_STRING = "http://localhost:4723/wd/hub";
		url = new URL(URL_STRING);

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", ""); //XCUITEST or UIAutomator2
		capabilities.setCapability("platformName", ""); //iOS or Android
		capabilities.setCapability("deviceName", ""); //Device's Model
		capabilities.setCapability("udid", ""); //Udid of the device
//		capabilities.setCapability("app", ""); //Location of the App if you are installing it
//		capabilities.setCapability("bundleId", ""); //iOS App Identifier
//		capabilities.setCapability("appPackage", ""); //Android App Identifier
//		capabilities.setCapability("appActivity", ""); //Activity to start Android App
		capabilities.setCapability("noReset", true); //Set this to not remove the app after test
//		capabilities.setCapability("startIWDP", true); //iOS WebDebug Proxy for Hybrid Applications

		driver = new IOSDriver<IOSElement>(url, capabilities);
//		driver = new AndroidDriver<AndroidElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Instantiated Driver and Opened App");

	}

	@AfterSuite
	public void endProject() throws InterruptedException {

		try {
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Run ended");

	}

	@Test(enabled = true)
	public void myTest() throws InterruptedException {
			try {
				
			//Write your test here

		} catch (Exception e) {
			e.printStackTrace();}
			
	}

	public void switchToWebView() {
		System.out.println("Checking for Number of Contexts");
		Set<String> availableContexts = driver.getContextHandles();
		System.out.println("Total Number of Contexts Found After we reach to WebView = " + availableContexts.size());
		for (String context : availableContexts) {
			if (context.contains("WEBVIEW")) {
				System.out.println("Context Name is " + context);
				driver.context(context);
				System.out.println("Switched Context");
				break;
			}
		}
	}
}
