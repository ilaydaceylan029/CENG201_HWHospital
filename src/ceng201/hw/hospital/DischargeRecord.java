package ceng201.hw.hospital;

public class DischargeRecord {

    //Which aptient is discharged
    private int patientId;
    // Time when the discharge record is created
    private long dischargeTime;

    //Creates a discharge record for a patient
    // discharge is set automatically
    public DischargeRecord(int patientId){
        this.patientId = patientId;
        this.dischargeTime = System.currentTimeMillis();
    }

    // Returns patient is
    public int getPatientId(){
        return patientId;
    }

    // Returns discharge time
    public long getDischargeTime(){
        return dischargeTime;
    }

    //For printing
    @Override
    public String toString() {
        return "DischargeRecord{" +
                "patientId=" + patientId +
                ", dischargeTime=" + dischargeTime +
                '}';
    }
}



























