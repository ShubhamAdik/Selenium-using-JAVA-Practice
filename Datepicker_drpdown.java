package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker_drpdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		Select drp_year = new Select (driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		drp_year.selectByVisibleText("1999");
		
		Select drp_month = new Select (driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		drp_month.selectByVisibleText("Mar");
		
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		
		for(WebElement dt : alldates) {
			
			String date = dt.getText();   //converting web element into string by getting text value of web element 
			
			if(date.equals("18")) {
				dt.click();
				break;
			}
		}
		//driver.quit();
	}

}
