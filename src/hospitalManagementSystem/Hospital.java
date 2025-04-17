package hospitalManagementSystem;

public class Hospital {
    private Person[] listPerson;
    private Appointment[] appointment;
    private int personCounter;
    private  int appointmentCounter;

    public Hospital(int hospitalSize, int appointmentSize){
        listPerson = new Person[hospitalSize];
        appointment = new Appointment[appointmentSize];
        personCounter = 0;
        appointmentCounter = 0;
    }

    public void addPerson(Person newPerson){
        if (personCounter < listPerson.length){
            listPerson[personCounter] = newPerson;
            personCounter++;

            System.out.println("Added person: " + newPerson.getDetails() );
        }
        else{
            throw new IllegalArgumentException("Hospital capacity for persons reached!");
        }
    }
}
