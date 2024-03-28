package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVsActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
		Actions act = new Actions(driver);                        //Actions is a class 
		//act.moveToElement(computers).perform();    --perform() method internally calls build() method 
		//act.moveToElement(computers).build().perform();     --here we are calling build() 2 times
		
		Action action = act.moveToElement(computers).build();  //build will return an action   --action is an interface
		action.perform();  //perform will complete the action 
		
	}

}
