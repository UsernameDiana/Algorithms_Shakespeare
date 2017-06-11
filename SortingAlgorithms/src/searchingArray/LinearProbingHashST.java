package searchingArray;

public class LinearProbingHashST<Key, Value> {

    private int N; // number of key-value pairs in the table
    private int M = 16; // SIZE -- of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    } 

    private LinearProbingHashST(int cap) {
        this.M = cap;                       // I made a constructor that sets the value of M (the initial size)
        keys = (Key[]) new Object[M];       // to the incomming value = cap, cap comes from the rezise method (M * 2)
        vals = (Value[]) new Object[M];
    }
   
//  Hash function - Compound keys. If the key type has multiple integer fields, we can typically mix them
//  together in the way just described for String values.
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    } // See page 474.

    public void put(Key key, Value val) {
        if (N >= M / 2) {
            resize(2 * M); // double M (see text)
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
}
