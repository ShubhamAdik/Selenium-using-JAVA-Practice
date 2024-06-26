package day5;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class ParsingXMLResponse {
	//@Test(priority=1)
       void testXMLResponse() {
		
		//approach1
		       given()
		       
		       .when()
		             .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		     .then()
		
					.statusCode(200)
					.header("Content-Type", "application/xml; charset=utf-8")
					.body("TravelerinformationResponse.page", equalTo("1"))
					.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));	 
       }
	
	
	@Test(priority=2)
    void testXMLResponseUsingResponseVar() {
		
		//approach2
		      Response res = given()
		       
		       .when()
		             .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		      
		      Assert.assertEquals(res.statusCode(),200);
		     Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		     String page=  res.xmlPath().get("TravelerinformationResponse.page").toString();
		     Assert.assertEquals(page,"1");
		     String Name=  res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		     Assert.assertEquals(Name,"Developer");
		
    }
	
	
	@Test(priority=3)
    void testXMLResponseBody() {
		
		//approach3
		      Response res = given()
		       
		       .when()
		             .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		      
		     XmlPath xmlobj = new XmlPath(res.asString());
		     
		     //Verify total number of travellers 
		     List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		    Assert.assertEquals(travellers.size(),10);
		    
		    //Verify traveller name is present in response 
		   List<String> traveller_names =  xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		   boolean status = false;
				for(String travellername : traveller_names) {
					if(travellername.equals("Developer")) {
						status = true;
						break;
					}	
		}
		Assert.assertEquals(status, true);
		
    }
	
}
