package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlayerPasswordChange1230 {

	public static String getChangePas ()
	
	{	
		RestAssured.baseURI="http://webserver4/Account/v1/accounts/product/5001/user/28676/changePassword";
	
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization", "Bearer "+ MethodHelpers.getServiceToken()).
									body("{"
											+ "\"oldPassword\": \"tess\",\r\n" + 
											"  \"newPassword\": \"test\""
											+ "}").
						 when().	post().
						  then().	
					   extract().	response();
		
		resp.prettyPeek();
		System.out.println(	resp.prettyPeek());
		return MethodHelpers.getExtract(resp, "username");
		
						  			
	}
	@Test
	
	public static void getRegister ()
	{
		String it = getChangePas();
		System.out.println(it);
	}
	
}
	

