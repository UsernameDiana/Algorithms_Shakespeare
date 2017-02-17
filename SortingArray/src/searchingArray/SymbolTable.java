package searchingArray;

public interface SymbolTable<K, V> {
    
    void put (K key, V value);
        V get (K key);
        int size();
        Iterable<K> keys();
        
        default void delete(K key)
        {
            put(key, null);
        }
        
    default boolean contains(K key)
    {
    return get(key) != null;
    }
    
    default boolean isEmty()
    {
    return size() == 0;
    }
    
    }
