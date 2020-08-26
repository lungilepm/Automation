package TestHelp;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.testng.annotations.Test;

import static TestHelp.MethodHelpers.*;

public class SplitPayload {


	@Test
  public static void getSplitLog() throws IOException, SQLException {
		String line;
		String SQ = "@#";
		String SQname = "SQname";
		String newFileLocation;
		BufferedReader[] inputFile;
		inputFile = new BufferedReader[]{getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + ".log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-1.log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-2.log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-3.log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-4.log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-5.log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-6.log"),
				getinputFile(MethodHelpers.pathSi2 + "\\MGSEI.CEPEngine-" + MethodHelpers.getDate() + "-7.log"),

		};
		for (int i = 0; i < 4; i++) {
			while ((line = inputFile[i].readLine()) != null) {
				newFileLocation = makeDirectory("C:\\Users\\lungilemo\\Documents\\logs\\" + time);
				/******************* **********************************************
				 * Saves the stream onto a text file so that we can see it properly
				 * ****************************************************************/
				if (line.contains("StreamName:")) {
					writeCSVLine(newFileLocation + "\\ Sequence.txt", cleanName(line, 2) + ",\r\n", true);
					saveStream(line, newFileLocation);
				}


				if (line.contains("About to serialise msg. QueryID")) {
					SQ = "";
					SQ = SQ + line;
					SQname = cleanName(line, 1);
				}

				if (!SQ.equals("@#")) {
					SQ = SQ + line;
				}


				if (line.contains("Successfully serialised msg")) {
					writeCSVLine(newFileLocation + "\\ Sequence.txt", SQname + ",\r\n", true);
					writeToFile(newFileLocation, SQname, SQ);
					SQ = "@#";
				}

			}
		}
	}
	}

