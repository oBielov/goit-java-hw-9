package files_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordsCounter {

    private String fileToString (String path) throws IOException {
        return Files.readString(Path.of(path));
    }


    public void countWords(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        String text = fileToString(path);

        for (String word: text.split("\\W")){
            if(word.isEmpty()){
                continue;
            }
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }
            else{
                map.put(word, 1);
            }
        }
        Map<String, Integer> treeMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
