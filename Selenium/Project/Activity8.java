package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	@Test
	public void backendLogin() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(1000);
		String username= driver.findElement(By.xpath("//div[@id='wp-toolbar']/ul[2]/li[1]/a/span")).getText();
		Assert.assertEquals(username, "root");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}