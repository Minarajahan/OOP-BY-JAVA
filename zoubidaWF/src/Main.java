import java.io.*;
import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "records.txt";

        // Display existing records
        System.out.println("Reading Student Records from File:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-10s %-10s%n",
                "StudentID", "StudentName", "CourseName", "Grade", "Term");
        System.out.println("------------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length == 5) {
                    System.out.printf("%-10s %-15s %-15s %-10s %-10s%n",
                            studentData[0], studentData[1], studentData[2],
                            studentData[3], studentData[4]);
                } else {
                    System.out.println("Invalid record format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("No file found or empty. A new file will be created.");
        }

        // Add new records to the file
        System.out.println("\nAdd new student records (enter 'stop' to finish):");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            while (true) {
                System.out.print("Enter StudentID, StudentName, CourseName, Grade, Term: ");
                String studentInput = scanner.nextLine();
                if (studentInput.equalsIgnoreCase("stop")) {
                    break;
                }

                String[] inputData = studentInput.split(",");
                if (inputData.length != 5) {
                    System.out.println("Invalid format. Please enter data as: StudentID,StudentName,CourseName,Grade,Term");
                    continue;
                }

                // Write valid input to the file
                bw.write(studentInput);
                bw.newLine();
                System.out.println("Student record added successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Display updated records
        System.out.println("\nUpdated Student Records from File:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-10s %-10s%n",
                "StudentID", "StudentName", "CourseName", "Grade", "Term");
        System.out.println("------------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length != 5) {
                    System.out.printf("%-10s %-15s %-15s %-10s %-10s%n",
                            studentData[0], studentData[1], studentData[2],
                            studentData[3], studentData[4]);
                } else {
                    System.out.println("Invalid record format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}
