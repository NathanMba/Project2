package hospitalManagementSystem;

public class Hospital {
    private Person[] listPerson;
    private Appointment[] listappointment;
    private int personCounter;
    private  int appointmentCounter;

    public Hospital(int hospitalSize, int appointmentSize){
        listPerson = new Person[hospitalSize];
        listappointment = new Appointment[appointmentSize];
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
        if (appointmentCounter < listappointment.length ){
            listappointment[appointmentCounter] = newAppointment;
            appointmentCounter++;
            System.out.println("Added appointment: " + newAppointment.toString());

        }
        else{
            throw new IllegalArgumentException("Appointment capacity reached!");
        }
    }

    public void listAllPersons(){
        System.out.println("\n \"--- Hospital Persons List ---\"");
        for (int i = 0; i < personCounter; i++){
            listPerson[i].getDetails();
        }
    }

    public void listAppointments(){
        System.out.println("\n \"--- Hospital Appointments List ---\"");
        for (int i = 0; i < appointmentCounter; i++){
            listappointment[i].toString();
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



}
