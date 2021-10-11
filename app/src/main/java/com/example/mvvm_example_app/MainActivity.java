package com.example.mvvm_example_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //ARrHj7iS8nSPDazyFPamTbU1N0rmQsrQyggRUSrg
    private ArrayList<String> main_arr_images = new ArrayList<>();
    private ArrayList<String> main_arr_longitude = new ArrayList<>();
    private ArrayList<String> main_arr_latitude = new ArrayList<>();
    private Context ma_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: start");

        initialize_bitmaps();

    }
    
    private void initialize_bitmaps(){
        Log.d(TAG, "initialize_bitmaps: preparing bitmaps");

        main_arr_images.add("https://api.nasa.gov/planetary/earth/imagery?lon=-95.33&lat=29.78&date=2018-01-01&dim=0.15&api_key=ARrHj7iS8nSPDazyFPamTbU1N0rmQsrQyggRUSrg");
        main_arr_longitude.add("95.33");
        main_arr_latitude.add("29.78");
        initialize_recyclerview();
    }

    private void initialize_recyclerview(){
        Log.d(TAG, "initialize_recyclerview: preparing recyclerview");
        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter( main_arr_images, main_arr_longitude, main_arr_latitude, this);
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }
}