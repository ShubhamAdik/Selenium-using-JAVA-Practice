package selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFluentWaitUsingGenericMethod {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
	    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.RETURN);
	    
	  By  locator = By.xpath("//a[@href='https://www.selenium.dev/']//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']");
	  
	  waitForElementWithFluentWait(driver,locator).click();
	}
	
	public static WebElement waitForElementWithFluentWait(WebDriver driver, By locator) {
	
	//Fluent wait - it is similar to WebDriverWait with more flexibility in polling time and ignoring exceptions 
	Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);
	
	  WebElement element=mywait.until(new Function<WebDriver, WebElement>() {
	    	public WebElement apply(WebDriver driver) {
	    	return driver.findElement(locator);
	    	}
	    	});
	return element;
}
}