package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class FundGame3000 {
   public static String getFundGame3000()
       {
           return "soon";
       }

   @Test
   public static void testGetFundGame3000()
   {
       String value = getFundGame3000();
       System.out.println(value)
;   }
}
