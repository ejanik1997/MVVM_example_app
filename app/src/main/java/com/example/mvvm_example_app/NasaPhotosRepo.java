package com.example.mvvm_example_app;

import android.net.Uri;
import android.os.FileUtils;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NasaPhotosRepo {
    private static final String TAG = "NasaPhotosRepo";
    private static NasaPhotosRepo instance;
    private static String key = getApiKey();
    private ArrayList<NasaPhotos> dataset = new ArrayList<>();

    public static NasaPhotosRepo getInstance(){
        if(instance == null){
            instance = new NasaPhotosRepo();
        }
        return instance;
    }

    public MutableLiveData<List<NasaPhotos>> getNasaPhotos(){
        setNasaPhotos();

        MutableLiveData<List<NasaPhotos>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    private void setNasaPhotos(){
        NasaPhotos example = new NasaPhotos("95.33", "29.78", key);
        dataset.add(example);
        NasaPhotos example2 = new NasaPhotos("95.22", "29.33", key);
        dataset.add(example2);
    }
    public static String getApiKey(){
        /*TODO: why does the key always end up being null?
                also fix that path later, but simply getting currentDir() is causing erros
        */
        String key = null;
        Path path = Paths.get("/src/main/java/com/example/mvvm_example_app/key.txt");
        try {
            key = Files.readAllLines(path).get(0);
        }
        catch (IOException | NullPointerException e){
            e.getStackTrace();
        }
        return key;
    }
}
