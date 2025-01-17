package seleniumproject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void applyJob() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='main-navigation']//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Banking");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='job_listings']//li[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Apply for job']")));
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		String email= driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
		Assert.assertEquals(email, "ponty@gmail.com");
		Reporter.log("Email displayed: " + email);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}