
package searchingArray;

public class mainSearch {
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
