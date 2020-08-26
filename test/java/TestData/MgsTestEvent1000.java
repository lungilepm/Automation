package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class MgsTestEvent1000 {
   public static String getMgsTestEvent1000()
       {
           return "soon";
       }

   @Test
   public static void testGetMgsTestEvent1000()
   {
       String value = getMgsTestEvent1000();
       System.out.println(value)
;   }
}
