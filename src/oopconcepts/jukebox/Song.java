package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

public class Song {

    private final String title;

    private final CD cd;

    public Song(String title, CD cd) {
        this.title = title;
        this.cd = cd;
    }

    public String getTitle() {
        return title;
    }

    public CD getCd() {
        return cd;
    }
}
