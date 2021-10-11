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
        NasaPhotos example = new NasaPhotos();
        example.setImage("https://api.nasa.gov/planetary/earth/imagery?lon=-95.33&lat=29.78&date=2018-01-01&dim=0.15&api_key=ARrHj7iS8nSPDazyFPamTbU1N0rmQsrQyggRUSrg");
        example.setLongitude("95.33");
        example.setLatitude("29.78");
        dataset.add(example);
        NasaPhotos example2 = new NasaPhotos();
        example2.setImage("https://api.nasa.gov/planetary/earth/imagery?lon=-95.22&lat=29.33&date=2018-01-01&dim=0.15&api_key=ARrHj7iS8nSPDazyFPamTbU1N0rmQsrQyggRUSrg");
        example2.setLongitude("95.22");
        example2.setLatitude("29.33");
        dataset.add(example2);
    }
}
