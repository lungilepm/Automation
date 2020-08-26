package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class Milestone1570 {
   public static String getMilestone1570()
       {
           return "soon";
       }

   @Test
   public static void testGetMilestone1570()
   {
       String value = getMilestone1570();
       System.out.println(value)
;   }
}
