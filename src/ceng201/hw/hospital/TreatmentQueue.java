package ceng201.hw.hospital;

// Simple queue implemnt for TreatmentRequest(FIFO)
public class TreatmentQueue {

    //Node for the queue (like linked list)
    private static class Node{
        TreatmentRequest data;
        Node next;


        Node(TreatmentRequest data){
            this.data = data;
            this.next = null;
        }
    }

    // head = first elemnt to be removed tail = last elemnt to be added
    private Node head;
    private  Node tail;

    //keeps track of how many request are in the queue
    private int size;

    // creates an empty queue
    public TreatmentQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    // Adds a request to the end of the queue(FIFO)
    public  void enqueue(TreatmentRequest request){
        Node newNode = new Node(request);

        if (tail == null){   //Empty queue case
            head = newNode;
            tail = newNode;
        }else{               // Add after tail
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }


    // Removes and returns the request at the front of the queue
    // Returns null if the queue is empty
    public TreatmentRequest dequeue(){
        if (head == null){
            return null;     // nothing to remove
        }

        TreatmentRequest removed = head.data;
        head = head.next;
        size--;

        // if queue becomes empty tail shoul also be null
        if(head == null){
            tail = null;
        }

        return removed;
    }

    // Returns current queue size
    public int size(){
        return size;
    }

    // Prints queue from head to tail
    public void printQueue(){
        System.out.println("___ Treatment Queue (size = " + size +")____");

        Node current = head;
        while (current != null){
            // printing in a simply way instead of calling toString()
            System.out.println("TreatmentRequest{patientID =" +current.data.getPatientID() + " arrivalTime = " + current.data.getArrivalTime() + " }");
            current = current.next;
        }
    }
}




















