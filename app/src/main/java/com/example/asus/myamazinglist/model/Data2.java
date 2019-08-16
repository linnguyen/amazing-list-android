package com.example.asus.myamazinglist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data2 {
    @SerializedName("thumbnail")
    @Expose
    private String thumbNail;
    @SerializedName("title")
    @Expose
    private String title;

    public Data2(String thumbNail, String title) {
        this.thumbNail = thumbNail;
        this.title = title;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
