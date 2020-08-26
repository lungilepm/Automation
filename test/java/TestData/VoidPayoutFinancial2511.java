package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class VoidPayoutFinancial2511 {
   public static String getVoidPayoutFinancial2511()
       {
           return "soon";
       }

   @Test
   public static void testGetVoidPayoutFinancial2511()
   {
       String value = getVoidPayoutFinancial2511();
       System.out.println(value)
;   }
}
