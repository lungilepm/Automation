package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class PlayerForgotPasswordReset1240 {
   public static String getPlayerForgotPasswordReset1240()
       {
           return "soon";
       }

   @Test
   public static void testGetPlayerForgotPasswordReset1240()
   {
       String value = getPlayerForgotPasswordReset1240();
       System.out.println(value)
;   }
}
