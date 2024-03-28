package day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
/*
 Different ways to create POST request body -
 1) Post request body using HashMap
 2) Post request body creation using Org.JSON 
 3) Post request body creation using POJO (Plain Old Java Object) class
 
		  Serialization = converting pojo ----> json
		  De-serialization = converting json ----> pojo
 
 4) Post request body creation using external json file data
 */
public class DiffWaysToCreatePostRequestBody {

	//1) Post request body using HashMap
	@Test(priority=1)
	public void testPostusingHashMap() {
		HashMap data = new HashMap();
		
		data.put("name","shubham");
		data.put("location","france");
		data.put("phone","12345678");
		
		String courseArr[] = {"C","C++"};
		data.put("courses",courseArr);
		
		given()
				.contentType("application/json")
				.body(data)
		
		.when()
				.post("https://reqres.in/api/users")
		
		.then()
				.statusCode(201)
				.body("name", equalTo("shubham"))
				.body("location", equalTo("france"))
				.body("phone", equalTo("12345678"))
				.header("Content-Type","application/json; charset=utf-8")
				.log().all();
	}
	
	
	//2) Post request body creation using Org.JSON 
		@Test(priority=2)
		public void testPostusingJSONObj() {
			JSONObject data = new JSONObject();
			
			data.put("name","shubham");
			data.put("location","france");
			data.put("phone","12345678");
			
			String courseArr[] = {"C","C++"};
			data.put("courses",courseArr);
			
			given()
					.contentType("application/json")
					.body(data.toString())
			
			.when()
					.post("https://reqres.in/api/users")
			
			.then()
					.statusCode(201)
					.body("name", equalTo("shubham"))
					.body("location", equalTo("france"))
					.body("phone", equalTo("12345678"))
					.header("Content-Type","application/json; charset=utf-8")
					.log().all();
		}
	
	
		//3) Post request body creation using POJO Class 
				@Test(priority=3)
				public void testPostusingPOJO() {
					POJO_PostRequest data = new POJO_PostRequest();
					
					data.setName("shubham");
					data.setLocation("france");
					data.setPhone("12345678");
					
					String courseArr[] = {"C","C++"};
					data.setCourseArr(courseArr);
					
					given()
							.contentType("application/json")
							.body(data)
					
					.when()
							.post("https://reqres.in/api/users")
					
					.then()
							.statusCode(201)
							.body("name", equalTo("shubham"))
							.body("location", equalTo("france"))
							.body("phone", equalTo("12345678"))
							.header("Content-Type","application/json; charset=utf-8")
							.log().all();
				}
	
				
				//4) Post request body creation using External json file data
				@Test(priority=4)
				public void testPostusingExternalData() throws FileNotFoundException {
					
					File f = new File(".\\body.json");
					FileReader fr = new FileReader(f);
					JSONTokener jt = new JSONTokener(fr);
					
					JSONObject data = new JSONObject(jt);
					
					given()
							.contentType("application/json")
							.body(data.toString())
					
					.when()
							.post("https://reqres.in/api/users")
					
					.then()
							.statusCode(201)
							.body("name", equalTo("shubham"))
							.body("location", equalTo("france"))
							.body("phone", equalTo("12345678"))
							.header("Content-Type","application/json; charset=utf-8")
							.log().all();
				}
	
}
