package hospitalManagementSystem;

public class Appointment {
    private String AppointmentId;
    private Patient patient;
    private Doctor doctor;
    private String dateTime;
    private String reason;
    private static int apptCounter = 0;

    public Appointment(String AppointmentId, Patient patient, Doctor doctor, String dateTime, String reason ){
        this.AppointmentId = AppointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    public static String generateAppointmentId(){
        apptCounter++;
        return "APT-" + apptCounter;
    }
    public String getReason() {
        return reason;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getAppointmentId() {
        return AppointmentId;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setAppointmentId(String appointmentId) {
        AppointmentId = appointmentId;
    }

    public String toString(){
        return "Appointment{" +
                "ID='" + AppointmentId + '\'' +
                ", Patient=" + patient.getName() + // Uses patient's name
                ", Doctor=" + doctor.getName() +   // Uses doctor's name
                ", DateTime='" + dateTime + '\'' +
                ", Reason='" + reason + '\'' +
                '}';
    }

}
