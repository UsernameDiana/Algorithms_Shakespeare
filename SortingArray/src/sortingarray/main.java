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
        String[] words = fileUtility.toStringArray("build/classes/shakespeare/shak.txt", "[^A-Za-z]");//espeare-complete-works
       
        System.out.println("Number of words " + words.length); // Word count
      
        SortingArray sa = new SortingArray(words); // Making a new instance of Sorting class
        // sa.arrayPrinter(); // Array before sorting
        StopWatch start1= new StopWatch();
        sa.selectionSort(words);
        double stop1 = start1.endTime();
        // sa.arrayPrinter(); // Sorted array
        
        SortingArray sa2 = new SortingArray(words);
        StopWatch start2 = new StopWatch();
        sa2.insertionSort(words);
        double stop2 = start2.endTime();
        // sa2.arrayPrinter();

        Comparable[] wordsForMerge = fileUtility.toStringArray("build/classes/shakespeare/shak.txt", "[^A-Za-z]");
        
        MergeSort mSort = new MergeSort(wordsForMerge);
        StopWatch start3 = new StopWatch(); 
        mSort.mergeTopDown(wordsForMerge);
        double stop3 = start3.endTime();
        
        Comparable[] wordsForQuick = fileUtility.toStringArray("build/classes/shakespeare/shak.txt", "[^A-Za-z]"); 
        QuickSort qSort = new QuickSort(wordsForQuick);
        StopWatch start4 = new StopWatch();
        qSort.quickSort(wordsForQuick);
        double stop4 = start4.endTime();
        
        System.out.println("Time of Selection Sort: " + stop1);
        System.out.println("Time of Insertion Sort: " + stop2);
        System.out.println("Time of Merge Sort: " + stop3);
        System.out.println("Time of Quick Sort: " + stop4);
    }

}
