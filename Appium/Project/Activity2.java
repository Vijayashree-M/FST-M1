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

public class Activity2 {
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

	@Test(priority = 1)
	public void addNote() throws InterruptedException {
		driver.findElement(AppiumBy.id("speed_dial_create_close_button")).click();
		driver.findElement(AppiumBy.id("new_note_button")).click();
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("My First Note Vijaya");
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("My First Note's Description Vijaya");
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		String des = driver.findElement(AppiumBy.id("index_note_title")).getText();
		System.out.println(des);
		Assert.assertEquals(des, "My First Note");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}