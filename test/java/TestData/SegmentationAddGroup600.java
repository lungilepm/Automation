package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SegmentationAddGroup600 {


public static String SegmentationAddGroup()
	{	
		String guid = MethodHelpers.getGuid();
		RestAssured.baseURI="http://webserver4/Account/UserSegmentation/v1/usergroups";
		
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization","Bearer "+MethodHelpers.getOperatorToken()).
						
									body("{\r\n" + 
											"  \"userGroupGuid\": \""+guid+"\",\r\n" + 
											"  \"name\": \""+MethodHelpers.getGuid().substring(5)+"\",\r\n" +
											"  \"productid\": \"5001\",\r\n" + 
											"  \"description\": \"600 SegmentationAddGroup\"\r\n" + 
											"}").
									
						 when().	post().
						 
						  then().	
					   extract().	response();
/*		try {
			//Thread.sleep(6000); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(resp.prettyPeek());
		return guid;
	}



}