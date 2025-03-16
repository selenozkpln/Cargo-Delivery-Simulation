//-----------------------------------------------------
// Title: DNode class
// Author: Selen Özkaplan
// Description: This class provides a structure for each element
// in a doubly linked list, enabling traversal in both directions
// by maintaining references to the next and previous nodes.
//-----------------------------------------------------

public class DNode<Type> {

    private Type data;
    private DNode<Type> next;
    private DNode<Type> prev;

    public DNode(Type data)
    //--------------------------------------------------------
    // Summary: Constructs a new DNode with the specified data.
    // Precondition: data is of type Type.
    // Postcondition: The node's data is set, and
    // next and prev references are initialized to null.
    //--------------------------------------------------------
     {
        this.data = data;
        next = null;
        prev = null;
    }

    public Type getData()
    //--------------------------------------------------------
    // Summary: Retrieves the data stored in the node.
    // Precondition: None.
    // Postcondition: Returns the data of the node.
    //--------------------------------------------------------
    {
        return data;
    }

    public void setData(Type data)
    //--------------------------------------------------------
    // Summary: Sets the data for this node to the specified value.
    // Precondition: data is of type Type.
    // Postcondition: The data of the node is updated to the new value.
    //--------------------------------------------------------
    {
        this.data = data;
    }

    public DNode<Type> getNext()
    //--------------------------------------------------------
    // Summary: Retrieves the reference to the next node in the list.
    // Precondition: None.
    // Postcondition: Returns the next node.
    //--------------------------------------------------------
    {
        return next;
    }

    public void setNext(DNode<Type> next)
    //--------------------------------------------------------
    // Summary: Sets the reference to the next node in the list.
    // Precondition: next is a DNode<Type> instance or null.
    // Postcondition: The next reference of this node is updated to the new node.
    //--------------------------------------------------------
    {
        this.next = next;
    }

    public DNode<Type> getPrev()
    //--------------------------------------------------------
    // Summary: Retrieves the reference to the previous node in the list.
    // Precondition: None.
    // Postcondition: Returns the previous node.
    //--------------------------------------------------------
    {
        return prev;
    }

    public void setPrev(DNode<Type> prev)
    //--------------------------------------------------------
    // Summary: Sets the reference to the previous node in the list.
    // Precondition: prev is a DNode<Type> instance or null.
    // Postcondition: The previous reference of this node is updated to the new node.
    //--------------------------------------------------------
    {
        this.prev = prev;
    }
}
