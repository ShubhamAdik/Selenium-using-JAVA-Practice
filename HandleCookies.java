package selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//to capture cookies 
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies : " +cookies.size());
		
		//to print cookies 
		for(Cookie cookie :cookies) {
			System.out.println("Cookie Name is " +cookie.getName() + " and value is "    +cookie.getValue());
		}
		
		//how to create our own cookie and add it to the browser 
		Cookie ck = new Cookie("MyCookie","Shubham Adik");
		driver.manage().addCookie(ck);
		
		Set<Cookie> cookiesObj = driver.manage().getCookies();
		System.out.println("Size of Cookies after adding our own cookie : " +cookiesObj.size());
				
				//to print cookies 
				for(Cookie cookie :cookiesObj) {
					System.out.println("Cookie Name is " +cookie.getName() + " and value is "    +cookie.getValue());
				}
				
				
				//how to delete specific cookie from the browser 
				driver.manage().deleteCookieNamed("MyCookie");   
				driver.manage().deleteCookie(ck);
				System.out.println("Size of cookies after deleting own cookie : " +driver.manage().getCookies().size());
				
				//how to delete all cookies from the browser 
				driver.manage().deleteAllCookies();
				System.out.println("Size of cookies after deleting all cookies : " +driver.manage().getCookies().size());
					
	}

}
