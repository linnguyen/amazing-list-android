package com.example.asus.myamazinglist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data1 implements Parcelable {
    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("description")
    @Expose
    private String description;

    public Data1(String image, String description) {
        this.image = image;
        this.description = description;
    }

    protected Data1(Parcel in) {
        image = in.readString();
        description = in.readString();
    }

    public static final Creator<Data1> CREATOR = new Creator<Data1>() {
        @Override
        public Data1 createFromParcel(Parcel in) {
            return new Data1(in);
        }

        @Override
        public Data1[] newArray(int size) {
            return new Data1[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(description);
    }
}
