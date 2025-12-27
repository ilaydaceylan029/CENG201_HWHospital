package ceng201.hw.hospital;

import java.util.HashMap;

public class HospitalSystem {

    // Stores admitted patients (linked list version)
    private PatientList patients;

    // Two separate queues for treatment requests
    private TreatmentQueue normalQueue;
    private TreatmentQueue emergencyQueue;

    // Stack for discharge history (last discharged is on top)
    private DischargeStack history;

    // Fast lookup by patient id (Task 4 asks for this)
    private HashMap<Integer, Patient> patientMap;

    public HospitalSystem() {
        // start with empty structures
        patients = new PatientList();
        normalQueue = new TreatmentQueue();
        emergencyQueue = new TreatmentQueue();
        history = new DischargeStack();
        patientMap = new HashMap<>();
    }

    // 1) Register a patient into the system
    // Adds to both list (for printing) and map (for quick search)
    public void registerPatient(Patient p) {
        if (p == null) return;

        patients.addPatient(p);
        patientMap.put(p.getId(), p);
    }

    // 2) Create a treatment request for an existing patient
    // Emergency requests go to emergencyQueue, others go to normalQueue
    public void requestTreatment(int id, boolean isEmergency) {

        // check if patient exists (map lookup)
        Patient p = patientMap.get(id);
        if (p == null) {
            System.out.println("Error: Patient ID " + id + " not in system.");
            return;
        }

        // request keeps patient id + arrival time
        TreatmentRequest req = new TreatmentRequest(id);

        // decide which queue to put it in
        if (isEmergency) {
            emergencyQueue.enqueue(req);
        } else {
            normalQueue.enqueue(req);
        }
    }

    // 3) Manually add a discharge record (without processing queue)
    public void addDischargeRecord(int id) {
        history.push(new DischargeRecord(id));
    }

    // 4) Process the next request (emergency first)
    // After treatment, patient is discharged and removed from the system
    public void processNextTreatment() {
        TreatmentRequest target = null;

        // emergency has priority
        if (emergencyQueue.size() > 0) {
            target = emergencyQueue.dequeue();
        } else if (normalQueue.size() > 0) {
            target = normalQueue.dequeue();
        }

        // nothing to process
        if (target == null) {
            System.out.println("No patients waiting.");
            return;
        }

        int pid = target.getPatientID();

        // add discharge record to history stack
        history.push(new DischargeRecord(pid));

        // remove patient from current active structures
        boolean removedFromList = patients.removePatient(pid);
        patientMap.remove(pid);

        // print a simple result message
        if (removedFromList) {
            System.out.println("Processed treatment for patient " + pid + " (discharged).");
        } else {
            System.out.println("Processed treatment for patient " + pid + " but patient was not found in list.");
        }
    }

    // 5) Prints the current status of the system
    public void displayStatus() {
        System.out.println("\n--- SYSTEM STATUS ---");

        System.out.println("\nPatients (admitted):");
        patients.printList();

        System.out.println("\nEmergency Queue (size=" + emergencyQueue.size() + "):");
        emergencyQueue.printQueue();

        System.out.println("\nNormal Queue (size=" + normalQueue.size() + "):");
        normalQueue.printQueue();

        System.out.println("\nDischarge History (stack):");
        history.printStack();

        System.out.println("----------------------\n");
    }

    // 6) Sort patients by severity (high -> low)
    // Bubble sort is used because it is easy for homework
    public void sortPatientsBySeverity() {
        int n = patientMap.size();
        if (n <= 1) {
            System.out.println("Not enough patients to sort.");
            return;
        }

        // convert map values into an array to sort
        Patient[] arr = new Patient[n];
        int i = 0;
        for (Patient p : patientMap.values()) {
            arr[i++] = p;
        }

        // bubble sort (descending severity)
        for (int a = 0; a < arr.length - 1; a++) {
            for (int b = 0; b < arr.length - 1 - a; b++) {
                if (arr[b].getSeverity() < arr[b + 1].getSeverity()) {
                    Patient tmp = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = tmp;
                }
            }
        }

        // print sorted patients
        System.out.println("\nPatients sorted by severity (desc):");
        for (Patient p : arr) {
            System.out.println(p);
        }
    }
}
