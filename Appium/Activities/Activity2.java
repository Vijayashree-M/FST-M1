package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        //options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setAppActivity("org.chromium.chrome.browser.firstrun.FirstRunActivity");
        options.noReset();

        // Set the Appium server URL
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Open the page in Chrome
        driver.get("https://training-support.net");
    }

    // Test method
    @Test
    public void chromeTest() {
        // Find heading on the page
        //String pageHeading = driver.findElement(AppiumBy.xpath(
        //   "//android.widget.TextView[@text='Training Support']")).getText();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@text='About Us']")));
      
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text=\"Training Support\"]"
        )).getText();
        
              // Print to console
        System.out.println("Heading: " + pageHeading);

        // Find and click the About Us link
               driver.findElement(AppiumBy.xpath(
        		"//android.view.View[@text='About Us']")).click();
        
      
        // Find heading of new page and print to console
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
              		"//android.view.View[@text='About Us']"
        )).getText();
        System.out.println(aboutPageHeading);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}