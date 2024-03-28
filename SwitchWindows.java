package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
	//	String windowID = driver.getWindowHandle();  //to get window ID of single browser window 
	//	System.out.println("Parent ID : " +windowID);
		
		Set<String> windowIDs = driver.getWindowHandles();   //set is a collection in java which stores list of string values 
		
		List<String> winids = new ArrayList(windowIDs);  //list is a interface which contains arraylist class  --here we have convet set<string> into list type 
		
		for(String ids :winids) {
			//System.out.println(ids);
			String title = driver.switchTo().window(ids).getTitle();
			System.out.println(title);	
		}
		
		//driver.close();    //close single browser window driver which pointing 
		//driver.quit();   // close all the browser windows 
		
		for(String ids :winids) {
			String title = driver.switchTo().window(ids).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM")) {
				driver.close();
			}	
		}
		
	}

}
