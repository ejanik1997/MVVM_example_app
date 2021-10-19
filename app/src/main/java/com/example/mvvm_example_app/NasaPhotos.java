package com.example.mvvm_example_app;


import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class NasaPhotos {
    private static final String TAG = "NasaPhotos";
    private String image;
    private String longitude;
    private String latitude;

    public NasaPhotos() {}

    public NasaPhotos(String longitude, String latitude, String key){
        //String key = getApiKey();
        this.longitude = longitude;
        this.latitude = latitude;
        this.image = "https://api.nasa.gov/planetary/earth/imagery?lon=-"+longitude+"&lat="+latitude+"&date=2018-01-01&dim=0.15&api_key=" + key;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


}
