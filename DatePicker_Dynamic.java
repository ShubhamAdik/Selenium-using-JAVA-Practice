package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Dynamic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();  //opening datepicker 
		
       String year = "2024";
       String month = "Apr";
       String date = "28";
       
       while(true) {
    	   
    	   driver.findElement(By.xpath(""));
    	   
       }
	}

}
