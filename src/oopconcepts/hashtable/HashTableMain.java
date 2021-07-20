package oopconcepts.hashtable;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class HashTableMain {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Put some key-value
        hashTable.put("ana", "ana".toUpperCase());
        hashTable.put("alia", "alia".toUpperCase());
        hashTable.put("aish", "aish".toUpperCase());
        hashTable.put("ansh", "ansh".toUpperCase());
        hashTable.put("raag", "raag".toUpperCase());
        hashTable.put("dharm", "dharm".toUpperCase());
        hashTable.put("ketu", "ketu".toUpperCase());

        // The following keys should exists
        System.out.println("get(ana) : " + hashTable.get("ana"));
        System.out.println("get(alia) : " + hashTable.get("alia"));
        System.out.println("get(ansh) : " + hashTable.get("ansh"));
        System.out.println("get(dharm) : " + hashTable.get("dharm"));

        //should not exists
        System.out.println("get(kk) : " + hashTable.get("kk")); //null
        System.out.println("get(aa) : " + hashTable.get("aa")); //null
    }
}
