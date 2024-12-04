import java.io.FileWriter;
import java.io.IOException;
public class Main{
    public static void main(String[]args){
        try(FileWriter writer=new FileWriter("example.txt")){
            writer.write("Hello,I am a writer!");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}