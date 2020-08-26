package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class AdjustBetFinancial2501 {
   public static String getAdjustBetFinancial2501()
       {
           return "soon";
       }

   @Test
   public static void testGetAdjustBetFinancial2501()
   {
       String value = getAdjustBetFinancial2501();
       System.out.println(value)
;   }
}
