package sortingarray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class fileUtility {

    public static String[] toStringArray(String path, String delimiterPattern) throws IOException 
    {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Stream.of(line.split(delimiterPattern)))
                .filter(word -> !word.isEmpty())
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);
    }  
 
}
//String[] words = fileUtility.toStringArray("shakespeare-complete-works.txt", "[^A-Za-z]"); 
   
