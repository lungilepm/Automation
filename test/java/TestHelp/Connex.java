package TestHelp;


import org.testng.annotations.Test;

import java.sql.*;

class  Connex{

    public static String dbCon(String sql,int col,String Urls) throws SQLException {

        Connection connObj = DriverManager.getConnection(MethodHelpers.conEventinsight);

        Statement stmtObj = connObj.createStatement();
        ResultSet resObj = stmtObj.executeQuery(sql);
        while (resObj.next()) {

          return  resObj.getString(col);

        }
    return "#$$#";
    }

    @Test (priority = 1)

    public static void testcon() throws SQLException {   
        
        String yu = "select * from evt.tb_EventType";
        dbCon(yu,1,MethodHelpers.conEventinsight);
    }
}