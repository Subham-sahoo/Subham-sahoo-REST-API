package Parameter_in_RestApi;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

@Test
public class Query_Param 
{
	public void Fetch_Data() {
		
	/*	RequestSpecification req= given();
		RequestSpecification req_with_QueryParam=req.queryParam("UserId","3");
		RequestSender Sender=  Sender.get("https://jsonplaceholder.typicode.com/posts");
		req.response().then().log().all();*/
		given().queryParam("userId", "3").when().get("https://jsonplaceholder.typicode.com/posts").then().log().all();
	}

	
	
	
	
	
	
	
	
	
	

}
