package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
	}

	@Test
	public void addReminder() {
		driver.findElement(AppiumBy.id("speed_dial_create_close_button")).click();
		driver.findElement(AppiumBy.id("new_note_button")).click();
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("My First Note Vijaya");
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("My First Note's Description Vijaya");
		driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/menu_text' and @text='Tomorrow morning']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		String des = driver.findElement(AppiumBy.id("index_note_text_description")).getText();
		System.out.println(des);
		Assert.assertEquals(des, "Reminder at February 2, 8:00 AM");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}