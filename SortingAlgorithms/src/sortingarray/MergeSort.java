package sortingarray;

// Divide and conqure, uses recursion O(n logn)
// very consistant (treats sorted and unsorted the same way), most used, stable
public class MergeSort {

    private static Comparable[] temp; // additional array

    public MergeSort(Comparable[] array) {
        this.temp = array;
    }

    public static void mergeBottomsUp(Comparable[] a) {
        int N = a.length;
        temp = new Comparable[N];
        for (int subSize = 1; subSize < N; subSize = subSize + subSize)
        {
            for (int subIndex = 0; subIndex < N - subSize; subIndex += subSize + subSize)
            {
                merge(a, subIndex, subIndex + subSize - 1, Math.min(subIndex + subSize + subSize - 1, N - 1));
            }
        }
    }

    public static void mergeTopDown(Comparable[] a) {
        temp = new Comparable[a.length];
        mergeTopDown(a, 0, a.length - 1);
    }

    // Recursive mergesort implementation based on this abstract merge.
    private static void mergeTopDown(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeTopDown(a, lo, mid); // Sort left half.
        mergeTopDown(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi);
    }

    // Merge into new array
    public static void merge(Comparable[] pivot, int subIndex, int mid, int hi) {
        int i = subIndex, j = mid + 1;
        for (int k = subIndex; k <= hi; k++) // Copy pivot[subIndex..hi] to temp[subIndex..hi]
        {
            temp[k] = pivot[k];
        }
        for (int k = subIndex; k <= hi; k++) // Merge back to pivot[subIndex..hi].
        {
            if (i > mid) {
                pivot[k] = temp[j++];
            } else if (j > hi) {
                pivot[k] = temp[i++];
            } // if ( x[left].compareTo(x[right]) <= 0 
            else if (temp[j].compareTo(temp[i]) < 0) //position > 0 && array[position - 1].compareTo(valueToInsert) > 0 //less(temp[j], temp[i])
            {
                pivot[k] = temp[j++];
            } else {
                pivot[k] = temp[i++];
            }
        }
    }
//    This method merges by first copying into the auxiliary array aux[] 
//    then merging back to a[]. In the merge (the second for loop), 
//    there are four conditions: left half exhausted (take from the right), 
//    right half exhausted (take from the left), 
//    current key on right less than current key on left (take from the right), 
//    and current key on right greater than or equal to current key on left (take from the left).

    public void arrayPrinter() {
        for (int i = 0; i < temp.length; i++) {
            System.out.println("Content of array : " + temp[i]);
        }
    }
}
