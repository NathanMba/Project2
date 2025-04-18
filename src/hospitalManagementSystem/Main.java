package hospitalManagementSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

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

        if (choice == 1){
            System.out.print("Enter type(1 for Patient, 2 for Doctor): ");
            int type = scanner.nextInt();

            if (type == 1){
                System.out.print("Enter Patient ID: ");
                String patientId = scanner.nextLine();

                System.out.print("Enter Name: ");
                String patientName = scanner.nextLine();

                System.out.print("Enter Age: ");
                int patientAge = scanner.nextInt();
                scanner.nextLine(); // Fix: clear the newline

                System.out.print("Enter Symptoms: ");
                String patientSymptoms = scanner.nextLine();

                System.out.print("Enter Medical Record Number: ");
                int patientMedicalRecordNumber = scanner.nextInt();
                scanner.nextLine(); // optional, in case another nextLine() comes

                System.out.println("Added person: ID: " + patientId + ", Name: " + patientName + ", Age: " + patientAge + ", Role: Patient");
            }
            else if (type == 2){
                System.out.print("Enter Doctor ID: ");
                String doctorId = scanner.nextLine();

                System.out.print("Enter Name: ");
                String doctorName = scanner.nextLine();

                System.out.print("Enter Age: ");
                int doctorAge = scanner.nextInt();

                System.out.print("Enter Speciality: ");
                String doctorSpeciality = scanner.nextLine();

                System.out.print("Enter licenseNumber: ");
                int doctorLicenseNumber = scanner.nextInt();

                System.out.print("Enter consultationFee: ");
                double consultationFee = scanner.nextDouble();

                System.out.print("Added person: ID: " + doctorId + ", Name: " + doctorName + ", Age: " + doctorAge + ", Speciality: " + doctorSpeciality + "LicenseNumber: " + doctorLicenseNumber + "consultationFee: " + consultationFee +", Role: " + "Doctor");
            }
        }






















        scanner.close();
    }
















































}
