package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		driver.manage().window().maximize();
		
		//If type="File" tag is present for file upload then we can directly use sendKeys() method 
		driver.findElement(By.xpath("//input[@name='userfile']")).sendKeys("D:/Shubham/Resume/SHUBHAM_ADIK_RESUME.pdf");
		
		//If type="File" tag is not present then we needs to use Robot class methods 
		
		WebElement button = driver.findElement(By.xpath("//input[@name='userfile']"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		Robot rb = new Robot();
		rb.delay(2000);
		
		//put path to file in a clipboard - CTRL + C operation
		
		StringSelection ss = new StringSelection("D:/Shubham/Resume/SHUBHAM_ADIK_RESUME.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL + V operation 
		
		rb.keyPress(KeyEvent.VK_CONTROL);   //press CTRL keyword 
		rb.keyPress(KeyEvent.VK_V);  //press V keyword 
		
	   rb.keyRelease(KeyEvent.VK_CONTROL);
	   rb.keyRelease(KeyEvent.VK_V);
	   
	   //Enter 
	   
	  rb.keyPress(KeyEvent.VK_ENTER);
	  rb.keyRelease(KeyEvent.VK_ENTER);
	}

}
