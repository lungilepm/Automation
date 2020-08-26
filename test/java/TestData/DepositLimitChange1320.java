package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DepositLimitChange1320 {

	public static String getLimits (String Daily, String weekly, String monthly,String productId, String user)
	
	{
		int row = 0;

		RestAssured.baseURI="http://webserver4/Account/ResponsibleGaming/v1/userDepositLimits/product/"+productId+"/user/"+user;
		
		Response resp = given ().	header("Content-Type", "application/json").
									header("Authorization","Bearer "+ MethodHelpers.getOperatorToken()).
						
									body("{\r\n"+ 
											"\"depositDailyLimit\": "+Daily+",\r\n" + 
											"\"depositWeeklyLimit\":"+weekly+",\r\n" + 
											"\"depositMonthlyLimit\":"+monthly+",\r\n" + 
											"\"linkAccountDepositLimits\": 1\r\n" + 
											"}\r\n" 
											).
									
						 when().	post().
						  then().
					   extract().	response();
		int code =0;
		if((code=resp.getStatusCode())!=200)
		{		System.out.println(code+"status code error on user deposit limits");
				System.out.println("Let______________________________________________"+resp.prettyPeek());
				return "lutho";
		}
		
		System.out.println("Sucess:___"+resp.prettyPeek());
		return resp.prettyPeek()+"";
	}

	

	@Test(priority =3)
	public static void getLimitApprove1 ()
	{	
				getLimits ("1500","3000","5000","5143","31015");
			


		
	}
	
	
	
	//rabbitAdminPwd
	//rabbitAdmin

}
