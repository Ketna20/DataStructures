package oopconcepts.jukebox;
/*
 * ketnakhalasi created on 7/15/21
 * */

import java.util.Set;

public class CDPlayer {
    private CD cd;
    private final Set<CD> cds;
    private final Playlist playlist;

    public CDPlayer(Set<CD> cds, Playlist playlist) {
        this.cds = cds;
        this.playlist = playlist;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public Set<CD> getCds() {
        return cds;
    }

    public Playlist getPlaylist() {
        return playlist;
    }
}
