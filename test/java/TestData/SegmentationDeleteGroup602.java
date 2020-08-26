package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class SegmentationDeleteGroup602 {
   public static String getSegmentationDeleteGroup602()
       {
           return "soon";
       }

   @Test
   public static void testGetSegmentationDeleteGroup602()
   {
       String value = getSegmentationDeleteGroup602();
       System.out.println(value)
;   }
}
