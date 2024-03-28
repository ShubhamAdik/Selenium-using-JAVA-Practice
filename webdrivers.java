package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class webdrivers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		System.out.println("the Title of web page is " + driver.getTitle());
		System.out.println("the URL of web page is " + driver.getCurrentUrl());
		System.out.println(driver.getPageSource());

	}

}
