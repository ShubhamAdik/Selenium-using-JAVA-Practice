package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Implicit wait - it will applicable to all elements in code as it i global wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
	    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.RETURN);
	    
	    driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']")).click();
	}

}
