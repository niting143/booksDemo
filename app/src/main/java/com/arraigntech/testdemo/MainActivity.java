package com.arraigntech.testdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.arraigntech.testdemo.databinding.ActivityMainBinding;
import com.arraigntech.testdemo.ui.MainActivityModel;
import com.arraigntech.testdemo.ui.adapters.ItemListAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityModel model;
    private ItemListAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        itemListAdapter = new ItemListAdapter();
        model = new ViewModelProvider(this).get(MainActivityModel.class);
        model.init();
        binding.setMainModel(model);
        model.getStringData().observe(this, s -> {
            if (!s) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.GONE);
                itemListAdapter.setResults(null);
            }
        });
        model.getMoviesListPojoLiveData().observe(this, listPojo -> {
            binding.progressBar.setVisibility(View.GONE);
            if (listPojo != null) {
                itemListAdapter.setResults(listPojo);
                binding.recyclerRV.setAdapter(itemListAdapter);
            } else {
                binding.progressBar.setVisibility(View.GONE);
                itemListAdapter.setResults(null);
            }
        });


    }
}