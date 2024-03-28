package day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class HeadersDemo {

	//3) headers 
	@Test(priority=1)
	void testHeaders()
	{
		given()
	
		.when()
		           .get("https://www.google.com/")     
		
		.then()
		            .header("Content-Type", "text/html; charset=ISO-8859-1")
		            .and()
					.header("Content-Encoding","gzip")
					.and()
					.header("Server","gws");
				//	.log().headers();  -- to get details of only headers 
	}
	
   @Test(priority=2)
	void testMultipleHeaders()
	{
		Response res = given()
	
		.when()
		           .get("https://www.google.com/");  
		
		//get single header info
		String Content_Type = res.getHeader("Content-Type");	
		System.out.println("The value of Content-Type header is " +Content_Type);
		
		//get multiple headers 
		Headers myheaders = res.getHeaders();
		for(Header k : myheaders) {
			System.out.println(k.getName()+ "            " +k.getValue());
		}
	}
}
