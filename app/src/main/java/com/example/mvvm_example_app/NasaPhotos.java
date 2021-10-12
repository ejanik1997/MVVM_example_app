package com.example.mvvm_example_app;

public class NasaPhotos {
    private String image;
    private String longitude;
    private String latitude;

    public NasaPhotos() {}

    public NasaPhotos(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.image = "https://api.nasa.gov/planetary/earth/imagery?lon=-"+longitude+"&lat="+latitude+"&date=2018-01-01&dim=0.15&api_key=ARrHj7iS8nSPDazyFPamTbU1N0rmQsrQyggRUSrg";

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
