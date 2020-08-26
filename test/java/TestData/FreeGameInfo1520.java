package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class FreeGameInfo1520 {
   public static String getFreeGameInfo1520()
       {
           return "soon";
       }

   @Test
   public static void testGetFreeGameInfo1520()
   {
       String value = getFreeGameInfo1520();
       System.out.println(value)
;   }
}
