package Rest_Api.REST_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Assured 
{
@Test
public void Check_Delete()

{
	
	Response resp = RestAssured.delete("http://localhost:3000/posts/7");
	int statusCode = resp.getStatusCode();
	System.out.println("StatusCode is "+statusCode);
	System.out.println("===================");
	
	
	String contentType = resp.getContentType();
	System.out.println(" "+contentType);
	System.out.println("=====================");
	
	String actualResponse = resp.asString();
	System.out.println("actualResponse is "+actualResponse);
}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	

