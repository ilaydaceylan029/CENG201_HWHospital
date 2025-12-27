package ceng201.hw.hospital;

// Singly linked list that stores Patient objects
public class PatientList {

    // Simple node class for the linked list
    private static class Node {
        Patient data;
        Node next;

        Node(Patient data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head: first node, tail: last node
    private Node head;
    private Node tail;

    // Number of elements in the list
    private int size;

    // Create an empty list
    public PatientList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adds a patient to the end of the list (O(1))
    public void addPatient(Patient p) {
        Node newNode = new Node(p);

        if (head == null) { // list is empty
            head = newNode;
            tail = newNode;
        } else { // add after tail
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Searches patient by id (O(n))
    public Patient findPatient(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data; // found
            }
            current = current.next;
        }
        return null; // not found
    }

    // Removes a patient by id (O(n))
    public boolean removePatient(int id) {
        if (head == null) {
            return false; // nothing to remove
        }

        // If the first patient is the one to remove
        if (head.data.getId() == id) {
            head = head.next;
            size--;

            if (head == null) { // list became empty
                tail = null;
            }
            return true;
        }

        // Otherwise we keep previous node to skip the removed one
        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data.getId() == id) {
                prev.next = current.next; // unlink

                // If last node is removed update tail
                if (current == tail) {
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false; // id not found
    }

    // OPTIONAL: keep old typo method name so older code doesn't break
    public boolean removePatint(int id) {
        return removePatient(id);
    }

    // Prints all patients in order
    public void printList() {
        System.out.println("--- Patient List (size=" + size + ")---");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Returns how many patients are currently stored
    public int size() {
        return size;
    }
}
