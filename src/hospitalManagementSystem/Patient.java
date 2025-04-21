package hospitalManagementSystem;

public class Patient extends Person implements Schedulable{
    private String symptoms;
    private String medicalRecordNumber;

    public Patient(String id, String name,int age, String symptoms, String medicalRecordNumber){
        super(name, age, id);
        this.symptoms = symptoms;
        this.medicalRecordNumber = medicalRecordNumber;

    }
    public Appointment scheduleAppointment(String dateTime, Person otherParty ,String reason){
        if (!(otherParty instanceof Doctor)){
            System.out.print("Error: Patients can only schedule appointments with Doctors.");
            return null;

        }
        else {
            System.out.println("Patient " + this.getName() + " has scheduled an appointment with Doctor "
                    + otherParty.getName()  + " at " + dateTime + ".");
            Appointment appointment = new Appointment (Appointment.generateAppointmentId(), this, (Doctor) otherParty, dateTime, reason);
            return appointment;
        }
    }

    public String getRole(){
        return "Patient";
    }

    public String getMedicalRecordNumber(){
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(String medicalRecordNumber){
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
