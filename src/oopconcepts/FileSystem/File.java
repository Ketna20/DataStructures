package oopconcepts.FileSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class File extends Item {

    private String content;
    private int size;

    public File(String name, Directory parent) {
        super(name, parent);
    }

    @Override
    public long size() {
        return size;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
