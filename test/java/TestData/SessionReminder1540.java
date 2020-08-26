package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SessionReminder1540 {

	
	//@Test (priority=2)
	public static void getSessRem ()
	{
	RestAssured.baseURI="http://webserver4/Account/ResponsibleGaming/public/v1/logicalSessions/start";

	Response resp = given ().	header("Content-Type", "application/json").
								header("Authorization","Bearer "+ MethodHelpers.getServiceToken()).
								body("{}" ).
					 when().post().
					  then().
				   extract().	response();

	System.out.println("THATHA "+resp.prettyPeek());



	}

	
	@Test(priority=1)
	public static void makeSessRem ()
	{
	RestAssured.baseURI="https://api2.gameassists.co.uk/Account/ResponsibleGaming/public/v1/logicalSessions/start";

	Response resp = given ().	header("Content-Type", "application/json").
								//header("Authorization","Bearer "+Helpers.getServiceToken()).
								header("logicalSessionIdentifier", "5007").
								header("username", "granth_URM").
								body("" ).
					 when().post().
					  then().
				   extract().	response();

	System.out.println("THATHA "+resp.prettyPeek());



	}

}
