package com.api.rootLib;

import java.io.FileInputStream;
import java.util.Properties;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Apiconfig 
{
	
	Properties pobj=new Properties();
	Response resp;
	String[] keyvalue;
	
	
	
	public String getPropertyObject(String key) 
	{
		
		try {
FileInputStream file=new FileInputStream("./apiList.properties");
			pobj.load(file);
			}catch(Exception e)
		{
			e.printStackTrace();	
			}
		
		return pobj.getProperty(key);
	}
	
	public Response executeRequest(String apidata) 
	{
	
		String[] arr = apidata.split(";");
		
		if(arr[0].equals("get")) {
			resp=  given().param("uerId","7").when().get(arr[1]);
		}
		else if(arr[0].equals("post")){
			
		String postobj=createjsonobject(arr[2]);
			
			resp=given().contentType(ContentType.JSON).body(postobj).when().post(arr[1]);
			
		}
		else if(arr[0].equals("patch")) {
		String postobj=	createjsonobject(arr[2]);
		resp=given().contentType(ContentType.JSON).body(postobj).when().patch(arr[1]);
		}
			
		else if(arr[0].equals("put")) {
			String postobj=	createjsonobject(arr[2]);
			resp=given().contentType(ContentType.JSON).body(postobj).when().put(arr[1]);
			}
		else if(arr[0].equals("delete")) {
			resp=delete(arr[1]);
		}
		return resp;
		}
	public String createjsonobject(String data) {
		
		JSONObject jobj=new JSONObject();
		String[] arrjsondata = data.split(",");
	
	for(int i=0;i<arrjsondata.length;i++) {
		
	keyvalue = arrjsondata[i].split(":");
	jobj.put(keyvalue[0], keyvalue[1]);
	}
		return jobj.toJSONString();
	}
	
	
	

	
	}
