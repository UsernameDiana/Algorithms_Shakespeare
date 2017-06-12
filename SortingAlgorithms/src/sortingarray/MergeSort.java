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
        for (int subSize = 1; subSize < N; subSize = subSize + subSize) // starting to put togeather/doubbling
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
    private static void mergeTopDown(Comparable[] data, int lo, int hi) {
        if (hi <= lo) { // there is no more to split
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeTopDown(data, lo, mid); // Sort left half.
        mergeTopDown(data, mid + 1, hi); // Sort right half.
        merge(data, lo, mid, hi);
    }

    // Merge into new array
    public static void merge(Comparable[] data, int subIndex, int mid, int hi) {
        int i = subIndex, j = mid + 1;
        for (int k = subIndex; k <= hi; k++) // Copy data[subIndex..hi] to temp[subIndex..hi]
        {
            temp[k] = data[k];
        }
        for (int k = subIndex; k <= hi; k++) // Merge back to data[subIndex..hi].
        {
            if (i > mid) {
                data[k] = temp[j++];
            } else if (j > hi) {
                data[k] = temp[i++];
            } 
            else if (temp[j].compareTo(temp[i]) < 0)
            {
                data[k] = temp[j++];
            } else {
                data[k] = temp[i++];
            }
        }
    }
//    This method merges by first copying into the temporary array temp[] 
//    then merging back to a[]. In the merge (the second for loop), 
//    there are four conditions: left half emptied (take from the right), 
//    right half emptied (take from the left), 
//    current key on right less than current key on left (take from the right), 
//    and current key on right greater than or equal to current key on left (take from the left).

    public void arrayPrinter() {
        for (int i = 0; i < temp.length; i++) {
            System.out.println("Content of array : " + temp[i]);
        }
    }
}
