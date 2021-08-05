package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

import java.util.List;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        CD cd1 = new CD();
        Song s1 = new Song("Song 1", cd1);
        Song s2 = new Song("Song 2", cd1);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        cd1.setSongs(songs);

        CD cd2 = new CD();
        Song s3 = new Song("Song 3", cd2);
        Song s4 = new Song("Song 4", cd2);
        List<Song> songs2 = new ArrayList<>();
        songs.add(s3);
        songs.add(s4);
        cd1.setSongs(songs2);

        Set<CD> cds = new HashSet<CD>() {{
            add(cd1);
            add(cd2);
        }
        };
        List<Song> allSongs = new ArrayList<>();
        allSongs.add(s1); allSongs.add(s2);
        allSongs.add(s3); allSongs.add(s4);
        Playlist playlist = new Playlist(allSongs);
        CDPlayer cdPlayer = new CDPlayer(cds, playlist);
        Jukebox jukebox = new Jukebox(cdPlayer);
        User user = new User(jukebox);
        user.getJukebox().nextSongBtn();
    }
}
