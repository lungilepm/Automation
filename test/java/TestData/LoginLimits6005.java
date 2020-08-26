package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginLimits6005 {

    public static void getLoginLimits6005 (String Daily, String weekly, String monthly,String productId, String user)

    {
        int row = 0;

        RestAssured.baseURI="http://webserver4/Account/ResponsibleGaming/v1/loginLimits/product/"+productId+"/user/"+user ;

        Response resp = given ().	header("Content-Type", "application/json").
                header("Authorization","Bearer "+MethodHelpers.getServiceToken()).

                body("{\n" +
                        "  \"daily\": "+Daily+",\n" +
                        "  \"weekly\": "+weekly+",\n" +
                        "  \"monthly\": "+monthly+",\n" +
                        "  \"isLimitShared\": true\n" +
                        "}"
                ).

                when().	post().
                then().
                extract().	response();
        int code =0;
        if((code=resp.getStatusCode())!=200)
        {		System.out.println(code+"status code error on user login limits");
            System.out.println("Let______________________________________________"+resp.prettyPeek());
            return;
        }

        System.out.println("Let______________________________________________"+resp.prettyPeek());

    }

    @Test
    public static void getLoginLimits()
    {
        getLoginLimits6005("88","300","500","31011","5143");
    }
}
