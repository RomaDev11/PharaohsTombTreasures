package com.UCMobile.in.FrG;
import static com.UCMobile.in.FrG.Game.*;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.UCMobile.in.R;

public class SettingStart extends Fragment {
    MediaPlayer PlayeraTomb;
    CheckBox checkBoxTomb;
    public static Boolean CHECKET_BOX = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_start, container, false);
        NavController setGame = NavHostFragment.findNavController(SettingStart.this);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button button4Pos = view.findViewById(R.id.position4);
        Button button2Pos = view.findViewById(R.id.position2);
        Button positionStore = view.findViewById(R.id.positionStore);
        checkBoxTomb = view.findViewById(R.id.checkBox);
        positionStore.setOnClickListener(view1 -> {
            setGame.navigate(R.id.action_settingStart_to_storeStart,null,
                    new NavOptions.Builder()
                            .setEnterAnim(androidx.navigation.ui.R.animator.nav_default_pop_enter_anim)
                            .setExitAnim(androidx.navigation.ui.R.animator.nav_default_pop_exit_anim)
                            .build());
        });
        checkBoxTomb.setChecked(CHECKET_BOX);
        checkBoxTomb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    CHECKET_BOX = true;
                    PlayeraTomb = MediaPlayer.create(getContext(), R.raw.mp);
                    PlayeraTomb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                        }
                    });
                    PlayeraTomb.start();
                } else{
                    CHECKET_BOX = false;
                    PlayeraTomb.stop();
                }
            }
        });
        button2Pos.setOnClickListener(view1 -> {
            twoPlayerTomb = true;
            onePlayerTomb = false;
        });
        button4Pos.setOnClickListener(view1 -> {
            onePlayerTomb = true;
            twoPlayerTomb = false;
        });


        return view;
    }
}