package selenium;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class HandleCheckBoxes {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1) Specific check box 
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2) Select all the check boxes
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total No of Checkboxes : " +checkboxes.size());
		int number = checkboxes.size();
		
		//using for loop
		for(int i = 0; i<checkboxes.size();i++) {
	        checkboxes.get(i).click();
		} 
		
		//using for...each loop
	   for(WebElement checkbox : checkboxes) {
        checkbox.click();
	}  
		
		//3) Multiple checkboxes by choice - Monday and Friday 
		   for(WebElement checkbox : checkboxes) {
			   if(checkbox.getAttribute("value").equals("monday") || checkbox.getAttribute("value").equals("friday")) {
		        checkbox.click();
			   }
			}	
		
		//4) Select last 3 check boxes - Total no of checkboxes - last no of checkboxes 
		for(int i= number - 3;i<number;i++){
		checkboxes.get(i).click();
	} 

		//5) Select first 3 check boxes 
		for(int i=0;i<number;i++){
			if(i<3) {
			checkboxes.get(i).click();
		} 
		}
}
}