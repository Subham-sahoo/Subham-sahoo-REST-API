package Parameter_in_RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Param_para {
	@Test
	public void  Fetch_Data_PP() {
		given().param("userId", "3").when().get("https://jsonplaceholder.typicode.com/posts").then().log().all();
	}

}
