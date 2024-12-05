import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Main{
    public static void main(String[]args){
        String text="Hello, this is a sample text data being wiriten in the BufferedWriter(FileWriter)";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"))){
            writer.write(text);
            writer.write("\nThis is another line.");
            System.out.println("Data written to file successfully");
        }
        catch(IOException e){
            System.out.println("An error occured while writing to the file: "+ e.getMessage());
        }
    }
}