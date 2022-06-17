package com.UCMobile.in.FrG;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.UCMobile.in.R;

public class GameStart extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_start, container, false);
        NavController startGame = NavHostFragment.findNavController(GameStart.this);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button buttonStartGame = view.findViewById(R.id.buttonStartGame);
        Button buttonStartRules = view.findViewById(R.id.buttonStartRules);
        Button buttonStartSetting = view.findViewById(R.id.buttonStartSetting);
        Button buttonStartEXIT = view.findViewById(R.id.buttonStartEXIT);
        buttonStartSetting.setOnClickListener(view1 -> {
            startGame.navigate(R.id.action_gameStart_to_settingStart,null,
                    new NavOptions.Builder()
                            .setEnterAnim(androidx.navigation.ui.R.animator.nav_default_pop_enter_anim)
                            .setExitAnim(androidx.navigation.ui.R.animator.nav_default_pop_exit_anim)
                            .build());
        });
        buttonStartGame.setOnClickListener(view1 -> {
            startGame.navigate(R.id.action_gameStart_to_game,null,
                    new NavOptions.Builder()
                            .setEnterAnim(androidx.navigation.ui.R.animator.nav_default_pop_enter_anim)
                            .setExitAnim(androidx.navigation.ui.R.animator.nav_default_pop_exit_anim)
                            .build());
        });
        buttonStartEXIT.setOnClickListener(view1 -> {
            AlertDialog.Builder dialogExit = new AlertDialog.Builder(getContext());
            dialogExit.setTitle("Exit the game");
            dialogExit.setIcon(R.drawable.icon);
            dialogExit.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    getActivity().finish();
                    System.exit(0);
                }
            });
            dialogExit.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dialogExit.show();
        });
        buttonStartRules.setOnClickListener(view1 -> {
            AlertDialog.Builder dialogRules = new AlertDialog.Builder(getContext());
            dialogRules.setTitle("Rules of the game");
            dialogRules.setMessage("You have to find all the pairs" + "\n" + "You can choose the game mode"
                    + "\n" + "By winning the game you earn points that can be used for tips");
            dialogRules.setIcon(R.drawable.icon);
            dialogRules.setPositiveButton("Okey", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dialogRules.show();
        });



        return view;
    }
}