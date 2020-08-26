package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class PlayerLogout1210 {
   public static String getPlayerLogout1210()
       {
           return "soon";
       }

   @Test
   public static void testGetPlayerLogout1210()
   {
       String value = getPlayerLogout1210();
       System.out.println(value)
;   }
}
