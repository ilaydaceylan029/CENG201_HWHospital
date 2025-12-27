package ceng201.hw.hospital;

public class TestHospitalSystem {

    public static void main(String[] args) {

        // Create the system (it starts with empty lists/queues/stack)
        HospitalSystem system = new HospitalSystem();

        // 1) Register some patients into the system
        // (id, name, severity, age)
        system.registerPatient(new Patient(201, "A", 5, 20));
        system.registerPatient(new Patient(202, "B", 2, 30));
        system.registerPatient(new Patient(203, "C", 9, 40));
        system.registerPatient(new Patient(204, "D", 1, 22));
        system.registerPatient(new Patient(205, "E", 7, 55));
        system.registerPatient(new Patient(206, "F", 3, 18));
        system.registerPatient(new Patient(207, "G", 8, 60));
        system.registerPatient(new Patient(208, "H", 4, 27));
        system.registerPatient(new Patient(209, "I", 6, 35));
        system.registerPatient(new Patient(210, "J", 10, 45));

        // 2) Add some treatment requests
        // First normal requests
        system.requestTreatment(201, false);
        system.requestTreatment(202, false);
        system.requestTreatment(203, false);
        system.requestTreatment(204, false);
        system.requestTreatment(205, false);

        // Then emergency requests (these should be processed first)
        system.requestTreatment(206, true);
        system.requestTreatment(207, true);
        system.requestTreatment(208, true);

        // 3) Manually add discharge records (just to test the stack/history)
        system.addDischargeRecord(209);
        system.addDischargeRecord(210);

        // 4) Process a few treatment requests
        // Emergency queue has priority in processNextTreatment()
        System.out.println("\n--- Processing 4 treatments ---");
        system.processNextTreatment();
        system.processNextTreatment();
        system.processNextTreatment();
        system.processNextTreatment();

        // Optional: print patients sorted by severity
        System.out.println("\n--- Sorted Patients By Severity ---");
        system.sortPatientsBySeverity();

        // 5) Print final status of all structures
        System.out.println("\n--- Final System State ---");
        system.displayStatus();
    }
}
