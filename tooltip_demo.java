package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class tooltip_demo {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		/*
		 * Tooltips can be attached to any element. When you hover the element with your mouse, the title attribute is displayed in a little box next to 
		 * the element, just like a native tooltip.

But as it's not a native tooltip, it can be styled. Any themes built with ThemeRoller will also style tooltips accordingly.

Tooltips are also useful for form elements, to show some additional information in the context of each field.
		 */
		
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement input = driver.findElement(By.xpath("//input[@id='age']"));
	   String tooltip =  input.getAttribute("titile");
	   System.out.println("tooltip text : " +tooltip);
		
		

	}

}
