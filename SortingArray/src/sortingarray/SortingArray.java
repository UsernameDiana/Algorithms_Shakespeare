package sortingarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingArray {

    public int[] array;

    public SortingArray(int size) {
        array = new int[size]; // created new list of array with given size
        for (int i = 0; i < array.length; i++) {
            array[i] = randomFill();
        }
//        System.out.println("random numbers at index" + array[1]);
    }

    public int randomFill() { // filling array with random numbers
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        return n;
    }

    public int[] insertionSort(int[] array) {

        int position;
        int valueToInsert;

        for (int i = 0; i < array.length; i++) {
            // select value to be inserted
            valueToInsert = array[i];
            position = i;
            //locate hole position for the element to be inserted
            while (position > 0 && array[position - 1] > valueToInsert) {
                array[position] = array[position - 1];
                position = position - 1;
            }
            // insert the number at hole position
            array[position] = valueToInsert;
//            System.out.println("insertion sort" + array[12]);
        }
        return array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] selectionSort(int[] array) {
        int j, temp, minValue, minIndex = 0;
        //Set MIN to location 0
        //Search the minimum element in the list
        //Swap with value at location MIN
        //Increment MIN to point to next element and repeat till sorted
        for (int i = 0; i < array.length; i++) {
            minValue = array[i]; // initializing mins for the first unsorted item
            minIndex = i;
            for (j = i; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            if (minValue < array[i]) {
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
