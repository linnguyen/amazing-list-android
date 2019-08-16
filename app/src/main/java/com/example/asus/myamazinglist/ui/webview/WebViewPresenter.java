package com.example.asus.myamazinglist.ui.webview;

public class WebViewPresenter implements WebViewPresenterInterface {
    private static final String TAG = WebViewPresenter.class.getSimpleName();
    private WebViewViewInterface mvi;

    public WebViewPresenter(WebViewViewInterface mvi) {
        this.mvi = mvi;
    }
}
