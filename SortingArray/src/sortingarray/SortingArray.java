 package sortingarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingArray {

    public String[] array;
    private static Comparable[] temp; // auxiliary(additional) array for merges in Top-down merge sort

    public SortingArray(int size) {
        array = new String[size]; // created new list of array with given size
//      wont use this, because we will get text from file
//     for (int i = 0; i < array.length; i++) {
//          array[i] = randomFill();
//        }
    }

    public SortingArray() {
    }

    public SortingArray(String[] array) {
        this.array = array;
    }
    
    // Abstract in-place merge trace
    //copy everything to an auxiliary array and then merging back to the original.
    public static void merge(Comparable[] pivot, int subIndex, int mid, int hi) { // Merge into new array
        int i = subIndex, j = mid + 1;
        for (int k = subIndex; k <= hi; k++) // Copy pivot[subIndex..hi] to temp[subIndex..hi]
        {
            temp[k] = pivot[k];
        }
        for (int k = subIndex; k <= hi; k++) // Merge back to pivot[subIndex..hi].
        {
            if (i > mid) 
            {
                pivot[k] = temp[j++];
            } 
            else if (j > hi) {
                pivot[k] = temp[i++];
            }                                   // if ( x[left].compareTo(x[right]) <= 0 
            else if (temp[j].compareTo(temp[i]) <= 0 ) //position > 0 && array[position - 1].compareTo(valueToInsert) > 0 //less(temp[j], temp[i])
            {
                pivot[k] = temp[j++];
            } 
            else 
            {
                pivot[k] = temp[i++];
            }
        }
    }
//    This method merges by fi rst copying into the auxiliary array aux[] 
//    then merging back to a[]. In the merge (the second for loop), 
//    there are four conditions: left half exhausted (take from the right), 
//    right half exhausted (take from the left), 
//    current key on right less than current key on left (take from the right), 
//    and current key on right greater than or equal to current key on left (take from the left).

    public static void mergeBottomsUp(Comparable[] a) { // Do lg N passes of pairwise merges.
        int N = a.length;
        temp = new Comparable[N];
        for (int subSize = 1; subSize < N; subSize = subSize + subSize) // subSize: subarray size
        {
            for (int subIndex = 0; subIndex < N - subSize; subIndex += subSize + subSize) // subIndex: subarray index
            {
                merge(a, subIndex, subIndex + subSize - 1, Math.min(subIndex + subSize + subSize - 1, N - 1));
            }
        }
    }
    
    public static void mergeTopDown(Comparable[] a) {
        temp = new Comparable[a.length]; // Allocate space just once.
        mergeTopDown(a, 0, a.length - 1);
    }
    
   // Recursive mergesort implementation based on this abstract inplace merge.
    private static void mergeTopDown(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeTopDown(a, lo, mid); // Sort left half.
        mergeTopDown(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    } 
    
    public String[] insertionSort(String[] array) { // comparing the neighbouring value

        int position;
        String valueToInsert;

        for (int i = 0; i < array.length; i++) {
            // select value to be inserted
            valueToInsert = array[i];
            position = i;
            //locate hole position for the element to be inserted
            while (position > 0 && array[position - 1].compareTo(valueToInsert) > 0) {
                array[position] = array[position - 1];
                position = position - 1;
            }
            // insert the number at hole position
            array[position] = valueToInsert;
        }
        return array;
    }

    public String[] selectionSort(String[] array) {
        String temp, minValue;
        int innerLoopIndex, minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            minValue = array[i]; // initializing mins for the first unsorted item
            minIndex = i;
            for (innerLoopIndex = i; innerLoopIndex < array.length; innerLoopIndex++) { // not looking at 0 anymore

                if (array[innerLoopIndex].compareTo(minValue) < 0) // whole loop is looking for the smallest value left in the unsorted part of array
                {
                    minValue = array[innerLoopIndex];
                    minIndex = innerLoopIndex;
                }
            }
            // after looking through the array, looking what values to swap
            if (minValue.compareTo(array[i]) < 0) {
                temp = array[i]; // temporery holding place while swapping places
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    public int randomFill() { // filling array with random numbers
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        return n;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void arrayPrinter() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("numbers : " + array[i]);
        }
    }
}
