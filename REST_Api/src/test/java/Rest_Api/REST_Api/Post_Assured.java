package Rest_Api.REST_Api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Assured 
{
@Test
public void check_Post() 
{
	    
  RequestSpecification req = RestAssured.given();	
  JSONObject jobj =new JSONObject();
  
  jobj.put("id","10");
  jobj.put("Titel", "AuthorisedTE");
  jobj.put("Author", "Raj");
  
  String jsondata = JSONObject.toJSONString(jobj);
  req.contentType(ContentType.JSON);
  req.body(jsondata);
  RequestSpecification sender = req.when();
	
  Response resp = sender.post("http://localhost:3000/posts");
	int statusCode = resp.getStatusCode();
	System.out.println("StatusCode is "+statusCode);
	System.out.println("===================");
	
	
	String contentType = resp.getContentType();
	
	
	System.out.println("contentType is "+contentType);
	System.out.println("=====================");
	
	String actualResponse = resp.asString();
	System.out.println("actualResponse is "+actualResponse);
	}
}
