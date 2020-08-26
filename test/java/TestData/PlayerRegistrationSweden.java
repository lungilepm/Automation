package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlayerRegistrationSweden {

    public static String getRegistration ()

    {
        RestAssured.baseURI="http://webserver4/Banking/Registration/v2/registrations/real";

        Response resp = given ().	header("Content-Type", "application/json").
                header("Authorization", "Bearer "+ MethodHelpers.getServiceToken()).
                body(
                        "{\n" +
                        "   \"Username\":\""+RandomStringUtils.randomAlphabetic(10)+"\",\n" +
                        "   \"FirstName\": \"Johnsw\",\n" +
                        "    \"LastName\": \"Malaza\",\n" +
                        "    \"DateOfBirth\": \"1900-01-30\",\n" +
                        "    \"AreTermsAndConditionsAccepted\": true,\n" +
                        "    \"Password\": \"test1234!\",\n" +
                        "     \"CurrencyIsoCode\": \"SEK\",\n" +
                        "    \"AddressDetails\": {\n" +
                        "        \"AddressLine1\": \"10 address\",\n" +
                        "        \"AddressLine2\": \"whatever\",\n" +
                        "        \"City\": \"city\",\n" +
                        "        \"CountryLongCode\": \"SWE\",\n" +
                        "        \"StateIsoCode\": \"SE-AB\",\n" +
                        "        \"PostalCode\": \"00194\"\n" +
                        "    },\n" +
                        "    \"ContactDetails\": {\n" +
                        "        \"Email\":\"RandLeave@dmail.com\",\n" +
                        "        \"PhoneNumber\": \"1\",\n" +
                        "                        \"WorkPhoneNumber\": \"\",\n" +
                        "        \"HomePhoneNumber\": \"\",\n" +
                        "        \"MobilePhoneNumber\": \"1111\"\n" +
                        "    },\n" +
                        "    \"policies\": {\n" +
                        "    \"privacy\": \"true\",\n" +
                        "    \"ProtectionOfFunds\": \"true\"\n" +
                        "  },\n" +
                        "    \"RegisteredProductId\": 5143,\n" +
                        "    \"CreatorId\": 22,\n" +
                        "    \"IpAddress\": \"10.1.20.139\",\n" +
                        "    \"UserFunnelId\": null,\n" +
                        "    \"Gender\": \"Male\",\n" +
                        "    \"LanguageCode\": \"EN\",\n" +
                        "    \"IdNumber\": \"195901086321\",\n" +
                        "    \"IdNumberTypeId\": \"35\",\n" +
                        "    \"IdempotencyId\": \""+MethodHelpers.getGuid()+"\",\n" +
                        "    \"UserIdentifier\": null,\n" +
                        "    \"daily\": 23,\n" +
                        "  \"weekly\":23,\n" +
                        "  \"monthly\": 300,\n" +
                        "  \"isLimitShared\": false,\n" +
                        "    \"AdditionalAttributes\": {\n" +
                        "        \"29\": \"en\",\n" +
                        "        \"33\": true,\n" +
                        "        \"35\": \"1\",\n" +
                        "        \"41\": \"fpabcasdf1\",\n" +
                        "        \"49\": \"\",\n" +
                        "        \"50\": \"\",\n" +
                        "        \"51\": \"\",\n" +
                        "        \"52\": \"\",\n" +
                        "        \"53\": \"\",\n" +
                        "        \"54\": \"\",\n" +
                        "        \"87\": \"\",\n" +
                        "        \"19\": true,\n" +
                        "        \"21\": \"\",\n" +
                        "        \"22\": \"\",\n" +
                        "        \"23\": \"4\",\n" +
                        "        \"24\": \"\",\n" +
                        "        \"30\": false,\n" +
                        "        \"31\": \"\",\n" +
                        "        \"32\": \"\",\n" +
                        "        \"38\": \"EN\",\n" +
                        "        \"39\": \"\",\n" +
                        "        \"43\": \"\",\n" +
                        "        \"58\": \"\",\n" +
                        "        \"60\": \"\",\n" +
                        "        \"61\": false,\n" +
                        "        \"59\": \"Italy\",\n" +
                        "        \"65\": \"RNLNCL65R15H501M\",\n" +
                        "        \"66\": \"Roma\",\n" +
                        "        \"67\": \"yes\",\n" +
                        "        \"68\": \"no\",\n" +
                        "        \"69\": \"Local Authority\",\n" +
                        "        \"70\": \"Roma\",\n" +
                        "        \"71\": \"2016-01-10\",\n" +
                        "        \"72\": \"2019-01-10\",\n" +
                        "        \"73\": \"9\",\n" +
                        "        \"80\": \"\",\n" +
                        "        \"85\": \"\",\n" +
                        "        \"weeklydepositlimit\": \"\",\n" +
                        "        \"111\": \"\",\n" +
                        "        \"106\": \"Municipality\",\n" +
                        "        \"92\": \"Turin\",\n" +
                        "        \"96\": \"True\",\n" +
                        "        \"95\": \"True\",\n" +
                        "        \"103\": false,\n" +
                        "        \"6\": \"\",\n" +
                        "        \"16\": \"\"\n" +
                        "    }\n" +
                        "}\n").
                when().	post().
                then().
                extract().	response();

        resp.prettyPeek();
        System.out.println(	resp.prettyPeek());
        return MethodHelpers.getExtract(resp, "username");


    }

    @Test

    public static void getRegister ()
    {
        String it = getRegistration();
        System.out.println(it);
    }

}


