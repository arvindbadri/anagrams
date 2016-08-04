class import java.util.*;

public class Anagrams{
     
     
     public static String sortString (String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        
        return sorted;
     }
     
     public static void main(String []args){
        
        
        
     }
     
}