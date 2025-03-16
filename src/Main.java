//-----------------------------------------------------
// Title: Main class
// Author: Selen Özkaplan
// Description: This class serves as the entry point for the logistics system simulation. It initializes
// the mission, loads data, reads mission details, and writes results to a file.
//-----------------------------------------------------
import java.io.IOException;

    public class Main
            //--------------------------------------------------------
            // Summary: The main method where the simulation starts. It initializes the Mission,
            // loads data from mission file, processes the mission data, and writes the results to result file.
            // Precondition: None.
            // Postcondition: The mission data is loaded, processed, and the results are written to "result.txt".
            //--------------------------------------------------------
{
    public static void main(String[] args) throws IOException {

    Mission MissionCase = new Mission();
    MissionCase.initializeData();
    MissionCase.readMission();
    MissionCase.writeResultsToFile("src/result.txt");



    }
}

