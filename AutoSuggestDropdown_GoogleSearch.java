package selenium;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium tutorial");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='pcTkSc']//div[@role='option']//div[@role='presentation']//span"));
		System.out.println("No of Suggestions : " +list.size());
		
		for(WebElement option :  list) {
		if(option.getText().contains(" w3schools")) {
			option.click();
			break;
		}
		}
		//driver.close();
	}
}
