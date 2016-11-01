package com.example.isen.audioplayer;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import java.util.ArrayList;

//Additionnal import

/**
 * DD
 **/

public class MusicService extends Service implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener {

    //variable for the inenr Binder class
    private final IBinder musicBind = new MusicBinder();
    //media player
    private MediaPlayer player;
    //song list
    private ArrayList<Song> songs;
    //current position
    private int songPosn;

    /**
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    /**
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        player.stop();
        player.release();
        return false;
    }

    /**
     *
     */
    public void onCreate() {
        //create the service
        super.onCreate();
        //initialize position
        songPosn = 0;
        //create player
        player = new MediaPlayer();

        initMusicPlayer();
    }

    /**
     *
     */
    public void initMusicPlayer() {
        //set player properties
        player.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }

    /**
     * @param theSongs
     */
    public void setList(ArrayList<Song> theSongs) {
        songs = theSongs;
    }

    /**
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    /**
     * @param mp
     * @param what
     * @param extra
     * @return
     */
    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    /**
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {
        //start playback
        mp.start();
    }

    /**
     *
     */
    public void playSong() {
        //play a song
        player.reset();

        //get song
        Song playSong = songs.get(songPosn);
        //get id
        long currSong = playSong.getID();
        //set uri
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                currSong);

        try {
            player.setDataSource(getApplicationContext(), trackUri);
        } catch (Exception e) {
            Log.e("MUSIC SERVICE", "Error setting data source", e);
        }

        player.prepareAsync();
    }

    /**
     * @param songIndex
     */
    public void setSong(int songIndex) {
        songPosn = songIndex;
    }

    /**
     *
     */
    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }
}
