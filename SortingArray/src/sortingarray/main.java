package sortingarray;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        SortingArray sa = new SortingArray(20);

//        sa.arrayPrinter(); 
//        int[] array = sa.getArray();
//        sa.selectionSort(array); //0.001
//        sa.insertionSort(array); //0.017
//        System.out.println("sorted");
//        System.out.println("time: " + time);
//        sa.arrayPrinter();

        String[] words = fileUtility.toStringArray("build/classes/shakespeare/shak.txt", "[^A-Za-z]");
        System.out.println(words.length); // i am getting the works with 879 words
        
        
        StopWatch timer = new StopWatch();
        sa.insertionSort(words); // we need to change int[] array to string [] in our sort methods
        double time = timer.endTime();
        sa.arrayPrinter();
    }
}
