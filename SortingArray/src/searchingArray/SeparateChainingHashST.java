package searchingArray;




// HASH is map key to the index
// building a linked list for each table
public class SeparateChainingHashST<Key, Value> {

    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) { // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

//  Hash function - Compound keys. If the key type has multiple integer fields, we can typically mix them
//  together in the way just described for String values.
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    // all the keys in the table
    public Iterable<Key> keys() {
        return null;
    } // See Exercise 3.4.19.

}
