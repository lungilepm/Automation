package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class ReverseWithdrawalLog5000 {
   public static String getReverseWithdrawalLog5000()
       {
           return "soon";
       }

   @Test
   public static void testGetReverseWithdrawalLog5000()
   {
       String value = getReverseWithdrawalLog5000();
       System.out.println(value)
;   }
}
