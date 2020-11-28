package com.arraigntech.testdemo.network;

import com.arraigntech.testdemo.ui.data.ResultPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListItemService {
    @GET("volumes")
    Call<ResultPojo> searchMovies(@Query("q") String text);
}
