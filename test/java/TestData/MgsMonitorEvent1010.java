package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class MgsMonitorEvent1010 {
   public static String getMgsMonitorEvent1010()
       {
           return "soon";
       }

   @Test
   public static void testGetMgsMonitorEvent1010()
   {
       String value = getMgsMonitorEvent1010();
       System.out.println(value)
;   }
}
