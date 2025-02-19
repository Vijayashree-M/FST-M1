package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void validateHeading() {
		WebElement heading= driver.findElement(By.cssSelector("h1.entry-title"));
		Assert.assertEquals(heading.getText(), "Welcome to Alchemy Jobs");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}