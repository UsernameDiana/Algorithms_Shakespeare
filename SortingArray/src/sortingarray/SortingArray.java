package sortingarray;

import java.util.Random;

public class SortingArray {

    public String[] array;
//    private static Comparable[] temp; // auxiliary(additional) array for merges in Top-down merge sort

    public SortingArray() {
    }

    public SortingArray(int size) {
        array = new String[size]; // created new list of array with given size
        //      wont use this, because we will get text from file
        //     for (int i = 0; i < array.length; i++) {
        //          array[i] = randomFill();
        //        }
    }

    public SortingArray(String[] array) {
        this.array = array;
    }
    
     public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

//    //    Quicksort is temp divide-and-conquer method for sorting. It
//    //    works by partitioning an array into two subarrays, then sorting the subarrays independently.
//    public static void quickSort(Comparable[] temp) {
//        StdRandom.shuffle(temp); // Eliminate dependence on input.
//        sort(temp, 0, temp.length - 1);
//    }
//
//    private static void sort(Comparable[] temp, int lo, int hi) {
//        if (hi <= lo) {
//            return;
//        }
//        int j = partition(temp, lo, hi); // Partition (see page 291).
//        sort(temp, lo, j - 1); // Sort left part temp[lo .. j-1].
//        sort(temp, j + 1, hi); // Sort right part temp[j+1 .. hi].
//    }
//    
//   private static int partition(Comparable[] temp, int lo, int hi) { // Partition into temp[lo..i-1], temp[i], temp[i+1..hi].
//        int i = lo, j = hi + 1; // left and right scan indices
//        Comparable v = temp[lo]; // partitioning item
//        while (true) { // Scan right, scan left, check for scan complete, and exchange.
//            while (less(temp[++i], v)) { // temp[j].compareTo(temp[i]) <= 0
//                if (i == hi) {
//                    break;
//                }
//            }
//            while (less(v, temp[--j])) {
//                if (j == lo) {
//                    break;
//                }
//            }
//            if (i >= j) {
//                break;
//            }
//            exch(temp, i, j);
//        }
//        exch(temp, lo, j); // Put v = temp[j] into position
//        return j; // with temp[lo..j-1] <= temp[j] <= temp[j+1..hi].
//    }

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

    public void arrayPrinter() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Content of array : " + array[i]);
        }
    }
}
