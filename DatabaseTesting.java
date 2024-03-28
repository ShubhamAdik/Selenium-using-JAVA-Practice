package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DatabaseTesting {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@id='u_0_0_7n']")).click();
		
		String username = "Shubham1803";
		String firstname = "Shubham";
		String lastname = "Adik";
		String email = "shubhamadik1803@gmail.com";
		String pwd = "123456";

	}

}
