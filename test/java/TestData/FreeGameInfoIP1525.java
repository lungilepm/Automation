package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class FreeGameInfoIP1525 {
   public static String getFreeGameInfoIP1525()
       {
           return "soon";
       }

   @Test
   public static void testGetFreeGameInfoIP1525()
   {
       String value = getFreeGameInfoIP1525();
       System.out.println(value)
;   }
}
