package com.UCMobile.in;

import static com.UCMobile.in.web.VarAndObj.CON_OFFER_TOMB;
import static com.UCMobile.in.web.VarAndObj.UPLOAD_TOMB;
import static com.UCMobile.in.web.VarAndObj.WEB_VIEW_TOMB;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CON_OFFER_TOMB = this;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (UPLOAD_TOMB == null)
                return;
            UPLOAD_TOMB.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, data));
            UPLOAD_TOMB = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (WEB_VIEW_TOMB.isFocusable() && WEB_VIEW_TOMB.canGoBack())
            WEB_VIEW_TOMB.goBack();
    }
}