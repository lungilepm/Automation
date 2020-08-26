package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class PlayerForgotPasswordRequest1220 {
   public static String getPlayerForgotPasswordRequest1220()
       {
           return "soon";
       }

   @Test
   public static void testGetPlayerForgotPasswordRequest1220()
   {
       String value = getPlayerForgotPasswordRequest1220();
       System.out.println(value)
;   }
}
