package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

public class Jukebox implements Selector {

    private CDPlayer cdPlayer;

    public Jukebox(CDPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    @Override
    public void nextSongBtn() {
        System.out.println("Playing next song ...");
    }

    @Override
    public void prevSongBtn() {
        System.out.println("Playing previous song ...");
    }

    @Override
    public void addSongToPlaylistBtn() {

    }

    @Override
    public void removeSongFromPlaylistBtn() {

    }

    @Override
    public void shuffleBtn() {

    }
}
