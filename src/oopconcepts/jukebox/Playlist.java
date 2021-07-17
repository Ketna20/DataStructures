package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

import java.util.List;

public class Playlist {
    private Song song;

    private final List<Song> songs;


    public Playlist(Song song, List<Song> songs) {
        this.song = song;
        this.songs = songs;
    }

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    protected void addSong(Song song) {
        this.songs.add(song);
    }

    protected void removeSong(Song song) {
        this.songs.remove(song);
    }

    protected void shuffle() {

    }

    protected Song getNextSong() {
        return null;
    }

    protected Song getPrevSong() {
        return null;
    }
}
