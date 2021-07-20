package oopconcepts.hashtable;
/*
 * ketnakhalasi created on 7/20/21
 * */

import java.util.Map;

public class HashTable<K, V> {
    private static final int SIZE = 16;
    private K key;
    private V value;

    private static final class HashEntry<K, V> {
        K key;
        V value;
        HashEntry<K, V> next;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HashEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    } //end HashEntry class

    private final HashEntry[] entries = new HashEntry[SIZE];

    public void put(K key, V value) {
        int hash = getHash(key);

        final HashEntry<K, V> hashEntry = new HashEntry(key, value);
        if(entries[hash] == null) {
            entries[hash] = hashEntry;
        } else { //collision => chaining
            HashEntry currentEntry = entries[hash];
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            currentEntry.next = hashEntry;
        }

    }

    public V get(K key) {
        int hash = getHash(key);
        System.out.println("Hash for "+ key +" : " + hash);
        if(entries[hash] != null) {
            HashEntry currentEntry = entries[hash];

            //check the entry linked list for matching the given 'key'
            while (currentEntry != null) {
                if(currentEntry.key.equals(key)) {
                    return (V) currentEntry.value;
                }
                currentEntry = currentEntry.next;
            }
        }

        return null;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }
}
