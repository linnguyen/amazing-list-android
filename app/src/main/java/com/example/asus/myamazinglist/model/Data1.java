package com.example.asus.myamazinglist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data1 {
    @SerializedName("image")
    @Expose
    private String image;

    public Data1(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
