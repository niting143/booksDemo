package com.arraigntech.testdemo.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.arraigntech.testdemo.ui.data.ResultPojo;

import java.util.Arrays;
import java.util.List;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListItemRepository {

    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";
    private ListItemService listItemService;

    private MutableLiveData<List<ResultPojo.Items>> listPojoMutableLiveData = new MutableLiveData<>();

    public ListItemRepository() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS))
                .build();
        listItemService = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ListItemService.class);
    }


    public void searchMovies(String keyword) {
        listItemService.searchMovies(keyword)
                .enqueue(new Callback<ResultPojo>() {
                    @Override
                    public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
                        if (response.body() != null) {
                            listPojoMutableLiveData.postValue(response.body().items);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultPojo> call, Throwable t) {
                        Log.e("Error", "" + t.getMessage());
                        listPojoMutableLiveData.postValue(null);
                    }

                });
    }

    public LiveData<List<ResultPojo.Items>> getResponseLiveData() {
        return listPojoMutableLiveData;
    }
}
