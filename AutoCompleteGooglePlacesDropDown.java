package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/maps/");
		driver.manage().window().maximize();
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='searchboxinput']"));
        searchbox.sendKeys("Aurangabad");
        Thread.sleep(1000);
        String text;
        do{
        	searchbox.sendKeys(Keys.ARROW_DOWN);
        	Thread.sleep(1000);
        	text = searchbox.getAttribute("value");
        	
        	if(text.equals("Aurangabad Caves")) {
        		searchbox.sendKeys(Keys.ENTER);
        		break;
        	}
        	Thread.sleep(1000);
        }while(!text.isEmpty());
	}

}
