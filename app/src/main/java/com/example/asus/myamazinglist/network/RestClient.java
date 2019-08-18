package com.example.asus.myamazinglist.network;

import android.content.Context;

import com.example.asus.myamazinglist.mock.FakeInterceptor;
import com.example.asus.myamazinglist.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RestClient {

    private static RestService mRestService = null;

    public static RestService getClient(Context context) {
        if (mRestService == null) {
            final OkHttpClient client = new OkHttpClient
                    .Builder()
                    .addInterceptor(new FakeInterceptor(context))
                    .build();

            final Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();

            mRestService = retrofit.create(RestService.class);
        }
        return mRestService;
    }
}