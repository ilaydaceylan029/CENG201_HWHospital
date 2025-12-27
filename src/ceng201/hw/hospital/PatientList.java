package ceng201.hw.hospital;

// Singly linked list that stores patient object
public class PatientList {

    // Simple node class for the linked list
    private static class Node{
        Patient data;
        Node next;

        Node(Patient data){
            this.data = data;  // Patient keep in this node
            this.next = null;  // next node
        }
    }

    // Head: first node, tail: last node
    private Node head;
    private Node tail;

    // Number of elements in the list
    private int size;

    // Create an empty list
    public PatientList(){
        head = null;
        tail = null;
        size = 0;
    }

    // Adds a patient to the end of the list
    // If tail is known append is o(1)
    public void addPatient(Patient p){
        Node newNode = new Node((p));

        if(head == null){      // list is empty
            head = newNode;
            tail = newNode;
        }else {                 // add after tail
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Searches patient by id
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

    // Removes a patient by id
    //We need to traverse so worst case is O(n)
    public boolean removePatint(int id){
        if(head == null){
            return false;  //nothing to remove
        }

        // If the first patient is the one we remove
        if (head.data.getId() == id){
            head = head.next;
            size--;

            // If the first patient is the one we remove
            if(head == null){    // list became empty after removal
                tail = null;
            }
            return true;
        }

        // Otherwise we keep previous node to skip the removed one
        Node prev = head;
        Node current = head.next;
        while ( current != null){
            if (current.data.getId() == id){
                prev.next = current.next;   //unlink

                // If last node is removed update tail
                if (current == tail){
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;  //id not the list
    }


    // Prints all patients in order
    public void printList(){
        System.out.println("--- Patient List (size=" + size +")---");
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

    }


    // Returns how many patients are currently stored
    public int size (){
        return size;
    }
}