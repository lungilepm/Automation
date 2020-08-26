package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class PlayerRegistration5100 {
   public static String getPlayerRegistration5100()
       {
           return "soon";
       }

   @Test
   public static void testGetPlayerRegistration5100()
   {
       String value = getPlayerRegistration5100();
       System.out.println(value)
;   }
}
