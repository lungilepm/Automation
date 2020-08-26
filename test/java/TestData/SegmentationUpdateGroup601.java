package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SegmentationUpdateGroup601 {
        public static String SegmentationAddUser(String user , String groupMovement)
        {
            //	String guida = SegmentationAddGroup600();
            RestAssured.baseURI="http://webserver4/Account/UserSegmentation/v1/userGroups/product/5001/user/"+user+"/userGroup/"+groupMovement;

            Response resp = given ().	header("Content-Type", "application/json").
                    header("Authorization","Bearer "+ MethodHelpers.getOperatorToken()).

                    body("{}").

                    when().	post().
                    then().
                    extract().	response();

            return resp.prettyPeek().toString();

        }
        @Test
        public static void TestSegmentationAddUserToGroup()
        {
            System.out.println(SegmentationAddUser("41739" ,"2874751e-18cf-4518-945f-2b041ae2a233" ));

        }


}
	