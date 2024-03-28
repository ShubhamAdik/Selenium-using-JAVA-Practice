package selenium;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		   
		driver.manage().timeouts().getImplicitWaitTimeout().withSeconds(10);
		
		
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List <WebElement> drpmultiple = driver.findElements(By.xpath("//div[@class='drp1']//div[@class='dropdown']//ul[@class='dropdown1 dropdown-menu']//li"));
		
		for(WebElement option : drpmultiple ) {
			if(option.getText().equals("Cards")) {
				option.click();
				break;
			}
			
			driver.findElement(By.xpath("//div[@class='drp2']//a[@class='btn-primary dropdown-toggle btn-block']")).click();
			List<WebElement> drpProducts = driver.findElements(By.xpath("//div[@class='drp2']//div[@class='dropdown']//ul[@class='dropdown2 dropdown-menu']//li"));
			
			for(WebElement op : drpProducts ) {
				if(op.getText().equals("Home Loan")) {
					option.click();
					break;
				}
		}
	}
		
	}
	}
