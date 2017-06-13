package searchingArray;

/**
 *
 * @author diana
 */
public class SymbolTableFlexArray<K, V> {

    private FlexibleArray<K> keys;
    private FlexibleArray<V> values;
    private int n = 0;

    public SymbolTableFlexArray() {
        keys = new FlexibleArray<>();
        values = new FlexibleArray<>();
    }

    public int size() {
        return n;
    }

    public void put(K key, V val) {
        for (int i = 0; i < keys.size(); i++) {
            if (key.equals(keys.get(i))) {
                values.set(i, val);
                return;
            }
        }
        if (n >= values.size()) {

            for (int j = 0; j < values.size(); j++) {
                values.add(values.get(j));
                values.set(j, val);
            }
            for (int k = 0; k < keys.size(); k++) {
                keys.add(keys.get(k));
                keys.set(k, key);
            }
        } else {
            System.out.println("HERE");
            values.set(n, val);
            keys.set(n, key);
            n++;
        }
    }

    public V get(K key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys.get(i))) {
                return values.get(i);
            }
        }
        return null;
    }

    public void print() {

        System.out.println(n);
        for (int i = 0; i < n; i++) {

            System.out.println(keys.get(i) + " - " + values.get(i));
        }
    }

    public boolean contains(K word) {
        return get(word) != null;
    }
}
