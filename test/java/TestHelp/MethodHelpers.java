package TestHelp;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class MethodHelpers {
	public static String pathToScripts ="\\\\mgsops\\data\\Public\\EventInsight\\Lungile\\Test Scripts\\";
	public static String passing =pathToScripts+"connectionString.txt";
	public static String path ="\\\\mgsops\\data\\Public\\EventInsight\\Lungile\\Logs\\";
	public static String pathSi1 ="\\\\eventinsight1\\c$\\MGSLog\\";
	public static String pathSi2 ="\\\\eventinsight2\\c$\\MGSLog\\";
	public static String conEventinsight;
	public static String fileName = "\\\\mgsops\\data\\mgs_server\\Testing_Dropoff\\Environments\\";
	public final static String time = timestamping();
	public static String fileNameLog =MethodHelpers.path+timestamping()+"\\";


	//Derivco API string
	public static String securityV2 = "http://webserver4/system/security/v2/";
	static {
		try {
			conEventinsight = getString(passing,"gamingdb7");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  String userGroup;
	static {
		try {
			userGroup = getString(passing,"userid");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  String conCasino;
	static {
		try {
			conCasino = getString(passing,"casino");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getString(String fileName, String searchTerm) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line =null;
		while ((line=in.readLine()) != null)
		{
			if (line.contains(searchTerm))
			{
				//System.out.println("Name_______________::::::"+line);
				return line;
			}
				else {continue;}

		}

		return "NotAvailable";
	}
	public static String findList(String path, String searchName) throws IOException {	String line;
		BufferedReader in = new BufferedReader(new FileReader(path));
		while ((line=in.readLine()) != null)
		{
			if (line.contains(searchName))
			{	
				 return line;
			}
		}
		return "ayikho";
	}
	public static String dbCon(String insertSql, int column, String connectionUrl) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
		}


		ResultSet resultSet = null;

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException throwables) {
			System.out.println("Could not find the connectionURL provided");
		}
		// PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS );
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException throwables) {
			System.out.println("Could not create a statement");
		}
		try {
			resultSet = statement.executeQuery(insertSql);
		} catch (SQLException throwables) {
			System.out.println("Could execute the query");
		}
		// prepsInsertProduct.execute();
		// Retrieve the generated key from the insert.
		// resultSet = prepsInsertProduct.getGeneratedKeys();
		String name =null;
		// Print the ID of the inserted row.
		while (true) {
			try {
				if (!resultSet.next()) break;
			} catch (SQLException throwables) {
				System.out.println("There is no result set");
			}
			try {
				name = resultSet.getString(column);
			} catch (SQLException throwables) {
				System.out.println("Could not return with the column");
			}

		}

		return name;
	}
	@Test(priority =1)
	public static void testCon () throws SQLException {
		String it =dbCon("SELECT * FROM [EventInsight].[dbo].[tb_StandingQuery]",
				 6,
				conEventinsight);
		System.out.println("In the test_______________::::::"+it);

	}
	public static boolean finder( String dirName, String filed) {
	  		File file;
	  		String fileContext =null;
	    	file = new File(dirName+filed)
	    			;
	    	if(!new File(dirName, filed).exists())
	    	{
	    		return false;
	    	}
	  	  
	    	else {
	  	       
	  	    	  
	  			try {
	  	   			fileContext = FileUtils.readFileToString(file,"UTF-8");
	  	   			
	  	   		} catch (IOException e) {
	  	   			
	  	   			e.printStackTrace();
	  	   		}	
	  	   		
	  	       	if( fileContext.contains("}"))
	  	       	{
	  	       		return true;
	  	       	}
	  	       	else { return false;}
	  	   		
	  	       }
	    	
	    	}
	    	public static void writeCSVLine(String fileDir, String result,Boolean bool) {


	          FileWriter file = null;


	          try {
	              file = new FileWriter(fileDir, bool);
	          } catch (IOException e) {
	              System.out.println("Could not create file with directory name" + fileDir + ".txt ;");
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	          }

	          try {
	              file.write(result);
	          } catch (IOException e1) {
	              // TODO Auto-generated catch block
	              e1.printStackTrace();
	          }


	          try {
	              file.close();
	          } catch (IOException e) {
	              // TODO Auto-generated catch block
	              System.out.println("Could not close the file " + fileDir + " ;");
	              e.printStackTrace();
	          }


	      }
	public static void exel(){
	    try{
	    	InputStream inp = new FileInputStream("C:\\Users\\lungilemo\\eclipse-workspace\\createData\\src\\main\\resources\\yiyo.xlsx");
	        //InputStream inp = new FileInputStream("workbook.xlsx");

	        Workbook wb = WorkbookFactory.create(inp);
	        Sheet sheet = wb.getSheetAt(0);
	        Row row = sheet.getRow(2);
	        Cell cell = row.getCell(2);
	        if (cell == null)
	            cell = row.createCell(3);

	        cell.setCellValue("a test");

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\lungilemo\\eclipse-workspace\\createData\\src\\main\\resources\\yiyo.xlsx");
	        wb.write(fileOut);
	        fileOut.close();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	      System.out.println("Sorry no file");
	    }
	}       	
	public static void makeJason() {
		      JSONObject obj = new JSONObject();

		      obj.put("name", "foo");
		      obj.put("num", new Integer(100));
		      obj.put("balance", new Double(1000.21));
		      obj.put("is_vip", new Boolean(true));

		      System.out.print(obj);
		   }
	public static String getGuid( )//copied
	{
		UUID uuid = UUID.randomUUID();
		String guid = uuid.toString();
		return guid;
	}
	public static boolean deleteFile(String path)
	{
		File directory = new File(path);
		directory.renameTo(new File("C:\\Users\\lungilemo\\Documents\\logs\\CEP"+time+".log"));
		try {
			FileUtils.forceDelete(directory);
			System.out.println("force delete file in java");
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String getExtract(Response resp, String identifier )
	{
		String response = resp.asString();
		JsonPath js = new JsonPath(response);
		response = js.get(identifier)+"";
	//	System.out.println(response);
		return response+"";
	}
	public static String getDate()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String formattedDate = formatter.format(LocalDate.now());
		return formattedDate;
	}
	public static String getOperatorToken ()
	{
		RestAssured.baseURI="http://webserver4/system/operatorsecurity/v1/operatortokens";
		
		Response resp = given ().	header("Content-Type", "application/json").
									body("{\r\n  \"apiKey\": \"e21ff5d7-893a-4198-a8c7-2e836aaedea4\"\r\n}").
						  when().	post().
						  then().	
					   extract().	response();
		
		
		System.out.println(resp.prettyPeek());

	return	getExtract(resp, "AccessToken");
						  			
	}	
	
	public static String getServiceToken ()
	{
		RestAssured.baseURI="http://webserver4/system/security/v2/servicetokens";
		
		Response resp = given ().	header("Content-Type", "application/json").
									body("{"
											+ "\"apiKey\": \"00d3041f-96de-4d9e-995d-0a3e7e53a743\","
											+ "\"ipAddress\": \"127.0.0.1\""
											+ "}").
						  when().	post().
						  then().	
					   extract().	response();
		
		
		System.out.println(resp.prettyPeek());

	return	getExtract(resp, "AccessToken");
						  			
	}
	
	//@Test(priority =2)
	public static void getLogin ()
	
	{
		String token = getOperatorToken();
		String token2 = getServiceToken();
		
		System.out.println("operator "+token);
		System.out.println("Service "+token2);
						  			
	}
	public static BufferedReader getinputFile(String path)
	{		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.println("The log file is not present or the server eventinsight is not working");
			e.printStackTrace();
		}

		return in;
	}
	public static String timestamping ( )
	{
		String timestamp  =new Timestamp(System.currentTimeMillis())+"";
		timestamp =timestamp.replace('-','.')
				.replace(':','.')
				.replace(' ','.');
		return timestamp+"";
	}
	public static String cleanName (String line, int type ) throws SQLException { 	String sql;
		if (type==1) {
			String temp = line.substring(line.indexOf("QueryID:")-1 + 10, line.indexOf(","));
			System.out.println("This is the name of the SQ: " +temp);
			sql = "SELECT * FROM [EventInsight].[dbo].[tb_StandingQuery] where QueryID ='"+temp+"'";
			String url =MethodHelpers.conEventinsight;
			System.out.println("This is the name of the url: " + url);
			String fname =  MethodHelpers.dbCon(sql,2,url);

			return fname;
		}

		if (type==2) {

			String temp=line.substring( line.indexOf("StreamName: ")+12, line.indexOf("StreamName: ")+70);
			String name = temp.substring(0, temp.indexOf(","));
			//System.out.println("This is the my heart: " + name);
			return name;
		}
		return null;
	}
	public static void writeToFile(String direct, String fileName, String line)
	{
		line = line.replaceAll(",", ",\r\n")+"\r\n\t";
		writeCSVLine (direct+"\\"+timestamping()+" "+fileName+".txt", line,true);
	}
	public static void saveStream (String line, String pathtoFile ) throws SQLException {
		String Name =cleanName (line,2);
		System.out.println("The path ___________________"+pathtoFile);

		writeToFile(pathtoFile,Name,line);

		return;
	}
	public static String makeDirectory(String pathToFile)
	{
		File file = new File(pathToFile);
		//  System.out.println("This is the time " + timestamping());

		if (!file.exists())
		{
			file.mkdir();
			System.out.println("The log file is not prese "+file.getAbsolutePath());
			return file.getAbsolutePath() ;
		}
		return file.getAbsolutePath();
	}

}
