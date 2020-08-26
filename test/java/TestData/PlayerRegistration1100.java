package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlayerRegistration1100 {

	public static String [] getComRegistration ()
	
	{/**
	 "username": "nRcTSXScal",
	 "password": "test",
	 "accountStatus": 1,
	 "userIdentifier": "9c69f51f-7ad2-4a49-a006-a48c469d8468",
	 "userId": 41743,*/
		RestAssured.baseURI="http://webserver4/Banking/Registration/v2/registrations/real";
	
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization", "Bearer "+ MethodHelpers.getServiceToken()).
									body("{ \r\n" + 
											" \"registeredProductId\" : 5001,\r\n" +
											" \"creatorId\" : 18,\r\n" +
											" \"idempotencyId\": \""+MethodHelpers.getGuid()+"\",\r\n" +
											" \"username\":\""+ RandomStringUtils.randomAlphabetic(10)+"\", \r\n" +
											" \"password\":\"test\", \r\n" + 
											" \"firstname\":\"Dan\", \r\n" + 
											" \"lastName\":\"Test\", \r\n" + 
											" \"dateOfBirth\":\"1993-05-18\", \r\n" + 
											" \"idNumber\":\"93051822361\", \r\n" + 
											" \"idNumberTypeId\": 3, \r\n" + 
											" \"gender\":\"Male\", \r\n" + 
											" \"ipAddress\":\"10.1.20.187\" , \r\n" + 
											" \"currencyIsoCode\":\"EUR\", \r\n" +
											" \"languageCode\":\"EN\", \r\n" + 
											" \"areTermsAndConditionsAccepted\":true, \r\n" + 
											" \"policies\": {\r\n" + 
											"  \"privacy\": true,\r\n" + 
											"  \"ProtectionOfFunds\": true\r\n" + 
											" },\r\n" + 
											" \"AdditionalAttributes\":{ \r\n" + 
											"   \"nationality\":\"BEL\", \r\n" + 
											"   \"placeOfBirth\":\"Antwerp\", \r\n"
											+ "\"btag1\": \"two\"" + 
											"  },\r\n" + 
											" \"addressDetails\" : {\r\n" + 
											"   \"addressLine1\":\"18 Anil road\",\r\n" + 
											"   \"addressLine2\":\"La Lucia\",\r\n" + 
											"   \"city\":\"Durban\",\r\n" + 
											"   \"stateIsoCode\":\"ZA-NL\",\r\n" + 
											"   \"countryLongCode\":\"ZAF\",\r\n" + 
											"   \"postalCode\":\"4019\"\r\n" + 
											" },\r\n" + 
											"\"contactDetails\" : {\r\n" + 
											"  \"email\":\"test@test.com\", \r\n" + 
											"  \"phoneNumber\":\"27 123456789\", \r\n" + 
											"  \"workPhoneNumber\":\"27 123456789\", \r\n" + 
											"  \"homePhoneNumber\":\"27 123456789\", \r\n" + 
											"  \"mobilePhoneNumber\":\"27 123456789\" \r\n" + 
											" }\r\n" + 
											"}").
						 when().	post().
						  then().	
					   extract().	response();
		
		resp.prettyPeek();
		System.out.println(	resp.prettyPeek());
		String [] won ={MethodHelpers.getExtract(resp, "username"),MethodHelpers.getExtract(resp, "userIdentifier"),MethodHelpers.getExtract(resp, "userId")};
		return won;
		
						  			
	}
	
	@Test
	
	public static void getRegister ()
	{
		String []it = getComRegistration();
		System.out.println("username "+it[0]+"---------------name"+it[1]+"---------------"+it[2]+"---------------");
	}
	
	
}
