package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class AdjustBet3001 {
   public static String getAdjustBet3001()
       {
           return "soon";
       }

   @Test
   public static void testGetAdjustBet3001()
   {
       String value = getAdjustBet3001();
       System.out.println(value)
;   }
}
