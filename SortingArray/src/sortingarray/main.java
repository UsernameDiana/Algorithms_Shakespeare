
package sortingarray;

public class main {
    public static void main(String[] args) {
        SortingArray sa = new SortingArray(2000);

        sa.arrayPrinter(); 
        int[] array = sa.getArray();
        
        StopWatch timer = new StopWatch();
        //sa.selectionSort(array); //0.001
        sa.insertionSort(array); //0.017
        double time = timer.endTime();
        
        System.out.println("sorted");
        System.out.println("time: " + time);
        
        sa.arrayPrinter();
        
    }
}
