package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class Cashin1310 {
   public static String getCashin1310()
       {
           return "soon";
       }

   @Test
   public static void testGetCashin1310()
   {
       String value = getCashin1310();
       System.out.println(value)
;   }
}
