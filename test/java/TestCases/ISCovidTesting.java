package TestCases;

import TestHelp.MethodHelpers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static TestData.DepositLimitChange1320.getLimits;
import static TestData.LoginLimits6005.getLoginLimits6005;
import static TestHelp.MethodHelpers.deleteFile;
import static TestHelp.SplitPayload.getSplitLog;

public class ISCovidTesting {

    @Test(priority = 1)
    public static void VPBNextSERequestedDepLim0K()
    {
        getLimits ("150","3000","10000","5143","31011");
        getLimits ("100","2000","9000","5143","31011");
        getLimits ("50","1000","8000","5143","31011");
        getLimits ("40","800","7000","5143","31011");


        try {
            getSplitLog();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println(	"cannot split");
            throwables.printStackTrace();

            deleteFile(MethodHelpers.pathSi2+"\\MGSEI.CEPEngine-"+MethodHelpers.getDate()+".log") ;

        }

    }

    @Test(priority = 2)
    public static void DepositLimitsIncrease()
    {
        getLimits ("400","600","800","5143","31015");
        getLimits ("4000","6000","8000","5143","31015");
        try {
            getSplitLog();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println(	"cannot split");
            throwables.printStackTrace();

            deleteFile(MethodHelpers.pathSi2+"\\MGSEI.CEPEngine-"+MethodHelpers.getDate()+".log") ;

        }

    }


}
