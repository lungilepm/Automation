package TestHelp;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MakeCEPConfigDebugMode {

	public static boolean deliverEdit(String fileName, String path, String search, String replacement)

	{	
		File file;
		String fileContext =null;
    	file = new File(path+fileName.replace(".config", "").replace('.', '_')+"\\"+fileName);
    	//System.out.println("\\\\eventinsight1\\c$\\MGS_Server\\"+event1[x].replace(".config", "").replace('.', '_')+"\\"+event1[x]);
    	try {
			fileContext = FileUtils.readFileToString(file,"UTF-8");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		
    	fileContext = fileContext.replaceAll(search,replacement );
    	try {
    		
			FileUtils.write(file, fileContext,"UTF-8");
			System.out.println(file+"\r\n EDITED___________________________________________________________________________|||||| \r\n"+fileContext+"\r\nEnd___________________________________________________________________________|||||| \r\\n");
			
			return true;
		} catch (IOException e) {
			System.out.println("NOT EDITED_____|||||| "+fileName);
			e.printStackTrace();
			return false;
		}
    	
    	
    }
	@Test
	public static void makeTrue()  {  
 
		    String [] event1 = {"MGSEI.Communicator.config","MGSEI.Collector.config","MGSEI.ClusterManager.config"}; 
		    String [] event2 = {"MGSEI.CEPEngine.config","MGSEI.HealthMonitor.config"}; 
		    File file;
		    String fileContext =null;
		    deliverEdit(event1[0], "\\\\"+"eventinsight1"+"\\c$\\MGS_Server\\","DebugMode=\"false\"","DebugMode=\"true\"");
		    deliverEdit(event1[1], "\\\\"+"eventinsight1"+"\\c$\\MGS_Server\\","DebugMode=\"false\"","DebugMode=\"true\"");
		    deliverEdit(event1[2], "\\\\"+"eventinsight1"+"\\c$\\MGS_Server\\","DebugMode=\"false\"","DebugMode=\"true\"");
		    deliverEdit(event2[0], "\\\\"+"eventinsight2"+"\\c$\\MGS_Server\\","DebugMode=\"false\"","DebugMode=\"true\"");
		    deliverEdit(event2[1], "\\\\"+"eventinsight2"+"\\c$\\MGS_Server\\","DebugMode=\"false\"","DebugMode=\"true\"");

		 }

}
