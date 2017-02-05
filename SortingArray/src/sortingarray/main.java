package sortingarray;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

//        sa.arrayPrinter(); 
//        int[] array = sa.getArray();
//        sa.selectionSort(array); //0.001
//        sa.insertionSort(array); //0.017
//        System.out.println("sorted");
//        System.out.println("time: " + time);
        String[] words = fileUtility.toStringArray("build/classes/shakespeare/shak.txt", "[^A-Za-z]");
        System.out.println("number of words " +words.length); // i am getting the works with 879 words
        //              sa.arrayPrinter();
        SortingArray sa = new SortingArray(words);
        StopWatch timer = new StopWatch();
        sa.insertionSort(words);
        sa.selectionSort(words);
        double time = timer.endTime();
        sa.arrayPrinter();
    }
}
