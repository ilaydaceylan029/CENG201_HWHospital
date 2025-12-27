package ceng201.hw.hospital;


public class TestTreatmentQueue {
    public static void main(String[] args){

        // Create a queue and add some sample treatment requests
        TreatmentQueue queue = new TreatmentQueue();

        queue.enqueue(new TreatmentRequest(222));
        queue.enqueue(new TreatmentRequest(223));
        queue.enqueue(new TreatmentRequest(224));
        queue.enqueue(new TreatmentRequest(225));
        queue.enqueue(new TreatmentRequest(226));
        queue.enqueue(new TreatmentRequest(227));
        queue.enqueue(new TreatmentRequest(228));
        queue.enqueue(new TreatmentRequest(229));

        // Print the queue before removing anything
        queue.printQueue();

        // Dequeue a few requests and print their patient IDs
        TreatmentRequest r1 = queue.dequeue();
        System.out.println("Dequeue request 1: " + (r1 != null ? r1.getPatientID() : "NULL.."));
        TreatmentRequest r2 = queue.dequeue();
        System.out.println("Dequeue request 2: " + (r2 != null ? r2.getPatientID() : "NULL.." ));
        TreatmentRequest r3 = queue.dequeue();
        System.out.println("Dequeue request 3: " + (r3 != null ? r3.getPatientID() : "NULL.."));

        // Print the queue after removals
        queue.printQueue();
    }
}
