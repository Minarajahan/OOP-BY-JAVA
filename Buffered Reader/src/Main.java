import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main{
    public static void main(String[]args){
        String text="Hello, this is a sample text data being wiriten in the BufferedWriter(FileWriter)";
        try(BufferedReader br = new BufferedReader(new FileReader("example.txt"))){
            String line;
            while((line = br.readLine()) !=null){
                System.out.println(line);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}