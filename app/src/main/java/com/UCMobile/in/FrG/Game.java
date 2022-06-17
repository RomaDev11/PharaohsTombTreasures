package com.UCMobile.in.FrG;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.UCMobile.in.R;

import java.util.Random;

public class Game extends Fragment {
    ImageView[] imageViewArrayTomb;
    Button[] buttonViewArrayTomb;
    public static int rangeGameTomb;
    int[] arrayViewTomb;
    int[] arrayBtnTomb;
    View view;
    boolean turnAndrovTomb;
    int clickedAndrovTomb = 0;
    int lastClickTomb = -1;
    int endGameTomb = 0;
    public static boolean onePlayerTomb = true;
    public static boolean twoPlayerTomb = false;
    public static boolean hindTomb = false;
    public static boolean hindTwoTomb = false;
    public static boolean hindThreeTomb = false;
    public static int pointsMainTomb = 0;
    int pl1Tomb = 0;
    int pl2Tomb = 0;
    boolean pl1BollTomb = true;
    boolean pl2BollTomb = false;
    int[] arrayDrawbleTomb = new int[]{R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4};
    public static int pChTomb[];
    public static int tsTomb;
    public static int[] nTomb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rangeGameTomb = 8;
        ImageView imageViewStar = view.findViewById(R.id.imageViewStar);
        TextView textView = view.findViewById(R.id.textView);
        arrayViewTomb = new int[]{R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8};
        arrayBtnTomb = new int[]{R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8};
        imageViewArrayTomb = new ImageView[rangeGameTomb];
        buttonViewArrayTomb = new Button[rangeGameTomb];
        Button buttonPlayGame = view.findViewById(R.id.buttonPlayGame);
        TextView textView3 = view.findViewById(R.id.textView3);
        shuffleTomb(arrayDrawbleTomb);
        pChTomb = new int[arrayDrawbleTomb.length];
        nTomb = new int[arrayDrawbleTomb.length];


