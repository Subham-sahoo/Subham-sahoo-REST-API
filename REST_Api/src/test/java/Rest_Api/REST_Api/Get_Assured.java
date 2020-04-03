package Rest_Api.REST_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Assured {

	@Test
	public void CheckGet()
	
	{
		Response resp = RestAssured.get("http://localhost:3000/posts");
		int statusCode = resp.getStatusCode();
		System.out.println("StatusCode is"+statusCode);
		System.out.println("===================");
		
		
		String contentType = resp.getContentType();
		
		
		System.out.println("contentType is"+contentType);
		System.out.println("=====================");
		
		String actualResponse = resp.asString();
		System.out.println("actualResponse is"+actualResponse);
	}

}

