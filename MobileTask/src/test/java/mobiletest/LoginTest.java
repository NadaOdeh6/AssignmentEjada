package mobiletest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
	 private AndroidDriver<MobileElement> driver;

	    @BeforeClass
	    public void setUp() throws MalformedURLException {
	        // Set Desired Capabilities for Appium
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	        capabilities.setCapability(MobileCapabilityType.APP, "path/to/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
	        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

	        // Create the driver instance
	        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
	    }

	    @Test
	    public void positiveLoginTest() {
	        // Locate username and password fields, and login button
	        MobileElement usernameField = driver.findElementByAccessibilityId("test-Username");
	        MobileElement passwordField = driver.findElementByAccessibilityId("test-Password");
	        MobileElement loginButton = driver.findElementByAccessibilityId("test-LOGIN");

	        // Perform the login action
	        usernameField.sendKeys("standard_user");
	        passwordField.sendKeys("secret_sauce");
	        loginButton.click();

	        // Assert that login was successful by checking if the products page is displayed
	        MobileElement productsTitle = driver.findElementByXPath("//android.widget.TextView[@text='PRODUCTS']");
	        Assert.assertTrue(productsTitle.isDisplayed(), "Login failed - Products page not displayed");
	    }

	    @Test
	    public void negativeLoginTest() {
	        // Locate username and password fields, and login button
	        MobileElement usernameField = driver.findElementByAccessibilityId("test-Username");
	        MobileElement passwordField = driver.findElementByAccessibilityId("test-Password");
	        MobileElement loginButton = driver.findElementByAccessibilityId("test-LOGIN");

	        // Perform the login action with incorrect credentials
	        usernameField.sendKeys("invalid_user");
	        passwordField.sendKeys("invalid_password");
	        loginButton.click();

	        // Assert that login failed by checking if the error message is displayed
	        MobileElement errorMessage = driver.findElementByXPath("//android.widget.TextView[@text='Username and password do not match any user in this service.']");
	        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
