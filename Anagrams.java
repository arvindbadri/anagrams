import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagrams{

	private static final String DELIMITER = "-";

     static List<String> getWordsFromFile(String path) throws IOException {
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

     public static List<String> getCombinedWordList (List<String> originalWordList) {
         List<String> combinedWordList = new ArrayList<>();
         for (String word : originalWordList) {
             combinedWordList.add(getCombinedWord(word));
         }
         return combinedWordList;
     }

     public static List<String> getOriginalWordList(List<String> combinedWordList) {
         List<String> originalWordList = new ArrayList<> ();
         for (String word : combinedWordList) {
             originalWordList.add(getOriginalWord(word));
         }
         return combinedWordList;
     }
	 
	 public static String getCombinedWord(String originalWord) {
         String sortedWord = sortString(originalWord);
         return sortedWord + DELIMITER + originalWord;
     }
     
     public static String getOriginalWord(String combinedWord) {
         return combinedWord.split(DELIMITER)[1];
	 }

	 public static List<List<String>> separateAnagrams (List<String> combinedWords) {
	     Collections.sort(combinedWords);
         List<List<String>> anagramsOfAllWords = new ArrayList<List<String>> ();
         List<String> anagramsOfSingleWord = new ArrayList<String> ();
         for (int i = 0; i < combinedWords.size() - 1; i++) {
             String sortedPartCurr = combinedWords.get(i).split(DELIMITER)[0];
             String sortedPartNext = combinedWords.get(i + 1).split(DELIMITER)[0];
             anagramsOfSingleWord.add(getOriginalWord(combinedWords.get(i)));
             if (!(sortedPartCurr.equals(sortedPartNext))) {
                 if (anagramsOfSingleWord.size() != 1) {
                     anagramsOfAllWords.add(anagramsOfSingleWord);
                     anagramsOfSingleWord.clear();
                 }
             }

         }
         return anagramsOfAllWords;
     }
     
     public static void main(String []args){
        try {
            List<List<String>> separateAnagrams = separateAnagrams(getCombinedWordList(getWordsFromFile("C:\\Users\\abadrinath\\IdeaProjects\\Training\\src\\test.txt")));
            for (List<String> list : separateAnagrams) {
                System.out.println(list);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
     }
     
}