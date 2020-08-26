package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class GameAchievement1600 {
   public static String getGameAchievement1600()
       {
           return "soon";
       }

   @Test
   public static void testGetGameAchievement1600()
   {
       String value = getGameAchievement1600();
       System.out.println(value)
;   }
}
