import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "student_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Reading existing student records...");
            System.out.println("----------------------------------------------");
            System.out.println("StudentID\tName\tCourseName\tCourseGrade\tTerm");
            System.out.println("-----------------------------------------------");
            String line;
            String header = br.readLine();
            System.out.println(header);

            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length == 5) {
                    System.out.printf("%-10s %-10s %-15s %-15s %-10s%n",
                            studentData[0], studentData[1], studentData[2], studentData[3], studentData[4]);
                } else {
                    System.out.println("Invalid data format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found. Creating a new file.");
        }



        System.out.println("Enter student details (StudentID, Name, CourseName, CourseGrade, Term):");
        String studentInput = scanner.nextLine();



        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.newLine();
            bw.write(studentInput);
            System.out.println("Student record added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}
