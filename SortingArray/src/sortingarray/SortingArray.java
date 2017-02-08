package sortingarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingArray {

    public String[] array;
    private static Comparable[] temp;

    // STEP ONE we need this to take in strings instead of int
    public SortingArray(int size) {
        array = new String[size]; // created new list of array with given size
//      wont use this, because we will get text from file
//        for (int i = 0; i < array.length; i++) {
//            array[i] = randomFill();
//        }
    }

    public SortingArray() {
    }

    public SortingArray(String[] array) {
        this.array = array;
    }

//    public int less(Comparable[] a,Comparable[] b)
//    {
//        if () return a;
//       
//        return 0;
//    }
    
    
    public static void mergeAbstract(Comparable[] a, int subIndex, int mid, int hi) { // Merge into new array
        int i = subIndex, j = mid + 1;
        for (int k = subIndex; k <= hi; k++) // Copy a[subIndex..hi] to aux[subIndex..hi].
        {
            temp[k] = a[k];
        }
        for (int k = subIndex; k <= hi; k++) // Merge back to a[subIndex..hi].
        {
            if (i > mid) 
            {
                a[k] = temp[j++];
            } 
            else if (j > hi) 
            {
                a[k] = temp[i++];
            } 
            else if (less(temp[j], temp[i])) 
            {
                a[k] = temp[j++];
            } 
            else 
            {
                a[k] = temp[i++];
            }
        }
    }
   
    
    public static void mergeSort(Comparable[] a) { // Do lg N passes of pairwise merges.
        int N = a.length;
        temp = new Comparable[N];
        for (int subSize = 1; subSize < N; subSize = subSize + subSize) // subSize: subarray size
        {
            for (int subIndex = 0; subIndex < N - subSize; subIndex += subSize + subSize) // subIndex: subarray index
            {
                mergeAbstract(a, subIndex, subIndex + subSize - 1, Math.min(subIndex + subSize + subSize - 1, N - 1));
            }
        }
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

        for (int i = 0; i < array.length; i++)
        {
            minValue = array[i]; // initializing mins for the first unsorted item
            minIndex = i;
            for (innerLoopIndex = i; innerLoopIndex < array.length; innerLoopIndex++) { // not looking at 0 anymore
                
                if (array[innerLoopIndex].compareTo(minValue)<0) // whole loop is looking for the smallest value left in the unsorted part of array
                {
                    minValue = array[innerLoopIndex];
                    minIndex = innerLoopIndex;
                }                
            }
            // after looking through the array, looking what values to swap
            if (minValue.compareTo(array[i])<0){
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
    
    public boolean isSorted(int limit) {
        if (limit <= 0 || words.length < limit) {
            limit = words.length;
        }
        String temp = words[0];
        for (int i = 1; i < limit; i++) {
            if (temp.compareTo(words[i]) > 0) {
                return false;
            }
            temp = words[i];
        }
        return true;
    }

}
