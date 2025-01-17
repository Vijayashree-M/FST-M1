package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void postJob() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@id='primary-menu']/li[3]/a")).click();
		driver.findElement(By.id("create_account_email")).sendKeys("vijayas@ibmer.com");
		driver.findElement(By.id("job_title")).sendKeys("Automation QE");
		WebElement dropdown= driver.findElement(By.id("job_type"));
		Select select= new Select(dropdown);
		select.selectByIndex(0);
		
		driver.findElement(By.id("application")).sendKeys("vijaya@ibmer.com");
		driver.findElement(By.id("company_name")).sendKeys("IBM");
		driver.switchTo().frame("job_description_ifr");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='tinymce']")));
		driver.findElement(By.xpath("//body[@id='tinymce']")).click();
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("This is FST-Selenium project");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.name("submit_job")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("job_preview_submit_button")));
		driver.findElement(By.id("job_preview_submit_button")).click();
		
		Thread.sleep(2000);
		String confirm= driver.findElement(By.xpath("//div[@class='entry-content clear']")).getText();
		String expected= "Job listed successfully. To view your listing click here.";
		Assert.assertEquals(confirm, expected);
		
		driver.findElement(By.xpath("//div[@class='entry-content clear']/a")).click();
		String company= driver.findElement(By.xpath("//div[@class='company']/p")).getText();
		Assert.assertEquals(company, "IBM");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}