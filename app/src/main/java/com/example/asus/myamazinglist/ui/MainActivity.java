package com.example.asus.myamazinglist.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.myamazinglist.R;

public class MainActivity extends AppCompatActivity implements MainViewInterface {
    public static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void displayData() {

    }

    @Override
    public void displayError(String s) {

    }
}
