package hospitalManagementSystem;

public class Patient extends Person implements Schedulable{
    private String symptoms;
    private int medicalRecordNumber;

    public Patient(String name, int age,String id, String symptoms, int medicalRecordNumber){
        super(name, age, id);
        this.symptoms = symptoms;
        this.medicalRecordNumber = medicalRecordNumber;

    }
    public void scheduleAppointment(String dateTime, Person otherParty ,String reason){
        if (!(otherParty instanceof Doctor)){
            throw new IllegalArgumentException ("Patients can only schedule appointments with Doctors.");
        }
        else {
            System.out.println("Patient " + this.getName() + " has scheduled an appointment with Doctor "
                    + otherParty.getName()  + " at " + dateTime + ".");
        }
    }

    public String getRole(){
        return "Patient";
    }

    public int getMedicalRecordNumber(){
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(int medicalRecordNumber){
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
