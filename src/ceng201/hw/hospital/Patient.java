package ceng201.hw.hospital;
// Represents a single patient in the hospital system.
public class Patient {

    // Unique identifier for each patient.
    private int id;

    // Patient full name.
    private String name;

    // Severity level in range 1-10 (higher means more urgent).
    private int severity;

    // Patient age.
    private int age ;

    // Creates a patient object with all required fields.
    public Patient(int id, String name, int severity, int age) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.age = age;
    }

    // Getters are used to access private fields safely.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    public int getAge() {
        return age;
    }

    // Returns a readable representation for debugging / printing.
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
