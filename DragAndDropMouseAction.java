package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DragAndDropMouseAction {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		//Drag and Drop click Operation 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement img1 = driver.findElement(By.xpath("//li[1]"));
		WebElement img2 = driver.findElement(By.xpath("//li[2]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions act = new Actions(driver);  //Actions class is used to perform mouse operations 
		act.dragAndDrop(img1, target).build().perform();  //drag and drop click operation 
		act.dragAndDrop(img2, target).build().perform();  //drag and drop click operation 
		
		

	}

}
