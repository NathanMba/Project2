package hospitalManagementSystem;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital(4, 5);
        boolean exit = false;

        while (!exit) {
            System.out.println("--- Hospital Management System Menu ---");
            System.out.println("1. Register Person (Patient/Doctor)");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. List All Persons");
            System.out.println("4. List Appointment");
            System.out.println("5. Simulate Day");
            System.out.println("6. Print Hospital Statistics");
            System.out.println("7. Search Person by id");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            if (choice == 1) {
                System.out.print("Enter type(1 for Patient, 2 for Doctor): ");
                int type = scanner.nextInt();
                scanner.nextLine();

                if (type == 1) {
                    System.out.print("Enter Patient ID: ");
                    String patientId = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Symptoms: ");
                    String patientSymptoms = scanner.nextLine();

                    System.out.print("Enter Medical Record Number: ");
                    int patientMedicalRecordNumber = scanner.nextInt();
                    scanner.nextLine();

                    Patient patient = new Patient(patientName, patientAge, patientId, patientSymptoms, patientMedicalRecordNumber);
                    try {
                        hospital.addPerson(patient);
                    } catch (IllegalArgumentException e) {
                        System.out.print(e.getMessage());
                    }
                } else if (type == 2) {
                    System.out.print("Enter Doctor ID: ");
                    String doctorId = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int doctorAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Speciality: ");
                    String doctorSpeciality = scanner.nextLine();

                    System.out.print("Enter licenseNumber: ");
                    int doctorLicenseNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter consultationFee: ");
                    double consultationFee = scanner.nextDouble();

                    Doctor doctor = new Doctor(doctorName, doctorAge, doctorId, doctorSpeciality, doctorLicenseNumber, consultationFee);

                    try {
                        hospital.addPerson(doctor);
                    } catch (IllegalArgumentException e) {
                        System.out.print(e.getMessage());
                    }

                } else {
                    System.out.println("No valid type chosen.");
                }
            } else if (choice == 2) {
                System.out.print("Enter Appointment ID: ");
                String appointmentId = scanner.nextLine();

                System.out.print("Enter Patient ID: ");
                String patientId = scanner.nextLine();
                Patient patient = hospital.getPatientById(patientId);

                System.out.print("Enter Doctor ID: ");
                String doctorId = scanner.nextLine();
                Doctor doctor = hospital.getDoctorById(doctorId);

                System.out.print("Enter Date time (example: 2025.05.28 17:53): ");
                String dateTime = scanner.nextLine();

                System.out.print("Enter reason: ");
                String reason = scanner.nextLine();

                Appointment appointment = new Appointment(appointmentId, patient, doctor, dateTime, reason);

                try {
                    hospital.addAppointment(appointment);
                } catch (IllegalArgumentException e) {
                    System.out.print(e.getMessage());
                }

            } else if (choice == 3) {
                hospital.listAllPersons();
            } else if (choice == 4) {
                hospital.listAppointments();
            } else if (choice == 5) {
                hospital.simulateDay();
            } else if (choice == 6) {
                Hospital.printHospitalStatistics(hospital);
            } else if (choice == 7) {
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                hospital.searchPerson(id);
            } else if (choice == 8){
                System.out.print("You selected Exit!");
                exit = true;
            }
            else{
                System.out.print("Invalid choice");
            }


        }
        scanner.close();
    }
}
