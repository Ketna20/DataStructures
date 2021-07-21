package oopconcepts.FileSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

import java.util.ArrayList;
import java.util.List;

public class Directory extends Item {
    protected List<Item> items;

    public Directory(String name, Directory parent) {
        super(name, parent);
        items = new ArrayList<>();
    }

    @Override
    public long size() {
        return 0;
    }

    public int countFiles() {
        return items.size();
    }
     protected boolean deleteItem(Item item) {
        return items.remove(item);
     }

     protected void addEntry(Item item) {
        items.add(item);
     }

     protected List<Item> getItems() {
        return items;
     }
}
