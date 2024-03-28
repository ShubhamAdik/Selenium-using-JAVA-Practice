package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Mouse Hover Click Operation 
		WebElement LaptopAndNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Macs (0)']"));
		
		Actions act = new Actions(driver);  //Actions class is used to perform mouse operations 
		act.moveToElement(LaptopAndNotebooks).moveToElement(mac).click().perform();  
		//mouse hover on laptop and notebooks then again mouse hover on mac and perform click opertion on it to open mac page 
		
	}

}
