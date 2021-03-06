package com.example.isen.audioplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * DD : referencer les chansons dans l'affichage de la liste.
 */

public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    /**
     * Constructeur pour referencer les songs.
     *
     * @param c        the context
     * @param theSongs la liste des songs
     */
    public SongAdapter(Context c, ArrayList<Song> theSongs) {
        songs = theSongs;
        songInf = LayoutInflater.from(c);
    }

    /**
     * Get la taille de la liste.
     * @return la de la liste
     */
    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int arg0) {
        return songs.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return songs.get(arg0).getID();
    }

    /**
     * Get le bon titre et le bon artiste de la musique sur la liste.
     * @param position the position
     * @param view the view
     * @param viewGroup the viewGroup
     * @return songLay the song Layout
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //map to song layout
        LinearLayout songLay = (LinearLayout) songInf.inflate(R.layout.song, viewGroup, false);

        //get title and artist views
        TextView songView = (TextView) songLay.findViewById(R.id.song_title);
        TextView artistView = (TextView) songLay.findViewById(R.id.song_artist);
        //get song using position
        Song currSong = songs.get(position);
        //get title and artist strings
        songView.setText(currSong.getTitle());
        artistView.setText(currSong.getArtist());
        //set position as tag
        songLay.setTag(position);
        return songLay;
    }

}