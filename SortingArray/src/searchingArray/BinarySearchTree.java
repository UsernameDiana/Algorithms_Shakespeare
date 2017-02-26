package searchingArray;


// O(log n) this is good big O
public class BinarySearchTree<K extends Comparable<K>, V>
        implements SymbolTable<K, V> {

    private final K key;
    private V value;
    private BinarySearchTree<K, V> left;
    private BinarySearchTree<K, V> right;

    public BinarySearchTree(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void put(K key, V value) {
        switch (key.compareTo(this.key)) {
            case -1:
                if (left == null) {
                    left = new BinarySearchTree<>(key, value);
                } else {
                    left.put(key, value);
                }
                break;
            case 0:
                this.value = value;
                break;
            case 1:
                if (right == null) {
                    right = new BinarySearchTree<>(key, value);
                } else {
                    right.put(key, value);
                }
                break;
        }
    }

    public V get(K key) {
        if (key.compareTo(this.key) < 0) {
            if (left == null) {
                return null;
            }
            return left.get(key);
        } else if (key.compareTo(this.key) == 0) {
            return value;
        } else {
            if (right == null) {
                return null;
            }
            return right.get(key);
        }
    }

    @Override
    public int size() {
        return 1
                + (left == null ? 0 : left.size())
                + (right == null ? 0 : right.size());
    }

    @Override
    public Iterable<K> keys() {
        throw new UnsupportedOperationException("TBD");
    }

}
