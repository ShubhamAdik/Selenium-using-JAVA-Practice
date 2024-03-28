package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//syntax
	/*	JavascriptExecutor js = driver;
		js.executeScript(Script, args);
		*/
		
		//flash
		WebElement ele = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.flashElement(ele, driver);
		
/*		//Drawing border and take screenshot
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.drawBorderJS(logo, driver );
		Thread.sleep(10);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screenshots\fullScreen.png"); 
		FileUtils.copyFile(src, trg);
		
		//Getting title of the page
		JavaScriptUtil.getTitleByJS(driver );
		
		//Click action
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		JavaScriptUtil.clickElementByJS(element, driver );
		
		//Generate alert 
		JavaScriptUtil.generateAlert(driver, "Welcome to my page...!!");
		
		//Refreshing the page 
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		//Scrolling down page
		JavaScriptUtil.ScrollPageDown(driver);
		
		//Scrolling up page
		JavaScriptUtil.ScrollPageUp(driver);
		
		//Zoom page 
		JavaScriptUtil.ZoomPageByJS(driver);
		*/

	}

}
