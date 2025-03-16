//-----------------------------------------------------
// Title: Tester class
// Author: Selen Özkaplan
// Description: This class identifies key test points of the program
//-----------------------------------------------------
import java.io.IOException;

public class Tester

{
    public static void main(String[] args) throws IOException
    //--------------------------------------------------------
    // Summary: Tests the main method where the simulation starts.
    // Precondition: None.
    // Postcondition: The mission data is loaded, processed, and the results
    // are written to "result.txt" in the tester file.
    //--------------------------------------------------------
    {
        MissionTester MissionTest = new MissionTester();
        MissionTest.initializeDataTester();
        MissionTest.readMissionTester();
        MissionTest.writeResultsToFile("src/Tester/result.txt");



    }
}

