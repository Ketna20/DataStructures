package oopconcepts.vendingmachine;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private Map<T, Integer> inventory = new HashMap<>();

    protected int getQuantity(T item) {
        Integer quantity = inventory.get(item);
        return quantity == null ? 0 : quantity;
    }

    protected boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }

    protected void clear() {}
    protected void add(T item) {}
    protected void put(T item, int quantity) {}
    protected void deduct(T item) {}
}
