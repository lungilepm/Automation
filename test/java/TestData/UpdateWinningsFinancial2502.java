package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class UpdateWinningsFinancial2502 {
   public static String getUpdateWinningsFinancial2502()
       {
           return "soon";
       }

   @Test
   public static void testGetUpdateWinningsFinancial2502()
   {
       String value = getUpdateWinningsFinancial2502();
       System.out.println(value)
;   }
}
