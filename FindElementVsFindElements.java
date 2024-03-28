package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//FindElement 
		
		//1 - locator finds 1 match and it will return it 
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchbox.sendKeys("xyz");
		
		//2 - locator finds 22 matches but it will return first matching element only 
		WebElement el = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(el.getText());
		
		//3 - If locator doesn't find element it will throw error - NoSuchElementException  
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='footer-upper']//a[contains(.,'Information')]"));
 	    System.out.println(ele1.getText());
		
		
		//FindElements
		
				//1 - locator finds 1 match and it will return it 
		List<WebElement> element = driver.findElements(By.xpath("//strong[normalize-space()='Newsletter']"));
		for(WebElement x:element) {
			System.out.println("FindElements - Single element " +x.getText());
		}
				
				//2 - locator finds 22 matches and it will return all 22 elements 
				List<WebElement> elements = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
				for(WebElement x:elements) {
					System.out.println(x.getText());
				}
				
				//3 - If locator doesn't find element it will not throw an error - return empty list   
				List<WebElement> ele2 = driver.findElements(By.xpath("//div[@class='footer-upper']//a[contains(.,'Information')]"));
				System.out.println(ele2.size());
		
		
	}

}
