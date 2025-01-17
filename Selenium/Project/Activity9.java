package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	@Test
	public void backendJobPublish() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(1000);
		String username= driver.findElement(By.xpath("//div[@id='wp-toolbar']/ul[2]/li[1]/a/span")).getText();
		Assert.assertEquals(username, "root");
		
		driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']//div[@class='wp-menu-name']")).click();
		driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys("QualityEngineer");
		driver.findElement(By.id("_company_website")).sendKeys("www.ibm.com");
		driver.findElement(By.id("_company_name")).sendKeys("IBM");
		
		driver.findElement(By.xpath("//div[@class='edit-post-header']/div[2]/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-publish-button']/button")).click();
		Thread.sleep(1000);
		String confirm= driver.findElement(By.xpath("//div[@class='post-publish-panel__postpublish']/div/a")).getText();
		Assert.assertEquals(confirm, "QualityEngineer");
		
		driver.findElement(By.xpath("//div[@class='post-publish-panel__postpublish-buttons']/a")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='application_button button']")));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
}
