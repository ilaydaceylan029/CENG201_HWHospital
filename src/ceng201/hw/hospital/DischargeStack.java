package ceng201.hw.hospital;

//Simple stack (LIFO) structure to store DischargeRecord objects
public class DischargeStack {

    //Node for linked list based stack
    private static class Node{
        DischargeRecord data;
        Node next;

        Node(DischargeRecord data){
            this.data = data;
            this.next = null;
        }
    }

    //top points to the last pushed element
    private Node top;
    //keeps how many records are in the stack
    private int size;

    //creates an empty stack
    public DischargeStack(){
        top = null;
        size = 0;
    }

    // push adds a record on top of the stack
    public void push(DischargeRecord record){
        Node newNode = new Node(record);

        // new node becomes the new top
        newNode.next = top;
        top = newNode;
        size ++;

    }

    // Pop removes and returns the top record
    // Returns null if stack is empty
    public DischargeRecord pop(){
        if (top == null){
            return null;
        }

        DischargeRecord removed = top.data;
        top = top.next;   // move top down
        size --;
        return removed;
    }

    //peek returns the top record without removing it
    public DischargeRecord peek(){
        if (top == null){
            return null;
        }
        return top.data;
    }

    // returns current stack size
    public int size(){
        return size;
    }

    // Prints stack from top to bottom
    public void printStack(){
        System.out.println("------ Discharge stack (size = " + size + ")------");
        Node current = top;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}

























