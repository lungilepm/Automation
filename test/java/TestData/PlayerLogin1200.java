package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlayerLogin1200 {

	
	
public static String getRealLogin (String name , String pass)
	
	{	
		RestAssured.baseURI="http://api5.installprogram.eu/casino/user/public/v1/accounts/login/real";
		
		Response resp = given ().	header("Content-Type", "application/json").
									header("X-ClientTypeId", "40").
									header("X-CorrelationId", MethodHelpers.getGuid()).
									body("{  "
											+ "\"userName\": \""+name+"\",\r\n" + 
											"  \"password\": \""+pass+"\",\r\n" + 
											"  \"sessionProductId\": 5007,\r\n" + 
											"  \"numLaunchTokens\": 1,"
											+ "}").
							
									
						 when().	post().
						  then().	
					   extract().	response();
		
		System.out.println(resp.prettyPeek());
		
		String tp= MethodHelpers.getExtract(resp, "tokens.userToken");
		System.out.println("Nayi la ne "+tp);
		
		return tp;
		
		
						  			
	}
//@Test (priority =2 )
public static void getRealLogout ()

{	
	RestAssured.baseURI="http://api5.installprogram.eu/casino/user/public/v1/accounts/logout";
	
	Response resp = given ().	header("Content-Type", "application/json").
								//header("Authorization", "Bearer "+Helpers.getOperatorToken()).
								header("X-ClientTypeId", "40").
								header("X-CorrelationId", MethodHelpers.getGuid()).
								body("{  "
										+ "\"closeRelatedSessions\": \"false\",\r\n" + 
										"  \"reason\": \"1\",\r\n" + 
										 "}").
								
					 when().	post().
					  then().	
				   extract().	response();
	
	System.out.println(resp.prettyPeek());
	
	//String tp= Helpers.getExtract(resp, "tokens.userToken");
	//System.out.println("Nayi la ne "+tp);
	//

	
	
					  			
}




@Test(priority =1 )

public static void testGet () 

{
	String value = getRealLogin("owenc", "test");
	
	System.out.println(value);
}


}
