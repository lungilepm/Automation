package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class FundGameFinancial2500 {
   public static String getFundGameFinancial2500()
       {
           return "soon";
       }

   @Test
   public static void testGetFundGameFinancial2500()
   {
       String value = getFundGameFinancial2500();
       System.out.println(value)
;   }
}
