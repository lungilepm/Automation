package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class FailedLogin1330 {
   public static String getFailedLogin1330()
       {
           return "soon";
       }

   @Test
   public static void testGetFailedLogin1330()
   {
       String value = getFailedLogin1330();
       System.out.println(value)
;   }
}
