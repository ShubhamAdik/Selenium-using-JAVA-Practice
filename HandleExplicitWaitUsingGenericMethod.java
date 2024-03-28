package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleExplicitWaitUsingGenericMethod {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
	    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.RETURN);
	    
	    By sel =  By.xpath("//a[@href='https://www.selenium.dev/']//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']");  
	    waitForElementPresent(driver,sel,10);
	}
	
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) {
		//Explicit wait - it is element specific - it uses speical class callled WebDriverWait 
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				return driver.findElement(locator);
	}
	
	
	
	

}
