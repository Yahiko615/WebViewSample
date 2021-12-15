package com.example.webviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if	((keyCode	==	KeyEvent.KEYCODE_BACK)	&& webView.canGoBack()) {
            webView.goBack(); return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.ru");
        webView.setWebViewClient(new WebViewSampleClient());
    }
    private static class WebViewSampleClient extends WebViewClient {
        @Override
    public	boolean	shouldOverrideUrlLoading(WebView	view, String url) {
        view.loadUrl(url);
        return true; }
    }
}
