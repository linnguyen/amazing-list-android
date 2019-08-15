package com.example.asus.myamazinglist.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.asus.myamazinglist.R;
import com.example.asus.myamazinglist.adapters.DataAdapter;
import com.example.asus.myamazinglist.adapters.DataHorizontalAdapter;
import com.example.asus.myamazinglist.model.Data;
import com.example.asus.myamazinglist.model.Movie;
import com.example.asus.myamazinglist.ui.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewInterface,
        DataHorizontalAdapter.HorizontalAdapterOnClickHandler {
    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView rcvVertical;
    private RecyclerView rcvHorizontal;
    private Toolbar toolbar;

    private DataAdapter mVerticalAdapter;
    private DataHorizontalAdapter mHorizontalAdapter;
    private MainPresenter presenter;
    private List<Data> DataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        rcvVertical = findViewById(R.id.rcv_vertical);
        rcvHorizontal = findViewById(R.id.rcv_horizontal);

        mVerticalAdapter = new DataAdapter(getApplicationContext());
        mHorizontalAdapter = new DataHorizontalAdapter(getApplicationContext(), this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvVertical.setLayoutManager(mLayoutManager);
        rcvVertical.setAdapter(mVerticalAdapter);
        rcvHorizontal.setLayoutManager(layoutManager);
        rcvHorizontal.setAdapter(mHorizontalAdapter);

        //get data from server themoviedb
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void displayHorizontalListData(List<Movie> lstData) {
        Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_LONG).show();
        mHorizontalAdapter.setData(lstData);
    }

    @Override
    public void displayVerticalListData(List<Movie> lstData) {
        mVerticalAdapter.setData(lstData);
    }

    @Override
    public void displayError(String s) {

    }
}
