package sortingarray;

import java.util.Random;

public class SortingArray {

    public String[] array;

    public SortingArray() {
    }

    public SortingArray(int size) {
        array = new String[size]; // created new list of array with given size
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
    
    public static void main(String[] args) {
        SortingArray sa = new SortingArray();
        String[] insertionSort = sa.insertionSort(new String[]{"dog","cat","emu"});
        for (String string : insertionSort) {
            System.out.println(string);
        }
    }
    
    
    // comparing the neighbouring value in sorted side
    public String[] insertionSort(String[] array) {

        int position;
        String valueToInsert;

        for (int i = 1; i < array.length; i++) { // represents where you are in the array
            valueToInsert = array[i];
            position = i;
            
            while (position > 0 && array[position - 1].compareTo(valueToInsert) > 0) { 
                // goes over the sorted part of the array
                array[position] = array[position - 1]; // overwrittes current values position
                position = position - 1;
            }
            // insert the value at hole position
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
            for (innerLoopIndex = i; innerLoopIndex < array.length; innerLoopIndex++) { // starts in unsorted part

                if (array[innerLoopIndex].compareTo(minValue) < 0) // compares th minValue to the next value
                {
                    minValue = array[innerLoopIndex];
                    minIndex = innerLoopIndex;
                }
            }
            // once the minValue is found, it will swap
            if (minValue.compareTo(array[i]) < 0) {
                temp = array[i];
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
