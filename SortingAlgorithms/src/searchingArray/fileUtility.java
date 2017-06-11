package searchingArray;

import sortingarray.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// A helper class to read files into string arrays
public class fileUtility {

    public static String[] toStringArray(String path, String delimiterPattern) throws IOException {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Stream.of(line.split(delimiterPattern)))
                .filter(word -> !word.isEmpty())
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);
    }

    // A small method that can be used to ensure the array words is actually sorted
//        public boolean isSorted(int limit) {
//        if (limit <= 0 || words.length < limit) {
//            limit = words.length;
//        }
//        String temp = words[0];
//        for (int i = 1; i < limit; i++) {
//            if (temp.compareTo(words[i]) > 0) {
//                return false;
//            }
//            temp = words[i];
//        }
//        return true;
//    }
}
