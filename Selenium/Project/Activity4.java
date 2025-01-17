package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void validateSecondHeading() {
		WebElement secondHeading= driver.findElement(By.xpath("//div[@class='entry-content clear']/h2"));
		Assert.assertEquals(secondHeading.getText(), "Quia quis non");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}