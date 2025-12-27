package ceng201.hw.hospital;

public class TestPatient {
    public static void main(String [] args){

        //Task1 test: create list and add 5b patient.
        PatientList list = new PatientList();
        list.addPatient(new Patient(120, "Barış Celik", 7,33));
        list.addPatient(new Patient(121, "Zeynep Arık", 4, 23));
        list.addPatient(new Patient(122, "Elif Sarıkoç", 8, 45));
        list.addPatient(new Patient(123, "Furkan Kaya", 9, 32));
        list.addPatient(new Patient(124, "Ceren Ozturk", 2, 28));

        // Remove patient with id 120
        System.out.println("Remove patient 120: " + list.removePatint(120));

        //Find patient with is 123
        Patient found = list.findPatient(123);
        System.out.println("Find patient 123: " + (found != null ? found : "NOT FOUND"));

        //Print final list..
        list.printList();
    }
}