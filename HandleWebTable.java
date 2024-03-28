package selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://automationpanda.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//How to find rows in table 
		int rows = driver.findElements(By.xpath("//figure[@class='wp-block-table']//table//tbody/tr")).size();
		System.out.println("No of Rows : " +rows);
		
		//How to find columns in table 
				int columns = driver.findElements(By.xpath("//figure[@class='wp-block-table']//tbody//tr[1]//td")).size();
				System.out.println("No of Columns : " +columns);
				
		//Retrive specific data from table 
				String name = driver.findElement(By.xpath("//figure[@class='wp-block-table']//tbody//tr[4]//td[1]")).getText();
				System.out.println("Fetched data : " +name);
				
				//Retrive all the data from table 
				for(int r=1;r<=rows;r++) {
					for(int c=1;c<=columns;c++) {
				String data1 =	driver.findElement(By.xpath("//figure[@class='wp-block-table']//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data1+ "       ");
					}
					System.out.println();
				}
				
				//Retrive specific data from table 
					for(int r=1;r<=rows;r++) {
							String data2 = driver.findElement(By.xpath("//figure[@class='wp-block-table']//tbody//tr["+r+"]//td[1]")).getText();
							if(data2.equals("Senior")) {
								String level = driver.findElement(By.xpath("//figure[@class='wp-block-table']//tbody//tr["+r+"]//td[1]")).getText();
								String responsibility = driver.findElement(By.xpath("//figure[@class='wp-block-table']//tbody//tr["+r+"]//td[2]")).getText();
								
								System.out.println(level);
								System.out.println(responsibility);	
							}
						}
				
				driver.quit();
	}
}
