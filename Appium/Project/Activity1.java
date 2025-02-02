package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
	}

	@Test(priority = 1)
	public void addTask() {
		WebElement title;
		// driver.findElement(AppiumBy.id("welcome_get_started")).click();
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		title = driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"));
		title.sendKeys("Complete Activity with Google Tasks");
		driver.findElement(AppiumBy.id("add_task_done")).click();
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mark as complete\"]")).click();
	}

	@Test(priority = 2)
	public void addSecTask() {
		WebElement title; // task2
		driver.findElement(AppiumBy.id("tasks_fab")).click();
		title = driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"));
		title.sendKeys("Complete Activity with Google Keep");
		driver.findElement(AppiumBy.id("add_task_done")).click();
		driver.findElement(AppiumBy.id("tasks_item_completed_check")).click();
	}

	@Test(priority = 3)
	public void addThirdTask() {
		WebElement title; // task3
		driver.findElement(AppiumBy.id("tasks_fab")).click();
		title = driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"));
		title.sendKeys("Complete the second Activity Google Keep");
		driver.findElement(AppiumBy.id("add_task_done")).click();
		driver.findElement(AppiumBy.id("tasks_item_completed_check")).click();

	}

	@Test(priority = 2)
	public void markCompleted() {
		String message = driver.findElement(AppiumBy.id("tasks_empty_state_header")).getText();
		Assert.assertEquals(message, "All tasks completed");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}