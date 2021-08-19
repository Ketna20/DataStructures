package intervwPrep;
/*
 * ketnakhalasi created on 8/18/21
 * */

import java.util.*;

public class BasicMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    @SuppressWarnings("unchecked")
    private MapEntry<K, V>[] entries = new MapEntry[DEFAULT_CAPACITY];

    public V get(K key) {
        for(int i=0; i<size; i++) {
            if(entries[i] != null) {
                if(entries[i].getKey().equals(key)){
                    return entries[i].getValue();
                }
            }
        }
        return null;
    }
    public void put(K key, V value) {
        boolean success = true;
        for(int i=0; i< size; i++) {
            if(entries[i].getKey().equals(key)){
                entries[i].setValue(value);
                success = false;
            }
        }
        if(success) {
            checkCapacity();
            entries[size++] = new MapEntry<>(key, value);
        }
    }

    private void checkCapacity() {
        if(size == entries.length) {
            int newSize = entries.length * 2;
            entries = Arrays.copyOf(entries, newSize);
        }
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        for(int i=0; i<size; i++) {
            if(entries[i].getKey().equals(key)) {
                entries[i] = null;
                 size--;
                 condenseArray(i);
            }
        }
    }

    private void condenseArray(int start) {
        int i;
        for(i = start; i < size; i++) {
            entries[i] = entries[i+1];
        }
        entries[i] = null;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for(int i=0; i<size; i++) {
            set.add(entries[i].getKey());
        }
        return set;
    }

    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        for(int i=0; i<size; i++) {
            list.add(entries[i].getValue());
        }
        return list;
    }

    public String toString() {
        return Arrays.toString(entries);
    }
}
