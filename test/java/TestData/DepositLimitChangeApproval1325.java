package TestData;


import java.io.BufferedReader;
import java.io.IOException;
import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static TestData.DepositLimitChange1320.getLimits;
import static io.restassured.RestAssured.given;
import static TestHelp.MethodHelpers.*;


public class DepositLimitChangeApproval1325 {
   public static String getDepositLimitChangeApproval1325(String user, String productId, String confirmation)
       {
           RestAssured.baseURI="http://webserver4:80/Account/ResponsibleGaming/v1/userDepositLimits/product/"+productId+"/user/"+user+"/"+confirmation;

           Response resp = given ().	header("Content-Type", "application/json").
                   header("Authorization","Bearer "+MethodHelpers.getOperatorToken()).

                   body("{\r\n"+

                           "}\r\n"
                   ).

                   when().	post().
                   then().
                   extract().	response();

           if(resp.getStatusCode()!=200)
           {		System.out.println("status code error on confirm");
               System.out.println("Let______________________________________________"+resp.prettyPeek());
               return "d";
           }

           String line ="Jame_______________________________________________________________________________"+resp.prettyPeek();
           System.out.println(line);
           return line;
       }



   @Test (priority = 0)
   public static void getDepositlimits() {
       String value1= getLimits ("100","200","300","5143", "31011");
}
    @Test (priority = 1)
   public static void testGetDepositLimitChangeApproval1325() {
       String value = getDepositLimitChangeApproval1325("31011", "5143", "confirm");
   }
}
