package com.example.kkbox;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    public String base_url = "http://10.0.2.2:8000/";

    @GET("{user_like}")
    Call<JsonObject> getSongList(@Path("user_like") String userLike);
    @GET("search")
    Call<ResponseBody> searchSong(@Query("song_name") String song_name);
}
