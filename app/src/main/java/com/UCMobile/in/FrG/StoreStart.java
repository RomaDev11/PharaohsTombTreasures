package com.UCMobile.in.FrG;

import static com.UCMobile.in.FrG.Game.pointsMainTomb;
import static com.UCMobile.in.FrG.Game.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.UCMobile.in.R;

public class StoreStart extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_start, container, false);
        Button buttonStarthond = view.findViewById(R.id.buttonStarthond);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button buttonStarthind2 = view.findViewById(R.id.buttonStarthind2);
        Button buttonStarthind3 = view.findViewById(R.id.buttonStarthind3);
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setText("" + pointsMainTomb);
        buttonStarthond.setOnClickListener(view1 -> {
            if(pointsMainTomb >= 10){
                hindTomb = true;
                pointsMainTomb -= 10;
                textView2.setText("" + pointsMainTomb);
            }else{
                Toast.makeText(getContext(), "You don't have enough points", Toast.LENGTH_SHORT).show();
            }
        });
        buttonStarthind2.setOnClickListener(view1 -> {
            if(pointsMainTomb >= 10){
                hindTwoTomb = true;
                pointsMainTomb -= 10;
                textView2.setText("" + pointsMainTomb);
            }else{
                Toast.makeText(getContext(), "You don't have enough points", Toast.LENGTH_SHORT).show();
            }
        });
        buttonStarthind3.setOnClickListener(view1 -> {
            AlertDialog.Builder dialogOnline = new AlertDialog.Builder(getContext());
            dialogOnline.setTitle("Star");
            dialogOnline.setMessage("By clicking on this wild it will automatically guess a couple");
            dialogOnline.setIcon(R.drawable.wild);
            dialogOnline.setPositiveButton("Okey", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if(pointsMainTomb >= 50){
                        hindThreeTomb = true;
                        pointsMainTomb -= 50;
                        textView2.setText("" + pointsMainTomb);
                    }else{
                        Toast.makeText(getContext(), "You don't have enough points", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialogOnline.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dialogOnline.show();
        });

        return view;
    }
}