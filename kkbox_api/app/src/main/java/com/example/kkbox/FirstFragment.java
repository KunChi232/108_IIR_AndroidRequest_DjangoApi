package com.example.kkbox;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    Button like, unlike, search;
    RetrofitRequst retrofitRequst;
    //接收 user_like 為 Like or Unlike 中所有歌曲名稱及歌手


    public FirstFragment()
    {

    }
    // get instance
    public static FirstFragment newInstance()
    {
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        like = (Button)view.findViewById(R.id.like);//
        unlike = (Button)view.findViewById(R.id.unlike);
        search = view.findViewById(R.id.search);
        //retrofitRequst = RetrofitRequst.getInstance();

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取得user_like為like的歌曲及歌手
                RetrofitInterface retrofitInterface = RetrofitRequst.getInstance().getRetrofitInterface();
                retrofitInterface.getSongList("like")
                        .enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                JsonObject response_object = response.body();

                                if(response.isSuccessful())
                                {
                                    Log.d("song",response_object.get("songs").toString());
                                    Log.d("artist",response_object.get("artists").toString());

                                    Song songs = new Gson().fromJson(response_object,Song.class);
                                    Log.d("song",songs.getArtistList().toString());
                                    Bundle bundle = new Bundle();

                                    //將取得的資訊加入到bundle後至second fragment內顯示
                                    String[] songs_name = new String[songs.getSongList().size()];
                                    String[] artist_name = new String[songs.getArtistList().size()];
                                    bundle.putStringArray("songs",songs.getSongList().toArray(songs_name));
                                    bundle.putStringArray("artists",songs.getArtistList().toArray(artist_name));
                                    SecondFragment fragment = SecondFragment.newInstance(bundle);
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.main, fragment)
                                            .addToBackStack(fragment.getClass().getName()).commit();
                                }
                                else
                                {
                                    Log.d("response","response failed");
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Log.d("response fail",call.request().method());
                                Log.d("response fail",call.request().url().toString());
                                Log.d("response fail","unsuccessful at getting Song and Artist");
                                Log.d("response fail",t.getMessage());
                            }
                        });

            }
        });

        unlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取得user_like為like的歌曲及歌手
                RetrofitInterface retrofitInterface = RetrofitRequst.getInstance().getRetrofitInterface();
                retrofitInterface.getSongList("unlike")
                        .enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                JsonObject response_object = response.body();

                                if(response.isSuccessful())
                                {
                                    Log.d("song",response_object.get("songs").toString());
                                    Log.d("artist",response_object.get("artists").toString());

                                    Song songs = new Gson().fromJson(response_object,Song.class);
                                    Log.d("song",songs.getArtistList().toString());
                                    Bundle bundle = new Bundle();

                                    //將取得的資訊加入到bundle後至second fragment內顯示
                                    String[] songs_name = new String[songs.getSongList().size()];
                                    String[] artist_name = new String[songs.getArtistList().size()];
                                    bundle.putStringArray("songs",songs.getSongList().toArray(songs_name));
                                    bundle.putStringArray("artists",songs.getArtistList().toArray(artist_name));
                                    SecondFragment fragment = SecondFragment.newInstance(bundle);
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.main, fragment)
                                            .addToBackStack(fragment.getClass().getName()).commit();
                                }
                                else
                                {
                                    Log.d("response","response failed");
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Log.d("response fail",call.request().method());
                                Log.d("response fail",call.request().url().toString());
                                Log.d("response fail","unsuccessful at getting Song and Artist");
                                Log.d("response fail",t.getMessage());
                            }
                        });

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitInterface retrofitInterface = RetrofitRequst.getInstance().getRetrofitInterface();
                retrofitInterface.searchSong("rain")
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("search failed", t.getMessage());
                            }
                        });
            }
        });
        return view;
    }
}
