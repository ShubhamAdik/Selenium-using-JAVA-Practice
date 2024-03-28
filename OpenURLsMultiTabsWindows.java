package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class OpenURLsMultiTabsWindows {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//To open URL of same website in new tab  - Demos link will open in new tab 
	     driver.get("https://jqueryui.com/tooltip/");
		String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("Demos")).sendKeys(tab);  
		
		//To open URL's in multiple tabs
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://ataevents.org/generative-ai-for-software-testers/"); 
		
		//To open URL's in multiple windows 
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://ataevents.org/generative-ai-for-software-testers/");
				

	}

}
