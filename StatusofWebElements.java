package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusofWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.xpath("//input[@id='small-searchterms']"));     
		
		//isDisplayed and isEnabled
		System.out.println("Is Displayed? :" + search.isDisplayed()); //true
		System.out.println("Is Enabled? :" + search.isEnabled()); //true
		
		//isSelected 
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Is male selected? :" +male.isSelected()); //false
		System.out.println("Is female selected? :" +female.isSelected()); //false
		
		male.click();
		
		System.out.println("Is male selected? :" +male.isSelected()); //true
		System.out.println("Is female selected? :" +female.isSelected()); //false
		
        female.click();
		
		System.out.println("Is male selected? :" +male.isSelected()); //false
		System.out.println("Is female selected? :" +female.isSelected()); //true
		driver.close();
	}

}
