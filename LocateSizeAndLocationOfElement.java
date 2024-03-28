package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class LocateSizeAndLocationOfElement {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://ataevents.org/generative-ai-for-software-testers/");
		driver.manage().window().maximize();
		
		WebElement title = driver.findElement(By.xpath("//div[@class='elementor-slide-heading']"));
		
		//get location - 1st method 
		System.out.println("Element location(X,Y) : " + title.getLocation() );
		System.out.println("Element location(X) : " + title.getLocation().getX() );
		System.out.println("Element location(Y) : " + title.getLocation().getY() );
		
		System.out.println();
		
		//get location - 2nd method 
		System.out.println("Element location(X) : " + title.getRect().getX() );
		System.out.println("Element location(Y) : " + title.getRect().getY() );
		
		System.out.println();
		
		//get size - 1st method 
		System.out.println("Element Width and Height : " + title.getSize() );
		System.out.println("Element Width : " + title.getSize().getWidth() );
		System.out.println("Element Height : " + title.getSize().getHeight());
		
		System.out.println();
		
		//get size - 2nd method 
		System.out.println("Element Width and Height : " + title.getRect().getDimension());
		System.out.println("Element Width : " + title.getRect().getDimension().getWidth());
		System.out.println("Element Height : " + title.getRect().getDimension().getHeight());
		
		driver.quit();
				

	}

}
