package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class CardRegistration1340 {
   public static String getCardRegistration1340()
       {
           return "soon";
       }

   @Test
   public static void testGetCardRegistration1340()
   {
       String value = getCardRegistration1340();
       System.out.println(value)
;   }
}
