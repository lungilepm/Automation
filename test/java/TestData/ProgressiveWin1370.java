package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class ProgressiveWin1370 {
   public static String getProgressiveWin1370()
       {
           return "soon";
       }

   @Test
   public static void testGetProgressiveWin1370()
   {
       String value = getProgressiveWin1370();
       System.out.println(value)
;   }
}
