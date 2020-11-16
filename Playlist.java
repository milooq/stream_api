package com.company;

import java.util.ArrayList;

public class Playlist {

    String owner;
    ArrayList<Album> albums;

    public Playlist(String owner, ArrayList<Album> albums) {
        this.owner = owner;
        this.albums = albums;
    }
}
