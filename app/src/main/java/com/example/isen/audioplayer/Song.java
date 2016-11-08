package com.example.isen.audioplayer;

/**
 * DD : Class Modélisation des données d'un fichier audio.
 */

public class Song {

    private long id;
    private String title;
    private String artist;

    /**
     * Constructeurs : Instacier les variables d'instances.
     *
     * @param songID
     * @param songTitle
     * @param songArtist
     */
    public Song(long songID, String songTitle, String songArtist) {
        id = songID;
        title = songTitle;
        artist = songArtist;
    }

    /**
     * Get the ID.
     * @return id the ID
     */
    public long getID() {
        return id;
    }

    /**
     * Get the title.
     * @return title the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the artiste.
     * @return artist the artiste
     */
    public String getArtist() {
        return artist;
    }
}
