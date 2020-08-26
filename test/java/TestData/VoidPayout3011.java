package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class VoidPayout3011 {
   public static String getVoidPayout3011()
       {
           return "soon";
       }

   @Test
   public static void testGetVoidPayout3011()
   {
       String value = getVoidPayout3011();
       System.out.println(value)
;   }
}
