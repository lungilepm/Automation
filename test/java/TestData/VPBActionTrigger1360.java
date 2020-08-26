package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class VPBActionTrigger1360 {
   public static String getVPBActionTrigger1360()
       {
           return "soon";
       }

   @Test
   public static void testGetVPBActionTrigger1360()
   {
       String value = getVPBActionTrigger1360();
       System.out.println(value)
;   }
}
