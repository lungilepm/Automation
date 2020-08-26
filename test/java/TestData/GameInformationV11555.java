package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class GameInformationV11555 {
   public static String getGameInformationV11555()
       {
           return "soon";
       }

   @Test
   public static void testGetGameInformationV11555()
   {
       String value = getGameInformationV11555();
       System.out.println(value)
;   }
}
