package com.example.isen.audioplayer;

/**
 * DD : Class pour la gestion des titres.
 */

public class Song {

    private long id;
    private String title;
    private String artist;

    // Constructeur pour l'instanciation des variables d'instances.
    public Song(long songID, String songTitle, String songArtist) {
        id = songID;
        title = songTitle;
        artist = songArtist;
    }

    public long getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
