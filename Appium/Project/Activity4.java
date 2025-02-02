package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test
	public void addToDoList() {
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button")));
		Dimension dims = driver.manage().window().getSize();
		
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .50));
		Point end = new Point((int) (dims.getWidth() * .75), (int) (dims.getHeight() * .50));
		
		ActionsBase.doSwipe(driver, start, end, 2000);
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"To-Do List  Elements get added at run time \"]")).click();
		driver.findElement(AppiumBy.id("taskInput")).sendKeys("Add tasks to list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		driver.findElement(AppiumBy.id("taskInput")).sendKeys("Get number of tasks");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		driver.findElement(AppiumBy.id("taskInput")).sendKeys("Clear the list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		List<WebElement> beforeTask = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View"));
		for(WebElement t : beforeTask) {
			t.click();
		}
		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksCard\"]/android.view.View[3]")).click();
		List<WebElement> afterTask = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View"));
		Assert.assertEquals(0, afterTask.size());
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}