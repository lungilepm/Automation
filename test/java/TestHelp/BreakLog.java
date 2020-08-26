package TestHelp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BreakLog {
	
     @Test(priority =20, dataProvider = "getPayloads")
    public static void printResult(String file) throws IOException {
    	
    	
    }
	
    @DataProvider
    public static Object[][] getPayloads() throws IOException {
        //String path = "\\\\eventinsight2\\c$\\MGSLog\\MGSEI.CEPEngine-2019-09-18.log";
    	String path = "C:\\Users\\lungilemo\\Documents\\eventinsight\\Projects\\[9] Pending Deposit limit stream\\Logs\\MGSEI.CEPEngine-2019-09-03.log";
        FileReader file = new FileReader(path);

        int row = -1;
        //File inFile =new File ("\\\\alleycat\\TQAAutomation\\EDP\\Target.txt");
        BufferedReader in = new BufferedReader(file);

        String line;
        String[] temp;
        while ((line = in.readLine()) != null) {
            row++;
        }


        System.out.println("[NOT IN] || " + row);

        file = new FileReader(path);
        in = new BufferedReader(file);

        Object[][] tableName = new Object[row][2];
        for (int i = 0; i < row; i++) {
            System.out.println("[PASSED] || " + i);
            temp = in.readLine().split(",");
            System.out.println("[PASSED] || "/*+temp[0]*/ + temp[1]);
            tableName[i][0] = temp[0];
            tableName[i][1] = temp[1];

        }
        in.close();
        return tableName;


    }
}
