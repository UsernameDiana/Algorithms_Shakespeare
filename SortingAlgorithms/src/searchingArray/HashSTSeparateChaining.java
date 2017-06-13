package searchingArray;

//This basic symbol-table implementation maintains an array of linked lists, using a hash function to
//choose a list for each key. 

public class HashSTSeparateChaining<Key, Value> { // items that collide are chained together in separate linked lists.

    private int N; // number of key-value pairs
    private int M; // hash table size
    private LinkedSymbolTable<Key, Value>[] st; // array of ST objects

    public HashSTSeparateChaining() {
        this(997);
    }

    public HashSTSeparateChaining(int M) { // Create M linked lists.
        this.M = M;
        st = (LinkedSymbolTable<Key, Value>[]) new LinkedSymbolTable[M];
        for (int i = 0; i < M; i++) {
            st[i] = new LinkedSymbolTable();
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
