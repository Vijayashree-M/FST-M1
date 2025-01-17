package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void validateJobsTitle() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='main-navigation']//a")).click();
		Thread.sleep(2000);
		String title= driver.getTitle();
		Assert.assertEquals(title,"Jobs – Alchemy Jobs");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}