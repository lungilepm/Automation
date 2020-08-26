package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class BalanceUpdateIP1355 {
   public static String getBalanceUpdateIP1355()
       {
           return "soon";
       }

   @Test
   public static void testGetBalanceUpdateIP1355()
   {
       String value = getBalanceUpdateIP1355();
       System.out.println(value)
;   }
}
