package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class UpdateWinnings3010 {
   public static String getUpdateWinnings3010()
       {
           return "soon";
       }

   @Test
   public static void testGetUpdateWinnings3010()
   {
       String value = getUpdateWinnings3010();
       System.out.println(value)
;   }
}
