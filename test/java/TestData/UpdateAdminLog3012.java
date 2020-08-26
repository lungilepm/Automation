package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class UpdateAdminLog3012 {
   public static String getUpdateAdminLog3012()
       {
           return "soon";
       }

   @Test
   public static void testGetUpdateAdminLog3012()
   {
       String value = getUpdateAdminLog3012();
       System.out.println(value)
;   }
}
