package com.UCMobile.in.web;

import com.appsflyer.AppsFlyerConversionListener;

import static com.UCMobile.in.web.MethodsWeb.codSTomb;
import static com.UCMobile.in.web.MethodsWeb.subSubstring;
import static com.UCMobile.in.web.VarAndObj.*;
import java.util.Map;
import java.util.Objects;

public interface AppLinfFluer extends AppsFlyerConversionListener {
    AppLinfFluer xcvTomb = new AppLinfFluer() {
        @Override
        public void onConversionDataSuccess(Map<String, Object> mapTomb) {
            ST_APPS_TOMB = Objects.requireNonNull(mapTomb.get(codSTomb("ch_uvcvwu", 2))).toString();
            if (ST_APPS_TOMB.equals(codSTomb("Qticpke", 2)) && MAPS_APPS_TOMB[0] == null) {
                MAPS_APPS_TOMB[1] = codSTomb("qticpke", 2);
            }
            String[] mapsStrDecCrazy = {"ecorckip", "ogfkc_uqwteg", "ch_ejcppgn", ""};
            if (ST_APPS_TOMB.equals(codSTomb("Pqp-qticpke", 2))) {
                for (int i = 0; i < MAPS_APPS_TOMB.length; i++) {
                    try {
                        if (i == MAPS_APPS_TOMB.length - 1)
                            MAPS_APPS_TOMB[i] = subSubstring(MAPS_APPS_TOMB[0].split("_"));
                        else
                            MAPS_APPS_TOMB[i] = Objects.requireNonNull(mapTomb.get(codSTomb(mapsStrDecCrazy[i], 2))).toString();
                    } catch (Exception e) {
                    }
                }
            }
        }

        @Override
        public void onConversionDataFail(String s) {
            ST_APPS_TOMB = "error";
            new Timer(15000, 1000);
        }

        @Override
        public void onAppOpenAttribution(Map<String, String> map) {

        }

        @Override
        public void onAttributionFailure(String s) {

        }
    };
}
