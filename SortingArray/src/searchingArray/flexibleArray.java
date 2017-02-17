package searchingArray;

public class flexibleArray<T> {

    private T[] less = null;
    private T[] more = null;
    private int split = 0;

    public void add(T element) {
        if (more == null) {
            more = (T[]) new Object[]{element};
        } else if (less == null) {
            less = more;
            more = (T[]) new Object[2];
            more[0] = less[0];
            more[1] = element;
            split = 1;
        } else if (split == less.length) {
            less = more;
            more = (T[]) new Object[2 * less.length];
            more[0] = less[0];
            more[less.length] = element;
            split = 1;
        } else {
            more[split] = less[split];
            more[less.length + split] = element;
            split++;
        }
    }

    public T get(int index) {
        if (less != null && split <= index && index < less.length) {
            return less[index];
        }
        if (index < less.length + split) {
            return more[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void set(int index, T element) {
        if (less != null && split <= index && index < less.length) {
            less[index] = element;
        } else if (index < less.length + split) {
            more[index] = element;
        } else {
            add(element);
        }
    }

    public int size() {
        if (more == null) {
            return 0;
        }
        if (less == null) {
            return 1;
        }
        return less.length + split;
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
