package TestHelp;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TemplateStandingQuery {
	
	@Test (priority =1)
	public static void getTemplateQuery ()

{
RestAssured.baseURI="http://webserver4:80/System/EventInsight/v1/standingQueries/standardQuery";
		
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization","Bearer "+MethodHelpers.getOperatorToken()).
						
									body("{\r\n" + 
											"  \"subSystemInstanceId\": null,\r\n" + 
											"  \"subSystemId\": 64,\r\n" + 
											"  \"isQueriesOrdered\": true,\r\n" + 
											"  \"createQueriesRequest\": [\r\n" + 
											"    {\r\n" + 
											"      \"baseQueryId\": \"42FC8CEC-3292-49E2-BEC5-D956F90DBBDC\",\r\n" + 
											"      \"queryId\": \""+MethodHelpers.getOperatorToken()+"\",\r\n" +
											"      \"milestoneTypeId\": 0,\r\n" + 
											"      \"queryOrder\": 1,\r\n" + 
											"      \"numberOfSequenceRepeats\": 0,\r\n" + 
											"      \"parameterValues\": []\r\n" + 
											"    }\r\n" + 
											"  ]\r\n" + 
											"}\r\n" + 
											"" 
											).
									
						 when().	post().
						  then().	
					   extract().	response();
		
		System.out.println(resp.prettyPeek());
		
	}

}
