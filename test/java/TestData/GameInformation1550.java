package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class GameInformation1550 {
   public static String getGameInformation1550()
       {
           return "soon";
       }

   @Test
   public static void testGetGameInformation1550()
   {
       String value = getGameInformation1550();
       System.out.println(value)
;   }
}
