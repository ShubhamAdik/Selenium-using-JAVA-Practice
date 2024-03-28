package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedUnsortedDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("searchDropdownBox"));
		List<WebElement> drpelements = driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
		
		ArrayList orginalList = new ArrayList();
		ArrayList tmpList = new ArrayList();
		
		for(WebElement option : drpelements) {
			orginalList.add(option.getText());
			tmpList.add(option.getText());
		}
		System.out.println("Original list : " +orginalList);
		System.out.println("Temp list : " +tmpList);
		
		Collections.sort(tmpList);   //collections.sort(list) - used to sort the collection objects 
		System.out.println("Temp list after Sorting : " +tmpList);
		
		if(orginalList.equals(tmpList)) {
			System.out.println("Dropdown list is not sorted");
		}
		else {
			System.out.println("Dropdown list is sorted");
		}
	}
}
