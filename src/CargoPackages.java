//-----------------------------------------------------
// Title: CargoPackages class
// Author: Selen Özkaplan
// Description: This class represents a cargo package with a unique ID,
// which can be used for identifying and managing packages
//-----------------------------------------------------


public class CargoPackages {

    private String ID;


    public CargoPackages(String id)
    //--------------------------------------------------------
    // Summary: Constructs a new CargoPackages object with the specified ID.
    // Precondition: id is a non-null, non-empty string.
    // Postcondition: A CargoPackages instance is created with the specified ID.
    //--------------------------------------------------------
    {
        this.ID = id;
    }


    public String getID()
    //--------------------------------------------------------
    // Summary: Retrieves the ID of the cargo package.
    // Precondition: None.
    // Postcondition: Returns the ID of this cargo package.
    //--------------------------------------------------------
    {
        return ID;
    }


    public void setID(String id)
    //--------------------------------------------------------
    // Summary: Sets the ID of the cargo package to the specified value.
    // Precondition: id is a non-null, non-empty string.
    // Postcondition: The ID of this cargo package is updated.
    //--------------------------------------------------------
    {
        this.ID = id;
    }
}
