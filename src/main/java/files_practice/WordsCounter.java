package files_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Behavioral class made for counting word occurrences in a text file.
 * Takes a TXT file, converts it to String with the {@link #fileToString(String)}
 * method, than counts words entries through the HashMap getting word as a key
 * and counts value as occurrences number.
 * Overrides Comparator to print results in descending order.
 * Prints result with {@link #countWords} method.
 */
public class WordsCounter {

    /**
     * Service method to convert text file to string
     * @param path path to TXT file
     * @return String object with file content
     * @throws IOException
     */
    private String fileToString (String path) throws IOException {
        return Files.readString(Path.of(path));
    }


    /**
     * Main business method. Builds a HashMap from String content,
     * count words occurrences by taking word as a key. If map contains
     * a key adds a count to value. Then sort map through set and overridden
     * Comparator.
     * @param path path to TXT file
     * @throws IOException
     */
    public void countWords(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String text = fileToString(path);


        //Build HashMap with occurrences as value

        for(String word : text.split("\\W")) {
            if(word.isEmpty()) {
                continue;
            }
            if(map.containsKey(word)) { //check if key exists
                map.put(word, map.get(word)+1); // adds +1 to value
            }
            else {
                map.put(word, 1);// first occurrence
            }
        }

        //Convert hashMap to ArrayList and sort it in descending order

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> a.getValue().compareTo(b.getValue()));

        //Print result
        for(int i = 0; i < map.size(); i++){
            System.out.println(entries.get(entries.size() - i - 1).getKey() + ": "
                               + entries.get(entries.size() - i - 1).getValue());
        }
    }



}
