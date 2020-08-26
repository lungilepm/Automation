package TestHelp;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static TestHelp.MethodHelpers.pathToScripts;


public class UpdateSQdef {
    public static String getContentInFile(String pathofFle,String begin, String end)
    {



        String content =null;
        String temp=null;
        File objFile = new File(pathofFle);
        try {
            content = Files.toString(objFile, Charsets.UTF_8);
        } catch (IOException e) {
            System.out.println("The file we are searching for of path: "+pathofFle+"does not exist");
            e.printStackTrace();
        }
        temp = content.substring(content.lastIndexOf(begin),content.indexOf(end));
        content =temp.replaceAll(begin,"");
        content =content.replaceAll("'","''");
        System.out.println("File in the path: "+content);

    return content;

    }
    @Test
    public static void updateSQDef() throws SQLException {
        String pathtoNewDef = pathToScripts+"newSQDef.txt";
        String sqNewSQ = getContentInFile(pathtoNewDef,"beginSQDef","endofSQdef");
        String sqGuid =getContentInFile(pathtoNewDef,"endofSQdef","endofSQguid");
       String sqlDef = "update [EventInsight].[dbo].[tb_StandingQuery] set StandingQueryDef = '"+sqNewSQ+"' where QueryID ='"+sqGuid+"';";
        System.out.println("The definition of the sql "+sqlDef);
        String name =  MethodHelpers.dbCon(sqlDef,1,MethodHelpers.conEventinsight);
        System.out.println("This is who we are people: "+name);
    }


}
