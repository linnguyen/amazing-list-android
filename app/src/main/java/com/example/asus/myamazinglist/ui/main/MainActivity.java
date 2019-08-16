package com.example.asus.myamazinglist.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asus.myamazinglist.R;
import com.example.asus.myamazinglist.adapters.DataHorizontalAdapter;
import com.example.asus.myamazinglist.adapters.DataVerticalAdapter;
import com.example.asus.myamazinglist.model.Data1;
import com.example.asus.myamazinglist.model.Data2;
import com.example.asus.myamazinglist.ui.webview.WebViewActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewInterface,
        DataHorizontalAdapter.HorizontalAdapterOnClickHandler {
    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView rcvVertical;
    private RecyclerView rcvHorizontal;

    private DataVerticalAdapter mVerticalAdapter;
    private DataHorizontalAdapter mHorizontalAdapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(getApplicationContext(), this);

        rcvVertical = findViewById(R.id.rcv_vertical);
        rcvHorizontal = findViewById(R.id.rcv_horizontal);

        mVerticalAdapter = new DataVerticalAdapter(getApplicationContext());
        mHorizontalAdapter = new DataHorizontalAdapter(getApplicationContext(), this);

        rcvVertical.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rcvVertical.setAdapter(mVerticalAdapter);
        rcvHorizontal.setAdapter(mHorizontalAdapter);

        //mock data from json file
        getData();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void displayHorizontalListData(List<Data1> lstData) {
        Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_LONG).show();
        mHorizontalAdapter.setData(lstData);
    }

    @Override
    public void displayVerticalListData(List<Data2> lstData) {
        mVerticalAdapter.setData(lstData);
    }

    @Override
    public void displayError(String s) {

    }

    private void getData() {
        presenter.getDataForHorizontalList();
        presenter.getDataForVerticalList();
    }

    @Override
    public void onClick(Data1 data1) {
        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        startActivity(intent);
    }
}
