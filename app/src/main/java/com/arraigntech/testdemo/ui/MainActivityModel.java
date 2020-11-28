package com.arraigntech.testdemo.ui;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.arraigntech.testdemo.network.ListItemRepository;
import com.arraigntech.testdemo.ui.data.ResultPojo;

import java.util.List;

public class MainActivityModel extends ViewModel {


    private long lastChange = 0;
    private ListItemRepository listItemRepository;
    private MutableLiveData<Boolean> stringMutableLiveData = new MutableLiveData<>();

    public LiveData<Boolean> getStringData() {
        return stringMutableLiveData;
    }

    private LiveData<List<ResultPojo.Items>> listPojoLiveData;

    public void init() {
        listItemRepository = new ListItemRepository();
        listPojoLiveData = listItemRepository.getResponseLiveData();
    }


    public void onUsernameTextChanged(CharSequence text) {
        if (text.length() < 3) {
            stringMutableLiveData.postValue(true);
        } else {
            /*new Handler().postDelayed(() -> {
                if (System.currentTimeMillis() - lastChange >= 300) {

                }
            }, 300);
            lastChange = System.currentTimeMillis();*/
            stringMutableLiveData.postValue(false);
            listItemRepository.searchMovies(text.toString());

        }
    }

    public LiveData<List<ResultPojo.Items>> getMoviesListPojoLiveData() {
        if (listPojoLiveData == null) {
            listPojoLiveData = listItemRepository.getResponseLiveData();
        }
        return listPojoLiveData;
    }


}
