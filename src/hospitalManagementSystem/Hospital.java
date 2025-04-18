package hospitalManagementSystem;

public class Hospital {
    private static Person[] listPerson;
    private static Appointment[] listAppointment;
    private static int personCounter;
    private  static int appointmentCounter;

    public Hospital(int hospitalSize, int appointmentSize){
        listPerson = new Person[hospitalSize];
        listAppointment = new Appointment[appointmentSize];
        personCounter = 0;
        appointmentCounter = 0;
    }

    public void addPerson(Person newPerson){
        if (personCounter < listPerson.length){
            listPerson[personCounter] = newPerson;
            personCounter++;
            System.out.println("Added person: " + newPerson.getDetails());
        }
        else{
            throw new IllegalArgumentException("Hospital capacity for persons reached!");
        }

    }

    public void addAppointment(Appointment newAppointment){
        if (appointmentCounter >= listAppointment.length ){
            throw new IllegalArgumentException("Appointment capacity reached!");

        }
        Person person1 = newAppointment.getPatient();
        Person person2 = newAppointment.getDoctor();

        boolean exist1 = false;
        boolean exist2 = false;

        for (int  i = 0; i < personCounter; i++){
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
            if (appointmentCounter < listAppointment.length){
                listAppointment[appointmentCounter]= newAppointment;
                appointmentCounter++;
                System.out.println("Added appointment: " + newAppointment.toString());
            }
        }
        else{
            System.out.println("Either the Doctor or the Patient does not exist in the Hospital.");
        }


    }

    public void listAllPersons(){
        if (personCounter == 0) {
            System.out.println("There is no person registered in the hospital");
        }
        else {
            System.out.println("\n \"--- Hospital Persons List ---\"");
            for (int i = 0; i < personCounter; i++) {
                System.out.println(listPerson[i].getDetails());
            }
        }
    }

    public void listAppointments(){
        if (appointmentCounter == 0) {
            System.out.println("There is no appointment registered in the hospital");
        }
        else {
            System.out.println("\n \"--- Hospital Appointments List ---\"");
            for (int i = 0; i < appointmentCounter; i++) {
                System.out.println(listAppointment[i].toString());
            }
        }
    }

    public void searchPerson(String researchedId){
        boolean state = false;
        for (int i = 0; i < personCounter; i++){
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
        System.out.println("\n Simulating day in the hospital...");

        if (appointmentCounter == 0){
            System.out.println("there is nothing to do in the Hospital");
        }
        else{
            for (int i = 0; i < appointmentCounter; i++){
                Doctor person1 = listAppointment[i].getDoctor();
                Patient person2 = listAppointment[i].getPatient();

                person1.diagnose(person2);
                System.out.println(listAppointment[i].toString());
            }
        }
    }

    public static String printHospitalStatistics(){
        System.out.println("--- Hospital Statistics ---");

        int numberOfDoctors = 0;
        int numberOfPatients = 0;
        for (int i = 0; i < personCounter; i++){
            if (listPerson[i] instanceof Doctor ){
                numberOfDoctors++;
            }
            if (listPerson[i] instanceof Patient ){
                numberOfPatients++;
            }

        }
        String information = "Total Persons: " + personCounter + "\"\n" + "Number of Patients: " + numberOfPatients + "\"\n" + "Number of Doctors: " + numberOfDoctors + "\"\n" + "Total Appointments: " + appointmentCounter;

        System.out.println(information);
        return information;


    }

    public static int getAppointmentCounter() {
        return appointmentCounter;
    }

    public static int getPersonCounter() {
        return personCounter;
    }

    public static Appointment[] getListAppointment() {
        return listAppointment;
    }

    public static Person[] getListPerson() {
        return listPerson;
    }

    public static void setAppointmentCounter(int appointmentCounter) {
        Hospital.appointmentCounter = appointmentCounter;
    }

    public static void setPersonCounter(int personCounter) {
        Hospital.personCounter = personCounter;
    }

    public static void setListAppointment(Appointment[] listAppointment) {
        Hospital.listAppointment = listAppointment;
    }

    public static void setListPerson(Person[] listPerson) {
        Hospital.listPerson = listPerson;
    }
}
