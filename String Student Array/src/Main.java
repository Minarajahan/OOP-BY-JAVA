//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
        String[] studArray={"Hasan","Hussain","Hasnain"};
        String text= "Hello, BufferedWriter(FileWriter)";
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("outputBuffer"))){
            writer.write(text);
            writer.newLine();
            writer.write("This is another line");
            writer.newLine();
            writer.write("Student name");
            writer.newLine();
            for(String student : studArray){
                writer.write(student);
                writer.newLine();
            }
            System.out.println("Data written to the file succefully");

        }
        catch(IOException e){
            System.out.println("An error occured while writing to the file: "+ e.getMessage());
        }
    }
}