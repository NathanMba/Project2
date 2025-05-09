package hospitalManagementSystem;

public class Doctor extends Person implements Schedulable{
    private String speciality;
    private String licenseNumber;
    private double consultationFee;

    public Doctor(String id,String name ,int age, String speciality, String licenseNumber, double consultationFee){
        super(name, age, id);
        this.speciality = speciality;
        this.licenseNumber = licenseNumber;
        this.consultationFee = consultationFee;

    }

    public Appointment scheduleAppointment(String dateTime, Person otherParty ,String reason){
        if (!(otherParty instanceof Patient)){

            System.out.print ("Error: Doctors can only schedule appointments with Patients.");
            return null;

        }
        else {
            System.out.println("Doctor " + this.getName() + " has scheduled an appointment with Patient "
                    + otherParty.getName() + " at " + dateTime + ".");
            Appointment appointment = new Appointment(Appointment.generateAppointmentId(), (Patient) otherParty, this, dateTime, reason );
            return appointment;
        }
    }

    public String getRole(){
        return "Doctor";
    }

    public void diagnose(Patient patient){
        String information = "Dr. " + this.getName() + " is diagnosing patient " + patient.getName() + ".";
        System.out.println(information);
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getSpecialty() {
        return speciality;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setSpecialty(String speciality) {
        this.speciality = speciality;
    }
}
