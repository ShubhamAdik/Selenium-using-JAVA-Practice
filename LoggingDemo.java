package day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class LoggingDemo {

	//4) Logging Demo 
	@Test(priority=1)
	void testLogs()
	{
		given()
	
		.when()
		           .get("https://reqres.in/api/users?page=2")     
		
		.then()
		        .log().all()
				.log().headers()
				.log().cookies()
				.log().body();
	}
}
