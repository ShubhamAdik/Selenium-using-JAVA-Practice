package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

import org.testng.annotations.Test;

public class FileUploadDownload {
	@Test
void SingleFileUpload() {
		File Myfile=new File("C:\\AutomationPractice\\Test.txt");
		
	given()
	           .multiPart("file",Myfile)
	           .contentType("multipart/form-data")
	           
	.when()
	           .post("http://localhost:8080/uploadFile")
	           
	.then()
	          .statusCode(200)
	          .body("fileName",equalTo("Test.txt"))
	          .log().all();
	
}
	
	@Test
void MultipleFileUpload() {
		File Myfile1=new File("C:\\AutomationPractice\\Test1.txt");
		File Myfile2=new File("C:\\AutomationPractice\\Test2.txt");
		
		File FileArr[] = {Myfile1,Myfile2};
		
	given()
	           .multiPart("files",Myfile1)
	           .multiPart("files",Myfile2)
	           
	           //OR
	           .multiPart("files",FileArr)    //useful when we need to upload multiple files - won't work for all kinds of api's
	           
	           .contentType("multipart/form-data")
	           
	.when()
	           .post("http://localhost:8080/uploadMultipleFiles")
	           
	.then()
	          .statusCode(200)
	          .body("[0].fileName",equalTo("Test1.txt"))
	          .body("[1].fileName",equalTo("Test2.txt"))
	          .log().all();
	
}
	
	@Test
	void fileDownload() {
		given()
		
		.when()
		           .get("http://localhost:8080/downlodFile/Test.txt")
		.then()
		          .statusCode(200)
		         .log().body();
	}
}
