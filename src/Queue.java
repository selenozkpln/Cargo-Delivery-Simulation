//-----------------------------------------------------
// Title: Queue class
// Author: Selen Özkaplan
// Description: This class represents a generic queue data structure,
// utilizing a doubly linked list as its underlying storage. It allows
// enqueueing elements at the end, dequeuing from the front, and
// checking if the queue is empty.
//-----------------------------------------------------
public class Queue<Type>{

    private DLinkedList<Type> list = new DLinkedList<>();

    public void enqueue (Type item)
    //--------------------------------------------------------
    // Summary: Adds an item to the end of the queue.
    // Precondition: item is of type Type.
    // Postcondition: The item is added to the end of the queue.
    //--------------------------------------------------------
    {
        list.addLast(item);
    }

    public Type dequeue()
    //--------------------------------------------------------
    // Summary: Removes and returns the item at the front of the queue.
    // Precondition: The queue is not empty (if empty, returns null).
    // Postcondition: The first item is removed from the queue, and its data is returned.
    //--------------------------------------------------------
    {
        return list.removeFirst();
    }

    public boolean isEmpty()
    //--------------------------------------------------------
    // Summary: Checks if the queue is empty.
    // Precondition: None.
    // Postcondition: Returns true if the queue is empty, otherwise false.
    //--------------------------------------------------------
    {
        return list.isEmpyt();
    }
}
