package day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class CookiesDemo {

	//2) cookies
	@Test(priority=1)
	void testCookies()
	{
		given()
	
		.when()
		           .get("https://www.google.com/")     
		
		.then()
		            .cookie("AEC","Ackid1QKdsfjUvEmK7cAfM6j8dXEr5F6lMXduNW9KEFWCKfStz0j9CnlgQc")
					.log().all();
		
		
	}
	
	//@Test(priority=2)
	void testCookiesInfo()
	{
		Response res = given()
	
		.when()
		           .get("https://www.google.com/");
		
		//get single cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("The value of cookie is " + cookie_value);
		
		
		//get all cookies info
			Map<String,String> cookies_values = res.getCookies();
			
			//In hashmap we get key values using keyset() method
				for(String k : cookies_values.keySet()) {
					String cookie_values = res.getCookie(k);
					System.out.println(k+"          "+cookie_values);
				}
	}
}
