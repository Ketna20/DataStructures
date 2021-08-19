package intervwPrep;
/*
 * ketnakhalasi created on 8/18/21
 * */

public class MapEntry<K, V> {
    private final K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MapEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
