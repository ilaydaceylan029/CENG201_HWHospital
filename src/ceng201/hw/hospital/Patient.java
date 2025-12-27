package ceng201.hw.hospital;

public class Patient {

    // Patient ID used to identify the patient in the system
    private int id;

    // Patient full name (name + surname)
    private String name;

    // Priority level for ordering patients(1-10)
    // Higher value means the patient should be handled earlier
    private int severity;

    // Patient age.
    private int age ;

    // Creates a new patient with basic information
    public Patient(int id, String name, int severity, int age) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.age = age;
    }

    // Return patient id
    public int getId() {
        return id;
    }
    // Return patient name
    public String getName() {
        return name;
    }
    // Return severity value
    public int getSeverity() {
        return severity;
    }
    //Return patient age
    public int getAge() {
        return age;
    }

    // Used when printing patient info (debug output)
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", severity=" + severity +
                ", age=" + age +
                '}';
    }
}