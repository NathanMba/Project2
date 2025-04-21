package hospitalManagementSystem;

public interface Schedulable {

    public Appointment scheduleAppointment(String dateTime, Person otherParty ,String reason);
}
