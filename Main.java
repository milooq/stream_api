package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Singer[] singers = {
            new Singer("Eminem", Singer.Country.USA, Singer.Type.SOLO),
            new Singer("Escape the fate", Singer.Country.USA, Singer.Type.BAND),
            new Singer("Silverstein", Singer.Country.USA, Singer.Type.BAND),
            new Singer("ЛСП", Singer.Country.RUSSIA, Singer.Type.BAND),
            new Singer("Король и ШУТ", Singer.Country.RUSSIA, Singer.Type.BAND),
            new Singer("Miley Cyrus", Singer.Country.USA, Singer.Type.SOLO),
            new Singer("RAMMSTEIN", Singer.Country.GERMANY, Singer.Type.BAND)
        };

        Song[] songs = {
                new Song("Lose Yourself", singers[0], 326, Song.Genre.HIP_HOP),
                new Song("Godzilla", singers[0], 210, Song.Genre.HIP_HOP),

                new Song("You are so beautiful", singers[1], 167, Song.Genre.POST_HARDCORE),
                new Song("Let it go", singers[1], 209, Song.Genre.POST_HARDCORE),

                new Song("My Disaster", singers[2], 228, Song.Genre.POST_HARDCORE),
                new Song("Still Dreaming", singers[2], 235, Song.Genre.POST_HARDCORE),

                new Song("Монетка", singers[3], 200, Song.Genre.HIP_HOP),
                new Song("Канкан", singers[3], 253, Song.Genre.HIP_HOP),

                new Song("Танец злобного гения", singers[4], 236, Song.Genre.ROCK),
                new Song("Фокусник", singers[4], 310, Song.Genre.ROCK),

                new Song("Unholy", singers[5], 130, Song.Genre.POP),
                new Song("The most", singers[5], 253, Song.Genre.POP),

                new Song("PUPPE", singers[6], 326, Song.Genre.ROCK),
                new Song("DEUTSCHLAND", singers[6], 322, Song.Genre.ROCK),

                new Song("Lock it up", singers[0], 170, Song.Genre.HIP_HOP),
                new Song("Marsh", singers[0], 200, Song.Genre.HIP_HOP),

                new Song("D.R.E.A.M", singers[5], 190, Song.Genre.POP),
                new Song("Cattitude", singers[5], 189, Song.Genre.POP)
        };

        Album[] albums = {
                new Album("Curtain call", new ArrayList<Song> (Arrays.asList(songs[0])), 2005),
                new Album("Music to be murdered by", new ArrayList<Song> (Arrays.asList(songs[1], songs[14], songs[15])), 2020),
                new Album("This war is ours", new ArrayList<Song> (Arrays.asList(songs[2], songs[3])), 2008),
                new Album("This is how the wind shifts: Addendum", new ArrayList<Song> (Arrays.asList(songs[4], songs[5])), 2013),
                new Album("Tragic city", new ArrayList<Song> (Arrays.asList(songs[6], songs[7])), 2017),
                new Album("Театръ демона", new ArrayList<Song> (Arrays.asList(songs[8], songs[9])), 2010),
                new Album("She is coming", new ArrayList<Song> (Arrays.asList(songs[10], songs[11], songs[16], songs[17])), 2019),
                new Album("RAMMSTEIN", new ArrayList<Song> (Arrays.asList(songs[12], songs[13])), 2019)
        };

        Playlist[] myPlaylist = {
                new Playlist("Настя", new ArrayList<Album> (Arrays.asList(albums[4], albums[5], albums[6], albums[7]))),
                new Playlist("Sam", new ArrayList<Album> (Arrays.asList(albums[0], albums[1], albums[2], albums[3], albums[4])))
        };

        System.out.println("Все песни в жанре поп длины менее 190с");
        Stream<Song> ss = Arrays.stream(songs);
        ss.filter(x -> x.duration < 190)
        .filter(x -> x.g == Song.Genre.POP)
        .forEach(System.out::println);

        System.out.println("Все песни исполнителя Eminem");
        Stream<Song> se = Arrays.stream(songs);
        se.filter(x -> x.singer.name == "Eminem").forEach(System.out::println);

        System.out.println("Все песни в жанре Post Hardcore");
        Stream<Song> sl = Arrays.stream(songs);
        sl = sl.filter(x -> x.g == Song.Genre.POST_HARDCORE);
        int sum = sl.mapToInt(x -> x.duration).sum();
        System.out.println("Длительность: "+ sum / 60 + ":" + sum % 60);

        System.out.println("Все песни из плейлиста пользователя с именем Настя:");
        Stream<Playlist> sp = Arrays.stream(myPlaylist);
        sp = sp.filter(x -> x.owner == "Настя");
        sp.flatMap(x -> x.albums.stream()).flatMap(x -> x.songs.stream()).forEach(System.out::println);
    }
}
