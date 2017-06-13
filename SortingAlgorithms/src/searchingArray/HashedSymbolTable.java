
package searchingArray;

/**
 *
 * @author diana
 */
public class HashedSymbolTable<K,V> {
     private int size;
    private LinkedSymbolTable<K, V>[] st;
    
    public HashedSymbolTable() {
        this(997);
    }

    public HashedSymbolTable(int tSize) {
        this.size = tSize;
        st = (LinkedSymbolTable<K, V>[]) new LinkedSymbolTable[tSize];
        for (int i = 0; i < tSize; i++) {
            st[i] = new LinkedSymbolTable();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public void put(K key, V val) {
        st[hash(key)].put(key, val); 
    }
    
    public void print() {
        
        for (int i = 0; i < st.length; i++) {
           st[i].print();
        }
        
    }

    boolean contains(K word) {
        return get(word) != null;
    }
}
