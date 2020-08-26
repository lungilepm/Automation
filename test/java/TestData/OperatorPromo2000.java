package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class OperatorPromo2000 {
   public static String getOperatorPromo2000()
       {
           return "soon";
       }

   @Test
   public static void testGetOperatorPromo2000()
   {
       String value = getOperatorPromo2000();
       System.out.println(value)
;   }
}
