package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeVsGetText {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/login");
		
		//getAttribute() - The method fetches the text contained by an attribute in an html document 
	
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println(searchbox.getAttribute("placeholder"));
		
		//gettext() - The method returns the inner text of an element 
		
		WebElement title = driver.findElement(By.xpath("//strong[contains(text(),'New Customer')]"));
		System.out.println(title.getText());
		

	}

}
