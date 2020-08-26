package TestData;

import TestHelp.MethodHelpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class WagerInfo1500 {

//http://api5.installprogram.eu/casino/play/public/v1/games/module/17501/client/40300/play

public static void getWager ( double wagerCount, String username, String password) {
	int flag = 0;
	long timeElapsed = System.currentTimeMillis();
	int row = 0;


	//Game is 10025	40300	HTML5 - Feature Slot - Thunderstruck	Advanced Slot - Veyron - Slot	Mobile Web Gaming Client
	String clientID = "40300";
	String moduleID = "10025";
	String verbex = "Spin";



		for (int i =0; i<wagerCount;i++) {
			String launchToken = PlayerLogin1200.getRealLogin(username, password);
			while (System.currentTimeMillis()-timeElapsed>500)
				{		System.out.println(System.currentTimeMillis()-timeElapsed);
					RestAssured.baseURI = "http://api5.installprogram.eu/casino/play/public/v1/games/module/" + moduleID + "/client/" + clientID + "/play";
					String load = "\"<Pkt version='4'>"
							+ "<Id mid='" + moduleID + "' cid='" + clientID + "' sid='2234' sessionid='" + MethodHelpers.getGuid() + "' verb='AdvSlot' clientLang='en'/>"
							+ "<Request verbex='" + verbex + "' chipSize='100' numChips='4' activePaylines='0,1,2,3,4,5,6,7,8'/>"
							+ "</Pkt>\"";

					Response resp = given().header("Content-Type", "application/json").
						header("Authorization", "bearer " + launchToken).
						header("X-CorrelationId", MethodHelpers.getGuid()).
						header("X-ClientTypeId", 40).
						header("X-Route-ProductId", 5001).
						header("X-Route-ModuleId", moduleID).
						body("{\r\n" +
								"\"packet\": {\r\n" +
								"\"payload\":" + load + ",\r\n" +
								"\"packetType\":8,\r\n" +
								"\"useFilter\":true\r\n" +
								"}\r\n" +
								"}").

						when().post().
						then().
						extract().response();

					System.out.println(resp.prettyPeek());
					System.out.println(row);
					String respS = MethodHelpers.getExtract(resp, "displayMessage");

					if (respS.equals("Out of Sequence Event.")) {
						if (flag == 1) {
							flag = 0;
							wagerCount = wagerCount + 1;
							verbex = "Spin";
							continue;
										}
						flag++;
						verbex = "FreeSpin";
				}
			}

}

}

	@Test(priority =1 )
	public static void testGetWager ()
	{
		getWager (2,"owenc","test");
	}
}
