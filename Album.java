package com.company;

import java.util.ArrayList;

public class Album {

    String title;
    ArrayList <Song> songs;
    int year;

    public Album(String title, ArrayList<Song> songs, int year) {
        this.title = title;
        this.songs = songs;
        this.year = year;
    }
}
