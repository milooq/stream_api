package com.company;

public class Song {

    String title;
    public Singer singer;
    public int duration;
    public Genre g;

    public Song(String title, Singer singer, int duration, Genre g) {
        this.title = title;
        this.singer = singer;
        this.duration = duration;
        this.g = g;
    }

    public enum Genre{
        ROCK, POP, HIP_HOP, POST_HARDCORE;
    }

    public String toString(){
        String output = "";
        output += title;
        output += " - ";
        output += singer;
        output += "\t" + duration / 60 + ":" + ((duration % 60 >= 10) ? duration % 60 : "0" + duration % 60);
        return output;
    }
}
