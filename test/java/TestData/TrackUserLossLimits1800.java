package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class TrackUserLossLimits1800 {
   public static String getTrackUserLossLimits1800()
       {
           return "soon";
       }

   @Test
   public static void testGetTrackUserLossLimits1800()
   {
       String value = getTrackUserLossLimits1800();
       System.out.println(value)
;   }
}
