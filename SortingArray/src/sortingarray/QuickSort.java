package sortingarray;

//    Quicksort is temp divide -and -conquer method for sorting.It
//    works by partitioning an array into two subarrays, then sorting the subarrays independently.

public class QuickSort {
    
    private static Comparable[] temp; 

    public QuickSort(Comparable[] array)
    {
        this.temp = array;
    }

    public static void quickSort(Comparable[] temp) { // throws IllegalArgumentException
       // StdRandom.shuffle(temp); // Eliminate dependence on input.
        sort(temp, 0, temp.length - 1);
    }

    private static void sort(Comparable[] temp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(temp, lo, hi); // Partition (see page 291).
        sort(temp, lo, j - 1); // Sort left part temp[lo .. j-1].
        sort(temp, j + 1, hi); // Sort right part temp[j+1 .. hi].
    }

    private static int partition(Comparable[] temp, int lo, int hi) { // Partition into temp[lo..i-1], temp[i], temp[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        Comparable v = temp[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (temp[++i].compareTo(v) < 0) { // temp[j].compareTo(temp[i]) <= 0
                if (i == hi) {
                    break;
                }
            }
            while (v.compareTo( temp[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(temp, i, j);// 
        }
        exch(temp, lo, j); // Put v = temp[j] into position
        return j; // with temp[lo..j-1] <= temp[j] <= temp[j+1..hi].
    }

     private static void exch(Object[] a, int i, int j) {
            Object tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    
}
