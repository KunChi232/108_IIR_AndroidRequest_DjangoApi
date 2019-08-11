package com.example.kkbox;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    String[] songs ;
    String[] artists ;
    String user_like;
    RetrofitRequst retrofitRequst;
    private ListView listView;

    public  SecondFragment()
    {
        // Required empty public constructor
    }
    // for accept bundle
    public static SecondFragment newInstance(Bundle arg)
    {
        SecondFragment mFragment = new SecondFragment();
        mFragment.setArguments(arg);
        return mFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            songs = getArguments().getStringArray("songs");
            artists = getArguments().getStringArray("artists");
            //user_like = getArguments().getString("user_like");
        }*/
        //retrofitRequst = RetrofitRequst.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        if (getArguments() != null) {
            songs = getArguments().getStringArray("songs");
            artists = getArguments().getStringArray("artists");
            //user_like = getArguments().getString("user_like");
        }
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        //Song song_list = retrofitRequst.Request_SongNameAndArtist(user_like);

        //song_list.getArtistList().toArray(artists);
       // song_list.getSongList().toArray(songs);

        //將adapter中每首歌的資訊放進ListView中
        listView = (ListView) view.findViewById(R.id.list_view);
        MyAdapter myAdapter = new MyAdapter(this.getContext());
        listView.setAdapter(myAdapter);


        return view;
    }

    //自定義Adapter
    public class MyAdapter extends BaseAdapter
    {
        private LayoutInflater myInflater;
        public  MyAdapter(Context c)
        {
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount()
        {
            return songs.length;
        }
        @Override
        public Object getItem(int i)
        {
            return songs[i];
        }
        @Override
        public long getItemId(int i)
        {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            //將linear_lyaou.xml中的2個TextView加上歌曲名字及歌手名字
            view = myInflater.inflate(R.layout.linear_layout, null);
            TextView song_name = view.findViewById(R.id.song_name);
            TextView artist_name = view.findViewById(R.id.artist_name);

            song_name.setText(song_name.getText() + songs[i]);
            artist_name.setText(artist_name.getText() + artists[i]);

            return view;
        }
    }
}
