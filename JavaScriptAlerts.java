package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//alert window with OK button 
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
		
		//alert window with confirmation buttons - OK and Cancel button 
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		//alert window with input box and capture text from alert 
		
	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().sendKeys("Welcome Shubham !!");
	driver.switchTo().alert().accept();
	

	}

}
