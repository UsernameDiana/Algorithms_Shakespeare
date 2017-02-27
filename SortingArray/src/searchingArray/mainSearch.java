
package searchingArray;

public class mainSearch {
    public static void main(String[] args) {
        FlexibleArray<Integer> list = new FlexibleArray<>();
        // ArrayList<Integer> list = new ArrayList();

        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long t1 = System.currentTimeMillis();

        System.out.println("Time: " + ((t1 - t0) / 1000.0));
        System.out.println("Value at index 123456: " + list.get(123456));
        
//        
//        ST<String, Integer> st;
//        st = new ST<String, Integer>();
//        
//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            String key = StdIn.readString();
//            st.put(key, i);
//        }
//        for (String s : st.keys()) {
//            StdOut.println(s + " " + st.get(s));
//        }
//        
    }
}
