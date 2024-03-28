package day3;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathAndQueryParamters {

	//https://reqres.in/api/users?page=2&id=5   1) Path and Query parameters 
	@Test
	void testQueryandPathParamters()
	{
		given()
				  .pathParam("mypath", "users")   //path parameters -- request reached to server 
				  .queryParam("page",2)   //query parameter - it is used to filter data once request reach to server 
				  .queryParam("id",5)       //query parameter - it is used to filter data once request reach to server
		.when()
		           .get("https://reqres.in/api/{mypath}")     //we just need to define path parameter in curly braces 
		
		.then()
					.statusCode(200)
					.log().all();
		
		
	}
	
	
	//2) cookies and headers 
}
