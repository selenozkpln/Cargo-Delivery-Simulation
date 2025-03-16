//-----------------------------------------------------
// Title: Vehicle class
// Author: Selen Özkaplan
// Description: This class represents a vehicle in the logistics system. Each vehicle has a unique ID,
// a defined capacity, and a stack of cargo packages it can hold. The class provides methods for loading
// and unloading cargo packages onto the vehicle.
//-----------------------------------------------------
public class Vehicle extends CargoPackages {

    Stack<CargoPackages> packages = new Stack<>();
    double capacity;

    Vehicle(String ID, double capacity)
    //--------------------------------------------------------
    // Summary: Constructs a new Vehicle object with the specified ID and capacity.
    // Precondition: ID is a non-null, non-empty string; capacity is a positive number.
    // Postcondition: A Vehicle instance is created with the specified ID and capacity.
    //--------------------------------------------------------
    {
        super(ID);
        this.capacity = capacity;
    }

}
