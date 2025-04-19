package hospitalManagementSystem;

public class Doctor extends Person implements Schedulable{
    private String speciality;
    private int licenseNumber;
    private double consultationFee;

    public Doctor(String name, int age, String id, String speciality, int licenseNumber, double consultationFee){
        super(name, age, id);
        this.speciality = speciality;
        this.licenseNumber = licenseNumber;
        this.consultationFee = consultationFee;

    }

    public void scheduleAppointment(String dateTime, Person otherParty ,String reason){
        if (!(otherParty instanceof Patient)){
            throw new IllegalArgumentException ("Doctors can only schedule appointments with Patients.");
        }
        else {
            System.out.println("Doctor " + this.getName() + " has scheduled an appointment with Patient "
                    + otherParty.getName() + " at " + dateTime + ".");
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

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
