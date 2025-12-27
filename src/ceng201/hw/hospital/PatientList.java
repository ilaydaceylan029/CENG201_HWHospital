package ceng201.hw.hospital;

// Singly linked list implementation to store Patient objects.
public class PatientList {

    // Node structure for singly linked list.
    private static class Node{
        Patient data;
        Node next;

        Node(Patient data){
            this.data = data;  // Patient stored in this node
            this.next = null;  // Reference to the next node
        }
    }

    // Head points to the first node, tail points to the last node.
    private Node head;
    private Node tail;

    // Tracks the number of patients in the list.
    private int size;

    // Initializes an empty list.
    public PatientList(){
        head = null;
        tail = null;
        size = 0;
    }

    // Adds a patient to the end of the list. Time: O(1)
    public void addPatient(Patient p){
        Node newNode = new Node((p));

        if(head == null){      // empty list case
            head = newNode;
            tail = newNode;
        }else {                 // general case: append to tail
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Finds a patient by id using linear search. Time: O(n).
    public Patient findPatient(int id){
        Node current = head;
        while (current != null){
            if(current.data.getId() == id){
                return current.data;  //found
            }
            current = current.next;
        }
        return null;    //not found
    }

    // Removes a patient by id. Time: O(n) due to traversal/search.
    public boolean removePatint(int id){
        if(head == null){
            return false;  //nothing to remove
        }

        // Special case: removing the head node
        if (head.data.getId() == id){
            head = head.next;
            size--;

            if(head == null){    // list became empty after removal
                tail = null;
            }
            return true;
        }

        // General case: track previous and current nodes.
        Node prev = head;
        Node current = head.next;
        while ( current != null){
            if (current.data.getId() == id){
                prev.next = current.next;   //unlink current node

                if (current == tail){     // if last node removed, update tail
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;  //id not found
    }


    // Prints all patients from head to tail.
    public void printList(){
        System.out.println("--- Patient List (size=" + size +")---");
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

    }


    // Returns current number of patients in the list..
    public int size (){
        return size;
    }
}