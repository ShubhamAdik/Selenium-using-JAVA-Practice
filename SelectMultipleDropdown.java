package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMultipleDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		
//		WebElement Country = driver.findElement(By.id("Form_getForm_Country"));
//		Select drpdownCountry = new Select(Country);
//		drpdownCountry.selectByVisibleText("Belgium");
//		
//		WebElement emp = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
//		Select drpdownEmp = new Select(emp);
//		drpdownEmp.selectByVisibleText("16 - 20");
		
		WebElement Country = driver.findElement(By.id("Form_getForm_Country"));
		SelectOptionFromDropdown(Country,"Belgium");
		WebElement emp = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
		SelectOptionFromDropdown(emp,"16 - 20");
	}
	
	public static void SelectOptionFromDropdown(WebElement ele,String value) {
		Select drpdownMul = new Select(ele);
		List<WebElement> drpOptions = drpdownMul.getOptions();
		for(WebElement option : drpOptions) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}
}
