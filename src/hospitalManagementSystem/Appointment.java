package hospitalManagementSystem;

public class Appointment {
    private String AppointmentId;
    private Patient patient;
    private Doctor doctor;
    private String dateTime;
    private String reason;

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
        String informations = "Appointment{" +
                "ID='" + this.getAppointmentId() + '\'' +
                ", Patient=" + patient.getName() +
                ", Doctor=" + doctor.getName() +
                ", DateTime='" + this.getDateTime() + '\'' +
                ", Reason='" + this.getReason() + '\'' +
                '}';
        System.out.println(informations);
        return informations;
    }
}
