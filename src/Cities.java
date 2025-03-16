//-----------------------------------------------------
// Title: Cities class
// Author: Selen Özkaplan
// Description: This class represents a city in the logistics system, containing a list of cargo packages
// and a queue of vehicles that are associated with the city. It also allows for adding packages to the city.
//-----------------------------------------------------
public class Cities {

    String name;
    Stack<CargoPackages> packages = new Stack<>();
    Queue<Vehicle> vehicles = new Queue<>();

    public Cities(String name)
    //--------------------------------------------------------
    // Summary: Constructs a new Cities object with the specified name.
    // Precondition: name is a non-null, non-empty string.
    // Postcondition: A Cities instance is created with the specified name.
    //--------------------------------------------------------
    {
        this.name = name;
    }

    public void addPackage(CargoPackages packageNo)
    //--------------------------------------------------------
    // Summary: Adds a cargo package to the city's stack of packages.
    // Precondition: packageNo is a non-null CargoPackages object.
    // Postcondition: The package is added to the stack of packages in the city.
    //--------------------------------------------------------
    {
        packages.push(packageNo);
    }

}
