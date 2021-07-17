package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

public class User {

    private final Jukebox jukebox;

    public User(Jukebox jukebox) {
        this.jukebox = jukebox;
    }

    public Jukebox getJukebox() {
        return jukebox;
    }
}
