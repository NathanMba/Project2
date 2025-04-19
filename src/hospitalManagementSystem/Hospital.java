package hospitalManagementSystem;

public class Hospital {
    private Person[] listPerson;
    private Appointment[] listAppointment;
    private int totalPerson;
    private  int totalAppointment;

    public Hospital(int hospitalSize, int appointmentSize){
        listPerson = new Person[hospitalSize];
        listAppointment = new Appointment[appointmentSize];
        totalPerson = 0;
        totalAppointment = 0;
    }

    public void addPerson(Person newPerson){

        for (int  i = 0; i < totalPerson; i++){
            if (newPerson.getId().equals(listPerson[i].getId())){
                throw new IllegalArgumentException("A person with the same ID \"" + newPerson.getId() + "\" already exist in the hospital.");
            }
        }

        if (totalPerson < listPerson.length){
            listPerson[totalPerson] = newPerson;
            totalPerson++;
            System.out.println("Added person: " + newPerson.getDetails());
        }
        else{
            throw new IllegalArgumentException("Hospital capacity for persons reached!");
        }

    }

    public void addAppointment(Appointment newAppointment){
        if (totalAppointment >= listAppointment.length ){
            throw new IllegalArgumentException("Appointment capacity reached!");

        }
        for (int  i = 0; i < totalAppointment; i++){
            if (newAppointment.getAppointmentId().equals(listAppointment[i].getAppointmentId())){
                throw new IllegalArgumentException("An appointment with the same ID \"" + newAppointment.getAppointmentId() + "\" already exist in the list of appointments.");
            }
        }

        Person person1 = newAppointment.getPatient();
        Person person2 = newAppointment.getDoctor();

        boolean exist1 = false;
        boolean exist2 = false;

        for (int  i = 0; i < totalPerson; i++){
            if ((listPerson[i].equals(person1))){
                exist1 = true;
            }
            if ((listPerson[i].equals(person2))){
                exist2 = true;
            }
            if (exist1 && exist2){
                break;
            }
        }

        if (exist1 && exist2){
            if (totalAppointment < listAppointment.length){
                listAppointment[totalAppointment]= newAppointment;
                totalAppointment++;
                System.out.println("Added appointment: " + newAppointment.toString());
            }
        }
        else{
            System.out.println("Either the Doctor or the Patient does not exist in the Hospital.");
        }


    }

    public void listAllPersons(){
        if (totalPerson == 0) {
            System.out.println("There is no person registered in the hospital.");
        }
        else {
            System.out.println("\n \"--- Hospital Persons List ---\"");
            for (int i = 0; i < totalPerson; i++) {
                System.out.println(listPerson[i].getDetails());
            }
        }
    }

    public void listAppointments(){
        if (totalAppointment == 0) {
            System.out.println("There is no appointment registered in the hospital");
        }
        else {
            System.out.println("\n \"--- Hospital Appointments List ---\"");
            for (int i = 0; i < totalAppointment; i++) {
                System.out.println(listAppointment[i].toString());
            }
        }
    }

    public Patient getPatientById(String patientId){
        for (int i = 0; i < totalPerson; i++){
            if (listPerson[i] instanceof Patient){
                Patient patient = (Patient) listPerson[i];
                if (patientId.equals(patient.getId())){
                    return patient;
                }
            }
        }
        return null;
    }

    public Doctor getDoctorById(String doctorId){
        for (int i = 0; i < totalPerson; i++){
            if (listPerson[i] instanceof Doctor){
                Doctor doctor = (Doctor) listPerson[i];
                if (doctorId.equals(doctor.getId())){
                    return doctor;
                }
            }
        }
        return null;
    }

    public void checkPatientIsPatient(String id, Hospital hospital){
        if (hospital.getDoctorById(id) != null){
            throw new IllegalArgumentException("Appointments are only schedulable between a Patient and a Doctor.");
        }
    }
    public void checkDoctorIsDoctor(String id, Hospital hospital){
        if (hospital.getPatientById(id) != null){
            throw new IllegalArgumentException("Appointments are only schedulable between a Patient and a Doctor.");
        }
    }


    public void searchPerson(String researchedId){
        boolean state = false;
        for (int i = 0; i < totalPerson; i++){
            if (researchedId.equals(listPerson[i].getId())){
                System.out.println("Found person: " + listPerson[i].getDetails());
                state = true;
                break;
            }
        }
        if (!state){
            System.out.println("The person with the provided ID: " + researchedId + " is not founded in the hospital.");
        }
    }

    public void simulateDay(){
        System.out.println("\nSimulating day in the hospital...");

        if (totalAppointment == 0){
            System.out.println("there is nothing to do in the Hospital");
        }
        else{
            for (int i = 0; i < totalAppointment; i++){
                Doctor person1 = listAppointment[i].getDoctor();
                Patient person2 = listAppointment[i].getPatient();

                person1.diagnose(person2);
                System.out.println(listAppointment[i].toString());
            }
        }
    }

    public int getTotalAppointment() {
        return totalAppointment;
    }

    public int getTotalPerson() {
        return totalPerson;
    }

    public Appointment[] getListAppointment() {
        return listAppointment;
    }

    public Person[] getListPerson() {
        return listPerson;
    }

    public void setTotalAppointment(int totalAppointment) {
        this.totalAppointment = totalAppointment;
    }

    public void setTotalPerson(int totalPerson) {
        this.totalPerson = totalPerson;
    }

    public void setListAppointment(Appointment[] listAppointment) {
        this.listAppointment = listAppointment;
    }

    public void setListPerson(Person[] listPerson) {
        this.listPerson = listPerson;
    }

    public static String printHospitalStatistics(Hospital hospital){
        System.out.println("--- Hospital Statistics ---");

        int numberOfDoctors = 0;
        int numberOfPatients = 0;
        for (int i = 0; i < hospital.getTotalPerson(); i++){
            if (hospital.getListPerson()[i] instanceof Doctor ){
                numberOfDoctors++;
            }
            if (hospital.getListPerson()[i] instanceof Patient ){
                numberOfPatients++;
            }

        }
        String information = "Total Persons: " + hospital.totalPerson + "\n" + "Number of Patients: " + numberOfPatients + "\n" + "Number of Doctors: " + numberOfDoctors + "\n" + "Total Appointments: " + hospital.totalAppointment;

        System.out.println(information);
        return information;
    }


}
