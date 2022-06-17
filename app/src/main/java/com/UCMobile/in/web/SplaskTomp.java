package com.UCMobile.in.web;

import android.os.Bundle;

import static com.UCMobile.in.web.MethodsWeb.AppsFl;
import static com.UCMobile.in.web.MethodsWeb.OnesAndAdId;
import static com.UCMobile.in.web.MethodsWeb.getDataFromGistTomb;
import static com.UCMobile.in.web.MethodsWeb.inFb;
import static com.UCMobile.in.web.SharedPref.getStrLineTomb;
import static com.UCMobile.in.web.SharedPref.setContextTomb;
import static com.UCMobile.in.web.VarAndObj.*;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.UCMobile.in.R;

public class SplaskTomp extends Fragment {
    static NavController navControllerSplTomb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splask_tomp, container, false);
        navControllerSplTomb = NavHostFragment.findNavController(SplaskTomp.this);
        CON_CONTEXXT_TOMB = requireContext();
        CON_ACTIVITY_TOMB = requireActivity();
        DEV_TOMB = Settings.Secure.getInt(getContext().getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
        setContextTomb(CON_CONTEXXT_TOMB);
        if (getStrLineTomb("lol") != null)
            navControllerSplTomb.navigate(R.id.action_splaskTomp_to_webTomp);
        else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getDataFromGistTomb();
                    inFb();
                    OnesAndAdId();
                    AppsFl();
                }
            }).start();
            new Timer(15000, 1000);
        }
        return view;
    }
}