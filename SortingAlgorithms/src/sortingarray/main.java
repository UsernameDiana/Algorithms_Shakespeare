package sortingarray;

import java.io.IOException;

public class main 
{
    public static void main(String[] args) throws IOException 
    {
        String[] words = fileUtility.toStringArray("build/classes/shakespeare/shak.txt", "[^A-Za-z]"); // espeare-complete-works
      
        // INSERTION SORT
        SortingArray sa = new SortingArray(words);
        StopWatch start = new StopWatch();
        sa.insertionSort(words);
        double stop = start.endTime();
        // sa2.arrayPrinter();
        
        // SELECTION SORT
        SortingArray sa2 = new SortingArray(words);
        // sa.arrayPrinter(); // Array before sorting
        StopWatch start2 = new StopWatch();
        sa2.selectionSort(words);
        double stop2 = start2.endTime();
        // sa.arrayPrinter(); // Sorted array

        // MERGE TOP DOWN SORT
        Comparable[] wordsForMerge = fileUtility.toStringArray("build/classes/shakespeare/shakespeare-complete-works.txt", "[^A-Za-z]");
        MergeSort mSort = new MergeSort(wordsForMerge);
        StopWatch start3 = new StopWatch(); 
        mSort.mergeTopDown(wordsForMerge);
        double stop3 = start3.endTime();
        
        // MERGE BOTTOMS UP SORT
        StopWatch start4 = new StopWatch();
        mSort.mergeBottomsUp(wordsForMerge);
        double stop4 = start4.endTime();
        // mSort.arrayPrinter();  // prints out the words as they get sorted
        
        // QUICK SORT
        Comparable[] wordsForQuick = fileUtility.toStringArray("build/classes/shakespeare/shakespeare-complete-works.txt", "[^A-Za-z]"); 
        QuickSort qSort = new QuickSort(wordsForQuick);
        StopWatch start5 = new StopWatch();
        qSort.quickSort(wordsForQuick);
        double stop5 = start5.endTime();
        // qSort.arrayPrinter();
        
        System.out.println("Time of Insertion Sort: " + stop);
        System.out.println("Time of Selection Sort: " + stop2);
        System.out.println("Number of words in Insertion and Selection sort: " + words.length); // Word count
        System.out.println("Time of Merge Top Down Sort: " + stop3);
        System.out.println("Time of Merge Bottoms Up Sort: " + stop4);
        System.out.println("Time of Quick Sort: " + stop5);
        System.out.println("Number of words in Merge and Quick sort:  " + wordsForMerge.length); // Word count
    }
}
