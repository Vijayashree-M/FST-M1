package seleniumproject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void validateTitle() {
		Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}