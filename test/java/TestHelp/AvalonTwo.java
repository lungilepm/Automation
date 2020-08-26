package TestHelp;

import static io.restassured.RestAssured.given;

import java.util.UUID;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AvalonTwo {
	
	static String  idem = null;
	public static String getGuid( )
	{
		UUID uuid = UUID.randomUUID();
		String guid = uuid.toString();
		return guid;
	}
	
	public static String getExtract(Response resp, String identifier )
	{
		String response = resp.asString();
		JsonPath js = new JsonPath(response);
		response = js.get(identifier)+"";
		System.out.println(response);
		return response+"";
	}
	
	public static String getToken ()
	
	{
		RestAssured.baseURI="http://webserver4/system/operatorsecurity/v1/operatortokens";
		
		Response resp = given ().	header("Content-Type", "application/json").
									body("{\r\n  \"apiKey\": \"e21ff5d7-893a-4198-a8c7-2e836aaedea4\"\r\n}").
						  when().	post().
						  then().	
					   extract().	response();
		
		
		System.out.println(resp.prettyPeek());

	return	getExtract(resp, "AccessToken");
						  			
	}
	
	@Test (priority =1)
	public static void getOffer ()
	
	{	
		RestAssured.baseURI="http://pcm3.valueactive.eu/Games/AvalonII/public/v1/play/spins";
		Response resp = given ().	header("Content-Type", "application/json").
									header("X-CorrelationId", getGuid( )).
									header("X-ClientTypeId",1).
									body("{\r\n  \"context\": {\r\n"
											+ "\"freeGames\": null\r\n  },\r\n"
											+ "\"gameRequest\": {\r\n"
											+ "\"bet\": {\r\n"
											+ "\"betMultiplier\": 30,\r\n"
											+ "\"numCoinsPerLineOrWay\": 5,\r\n"
											+ "\"coinSize\": 1\r\n    }\r\n"
											+"}").
						 when().	post().
						  then().	
					   extract().	response();
		
		resp.prettyPeek();

	}

}
