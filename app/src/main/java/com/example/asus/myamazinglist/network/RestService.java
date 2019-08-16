package com.example.asus.myamazinglist.network;


import com.example.asus.myamazinglist.model.Data1;
import com.example.asus.myamazinglist.model.Data2;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RestService {

    @GET("/data/api1")
    Observable<List<Data1>> getData1(@Query("api_key") String api_key);

    @GET("/data/api2")
    Observable<List<Data2>> getData2(@Query("api_key") String api_key);
}