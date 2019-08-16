package com.example.asus.myamazinglist.ui.main;

import android.content.Context;

import com.example.asus.myamazinglist.R;
import com.example.asus.myamazinglist.model.Data1;
import com.example.asus.myamazinglist.model.Data2;
import com.example.asus.myamazinglist.network.RestClient;
import com.example.asus.myamazinglist.utils.Constants;

import java.util.List;
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
    private Context mContext;
    private MainViewInterface mvi;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(Context context, MainViewInterface mvi) {
        this.mvi = mvi;
        mContext = context;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getDataForHorizontalList() {
        // adding observable to the disposable
        compositeDisposable.add((Disposable) getHorizontalDataObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Data1>>() {
                    @Override
                    public void onComplete() {
                        mvi.hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mvi.hideProgressBar();
                        mvi.displayError("Error fetching Data1");
                    }

                    @Override
                    public void onNext(List<Data1> lstData) {
                        mvi.displayHorizontalListData(lstData);
                    }
                }));
    }

    @Override
    public void getDataForVerticalList() {
        // adding observable to the disposable
        compositeDisposable.add((Disposable) getVerticalDataObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Data2>>() {
                    @Override
                    public void onComplete() {
                        mvi.hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mvi.hideProgressBar();
                        mvi.displayError("Error fetching Data2");
                    }

                    @Override
                    public void onNext(List<Data2> lstData) {
                        mvi.displayVerticalListData(lstData);
                    }
                }));
    }

    private Observable getHorizontalDataObservable() {
        // horizontal list will be refreshed after 60 seconds
        return Observable
                .interval(0, mContext.getResources().getInteger(R.integer.number_of_second_refresh_list), TimeUnit.SECONDS)
                .flatMap(new Function<Long, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Long aLong) {
                        return RestClient.getClient(mContext).getData1(Constants.api_key);
                    }
                });
    }

    private Observable getVerticalDataObservable() {
        return RestClient.getClient(mContext).getData2(Constants.api_key);
    }
}
