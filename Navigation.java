package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Navigation {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		
        driver.get("https://www.amazon.in/");
        driver.navigate().to("https://www.flipkart.com/");
        
        driver.navigate().back(); //amazon 
        driver.navigate().forward(); //flipkart 
        
        driver.navigate().refresh();
        
        
	}

}
