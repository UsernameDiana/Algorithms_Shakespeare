
package searchingArray;

public class mainSearch {
    public static void main(String[] args) 
    {
        FlexibleArray<Word> arrayST = new FlexibleArray<>();
        // ArrayList<Integer> list = new ArrayList();
        
        LinearProbingHashST<String, Integer> lpHash = new LinearProbingHashST<>();
        SeparateChainingHashST<String, Integer> scHash = new SeparateChainingHashST<>();
        SequentialSearchST<String, Integer> ss = new SequentialSearchST<>();

        long t0 = System.currentTimeMillis();
//        for (String i = null; i < 1_000_000; i++) {
//            arrayST.add(i);
//        }
        long t1 = System.currentTimeMillis();
        
        System.out.println("Time Milliseconds: " + ((t1 - t0) / 1000.0));

        long t2 = System.nanoTime();
        arrayST.get(123456);
        long t3 = System.nanoTime();
       
        System.out.println("ArraySymbolTable Value at index 123456: "+ ((t3-t2)/1000.0) + " Nanoseconds");



      
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
    }
}
