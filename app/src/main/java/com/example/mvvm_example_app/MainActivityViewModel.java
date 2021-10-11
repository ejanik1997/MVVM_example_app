package com.example.mvvm_example_app;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

     private MutableLiveData<List<NasaPhotos>> nasa_photos;
     private NasaPhotosRepo repository;

     public void init(){
         if(nasa_photos != null){
             return;
         }
         repository = NasaPhotosRepo.getInstance();
         nasa_photos =  repository.getNasaPhotos();
     }

     public LiveData<List<NasaPhotos>> getNasaPhotos(){
         return nasa_photos;
     }
}
