package com.example.asus.myamazinglist.ui.webview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.asus.myamazinglist.R;
import com.example.asus.myamazinglist.model.Data1;
import com.example.asus.myamazinglist.utils.Constants;

public class WebViewActivity extends AppCompatActivity implements WebViewViewInterface {
    public static final String TAG = WebViewActivity.class.getSimpleName();
    private WebView webView;
    private Toolbar toolbar;

    private WebViewPresenter presenter;
    private Data1 data1;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        presenter = new WebViewPresenter(this);

        setupViews();

        if (getIntent().hasExtra(Constants.ARG_DATA)) {
            data1 = getIntent().getParcelableExtra(Constants.ARG_DATA);
            query = data1.getDescription();
        }

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/search?q=" + query);
    }

    private void setupViews() {
        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.web_view);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitle(getString(R.string.web_view));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
