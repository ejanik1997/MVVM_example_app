package com.example.mvvm_example_app;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NasaPhotosRepo {
    private static NasaPhotosRepo instance;
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
        NasaPhotos example = new NasaPhotos("95.33", "29.78");
        dataset.add(example);
        NasaPhotos example2 = new NasaPhotos("95.22", "29.33");
        dataset.add(example2);
    }
}
