package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		
		System.out.println("X and Y axis of element : " +min_slider.getLocation());
		System.out.println("Width and Height of element : " +min_slider.getSize());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider, 100, 0).perform();
		
		System.out.println("X and Y axis of element : " +min_slider.getLocation());
		System.out.println("Width and Height of element : " +min_slider.getSize());
		
		
		act.dragAndDropBy(max_slider, -100, 0).perform();
		
		
		
	
		
		
	
		

	}

}
