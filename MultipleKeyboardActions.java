package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleKeyboardActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		
		input1.sendKeys("Welcome to my page...!!");
		Actions act = new Actions(driver);
		
		//CTRL + A          - Copy All
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL + C         - Copy 
				act.keyDown(Keys.CONTROL);
				act.sendKeys("c");
				act.keyUp(Keys.CONTROL);
				act.perform();
				
		//TAB - Shift to 2nd input box 	
				act.sendKeys(Keys.TAB).perform();
				
				//CTRL + V        - Paste 
				act.keyDown(Keys.CONTROL);
				act.sendKeys("v");
				act.keyUp(Keys.CONTROL);
				act.perform();
				
		//Compare 
				if(input1.getAttribute("value").equals(input2.getAttribute("value"))) {
					System.out.println("Both Text matching with each other");
				}else {
					System.out.println("Both Text is not matching with each other");
				}
		

	}

}
