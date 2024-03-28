package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenlinks = 0;
		for(WebElement element : links) {
			String url = element.getAttribute("href");
			
			if(url.isEmpty() || url == null) {		
		System.out.println("URL is empty");	
		continue;
			}
			URL link = new URL(url);
			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				
				if(httpconn.getResponseCode() >=400) {
					System.out.println(httpconn.getResponseCode()+url + "  is " + " broken link");	
					brokenlinks++;
				}
				else {
					System.out.println(httpconn.getResponseCode() +url + "  is " + "valid link");	
				}
			} 	
			catch (Exception e) {
			}
		}
		
		System.out.println("No of broken links : " +brokenlinks);
		driver.quit();
	}

}
