package TestHelp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;


public class getSchema {
	
	public static String[] getLine(String searTerm, String path) throws IOException
	{

	 //System.out.println(searTerm);
	      CSVReader reader = new CSVReader(new FileReader(path), ',' , '"' , 1);
	       
	      //Read CSV line by line and use the string array as you want
	      String[] nextLine;
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (nextLine[0].toLowerCase().contains(searTerm.toLowerCase())) {
	            //Verifying the read data here
	        	 //System.out.println(Arrays.toString(nextLine)+nextLine.length+"");
	        	return nextLine;
	           
	         }
	       }

	      String[] temp = {searTerm};
	      return temp;
	}
	

	
/**	public static String getDescription(String line, String path) throws IOException
	{	BufferedReader in = new BufferedReader(new FileReader(path));
	
		while ((line=in.readLine()) != null)
		{			
			if (line.contains("robbggf"))
				{	
					return line;

				}
		}
		
		return "%none%";
	}	**/
	
	
	
	@Test
	public static void getScheme() throws SQLException, IOException
	{   String[] lineArr;
		
		String res =Connex.dbCon("select * from tb_CepStream where name like '%GameAchievement%'",3,MethodHelpers.conEventinsight);
		MethodHelpers.writeCSVLine (MethodHelpers.path+"\\scheme.csv", ",,Property,Description,CEP Data Type,DB Data Type,Rules/Exceptions/Constraints\r\n",false);
		MethodHelpers.writeCSVLine (MethodHelpers.path+"\\schemeFinal.csv", ",,Property,Description,CEP Data Type,DB Data Type,Rules/Exceptions/Constraints\r\n",false);
		String line =null;
		String[] col =null;
		
		//String [] col = new String [14];
	if (res.contains("("))
			
		{	
			String temp=res.substring( res.indexOf("(")+1, res.indexOf(","));
			String original =res.substring(0,res.indexOf(","));
			res=res.replace(original, " "+temp);
			res=res.replaceAll(",", "'");
			
			res=res.replaceAll(" ", ",,");
			res=res.replace(")", "");
			
			res=res.trim();
			MethodHelpers.writeCSVLine (MethodHelpers.path+"\\scheme.csv", res.replaceAll("'", "\r\n")+"\r\n\t".trim(),true);
			////System.out.println(res);
		}
	BufferedReader in = new BufferedReader(new FileReader("D:\\\\Logs\\\\scheme.csv"));
	/*				col=line.split(",");
					temp = col[12];
					////System.out.println(temp);
					return temp;
					*/
	while ((line=in.readLine()) != null)
	{			
				//This reads the schema present and take the search term
				col=line.split(",");
				String parameter = col[2];
				parameter =parameter.trim();
				
				
				if (parameter.equals("Property"))
				{ //|| parameter.equals("%none%")
					continue;
				}

				lineArr=getLine(parameter,"D:\\\\Logs\\\\dictionary.csv");
				System.out.println(Arrays.toString(lineArr)+lineArr.length);
				//lineArr;term
				//lineArr[1];DB Data
				//lineArr[12];Description
				if(lineArr.length<12)
				{
					
						MethodHelpers.writeCSVLine (MethodHelpers.path+"\\schemeFinal.csv", ",,"+lineArr[0]+",,,,\r\n",true);
					    MethodHelpers.writeCSVLine (MethodHelpers.path+"\\dictionary.csv", lineArr[0]+"�,,"+col[4]+",,,,,,,,,,\r\n",true);
					}
				else
				{
					MethodHelpers.writeCSVLine (MethodHelpers.path+"\\schemeFinal.csv", ",,"+lineArr[0]+","+lineArr[12]+","+lineArr[2]+","+lineArr[1]+",\r\n",true);
					}

			}
	
			

		
		
		
	}

}
