package com.example.asus.myamazinglist.ui.main;

import com.example.asus.myamazinglist.model.Movie;

import java.util.List;

public interface MainViewInterface {
    void showProgressBar();

    void hideProgressBar();

    void displayHorizontalListData(List<Movie> lstData);

    void displayVerticalListData(List<Movie> lstData);

    void displayError(String s);
}
