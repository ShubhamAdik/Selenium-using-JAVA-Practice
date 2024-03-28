package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermisionPopups {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		//To handle allow and block pop ups using ChromeOptions 
		
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
    	driver.get("https://www.redbus.in/");
    	driver.manage().window().maximize();
	}
}
