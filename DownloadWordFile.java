package selenium;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Screenshots/AdBlock.crx"));
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://freetestdata.com/document-files/doc/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-95a6277 elementor-align-justify elementor-widget elementor-widget-button']//span[@class='elementor-button-text'][normalize-space()='Select File & Download']")).click();

	}

}
