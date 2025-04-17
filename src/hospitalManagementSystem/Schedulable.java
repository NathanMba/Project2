package hospitalManagementSystem;

public interface Schedulable {

    public void scheduleAppointment(String dateTime, Person otherParty ,String reason);
}
