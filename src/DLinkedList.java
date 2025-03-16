//-----------------------------------------------------
// Title: DLinkedList class
// Author: Selen Özkaplan
// Description: This class represents a doubly linked list
// which supports adding, removing, and checking if the list is empty.
// It enables traversal from both ends, using DNode objects as nodes.
//-----------------------------------------------------
public class DLinkedList<Type> {
    DNode<Type> head;
    int size;


    public void addLast(Type data)
    //--------------------------------------------------------
    // Summary: Adds a new node with the specified data at the end of the list.
    // Precondition: data is of type Type.
    // Postcondition: A new node containing data is added to the end of the list,
    // and the size of the list is incremented.
    //--------------------------------------------------------
    {
        DNode<Type> newDNode = new DNode<>(data);

        if(head == null){
            head = newDNode;
        }
        else{
            DNode<Type> temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newDNode);
            newDNode.setPrev(temp);
        }
        ++size;
    }

    public Type removeFirst()
    //--------------------------------------------------------
    // Summary: Removes and returns the data of the first node in the list.
    // Precondition: The list may be empty.
    // Postcondition: If the list is not empty, the head node is removed,
    // the head reference is updated, and the size of the list is decremented.
    // If the list is empty, null is returned.
    //--------------------------------------------------------
    {
        if (head == null) {
            return null;
        }
        DNode<Type> temp = head;

        if (head.getNext() == null) {
            head = null;
        }
        else {
            head = head.getNext();
            head.setPrev(null);
            temp.setNext(null);
        }
        --size;
        return temp.getData();
    }

    public Type removeLast()
    //--------------------------------------------------------
    // Summary: Removes and returns the data of the last node in the list.
    // Precondition: The list may be empty.
    // Postcondition: If the list is not empty, the last node is removed,
    // and the size of the list is decremented. If the list is empty, null is returned.
    //--------------------------------------------------------
    {
        DNode<Type> temp = head;

        if (head == null) {
            return null;
        }
        else if (head.getNext() == null) {
            head = null;
            --size;
            return temp.getData();
        }

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        DNode<Type> lastNode = temp.getNext();
        temp.setNext(null);
        lastNode.setPrev(null);
        --size;

        return lastNode.getData();
    }

    public boolean isEmpyt()
    //--------------------------------------------------------
    // Summary: Checks if the list is empty.
    // Precondition: None.
    // Postcondition: Returns true if the list is empty (head is null); otherwise, false.
    //--------------------------------------------------------
    {
        return head ==null;
    }
}