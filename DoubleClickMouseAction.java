package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DoubleClickMouseAction {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//Double Click Operation 
		driver.switchTo().frame("iframeResult");
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Welcome Shubham");
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions act = new Actions(driver);  //Actions class is used to perform mouse operations 
		act.doubleClick(button).build().perform();  //double click mouse operation 
		
		

	}

}
