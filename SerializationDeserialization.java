package day6;
//Pojo --- Serialize --> JSON Object --- De-serialize ----> Pojo

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.matcher.RestAssuredMatchers;

public class SerializationDeserialization {
	
	//POJO -----> JSON  (Serilization)
//	@Test
	void covertPojoToJSON() throws JsonProcessingException {
		//created java obj using pojo class
		student stupojo = new student();   //pojo 
		
		stupojo.setName("shubham");
		stupojo.setLocation("france");
		stupojo.setPhone("12345678");
		
		String courseArr[] = {"C","C++"};
		stupojo.setCourseArr(courseArr);
		
		//convert java object ---> json object (Serialization)
		ObjectMapper objmapper = new ObjectMapper();
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		System.out.println(jsondata);
	}
	
	
	//JSON -----> POJO  (De - Serilization) - json is light weight format and secure 
	@Test
	void covertJsonToPojo() throws JsonProcessingException {
	
		String jsondata = "{\r\n"
				+ "  \"name\" : \"shubham\",\r\n"
				+ "  \"location\" : \"france\",\r\n"
				+ "  \"phone\" : \"12345678\",\r\n"
				+ "  \"courseArr\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		
		//convert json data ----> Pojo object (De - Serilization)
		ObjectMapper objMapper = new ObjectMapper();
		
		student stupojo = objMapper.readValue(jsondata, student.class);
		System.out.println("Name         " +stupojo.getName());
		System.out.println("Location     " +stupojo.getLocation());
		System.out.println("Phone         " +stupojo.getPhone());
		System.out.println("course 1     " +stupojo.getCourseArr()[0]);
		System.out.println("course 2     " +stupojo.getCourseArr()[1]);
	}	
}
