import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams{

     List<String> getWordsFromFile(String path) throws IOException {
         FileReader file = new FileReader(path);
         BufferedReader reader = new BufferedReader(file);
         List<String> lines = new ArrayList<>();
         String singleLine = "";
         while ((singleLine = reader.readLine()) != null) {
             lines.add(singleLine);
         }
         return lines;
     }
     
     public static String sortString (String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        
        return sorted;
     }
     
     public static void main(String []args){
        
        
     }
     
}