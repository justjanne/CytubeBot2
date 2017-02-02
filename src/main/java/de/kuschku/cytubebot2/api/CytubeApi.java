package de.kuschku.cytubebot2.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CytubeApi {
    @GET("socketconfig/{channel}.json")
    Call<ServerList> serverList(@Path("channel") String channel);
}
