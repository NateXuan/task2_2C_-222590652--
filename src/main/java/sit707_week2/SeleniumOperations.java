package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils; 
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.support.locators.RelativeLocator;


public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		driver.get(url);

		WebElement firstNameLabel = driver.findElement(By.xpath("//label[@for='firstname']"));
        WebElement firstNameInput = driver.findElement(RelativeLocator.with(By.tagName("input")).near(firstNameLabel));
        firstNameInput.sendKeys("Wenzong");

		WebElement lastNameInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(firstNameInput));
		lastNameInput.sendKeys("Xuan");
		
		WebElement PhoneInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(lastNameInput));
		PhoneInput.sendKeys("0400000000");

		WebElement EmailInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(PhoneInput));
		EmailInput.sendKeys("123456@gmail.com");

	    WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-testid='account-action-btn']"));
	    createAccountButton.click();
		
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(scrFile, new File("/Users/wenzongxuan/Downloads/screenshot.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
