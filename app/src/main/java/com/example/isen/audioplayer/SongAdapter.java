package com.example.isen.audioplayer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * DD : referencer les chansons dans l'affichage de la liste
 */

public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    public SongAdapter(Context c, ArrayList<Song> theSongs) {
        songs = theSongs;
        /*
        * permet de referencier sous forme de chaine de caractere
        * le titre et l'artiste dans le TextView du layout-->song (mise en page principale)
        * */
        songInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return songs.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return songs.get(arg0).getID();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // Changement
        //public View getView(int position, View convertView, ViewGroup parent) {
        //map to song layout
        //LinearLayout songLay = (LinearLayout) songInf.inflate(R.layout.song, parent, false);

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