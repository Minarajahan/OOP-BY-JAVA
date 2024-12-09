import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "student_data.txt";

        // 1. Read existing data (or create an empty file if it doesn't exist)
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Reading existing student records...");
            String line;
            String header = br.readLine(); // Read and discard the header line
            System.out.println(header); // Print the header

            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length == 5) { // Check for 5 fields
                    System.out.printf("%-10s %-10s %-15s %-15s %-10s%n",
                            studentData[0], studentData[1], studentData[2], studentData[3], studentData[4]);
                } else {
                    System.out.println("Invalid data format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found. Creating a new file.");
        }


        // 2. Get user input
        System.out.println("Enter student details (StudentID, Name, CourseName, CourseGrade, Term):");
        String studentInput = scanner.nextLine();


        // 3. Write user input to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.newLine(); //add new line before writing new input
            bw.write(studentInput);
            System.out.println("Student record added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}