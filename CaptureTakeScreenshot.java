package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTakeScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//full page screenshot 
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\Screenshots\\homepage.png");
		FileUtils.copyFile(src, target);
		
		//capture screenshot of section of page 
		WebElement section = driver.findElement(By.xpath("//div[@class='category-grid home-page-category-grid']//div[@class='item-grid']"));
		File src_section = section.getScreenshotAs(OutputType.FILE);
		File trg_section = new File(".\\\\Screenshots\\\\section.png");
		FileUtils.copyFile(src_section, trg_section);

		
		//capture screenshot of element on a page 
		WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src_element = element.getScreenshotAs(OutputType.FILE);
		File trg_element = new File(".\\\\Screenshots\\\\element_logo.png");
		FileUtils.copyFile(src_element, trg_element);
	}

}
