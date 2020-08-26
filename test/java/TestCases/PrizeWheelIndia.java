package TestCases;

import TestData.PlayerLogin1200;
import TestData.SegmentationUpdateGroup601;
import TestData.WagerInfo1500;
import TestHelp.MethodHelpers;
import TestHelp.SplitPayload;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static TestData.SegmentationUpdateGroup601.SegmentationAddUser;
import static TestHelp.MethodHelpers.deleteFile;

public class PrizeWheelIndia {
    static String  username = "sahils";
    static String userid = "4554";
    static String [] groupMovement ={
            "837EAAAD-E2CD-482E-A8CA-A01FECD56BA3",
            "18A968D2-E232-4B27-BD79-5F25956CD116",
            "C594E574-0BD9-4C9F-96E3-31C83287D4D8",
            "A8CC30A6-E9AC-4DE1-9350-A9D3FE7B8CC7",
            "48F9A143-7E8B-43CA-99C9-2F9632AC50ED"}
        ;
 @Test (priority = 1)
    public static void testPrize1()
    {


        SegmentationAddUser(userid ,groupMovement[0]);
        SegmentationAddUser(userid ,groupMovement[1]);
        SegmentationAddUser(userid ,groupMovement[2]);
        SegmentationAddUser(userid ,groupMovement[3]);
        SegmentationAddUser(userid ,groupMovement[4]);
        WagerInfo1500.getWager (10000,"sahils","test");


        try {
            SplitPayload.getSplitLog();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }



}
