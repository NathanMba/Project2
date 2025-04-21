package hospitalManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital(4, 5);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Hospital Management System Menu ---");
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
                    String patientMedicalRecordNumber = scanner.nextLine();


                    Patient patient = new Patient(patientId, patientName,patientAge, patientSymptoms, patientMedicalRecordNumber);
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
                    String doctorLicenseNumber = scanner.nextLine();


                    System.out.print("Enter consultationFee: ");
                    double consultationFee = scanner.nextDouble();

                    Doctor doctor = new Doctor(doctorId, doctorName,doctorAge , doctorSpeciality, doctorLicenseNumber, consultationFee);

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
                try {
                    hospital.checkPatientIsPatient(patientId, hospital);
                }catch(IllegalArgumentException e){
                    System.out.print(e.getMessage());
                    return;
                }
                Patient patient = hospital.getPatientById(patientId);

                System.out.print("Enter Doctor ID: ");
                String doctorId = scanner.nextLine();
                try {
                    hospital.checkDoctorIsDoctor(doctorId, hospital);
                }catch(IllegalArgumentException e){
                    System.out.print(e.getMessage());
                    return;
                }
                Doctor doctor = hospital.getDoctorById(doctorId);

                String dateTime;
                while (true) {
                    System.out.print("Enter Date time (example: 2025.05.28 17:53): ");
                    dateTime = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
                    try {
                        LocalDateTime.parse(dateTime, formatter);
                        break;
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid format for the date time, use this format \"year.month.day HH:MM\" (example: 2025.05.28 17:53)  ");
                    }
                }

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
