package com.example.kkbox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Song {

    @Expose
    @SerializedName("songs")
    private ArrayList<String> songs = new ArrayList<String>();

    @Expose
    @SerializedName("artists")
    private ArrayList<String> artists = new ArrayList<String>();
    public Song(ArrayList<String>songs, ArrayList<String>artists)
    {
        this.songs = songs;
        this.artists = artists;
    }
    public ArrayList<String> getSongList()
    {
        return songs;
    }

    public ArrayList<String> getArtistList()
    {
        return artists;
    }



}
