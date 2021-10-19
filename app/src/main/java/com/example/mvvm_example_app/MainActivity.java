package com.example.mvvm_example_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<NasaPhotos> nasa_photos = new ArrayList<>();
    private Context ma_context;
    private RecyclerView main_recycler_view;
    private RecyclerViewAdapter main_adapter;
    private MainActivityViewModel main_activity_vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: start");
        main_recycler_view = findViewById(R.id.recycler_view);
        main_activity_vm = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        main_activity_vm.init();
        main_activity_vm.getNasaPhotos().observe(this, new Observer<List<NasaPhotos>>() {
            @Override
            public void onChanged(List<NasaPhotos> nasaPhotos) {
                main_adapter.notifyDataSetChanged();
            }
        });

        initialize_recyclerview();

    }

    private void initialize_recyclerview(){
        Log.d(TAG, "initialize_recyclerview: preparing recyclerview");
        main_adapter = new RecyclerViewAdapter( this, main_activity_vm.getNasaPhotos().getValue());
        RecyclerView.LayoutManager linear_layout_manager = new LinearLayoutManager(this);
        main_recycler_view.setLayoutManager(linear_layout_manager);
        main_recycler_view.setAdapter(main_adapter);
    }
}