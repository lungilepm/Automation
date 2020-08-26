package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class MGSRegulatedMarketAPIRegulatorExclusion6010 {
   public static String getMGSRegulatedMarketAPIRegulatorExclusion6010()
       {
           return "soon";
       }

   @Test
   public static void testGetMGSRegulatedMarketAPIRegulatorExclusion6010()
   {
       String value = getMGSRegulatedMarketAPIRegulatorExclusion6010();
       System.out.println(value)
;   }
}
