package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTestSteps {
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@Given("User is on the page")
	public void get_title() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/alerts");
	}
	
	@When("User clicks the Simple Alert button")
	public void first_button() {
		WebElement firstButton = driver.findElement(By.id("simple"));
		firstButton.click();
	}
	
	@When("User clicks the Confirm Alert button")
	public void second_button() {
		WebElement secondButton = driver.findElement(By.id("confirmation"));
		secondButton.click();
	}
	
	@When("User clicks the Prompt Alert button")
	public void third_button() {
		WebElement thirdButton = driver.findElement(By.id("prompt"));
		thirdButton.click();
	}
	
	@Then("Alert opens")
	public void switch_focus() {
		alert = driver.switchTo().alert();
	}
	
	@And("Read the text from it and print it")
	public void alert_message() {
		System.out.println("Alert says: " + alert.getText());
	}
	
	@And("Write a custom message in it")
	public void write_text() {
		alert.sendKeys("Custom Message");
	}
	
	@And("Close the alert")
	public void close_alert_accept() {
		alert.accept();
	}
	
	@And("Close the alert with Cancel")
	public void close_alert_cancel() {
		alert.dismiss();
	}
	
	@And("Read the result text")
	public void read_result() {
		WebElement resultElement = driver.findElement(By.id("result"));
        String resultText = resultElement.getText();
        System.out.println("Text in the <p> tag: " + resultText);
	}
	
	@And("Close Browser")
	public void close() {
		driver.quit();
	}

}