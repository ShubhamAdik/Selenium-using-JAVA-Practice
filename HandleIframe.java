package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver  = new ChromeDriver();
		driver.get("");
		

	}

}
