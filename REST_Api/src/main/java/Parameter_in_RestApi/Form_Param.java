package Parameter_in_RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Form_Param {
	@Test
	public void fetch_Data_By_Param(){
		
		
		given().formParam("userId", "3").when().get("https://jsonplaceholder.typicode.com/posts").then().log().all();
		
	}

}
