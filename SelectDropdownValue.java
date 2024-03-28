package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdownValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		WebElement Country = driver.findElement(By.id("Form_getForm_Country"));
		
		Select drpdownCountry = new Select(Country);
		
		//drpdownCountry.selectByVisibleText("Belgium");
		//drpdownCountry.selectByValue("Belgium");
		//drpdownCountry.selectByIndex(4);
		
		List<WebElement> drpOptions = drpdownCountry.getOptions();
		for(WebElement option : drpOptions) {
			if(option.getText().equals("Belgium")) {
				option.click();
				break;
			}
		}
		

	}

}
