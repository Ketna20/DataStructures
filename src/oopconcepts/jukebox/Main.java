package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

import com.sun.tools.javac.util.List;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        CD cd1 = new CD();
        Song s1 = new Song("Song 1", cd1);
        Song s2 = new Song("Song 2", cd1);
        cd1.setSongs(List.of(s1,s2));

        CD cd2 = new CD();
        Song s3 = new Song("Song 3", cd2);
        Song s4 = new Song("Song 4", cd2);
        cd1.setSongs(List.of(s3,s4));

        Set<CD> cds = new HashSet<CD>() {{
            add(cd1);
            add(cd2);
        }
        };
        Playlist playlist = new Playlist(List.of(s1, s2, s3, s4));
        CDPlayer cdPlayer = new CDPlayer(cds, playlist);
        Jukebox jukebox = new Jukebox(cdPlayer);
        User user = new User(jukebox);
        user.getJukebox().nextSongBtn();
    }
}
