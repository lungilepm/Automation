package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class RichMediaMessage1700 {
   public static String getRichMediaMessage1700()
       {
           return "soon";
       }

   @Test
   public static void testGetRichMediaMessage1700()
   {
       String value = getRichMediaMessage1700();
       System.out.println(value)
;   }
}
