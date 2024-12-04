import java.io.FileReader;
import java.io.IOException;
public class Main{
    public static void main(String[]args){
        try(FileReader fr=new FileReader("Example.txt")){
            int ch;
            while((ch=fr.read()) !=-1){
                System.out.println((char)ch);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}