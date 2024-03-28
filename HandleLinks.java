package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Today's Deals")).click();
		//driver.findElement(By.partialLinkText("Deals")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
//		for(WebElement link : links) {
//			System.out.println(link.getText());
//			System.out.println(link.getAttribute("href"));
//		}
		
		for(int i=0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
		
		System.out.println("No of links present : " +links.size());
	}

}
