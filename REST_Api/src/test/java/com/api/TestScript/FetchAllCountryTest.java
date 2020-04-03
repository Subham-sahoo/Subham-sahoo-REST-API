package com.api.TestScript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.rootLib.RootClass;

import io.restassured.response.Response;
@Listeners(com.api.rootLib.TakeListner.class)
public class FetchAllCountryTest  extends RootClass {
@Test
	public  void getCountryDetails() {
	String apidata=config.getPropertyObject("getAllcountries");
	
		Response resp=config.executeRequest(apidata);
		resp.then().log().all();

	}

}
