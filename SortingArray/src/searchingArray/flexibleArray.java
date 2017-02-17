package searchingArray;

// An implementation of a flexible array
public class flexibleArray<T> {

    private T[] oldArray = null;
    private T[] doubleArray = null;
    private int split = 0;

    public void add(T element) {
        if (doubleArray == null) {
            doubleArray = (T[]) new Object[]{element};
        } else if (oldArray == null) {
            oldArray = doubleArray;
            doubleArray = (T[]) new Object[2];
            doubleArray[0] = oldArray[0];
            doubleArray[1] = element;
            split = 1;
        } else if (split == oldArray.length) {
            oldArray = doubleArray;
            doubleArray = (T[]) new Object[2 * oldArray.length];
            doubleArray[0] = oldArray[0];
            doubleArray[oldArray.length] = element;
            split = 1;
        } else {
            doubleArray[split] = oldArray[split];
            doubleArray[oldArray.length + split] = element;
            split++;
        }
    }

    public T get(int index) {
        if (oldArray != null && split <= index && index < oldArray.length) {
            return oldArray[index];
        }
        if (index < oldArray.length + split) {
            return doubleArray[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void set(int index, T element) {
        if (oldArray != null && split <= index && index < oldArray.length) {
            oldArray[index] = element;
        } else if (index < oldArray.length + split) {
            doubleArray[index] = element;
        } else {
            add(element);
        }
    }

    public int size() {
        if (doubleArray == null) {
            return 0;
        }
        if (oldArray == null) {
            return 1;
        }
        return oldArray.length + split;
    }

    public static void main(String[] args) {
        flexibleArray<Integer> list = new flexibleArray<>();
        // ArrayList<Integer> list = new ArrayList();

        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long t1 = System.currentTimeMillis();

        System.out.println("Time: " + ((t1 - t0) / 1000.0));
        System.out.println("Value at index 123456: " + list.get(123456));
    }

}
