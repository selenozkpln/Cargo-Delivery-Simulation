//-----------------------------------------------------
// Title: Stack class
// Author: Selen Özkaplan
// Description: This class represents a generic stack data structure,
// utilizing a doubly linked list as its underlying storage. It allows
// pushing elements onto the top, popping elements from the top, and
// checking if the stack is empty.
//-----------------------------------------------------
public class Stack<Type> {

    private DLinkedList<Type> list = new DLinkedList<>();

    public void push(Type item)
    //--------------------------------------------------------
    // Summary: Adds an item to the top of the stack.
    // Precondition: item is of type Type.
    // Postcondition: The item is added to the top of the stack.
    //--------------------------------------------------------
    {
        list.addLast(item);
    }

    public Type pop()
    //--------------------------------------------------------
    // Summary: Removes and returns the item from the top of the stack.
    // Precondition: The stack is not empty (if empty, returns null).
    // Postcondition: The top item is removed from the stack, and its data is returned.
    //--------------------------------------------------------
    {
        return list.removeLast();
    }

    public boolean isEmpty()
    //--------------------------------------------------------
    // Summary: Checks if the stack is empty.
    // Precondition: None.
    // Postcondition: Returns true if the stack is empty, otherwise false.
    //--------------------------------------------------------
    {
        return list.isEmpyt();
    }

}
