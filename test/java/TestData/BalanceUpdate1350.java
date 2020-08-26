package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class BalanceUpdate1350 {
   public static String getBalanceUpdate1350()
       {
           return "soon";
       }

   @Test
   public static void testGetBalanceUpdate1350()
   {
       String value = getBalanceUpdate1350();
       System.out.println(value)
;   }
}
