package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void validateImgUrl() {
		WebElement imgUrl= driver.findElement(By.xpath("//img[contains(@src, '.jpg')]"));
		Reporter.log(imgUrl.getDomAttribute("src"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}