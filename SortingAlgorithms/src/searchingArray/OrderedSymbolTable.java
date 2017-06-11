package searchingArray;

// keeping the keys in order
public interface OrderedSymbolTable< K extends Comparable<K>, V> extends SymbolTable<K, V> {

    K min();

    K max();

    K floor(K key); // largest key less than or equal to key

    K ceiling(K key); // smallest key greater than or equal to key

    int rank(K key); // number of keys less than key

    K select(int rank); // key of rank k

    void deleteMin();

    void deleteMax();

    int size(K low, K high); // number of keys in [lo..hi]

    Iterable<K> keys(K low, K high);

}
