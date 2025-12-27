package ceng201.hw.hospital;

public class TreatmentRequest {

    //Stores which patient this request belongs to
    private int patientID;
    // Time when the request is created
    private long arrivalTime;

    //Creates a new treatment request for a patient
    // ArrivalTime is set automaticlly at creation time
    public TreatmentRequest(int patientID){
        this.patientID = patientID;
        this.arrivalTime = System.currentTimeMillis();
    }

    // Return the patient id of this request
    public int getPatientID() {
        return patientID;
    }

    // Return the time when the request details in console
    public long getArrivalTime() {
        return arrivalTime;
    }

    // Useful for printing request details in console
    @Override
    public String toString() {
        return "TreatmentRequest{" +
                "patientID=" + patientID +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}


