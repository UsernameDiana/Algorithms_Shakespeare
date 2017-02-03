package sortingarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingArray {

    public String[] array;

    public SortingArray(int size) {
        array = new String[size]; // created new list of array with given size
//        for (int i = 0; i < array.length; i++) { // wont use this, because we will get text from file
//            array[i] = randomFill();
//        }
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

    
    public int[] selectionSort(String[] array) {
        String temp, minValue;
        int innerLoopIndex, minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            minValue = array[i]; // initializing mins for the first unsorted item
            minIndex = i;
            for (innerLoopIndex = i; innerLoopIndex < array.length; innerLoopIndex++) { // both loops are dependent
                
                if (array[innerLoopIndex].compareTo(minValue)) {
                    minValue = array[innerLoopIndex];
                    minIndex = innerLoopIndex;
                }
            }
            if (minValue.compareTo(array[i]){
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    public void arrayPrinter() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("numbers : " + array[i]);
        }
    }
}
