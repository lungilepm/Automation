package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class PlayerGroupMovement1250 {
   public static String getPlayerGroupMovement1250()
       {
           return "soon";
       }

   @Test
   public static void testGetPlayerGroupMovement1250()
   {
       String value = getPlayerGroupMovement1250();
       System.out.println(value)
;   }
}
