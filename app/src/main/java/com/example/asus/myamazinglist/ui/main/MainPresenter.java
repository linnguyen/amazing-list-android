package com.example.asus.myamazinglist.ui.main;

import com.example.asus.myamazinglist.model.MovieResponse;
import com.example.asus.myamazinglist.network.NetworkClient;
import com.example.asus.myamazinglist.network.NetworkInterface;
import com.example.asus.myamazinglist.utils.Constants;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {
    private static final String TAG = MainPresenter.class.getSimpleName();
    private MainViewInterface mvi;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
        compositeDisposable = new CompositeDisposable();
    }
}
