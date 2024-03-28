package day4;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;


public class ParsingJSONResponseData {
	
	//approach - 1
//@Test(priority=1)
 void testJsonResponse() {
	 given()
	 .contentType(ContentType.JSON)
.when()
           .get("https://reqres.in/api/users?page=2")
.then()
          .statusCode(200)
          .header("Content-Type","application/json; charset=utf-8")
          .body("data[0].email", equalTo("michael.lawson@reqres.in"));
 }

//approach - 2
@Test(priority=2)
void testJsonResponseUsingResponseVar() {
	Response res =  given()
	 .contentType(ContentType.JSON)
.when()
          .get("https://reqres.in/api/users?page=2");
	
	Assert.assertEquals(res.statusCode(), 200);
	Assert.assertEquals( res.header("Content-Type"), "application/json; charset=utf-8");
	Assert.assertEquals( res.jsonPath().get("data[0].email"), "michael.lawson@reqres.in");
}
 
//approach - 3
@Test(priority=3)
void testJsonResponseUsingJSONObj() {
	Response res =  given()
	 .contentType(ContentType.JSON)
.when()
        .get("https://reqres.in/api/users?page=2");
	
	//JSON Object Class
	JSONObject jo = new JSONObject(res.asString());  //converting response to json object type 
	boolean status = false;
	for(int i=0;  i< jo.getJSONArray("data").length();  i++) {
		
		String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
		if(email.equals("michael.lawson@reqres.in")) {
			status=true;
			break;
		}
		Assert.assertEquals(status,true);
	}
}


//approach - 4
@Test(priority=3)
void testJsonResponseUsingJSONObjToSum() {
	Response res =  given()
	 .contentType(ContentType.JSON)
.when()
      .get("https://reqres.in/api/users?page=2");
	
	//JSON Object Class
	JSONObject jo = new JSONObject(res.asString());  //converting response to json object type 
	boolean status = false;
	double sum = 0;
	for(int i=0;  i< jo.getJSONArray("data").length();  i++) {
		
		String id = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
		sum = sum +  Double.parseDouble(id);
	}
	System.out.println("total sum of id's are : " +sum);
}


}
