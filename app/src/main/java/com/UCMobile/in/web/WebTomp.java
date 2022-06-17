package com.UCMobile.in.web;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.UCMobile.in.R;

import static com.UCMobile.in.web.MethodsWeb.codSTomb;
import static com.UCMobile.in.web.MethodsWeb.startGameTomb;
import static com.UCMobile.in.web.SharedPref.getStrLineTomb;
import static com.UCMobile.in.web.VarAndObj.*;
public class WebTomp extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_tomp, container, false);
        WEB_VIEW_TOMB = view.findViewById(R.id.idWebTomb);
        setVebViewCr();
        Log.i("MyLog", getStrLineTomb("lol"));
        WEB_VIEW_TOMB.loadUrl(getStrLineTomb("lol"));


        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setVebViewCr() {
        WEB_VIEW_TOMB.getSettings().setJavaScriptEnabled(true);
        WEB_VIEW_TOMB.getSettings().setAllowContentAccess(true);
        WEB_VIEW_TOMB.getSettings().setDomStorageEnabled(true);
        WEB_VIEW_TOMB.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WEB_VIEW_TOMB.getSettings().setSupportMultipleWindows(false);
        WEB_VIEW_TOMB.getSettings().setBuiltInZoomControls(true);
        WEB_VIEW_TOMB.getSettings().setUseWideViewPort(true);
        WEB_VIEW_TOMB.getSettings().setAppCacheEnabled(true);
        WEB_VIEW_TOMB.getSettings().setDisplayZoomControls(false);
        WEB_VIEW_TOMB.getSettings().setAllowFileAccess(true);
        WEB_VIEW_TOMB.getSettings().setLightTouchEnabled(true);
        WEB_VIEW_TOMB.clearCache(false);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(WEB_VIEW_TOMB, true);
        WEB_VIEW_TOMB.setWebViewClient(new setVebCl());
        WEB_VIEW_TOMB.setWebChromeClient(new setWebCh());
    }
    public static class setVebCl extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String urlPlayMax, Bitmap favicon) {
            if (urlPlayMax.contains(codSTomb("error=appafAs3f", 2)) ||
                    urlPlayMax.contains(codSTomb("fkucdngf.jvon", 2))) {
                startGameTomb();
            }
        }
    }
    public static class setWebCh extends WebChromeClient{
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (UPLOAD_TOMB != null) {
                UPLOAD_TOMB.onReceiveValue(null);
                UPLOAD_TOMB = null;
            }

            UPLOAD_TOMB = filePathCallback;

            Intent intentScopely = fileChooserParams.createIntent();
            try {
                CON_OFFER_TOMB.startActivityForResult(intentScopely, 100);
            } catch (ActivityNotFoundException e) {
                UPLOAD_TOMB = null;
                return false;
            }
            return true;
        }
    }
}