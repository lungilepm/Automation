package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class FreeGameAwarded1530 {

	static String  idem = MethodHelpers.getGuid();
	static String offerFrom =MethodHelpers.getDate()+"T09:00:00Z";// \""+Helpers.getDate()+" 00:00:00.000Z\",\r\n"
	static String connectionUrl = "jdbc:sqlserver://10.1.176.69:1433;"
    		+"server =gamingdb1\\inst2;"
    		+"databaseName=casino;"
    		+"user=sa;password=!@#$%A1;";
    		
	public static String createOffer ()
	
	{	//Guid yourGuid= Guid.NewGuid()
		
		
		RestAssured.baseURI="http://webserver4/casino/freeGames/v1/offers/nearestCost/product/5001";
	
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization","bearer " + MethodHelpers.getOperatorToken()).
									body("{\r\n"
											+ "\"idempotencyId\":\""+idem+"\",\r\n"
											+ "\"defaultNumberOfGames\": 5,\r\n"
											+ "\"offerName\" : \"luchaLegends "+idem.subSequence(0, 3)+"\",\r\n"
											+ "\"offerAvailableFromUtcDate\" : \""+offerFrom+"\",\r\n"
											+ "\"offerExpirationUtcDate\" : \"2033-09-03 00:00:00.000Z\",\r\n"
											+ "\"durationAvailableAfterAwarded\": "
											+ "{\r\n"
											+ "\t\"length\": 24,\r\n"
											+ "\t\"timeUnitId\": 6\r\n"
											+ "},\r\n"
											+ "\"games\":\r\n"
											+ "[\r\n"
											+ " {\r\n"
											+ "\"moduleId\" : 10685,\r\n"
											+ "\"clientId\" : 1,\r\n"
											+ "\"nearestCostPerBet\": 1\r\n"
											+ "}\r\n"
											+ "]\r\n}").
						 when().	post().
						  then().	
					   extract().	response();
		
		resp.prettyPeek();
		System.out.println(	resp.prettyPeek());
		return MethodHelpers.getExtract(resp, "offerId");
		
						  			
	}



	@Test(priority =1)
	public static void assignOffer () throws SQLException {
			String name =null;	
			String sql = "DECLARE @Now DateTime\r\n" + 
					"SET @Now = GETDATE()\r\n" + 
					"\r\n" + 
					"EXEC dbo.pr_AddUserFreeGame @OfferID = "+createOffer()+", \r\n" + 
					"@UserID = 28677, \r\n" + 
					"@UserOfferStartDate = @Now\r\n" + 
					"PRINT 'Assign Offers to User Account(s)'";

				name =  MethodHelpers.dbCon(sql,0,connectionUrl);

			System.out.println(	name);
			
		
		/***--To assign your Free Game offer to the UserID
Use casino
GO
BEGIN TRANSACTION

DECLARE @Offer_ID int, @User_ID int

----- PROVIDE OFFERID FROM THE INSTALLED OFFERS AND PROVIDE UserID For Bluemesa Account

SET @Offer_ID = ###
SET @User_ID = ###


--------------------------------------
"{\r\n\t\"idempotencyId\":"+Helpers.getGuid()+",\r\n\t\"offerAvailableFromUtcDate\": \""+Helpers.getDate()+"00:00:00.000Z\"\r\n}"

--------------------------------------
DECLARE @Now DateTime
SET @Now = GETDATE()

EXEC dbo.pr_AddUserFreeGame @OfferID = @Offer_ID , @UserID = @User_ID, @UserOfferStartDate = @Now
PRINT 'Assign Offers to User Account(s)'
--------------------------------------
PRINT 'All Done!'
COMMIT TRANSACTION					
		RestAssured.baseURI="http://webserver4/casino/freeGames/v1/offers/product/5001/user/28677/offer/"+createOffer ();
		
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization","bearer " + Helpers.getOperatorToken()).
									body("{\r\n" + 
											"  \"idempotencyId\"             : \""+Helpers.getGuid()+"\",\r\n" + 
											"  \"offerAvailableFromUtcDate\" : \""+offerFrom+"\"\r\n" + 
											"}"
											
											).
						  when().	post().
						  then().	
					   extract().	response();
		
		System.out.println(	resp.prettyPeek());**/

		
						  			
	}
	



        
    
    
	
	
	

}