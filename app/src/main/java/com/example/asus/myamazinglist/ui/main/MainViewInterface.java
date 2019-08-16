package com.example.asus.myamazinglist.ui.main;

import com.example.asus.myamazinglist.model.Data1;
import com.example.asus.myamazinglist.model.Data2;

import java.util.List;

public interface MainViewInterface {
    void showProgressBar();

    void hideProgressBar();

    void displayHorizontalListData(List<Data1> lstData);

    void displayVerticalListData(List<Data2> lstData);

    void displayError(String s);
}
