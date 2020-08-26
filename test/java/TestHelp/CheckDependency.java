package TestHelp;

import com.profesorfalken.jpowershell.PowerShell;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

import static TestHelp.MethodHelpers.fileNameLog;
import static TestHelp.MethodHelpers.pathToScripts;

public class CheckDependency {
static String operatingPath =pathToScripts+"\\listed.txt";

public static void makeCommand()
{
	String command = "md d:\\sqlScripts";

System.out.println(PowerShell.executeSingleCommand(command).getCommandOutput());
	
}

public static void searchProc(String directory, String filename)
{
	//filename="Core_EI_RegistrationStreamBaseline_Casino_Patch_PreInstall";
	File f = new File(directory);
	File[] matchingFiles = f.listFiles(new FilenameFilter() {
	    public boolean accept(File dir, String name) {
	    	boolean res = name.startsWith(filename) && name.endsWith("sql");
	    	System.out.println(res);
	        return res;
	    }
	});	
}
public static void copyFile(String source1, String dest1)
{
	File source = new File(source1);
	File dest = new File(dest1);
	try {
	    FileUtils.copyDirectory(source, dest);
	} catch (IOException e) {
	    e.printStackTrace();
	}	

}

public static void findAll(String file)
{
    String[] pathnames;

    // Creates a new File instance by converting the given pathname string
    // into an abstract pathname
    File f = new File(file);
   MethodHelpers.writeCSVLine(operatingPath,"",false);
    // Populates the array with names of files and pathToScriptsdirectories
    pathnames = f.list();

    // For each pathname in the pathnames array
    for (String pathname : pathnames) {
        // Print the names of files and directories
        System.out.println(pathname);
       MethodHelpers.writeCSVLine(operatingPath,pathname+"\r\n",true);
    }
}



@Test

public static void testCommand() throws IOException
{
	//makeCommand();
	//String directory = "\\\\mgsops\\data\\mgs_server\\Testing_Dropoff\\Environments\\2020\\[004]2020-09(Jan) - Core_EI_RegistrationStreamBaseline_Patch\\DBPatch\\Casino";
	String preinstall = "Core_EI_PendingDepositLimitsStreamV2_Patch";
	findDir();
	//searchProc(directory,"Core_EI_RegistrationStreamBaseline");
	
}

static void findDir() throws IOException
{	//\\dersvrbuild1\Patches\Casino\2019\Core_EI_WagerStreamBaseline_Patch
	int [] year = {2020, 2019, 2018,2017,2016,2015};
    //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    String depend ="ayikho";
    String direct ="aykho";
    //System.out.println("Enter name of file");
    String userIn = "Core_EI_PendingDepositLimitsStreamV2_Patch";
	for (int i =0; i <6;i++)
	{		String fileN = MethodHelpers.fileName+year[i]+"\\";
			findAll(fileN);
			depend =MethodHelpers.findList(operatingPath,userIn);
			if(depend.contains(userIn))
				{ direct =fileN+depend;
				 System.out.println(direct);
				 break;
				};
	
	}

    //System.out.println("Enter destination");
    String newHome = pathToScripts +depend;
	File file = new File(newHome);
	file.mkdir();
    copyFile(direct,newHome);
}
}
