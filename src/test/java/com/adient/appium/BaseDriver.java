package com.adient.appium;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class BaseDriver {

	public static AppiumDriver<WebElement> driver;
	private static AppiumDriverLocalService service;

	@BeforeClass
	public static void setUp() throws IOException {
		
		if (driver != null) {
			System.out.println(" Driver is not null");
		}
		if (service != null) {
			System.out.println("Service is already runnig");
			return;
		}
		
		
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();

		if( service == null || !service.isRunning() ) {
			throw new AppiumServerHasNotBeenStartedLocallyException(
					"An appium server node is not started!");
		}

		File classpathRoot = new File(System.getProperty("user.dir"));
		System.out.println("CLass Path Root :: - "+classpathRoot.getAbsolutePath());
		File appDir = new File(classpathRoot, "src/test/resources/apk");
		System.out.println("app Dir path :: - "+appDir.getAbsolutePath());
		File app = new File(appDir.getCanonicalPath(), "appiumSample-debug.apk");
		System.out.println("app path :: - "+app.getAbsolutePath()+" , exist "+app.exists());
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.sagar.appiumsample");
		capabilities.setCapability("appActivity", ".MainActivity");
		//capabilities.setCapability("avd", "AndroidTestDevice");
		
		driver = new AndroidDriver<>(service.getUrl(), capabilities);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
		if (service != null) {
			service.stop();
		}
	}

	public MobileElement scrollTo(String text){
		return (MobileElement) driver.findElement(MobileBy.
				AndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".scrollable(true)).scrollIntoView(resourceId(\"android:id/list\")).scrollIntoView("
						+ "new UiSelector().text(\""+text+"\"))"));
	}



}
