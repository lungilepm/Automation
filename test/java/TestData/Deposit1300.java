package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Deposit1300 {

	@Test(priority =1)
public static void makeDeposit ()
	
	{	
		RestAssured.baseURI="http://webserver8/Banking/Deposit/v1/deposits/product/5001/";
		
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization","Bearer "+ MethodHelpers.getOperatorToken()).
						
									body("{\r\n" + 
											"     \"IdempotencyId\":\""+MethodHelpers.getGuid()+"\",\r\n" +
											"     \"DepositMethodId\":1,\r\n" + 
											"     \"Amount\":200.0,\r\n" + 
											"     \"ReturnUrl\":\"http://banking.mgsops.net/Swift.StateMachine/swiftlaunch/resume/bid-ae1ea60a-b6eb-fb63-4e52-712c41fa73aa\",\r\n" + 
											"     \"ClientLanguageIsoCode\":\"EN\",\r\n" + 
											"     \"CurrencyIsoCode\":\"USD\",\r\n" + 
											"     \"Card\":{\r\n" + 
											"        \"CardId\":63,\r\n" + 
											"        \"Cvc\":\"123\"\r\n" + 
											"     }\r\n" + 
											"}").
									
						 when().	post().
						  then().	
					   extract().	response();
		
		System.out.println(resp.prettyPeek());
		

						  			
	}
}

