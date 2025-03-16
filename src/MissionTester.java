//-----------------------------------------------------
// Title: MissionTester class
// Author: Selen Özkaplan
// Description: This class tests the logistics system's mission operations, including loading data
// from files, processing mission instructions, executing package transfers, and writing results to a file.
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MissionTester {

    String readCities = "src/Tester/cities.txt";
    String readPackages = "src/Tester/packages.txt";
    String readVehicles = "src/Tester/vehicles.txt";
    String readMissions = "src/Tester/missions.txt";

    private String source;
    private String middle;
    private String destination;
    private int loadFromSource;
    private int loadFromMiddle;
    private int[] dropOffIndices;


    DLinkedList<Cities> cityList = new DLinkedList<>();


    public MissionTester(String source, String middle, String destination, int loadFromSource, int loadFromMiddle, int[] dropOffIndices)
    //--------------------------------------------------------
    // Summary: Constructs a new Mission object with specified parameters for testing.
    // Precondition: source, middle, and destination are non-null strings, loadFromSource and loadFromMiddle are non-negative integers, dropOffIndices is a non-null array.
    // Postcondition: A Mission instance is created with specified source, middle, destination, and package parameters.
    //--------------------------------------------------------
    {
        this.source = source;
        this.middle = middle;
        this.destination = destination;
        this.loadFromSource = loadFromSource;
        this.loadFromMiddle = loadFromMiddle;
        this.dropOffIndices = dropOffIndices;
    }

    // Default constructor for loading data
    public MissionTester() {}

    public void initializeDataTester() throws IOException
    //--------------------------------------------------------
    // Summary: Loads city, package, and vehicle data from respective files for testing.
    // Precondition: Files at specified paths exist and are readable.
    // Postcondition: Data from files is loaded into memory.
    //--------------------------------------------------------
    {
        loadCityData();
        loadPackageData();
        loadVehicleData();
    }


    private Cities findCity(String name)
    //--------------------------------------------------------
    // Summary: Finds and returns a city by name in the city list.
    // Precondition: name is a non-null, non-empty string.
    // Postcondition: Returns a Cities object matching the name or null if not found.
    //--------------------------------------------------------
    {
        DNode<Cities> temp = cityList.head;
        while (temp != null) {
            if (temp.getData().name.equals(name)) {
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return null;
    }


    private void loadCityData() throws IOException
    //--------------------------------------------------------
    // Summary: Loads city data from a file and adds each city to the city list.
    // Precondition: The file at readCities exists and is readable.
    // Postcondition: Cities are added to the city list.
    //--------------------------------------------------------
    {
        try (BufferedReader readerCity = new BufferedReader(new FileReader(readCities))) {
            String line;
            while ((line = readerCity.readLine()) != null) {
                cityList.addLast(new Cities(line));
            }
        }
    }


    private void loadPackageData() throws IOException
    //--------------------------------------------------------
    // Summary: Loads package data from a file and assigns packages to the appropriate city.
    // Precondition: The file at readPackages exists and is readable.
    // Postcondition: Packages are assigned to cities.
    //--------------------------------------------------------
    {
        try (BufferedReader readerPackage = new BufferedReader(new FileReader(readPackages))) {
            String packageLine;
            while ((packageLine = readerPackage.readLine()) != null) {
                String[] packageArray = packageLine.split(" ");
                CargoPackages packages = new CargoPackages(packageArray[0]);
                Cities city = findCity(packageArray[1]);
                if (city != null) {
                    city.packages.push(packages);
                }
            }
        }
    }


    private void loadVehicleData() throws IOException
    //--------------------------------------------------------
    // Summary: Loads vehicle data from a file and assigns vehicles to the appropriate city.
    // Precondition: The file at readVehicles exists and is readable.
    // Postcondition: Vehicles are assigned to cities.
    //--------------------------------------------------------
    {
        try (BufferedReader readerVehicle = new BufferedReader(new FileReader(readVehicles))) {
            String vehicleLine;
            while ((vehicleLine = readerVehicle.readLine()) != null) {
                String[] vehicleArray = vehicleLine.split(" ");
                Vehicle vehicle = new Vehicle(vehicleArray[0], Double.parseDouble(vehicleArray[2]));
                Cities city = findCity(vehicleArray[1]);
                if (city != null) {
                    city.vehicles.enqueue(vehicle);
                }
            }
        }
    }

    int droppOfIndices;

    public void readMissionTester() throws IOException
    //--------------------------------------------------------
    // Summary: Reads mission data from mission file and executes each mission based on the details provided.
    // Precondition: The file at readMissions exists and is readable.
    // Postcondition: Each mission is processed and executed.
    //--------------------------------------------------------
    {
        try (BufferedReader readerMissions = new BufferedReader(new FileReader(readMissions))) {
            String missionLine;
            while ((missionLine = readerMissions.readLine()) != null) {
                String[] missionArray = missionLine.split("-");

                source = missionArray[0];
                middle = missionArray[1];
                destination = missionArray[2];
                loadFromSource = Integer.parseInt(missionArray[3]);
                loadFromMiddle = Integer.parseInt(missionArray[4]);



                String[] dropOffIndicesStr = missionArray[5].split(",");
                droppOfIndices = dropOffIndicesStr.length;
                dropOffIndices = new int[droppOfIndices];

                for (int i = 0; i < droppOfIndices; i++) {
                    dropOffIndices[i] = Integer.parseInt(dropOffIndicesStr[i]);
                }

                execute(source, middle, destination, loadFromSource, loadFromMiddle, dropOffIndices);
            }
        }
    }



    public void execute(String sourceCity, String middleCity, String destinationCity, int loadFromSource, int loadFromMiddle, int[] dropOffIndices)
    //--------------------------------------------------------
    // Summary: Executes a mission by transferring packages from source to destination via middle city.
    // Precondition: Cities and vehicles involved in the mission are properly initialized.
    // Postcondition: Packages are transferred according to mission parameters.
    //--------------------------------------------------------
    {
        Cities mysourceCity = findCity(sourceCity);
        Cities mymiddleCity = findCity(middleCity);
        Cities mydestinationCity = findCity(destinationCity);


        //Retrieving a vehicle from the source city
        Vehicle vehicle = mysourceCity.vehicles.dequeue();
        if (vehicle == null) {
            return;
        }

        //Loading packages from the source city onto the vehicle
        for (int i = 0; i < loadFromSource && !mysourceCity.packages.isEmpty(); i++) {
            CargoPackages cargo = mysourceCity.packages.pop();
            vehicle.packages.push(cargo);
        }

        //Using a temporary stack
        Stack<CargoPackages> dropOffStack = new Stack<>();

        for( int k = 0; k < droppOfIndices; k++){
            CargoPackages cargo = vehicle.packages.pop();
            dropOffStack.push(cargo);
        }

        // Loading packages from middle city onto the vehicle
        for(int j = 0; j< loadFromMiddle && !mymiddleCity.packages.isEmpty(); j++){
            CargoPackages midcargo = mymiddleCity.packages.pop();
            vehicle.packages.push(midcargo);
        }

        //Dropping off specific packages at the middle city as per dropOffIndices
        int currentIndex = dropOffStack.size() - 1;
        while (!dropOffStack.isEmpty()) {
            CargoPackages cargo = dropOffStack.pop();
            boolean isDropOff = false;


            for (int index : dropOffIndices) {
                if (currentIndex == index) {
                    mymiddleCity.packages.push(cargo);
                    isDropOff = true;
                    break;
                }
            }

            //Dropping off all the remaining packages in the vehicle to the destination city
            while(!vehicle.packages.isEmpty()){
                mydestinationCity.addPackage(vehicle.packages.pop());
            }

            currentIndex--;
        }

        mydestinationCity.vehicles.enqueue(vehicle);
    }


    public void writeResultsToFile(String outputPath) throws IOException
    //--------------------------------------------------------
    // Summary: Writes the final results to a specified output file.
    // Precondition: The specified output file path is valid and writable.
    // Postcondition: The results of the mission are written to the output file in a structured format.
    //--------------------------------------------------------
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            DNode<Cities> currentCityNode = cityList.head;

            while (currentCityNode != null) {
                Cities city = currentCityNode.getData();

                writer.write(city.name);
                writer.newLine();

                writer.write("Packages:");
                writer.newLine();
                if (city.packages.isEmpty()) {
                    writer.write("Null");
                } else {
                    Stack<CargoPackages> tempStack = new Stack<>();

                    while (!city.packages.isEmpty()) {
                        CargoPackages pkg = city.packages.pop();
                        tempStack.push(pkg);
                    }

                    while (!tempStack.isEmpty()) {
                        CargoPackages pkg = tempStack.pop();
                        writer.write(pkg.getID());
                        writer.newLine();
                        city.packages.push(pkg);
                    }
                }
                writer.newLine();

                writer.write("Vehicles:");
                writer.newLine();
                if (city.vehicles.isEmpty()) {
                    writer.write("Null");
                } else {
                    Queue<Vehicle> tempQueue = new Queue<>();

                    while (!city.vehicles.isEmpty()) {
                        Vehicle vehicle = city.vehicles.dequeue();
                        writer.write(vehicle.getID());
                        writer.newLine();
                        tempQueue.enqueue(vehicle);
                    }

                    while (!tempQueue.isEmpty()) {
                        city.vehicles.enqueue(tempQueue.dequeue());
                    }
                }
                writer.newLine();

                writer.write("-------------");
                writer.newLine();

                currentCityNode = currentCityNode.getNext();
            }
        }
    }
}