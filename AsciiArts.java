import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiArts {
  
    public static void print(String path) {
        try {
        Scanner sc = new Scanner(new File(path));
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine()); 
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        }
    
}