        if (hindThreeTomb) {
            imageViewStar.setVisibility(View.VISIBLE);
        } else {
            imageViewStar.setVisibility(View.INVISIBLE);
        }
        imageViewStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ch;
                int k = 0;
                for (int i = 0; i < arrayDrawbleTomb.length; i++) {
                    if (!povtorTomb(ch= arrayDrawbleTomb[tsTomb])){
                        ch= arrayDrawbleTomb[tsTomb];
                        for(int ts2 = 0; ts2< arrayDrawbleTomb.length; ts2++)
                            if(arrayDrawbleTomb[ts2]==ch){
                                nTomb[k]=ts2+1;
                                k++;
                            }
                        k=0;
                        pChTomb[tsTomb]=ch;
                    }
                }
                buttonViewArrayTomb[nTomb[0]-1].setClickable(false);
                buttonViewArrayTomb[nTomb[1]-1].setClickable(false);
                buttonViewArrayTomb[nTomb[0]-1].setBackgroundResource(arrayDrawbleTomb[nTomb[0]-1]);
                imageViewArrayTomb[nTomb[0]-1].setBackgroundResource(arrayDrawbleTomb[nTomb[0]-1]);
                buttonViewArrayTomb[nTomb[1]-1].setBackgroundResource(arrayDrawbleTomb[nTomb[1]-1]);
                imageViewArrayTomb[nTomb[1]-1].setBackgroundResource(arrayDrawbleTomb[nTomb[1]-1]);
                endGameTomb++;
            }
        });
        buttonPlayGame.setVisibility(View.INVISIBLE);
        buttonPlayGame.setOnClickListener(view2 -> {
            for (int j = 0; j < buttonViewArrayTomb.length; j++) {
                buttonViewArrayTomb[j].setVisibility(View.VISIBLE);
                imageViewArrayTomb[j].setVisibility(View.VISIBLE);
                buttonViewArrayTomb[j].setText("0");
                buttonViewArrayTomb[j].setBackgroundResource(R.drawable.front_image);
                imageViewArrayTomb[j].setBackgroundResource(R.drawable.front_image);
                buttonViewArrayTomb[j].setClickable(true);
                endGameTomb = 0;
                buttonPlayGame.setVisibility(View.INVISIBLE);
                shuffleTomb(arrayDrawbleTomb);
            }
        });

        if (twoPlayerTomb) {
            textView.setText("Player One: " + pl1Tomb + "\n" + "Player Two: " + pl2Tomb);
            for (int i = 0; i < buttonViewArrayTomb.length; i++) {
                buttonViewArrayTomb[i] = view.findViewById(arrayBtnTomb[i]);
                imageViewArrayTomb[i] = view.findViewById(arrayViewTomb[i]);
                buttonViewArrayTomb[i].setText("0");
                buttonViewArrayTomb[i].setTextSize(0.0F);
                int finalI = i;
                buttonViewArrayTomb[i].setOnClickListener(view3 -> {
                    if (buttonViewArrayTomb[finalI].getText() == "0" && !turnAndrovTomb) {
                        buttonViewArrayTomb[finalI].setBackgroundResource(arrayDrawbleTomb[finalI]);
                        imageViewArrayTomb[finalI].setBackgroundResource(arrayDrawbleTomb[finalI]);
                        buttonViewArrayTomb[finalI].setText(arrayDrawbleTomb[finalI]);
                        if (clickedAndrovTomb == 0) {
                            lastClickTomb = finalI;
                        }
                        clickedAndrovTomb++;
                    } else if (!buttonViewArrayTomb[finalI].getText().equals("0")) {
                        buttonViewArrayTomb[finalI].setBackgroundResource(R.drawable.front_image);
                        imageViewArrayTomb[finalI].setBackgroundResource(R.drawable.front_image);
                        buttonViewArrayTomb[finalI].setText("0");
                        clickedAndrovTomb--;
                    }
                    if (clickedAndrovTomb == 2) {
                        turnAndrovTomb = true;
                        if (buttonViewArrayTomb[finalI].getText() == buttonViewArrayTomb[lastClickTomb].getText()) {
                            buttonViewArrayTomb[finalI].setClickable(false);
                            buttonViewArrayTomb[lastClickTomb].setClickable(false);
                            turnAndrovTomb = false;
                            endGameTomb++;
                            clickedAndrovTomb = 0;
                            if (pl1BollTomb) {
                                pl1Tomb++;
                                pl2BollTomb = true;
                                pl1BollTomb = false;
                            } else if (pl2BollTomb) {
                                pl2Tomb++;
                                pl1BollTomb = true;
                                pl2BollTomb = false;
                            }
                            textView.setText("Player One: " + pl1Tomb + "\n" + "Player Two: " + pl2Tomb);
                        }
                    } else if (clickedAndrovTomb == 0) {
                        turnAndrovTomb = false;
                    }
                    if (endGameTomb == 4) {
                        for (int j = 0; j < buttonViewArrayTomb.length; j++) {
                            buttonViewArrayTomb[j].setVisibility(View.INVISIBLE);
                            imageViewArrayTomb[j].setVisibility(View.INVISIBLE);
                        }
                        if (pl1Tomb > pl2Tomb) {
                            Toast.makeText(getContext(), "Player one won!!!", Toast.LENGTH_SHORT).show();
                        } else if (pl2Tomb > pl1Tomb) {
                            Toast.makeText(getContext(), "Player two won!!!", Toast.LENGTH_SHORT).show();
                        } else if (pl2Tomb == pl1Tomb) {
                            Toast.makeText(getContext(), "Draw!!!", Toast.LENGTH_SHORT).show();
                        }
                        buttonPlayGame.setVisibility(View.VISIBLE);

                    }
                });

            }
        } else if (onePlayerTomb) {
            for (int i = 0; i < buttonViewArrayTomb.length; i++) {
                buttonViewArrayTomb[i] = view.findViewById(arrayBtnTomb[i]);
                imageViewArrayTomb[i] = view.findViewById(arrayViewTomb[i]);
                buttonViewArrayTomb[i].setText("0");
                buttonViewArrayTomb[i].setTextSize(0.0F);
                int finalI = i;
                if (i == buttonViewArrayTomb.length - 1) {
                    if (hindTomb) {
                        buttonViewArrayTomb[1].setBackgroundResource(arrayDrawbleTomb[1]);
                        imageViewArrayTomb[1].setBackgroundResource(arrayDrawbleTomb[1]);
                    }
                    if (hindTwoTomb) {
                        buttonViewArrayTomb[4].setBackgroundResource(arrayDrawbleTomb[4]);
                        imageViewArrayTomb[4].setBackgroundResource(arrayDrawbleTomb[4]);
                    }
                }
                buttonViewArrayTomb[i].setOnClickListener(view4 -> {
                    if (buttonViewArrayTomb[finalI].getText() == "0" && !turnAndrovTomb) {
                        buttonViewArrayTomb[finalI].setBackgroundResource(arrayDrawbleTomb[finalI]);
                        imageViewArrayTomb[finalI].setBackgroundResource(arrayDrawbleTomb[finalI]);
                        buttonViewArrayTomb[finalI].setText(arrayDrawbleTomb[finalI]);
                        if (clickedAndrovTomb == 0) {
                            lastClickTomb = finalI;
                        }
                        clickedAndrovTomb++;
                    } else if (!buttonViewArrayTomb[finalI].getText().equals("0")) {
                        buttonViewArrayTomb[finalI].setBackgroundResource(R.drawable.front_image);
                        imageViewArrayTomb[finalI].setBackgroundResource(R.drawable.front_image);
                        buttonViewArrayTomb[finalI].setText("0");
                        clickedAndrovTomb--;
                    }
                    if (clickedAndrovTomb == 2) {
                        turnAndrovTomb = true;
                        if (buttonViewArrayTomb[finalI].getText() == buttonViewArrayTomb[lastClickTomb].getText()) {
                            buttonViewArrayTomb[finalI].setClickable(false);
                            buttonViewArrayTomb[lastClickTomb].setClickable(false);
                            turnAndrovTomb = false;
                            endGameTomb++;
                            clickedAndrovTomb = 0;
                        }
                    } else if (clickedAndrovTomb == 0) {
                        turnAndrovTomb = false;
                    }
                    if (endGameTomb == 4) {
                        pointsMainTomb += 5;
                        textView3.setText("" + pointsMainTomb);
                        for (int j = 0; j < buttonViewArrayTomb.length; j++) {
                            buttonViewArrayTomb[j].setVisibility(View.INVISIBLE);
                            imageViewArrayTomb[j].setVisibility(View.INVISIBLE);
                        }
                        Toast.makeText(getContext(), "You Win!!!", Toast.LENGTH_SHORT).show();
                        buttonPlayGame.setVisibility(View.VISIBLE);
                    }
                });

            }
        }



        return view;
    }

    private void shuffleTomb(int[] arrayDrawble) {
        Random gen = new Random();
        for (int i = arrayDrawble.length - 1; i > 0; i--) {
            int index = gen.nextInt(i + 1);
            int a = arrayDrawble[index];
            arrayDrawble[index] = arrayDrawble[i];
            arrayDrawble[i] = a;
        }
    }

    static boolean povtorTomb(int x){
        for(int a = 0; a< tsTomb; a++){
            if (pChTomb[a]==x) return true;
        }
        return false;
    }
}