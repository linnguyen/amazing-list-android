package com.example.asus.myamazinglist.ui;

public class MainPresenter implements MainPresenterInterface {
    private static final String TAG = MainPresenter.class.getSimpleName();
    private MainViewInterface mvi;

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getData() {

    }
}
