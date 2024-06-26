package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	public static void drawBorderJS(WebElement element, WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("argument[0].style.border='3 px solid red' ", element);
	}
	
	public static String getTitleByJS(WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
	}
	
	public static void generateAlert(WebDriver driver, String message ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("alert(' "+ message +" ')");
	}
	
	public static void ScrollPageDown(WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");  
	}
	
	public static void ScrollPageUp(WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight) ");  
	}
	
	public static void refreshBrowserByJS(WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");  
	}
	
	public static void ZoomPageByJS(WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='150%' ");  
	}
	
	public static void flashElement(WebElement element, WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i < 50; i++) {
			changeColor("#000000", element, driver); //1
			changeColor(bgcolor, element, driver); //2
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver ) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("argument[0].style.backgroundColor = ' " + color + "'", element);
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e){
		}
	}
}
