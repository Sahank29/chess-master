package com.chess.chess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class chess_activity extends AppCompatActivity {

    TextView textViewDG,textViewD;

    Button btnback,btnundo2,btntime,btnuser3,btnuser,btntimeuser1,btnnext;

    Button a1,a2,a3,a4,a5,a6,a7,a8;
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    Button c1,c2,c3,c4,c5,c6,c7,c8;
    Button d1,d2,d3,d4,d5,d6,d7,d8;
    Button e1,e2,e3,e4,e5,e6,e7,e8;
    Button f1,f2,f3,f4,f5,f6,f7,f8;
    Button g1,g2,g3,g4,g5,g6,g7,g8;
    Button h1,h2,h3,h4,h5,h6,h7,h8;

    DBHelper DB;
    String theme,name_new,name,timer;
    CountDownTimer bcdt,wcdt;
    ArrayAdapter<String> adapter;
    ImageView imageView,imageView2;
    ArrayList<String> wins = new ArrayList<String>();
    Dialog dialog,dialogg;
    ListView listview;
    FrameLayout fraglayout;
    Animation scale_up,scale_down;
    ConstraintLayout activity_chess;
    SharedPreferences sharedPreferences;
    TextView listcolor;
    int flag = 1,val;
    Boolean a2_pos = true,a1_pos = true,a3_pos = false,a4_pos = false,a5_pos = false,a6_pos = false,a7_pos = true,a8_pos = true,round = true;
    String container_a1 = "castle",container_a2 = "pawn",container_a3,container_a4,container_a5,container_a6,container_a7= "pawn_w" ,container_a8= "castle_w" ;
    Boolean b2_pos = true,b1_pos = true,b3_pos = false,b4_pos = false,b5_pos = false,b6_pos = false,b7_pos = true,b8_pos = true;
    String container_b1 = "knight",container_b2 = "pawn",container_b3,container_b4,container_b5,container_b6,container_b7= "pawn_w" ,container_b8= "knight_w" ;
    Boolean c2_pos = true,c1_pos = true,c3_pos = false,c4_pos = false,c5_pos = false,c6_pos = false,c7_pos = true,c8_pos = true;
    String container_c1 = "bishop",container_c2 = "pawn",container_c3,container_c4,container_c5,container_c6,container_c7= "pawn_w" ,container_c8= "bishop_w" ;
    Boolean d2_pos = true,d1_pos = true,d3_pos = false,d4_pos = false,d5_pos = false,d6_pos = false,d7_pos = true,d8_pos = true;
    String container_d1 = "queen",container_d2 = "pawn",container_d3,container_d4,container_d5,container_d6,container_d7= "pawn_w" ,container_d8= "queen_w" ;
    Boolean e2_pos = true,e1_pos = true,e3_pos = false,e4_pos = false,e5_pos = false,e6_pos = false,e7_pos = true,e8_pos = true;
    String container_e1 = "king",container_e2 = "pawn",container_e3,container_e4,container_e5,container_e6,container_e7= "pawn_w" ,container_e8= "king_w" ;
    Boolean f2_pos = true,f1_pos = true,f3_pos = false,f4_pos = false,f5_pos = false,f6_pos = false,f7_pos = true,f8_pos = true;
    String container_f1 = "bishop",container_f2 = "pawn",container_f3,container_f4,container_f5,container_f6,container_f7= "pawn_w" ,container_f8= "bishop_w" ;
    Boolean g2_pos = true,g1_pos = true,g3_pos = false,g4_pos = false,g5_pos = false,g6_pos = false,g7_pos = true,g8_pos = true;
    String container_g1 = "knight",container_g2 = "pawn",container_g3,container_g4,container_g5,container_g6,container_g7= "pawn_w" ,container_g8= "knight_w" ;
    Boolean h2_pos = true,h1_pos = true,h3_pos = false,h4_pos = false,h5_pos = false,h6_pos = false,h7_pos = true,h8_pos = true;
    String container_h1 = "castle",container_h2 = "pawn",container_h3,container_h4,container_h5,container_h6,container_h7= "pawn_w" ,container_h8= "castle_w" ;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_SECUSER = "sec_user";
    private static final String TIMER = "timerval";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        theme = sharedPreferences.getString(MODE_THEME,"Brown");
        timer = sharedPreferences.getString(TIMER,"30000");
        val = Integer.parseInt(timer);
        name = sharedPreferences.getString(KEY_USERNAME,null);
        name_new = sharedPreferences.getString(KEY_SECUSER,null);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);

        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);

        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);

        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        g4 = findViewById(R.id.g4);
        g5 = findViewById(R.id.g5);
        g6 = findViewById(R.id.g6);
        g7 = findViewById(R.id.g7);
        g8 = findViewById(R.id.g8);

        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        h7 = findViewById(R.id.h7);
        h8 = findViewById(R.id.h8);

        DB = new DBHelper(this);

        btnback = findViewById(R.id.btnback);
        btntime = findViewById(R.id.btntime);
        btntimeuser1 = findViewById(R.id.btntimeuser1);
        btnuser3 = findViewById(R.id.btnuser3);
        btnuser = findViewById(R.id.btnuser);

        DB = new DBHelper(this);

        imageView = findViewById(R.id.imageView8);
        imageView2 = findViewById(R.id.imageView9);

        fraglayout = findViewById(R.id.frameLayout);

        listview = findViewById(R.id.list);

        listcolor = findViewById(R.id.text_list);

        activity_chess = findViewById(R.id.activity_chess);

        btnuser.setText(name);
        btnuser3.setText(name_new);

        if(Objects.equals(theme, "Green")){
            greencolor();
            adapter = new ArrayAdapter<String>(chess_activity.this,R.layout.listcolor_green,wins);
            listview.setAdapter(adapter);
        }else{
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
            adapter = new ArrayAdapter<String>(chess_activity.this,R.layout.listcolor,wins);
            listview.setAdapter(adapter);
        }

        if(val == 10000){
            btntime.setText("10");
            btntimeuser1.setText("10");
        }else if(val == 20000){
            btntime.setText("20");
            btntimeuser1.setText("20");
        }

        dialog = new Dialog(chess_activity.this);
        dialog.setContentView(R.layout.custom_win);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        textViewD = dialog.findViewById(R.id.textView3);
        Button btnhist = dialog.findViewById(R.id.btnhistory);
        Button btnplayagain = dialog.findViewById(R.id.btnplayagain);
        Button btnmenu = dialog.findViewById(R.id.btnback);

        dialogg = new Dialog(chess_activity.this);
        dialogg.setContentView(R.layout.custom_win_green);
        dialogg.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_green));
        dialogg.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogg.setCancelable(false);
        dialogg.getWindow().getAttributes().windowAnimations = R.style.animation;

        textViewDG = dialogg.findViewById(R.id.textView11);
        Button btnhistt = dialogg.findViewById(R.id.btnhistory);
        Button btnplayagainn = dialogg.findViewById(R.id.btnplayagain);
        Button btnmenuu = dialogg.findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGameBlack();
                startGameWhite();
                DB.dbmove();
                btnback.setVisibility(View.INVISIBLE);
            }
        });
        btnhistt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogg.dismiss();
                Intent in = new Intent(chess_activity.this,history_activity.class);
                startActivity(in);
            }
        });
        btnplayagainn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogg.dismiss();
                Intent in = new Intent(chess_activity.this,chess_activity.class);
                startActivity(in);
                finishAffinity();
            }
        });
        btnmenuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogg.dismiss();
                Intent in = new Intent(chess_activity.this,menu_activity.class);
                startActivity(in);
            }
        });

        btnhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent in = new Intent(chess_activity.this,history_activity.class);
                startActivity(in);
            }
        });
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent in = new Intent(chess_activity.this,menu_activity.class);
                startActivity(in);
            }
        });
        btnplayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent in = new Intent(chess_activity.this,chess_activity.class);
                startActivity(in);
                finishAffinity();
            }
        });

        btnhist.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnhist.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnhist.startAnimation(scale_down);
                }
                return false;
            }
        });
        btnmenu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnmenu.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnmenu.startAnimation(scale_down);
                }
                return false;
            }
        });
        btnplayagain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnplayagain.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnplayagain.startAnimation(scale_down);
                }
                return false;
            }
        });
        btnback.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnback.startAnimation(scale_up);
                //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnback.startAnimation(scale_down);
                }
                return false;
            }
        });
    }

    private void startGameBlack() {
        btntime.setText(" ");
        bcdt = new CountDownTimer(val, 1000) {
            @Override
            public void onTick(long l) {
                btntimeuser1.setText(""+l/1000);
                flag = 1;
                moveblack();
            }

            @Override
            public void onFinish() {
                btntime.setText(" ");
                bcdt.cancel();
                startGameWhite();
            }
        }.start();
    }
    private void startGameWhite() {
        btntimeuser1.setText(" ");
        wcdt = new CountDownTimer(val, 1000) {
            @Override
            public void onTick(long l) {
                btntime.setText(""+l/1000);
                flag = 0;
                movewhite();
            }

            @Override
            public void onFinish() {
                btntimeuser1.setText(" ");
                wcdt.cancel();
                startGameBlack();
            }
        }.start();
    }

    private void movewhite() {
        if (container_a1 == "pawn_w" || container_a2 == "pawn_w" || container_a3 == "pawn_w" || container_a4 == "pawn_w" || container_a5 == "pawn_w" || container_a6 == "pawn_w" || container_a7 == "pawn_w" || container_a8 == "pawn_w" || container_a1 == "castle_w" || container_a2 == "castle_w" || container_a3 == "castle_w" || container_a4 == "castle_w" || container_a5 == "castle_w" || container_a6 == "castle_w" || container_a7 == "castle_w" || container_a8 == "castle_w") {
            a8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a7.setVisibility(View.VISIBLE);
                            }else{
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            a7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a6_pos == false && a7_pos == true && container_a7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a6.setVisibility(View.VISIBLE);
                            }else{
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a6.setVisibility(View.VISIBLE);
                            }
                        } else if (a6_pos == false && a7_pos == true && container_a7 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a6.setVisibility(View.VISIBLE);
                            }else{
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a6.setVisibility(View.VISIBLE);
                            }
                        } else if (a7_pos == false && container_a8 == "castle_w") {
                            a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a8.setVisibility(View.INVISIBLE);
                            String temp = " A8 ---> A7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a7_pos = true;
                            a8_pos = false;
                            container_a7 = "castle_w";
                            container_a8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a7_pos == false && container_a8 == "pawn_w") {
                            a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a8.setVisibility(View.INVISIBLE);
                            String temp = " A8 ---> A7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a7_pos = true;
                            a8_pos = false;
                            container_a7 = "pawn_w";
                            container_a8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a7_pos == true && a8_pos == true && container_a8 == "pawn_w") {
                            if (container_a7 == "pawn" || container_a7 == "castle") {
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a8.setVisibility(View.INVISIBLE);
                                String temp = " A8 ---> A7    "+name_new+"    "+container_a7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a7_pos = true;
                                a8_pos = false;
                                container_a7 = "pawn_w";
                                container_a8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (a7_pos == true && a8_pos == true && container_a8 == "castle_w") {
                            if (container_a7 == "pawn" || container_a7 == "castle") {
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a8.setVisibility(View.INVISIBLE);
                                String temp = " A8 ---> A7    "+name_new+"    "+container_a7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a7_pos = true;
                                a8_pos = false;
                                container_a7 = "castle_w";
                                container_a8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            a6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a5_pos == false && a6_pos == true && container_a6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a5.setVisibility(View.VISIBLE);
                            }else{
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a5.setVisibility(View.VISIBLE);
                            }
                        } else if (a5_pos == false && a6_pos == true && container_a6 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a5.setVisibility(View.VISIBLE);
                            }else{
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a5.setVisibility(View.VISIBLE);
                            }
                        } else if (a6_pos == false && container_a7 == "castle_w") {
                            a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a7.setVisibility(View.INVISIBLE);
                            String temp = " A7 ---> A6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a6_pos = true;
                            a7_pos = false;
                            container_a6 = "castle_w";
                            container_a7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a6_pos == false && container_a7 == "pawn_w") {
                            a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a7.setVisibility(View.INVISIBLE);
                            String temp = " A7 ---> A6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a6_pos = true;
                            a7_pos = false;
                            container_a6 = "pawn_w";
                            container_a7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a6_pos == true && a7_pos == true && container_a7 == "pawn_w") {
                            if (container_a6 == "pawn" || container_a6 == "castle") {
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a7.setVisibility(View.INVISIBLE);
                                String temp = " A7 ---> A6    "+name_new+"    "+container_a6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a6_pos = true;
                                a7_pos = false;
                                container_a6 = "pawn_w";
                                container_a7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (a6_pos == true && a7_pos == true && container_a7 == "castle_w") {
                            if (container_a6 == "pawn" || container_a6 == "castle") {
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a7.setVisibility(View.INVISIBLE);
                                String temp = " A7 ---> A6    "+name_new+"    "+container_a6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a6_pos = true;
                                a7_pos = false;
                                container_a6 = "castle_w";
                                container_a7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            a5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a4_pos == false && a5_pos == true && container_a5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a4.setVisibility(View.VISIBLE);
                            }else{
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a4.setVisibility(View.VISIBLE);
                            }
                        } else if (a4_pos == false && a5_pos == true && container_a5 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a4.setVisibility(View.VISIBLE);
                            }else{
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a4.setVisibility(View.VISIBLE);
                            }
                        } else if (a5_pos == false && container_a6 == "castle_w") {
                            a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a6.setVisibility(View.INVISIBLE);
                            String temp = " A6 ---> A5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a5_pos = true;
                            a6_pos = false;
                            container_a5 = "castle_w";
                            container_a6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a5_pos == false && container_a6 == "pawn_w") {
                            a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a6.setVisibility(View.INVISIBLE);
                            String temp = " A6 ---> A5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a5_pos = true;
                            a6_pos = false;
                            container_a5 = "pawn_w";
                            container_a6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a5_pos == true && a6_pos == true && container_a6 == "pawn_w") {
                            if (container_a5 == "pawn" || container_a5 == "castle") {
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a6.setVisibility(View.INVISIBLE);
                                String temp = " A6 ---> A5    "+name_new+"    "+container_a5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a5_pos = true;
                                a6_pos = false;
                                container_a5 = "pawn_w";
                                container_a6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (a5_pos == true && a6_pos == true && container_a6 == "castle_w") {
                            if (container_a5 == "pawn" || container_a5 == "castle") {
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a6.setVisibility(View.INVISIBLE);
                                String temp = " A6 ---> A5    "+name_new+"    "+container_a5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a5_pos = true;
                                a6_pos = false;
                                container_a5 = "castle_w";
                                container_a6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            a4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a3_pos == false && a4_pos == true && container_a4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a3.setVisibility(View.VISIBLE);
                            }else{
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a3.setVisibility(View.VISIBLE);
                            }
                        } else if (a3_pos == false && a4_pos == true && container_a4 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a3.setVisibility(View.VISIBLE);
                            }else{
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a3.setVisibility(View.VISIBLE);
                            }
                        } else if (a4_pos == false && container_a5 == "castle_w") {
                            a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a5.setVisibility(View.INVISIBLE);
                            String temp = " A5 ---> A4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a4_pos = true;
                            a5_pos = false;
                            container_a4 = "castle_w";
                            container_a5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a4_pos == false && container_a5 == "pawn_w") {
                            a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a5.setVisibility(View.INVISIBLE);
                            String temp = " A5 ---> A4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a4_pos = true;
                            a5_pos = false;
                            container_a4 = "pawn_w";
                            container_a5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a4_pos == true && a5_pos == true && container_a5 == "pawn_w") {
                            if (container_a4 == "pawn" || container_a4 == "castle") {
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a5.setVisibility(View.INVISIBLE);
                                String temp = " A5 ---> A4    "+name_new+"    "+container_a4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a4_pos = true;
                                a5_pos = false;
                                container_a4 = "pawn_w";
                                container_a5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (a4_pos == true && a5_pos == true && container_a5 == "castle_w") {
                            if (container_a4 == "pawn" || container_a4 == "castle") {
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a5.setVisibility(View.INVISIBLE);
                                String temp = " A5 ---> A4    "+name_new+"    "+container_a4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a4_pos = true;
                                a5_pos = false;
                                container_a4 = "castle_w";
                                container_a5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            a3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a2_pos == false && a3_pos == true && container_a3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a2.setVisibility(View.VISIBLE);
                            }else{
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a2.setVisibility(View.VISIBLE);
                            }
                        } else if (a2_pos == false && a3_pos == true && container_a3 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a2.setVisibility(View.VISIBLE);
                            }else{
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a2.setVisibility(View.VISIBLE);
                            }
                        } else if (a3_pos == false && container_a4 == "castle_w") {
                            a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a4.setVisibility(View.INVISIBLE);
                            String temp = " A4 ---> A3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a3_pos = true;
                            a4_pos = false;
                            container_a3 = "castle_w";
                            container_a4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a3_pos == false && container_a4 == "pawn_w") {
                            a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a4.setVisibility(View.INVISIBLE);
                            String temp = " A4 ---> A3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a3_pos = true;
                            a4_pos = false;
                            container_a3 = "pawn_w";
                            container_a4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a3_pos == true && a4_pos == true && container_a4 == "pawn_w") {
                            if (container_a3 == "pawn" || container_a3 == "castle") {
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a4.setVisibility(View.INVISIBLE);
                                String temp = " A4 ---> A3    "+name_new+"    "+container_a3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a3_pos = true;
                                a4_pos = false;
                                container_a3 = "pawn_w";
                                container_a4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (a3_pos == true && a4_pos == true && container_a4 == "castle_w") {
                            if (container_a3 == "pawn" || container_a3 == "castle") {
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a4.setVisibility(View.INVISIBLE);
                                String temp = " A4 ---> A3    "+name_new+"    "+container_a3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a3_pos = true;
                                a4_pos = false;
                                container_a3 = "castle_w";
                                container_a4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            a2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a1_pos == false && a2_pos == true && container_a2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a1.setVisibility(View.VISIBLE);
                            }else{
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a1.setVisibility(View.VISIBLE);
                            }
                        } else if (a1_pos == false && a2_pos == true && container_a2 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a1.setVisibility(View.VISIBLE);
                            }else{
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a1.setVisibility(View.VISIBLE);
                            }
                        } else if (a2_pos == false && container_a3 == "castle_w") {
                            a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a3.setVisibility(View.INVISIBLE);
                            String temp = " A3 ---> A2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a2_pos = true;
                            a3_pos = false;
                            container_a2 = "castle_w";
                            container_a3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a2_pos == false && container_a3 == "pawn_w") {
                            a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a3.setVisibility(View.INVISIBLE);
                            String temp = " A3 ---> A2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a2_pos = true;
                            a3_pos = false;
                            container_a2 = "pawn_w";
                            container_a3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (a2_pos == true && a3_pos == true && container_a3 == "pawn_w") {
                            if (container_a2 == "pawn" || container_a2 == "castle") {
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a3.setVisibility(View.INVISIBLE);
                                String temp = " A3 ---> A2    "+name_new+"    "+container_a2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a2_pos = true;
                                a3_pos = false;
                                container_a2 = "pawn_w";
                                container_a3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (a2_pos == true && a3_pos == true && container_a3 == "castle_w") {
                            if (container_a2 == "pawn" || container_a2 == "castle") {
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a3.setVisibility(View.INVISIBLE);
                                String temp = " A3 ---> A2    "+name_new+"    "+container_a2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a2_pos = true;
                                a3_pos = false;
                                container_a2 = "castle_w";
                                container_a3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            a1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (a1_pos == false && container_a2 == "castle_w") {
                            a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            a2.setVisibility(View.INVISIBLE);
                            String temp = " A2 ---> A1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a1_pos = true;
                            a2_pos = false;
                            container_a1 = "castle_w";
                            container_a2 = "";
                            flag = 1;
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (a1_pos == false && container_a2 == "pawn_w") {
                            a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            a2.setVisibility(View.INVISIBLE);
                            String temp = " A2 ---> A1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a1_pos = true;
                            a2_pos = false;
                            container_a1 = "pawn_w";
                            container_a2 = "";
                            flag = 1;
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (a1_pos == true && a2_pos == true && container_a2 == "pawn_w") {
                            if (container_a1 == "pawn" || container_a1 == "castle") {
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                a2.setVisibility(View.INVISIBLE);
                                String temp = " A2 ---> A1    "+name_new+"    "+container_a1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a1_pos = true;
                                a2_pos = false;
                                container_a1 = "pawn_w";
                                container_a2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        } else if (a1_pos == true && a2_pos == true && container_a2 == "castle_w") {
                            if (container_a1 == "pawn" || container_a1 == "castle") {
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                a2.setVisibility(View.INVISIBLE);
                                String temp = " A2 ---> A1    "+name_new+"    "+container_a1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a1_pos = true;
                                a2_pos = false;
                                container_a1 = "castle_w";
                                container_a2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
        }
        if (container_b1 == "pawn_w" || container_b2 == "pawn_w" || container_b3 == "pawn_w" || container_b4 == "pawn_w" || container_b5 == "pawn_w" || container_b6 == "pawn_w" || container_b7 == "pawn_w" || container_b8 == "pawn_w" || container_b1 == "knight_w" || container_b2 == "knight_w" || container_b3 == "knight_w" || container_b4 == "knight_w" || container_b5 == "knight_w" || container_b6 == "knight_w" || container_b7 == "knight_w" || container_b8 == "knight_w") {
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b7.setVisibility(View.VISIBLE);
                            }else{
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b6_pos == false && b7_pos == true && container_b7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b6.setVisibility(View.VISIBLE);
                            }else{
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b6.setVisibility(View.VISIBLE);
                            }
                        } else if (b6_pos == false && b7_pos == true && container_b7 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b6.setVisibility(View.VISIBLE);
                            }else{
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b6.setVisibility(View.VISIBLE);
                            }
                        } else if (b7_pos == false && container_b8 == "knight_w") {
                            b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                            b8.setVisibility(View.INVISIBLE);
                            String temp = " B8 ---> B7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b7_pos = true;
                            b8_pos = false;
                            container_b7 = "knight_w";
                            container_b8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b7_pos == false && container_b8 == "pawn_w") {
                            b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b8.setVisibility(View.INVISIBLE);
                            String temp = " B8 ---> B7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b7_pos = true;
                            b8_pos = false;
                            container_b7 = "pawn_w";
                            container_b8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b7_pos == true && b8_pos == true && container_b8 == "pawn_w") {
                            if (container_b7 == "pawn" || container_b7 == "knight") {
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b8.setVisibility(View.INVISIBLE);
                                String temp = " B8 ---> B7    "+name_new+"    "+container_b7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b7_pos = true;
                                b8_pos = false;
                                container_b7 = "pawn_w";
                                container_b8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (b7_pos == true && b8_pos == true && container_b8 == "knight_w") {
                            if (container_b7 == "pawn" || container_b7 == "knight") {
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                                b8.setVisibility(View.INVISIBLE);
                                String temp = " B8 ---> B7    "+name_new+"    "+container_b7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b7_pos = true;
                                b8_pos = false;
                                container_b7 = "knight_w";
                                container_b8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b5_pos == false && b6_pos == true && container_b6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b5.setVisibility(View.VISIBLE);
                            }else{
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b5.setVisibility(View.VISIBLE);
                            }
                        } else if (b5_pos == false && b6_pos == true && container_b6 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b5.setVisibility(View.VISIBLE);
                            }else{
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b5.setVisibility(View.VISIBLE);
                            }
                        } else if (b6_pos == false && container_b7 == "knight_w") {
                            b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                            b7.setVisibility(View.INVISIBLE);
                            String temp = " B7 ---> B6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b6_pos = true;
                            b7_pos = false;
                            container_b6 = "knight_w";
                            container_b7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b6_pos == false && container_b7 == "pawn_w") {
                            b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b7.setVisibility(View.INVISIBLE);
                            String temp = " B7 ---> B6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b6_pos = true;
                            b7_pos = false;
                            container_b6 = "pawn_w";
                            container_b7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b6_pos == true && b7_pos == true && container_b7 == "pawn_w") {
                            if (container_b6 == "pawn" || container_b6 == "knight") {
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b7.setVisibility(View.INVISIBLE);
                                String temp = " B7 ---> B6    "+name_new+"    "+container_b6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b6_pos = true;
                                b7_pos = false;
                                container_b6 = "pawn_w";
                                container_b7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (b6_pos == true && b7_pos == true && container_b7 == "knight_w") {
                            if (container_b6 == "pawn" || container_b6 == "knight") {
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                                b7.setVisibility(View.INVISIBLE);
                                String temp = " B7 ---> B6    "+name_new+"    "+container_b6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b6_pos = true;
                                b7_pos = false;
                                container_b6 = "knight_w";
                                container_b7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b4_pos == false && b5_pos == true && container_b5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b4.setVisibility(View.VISIBLE);
                            }else{
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b4.setVisibility(View.VISIBLE);
                            }
                        } else if (b4_pos == false && b5_pos == true && container_b5 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b4.setVisibility(View.VISIBLE);
                            }else{
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b4.setVisibility(View.VISIBLE);
                            }
                        } else if (b5_pos == false && container_b6 == "knight_w") {
                            b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                            b6.setVisibility(View.INVISIBLE);
                            String temp = " B6 ---> B5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b5_pos = true;
                            b6_pos = false;
                            container_b5 = "knight_w";
                            container_b6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b5_pos == false && container_b6 == "pawn_w") {
                            b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b6.setVisibility(View.INVISIBLE);
                            String temp = " B6 ---> B5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b5_pos = true;
                            b6_pos = false;
                            container_b5 = "pawn_w";
                            container_b6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b5_pos == true && b6_pos == true && container_b6 == "pawn_w") {
                            if (container_b5 == "pawn" || container_b5 == "knight") {
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b6.setVisibility(View.INVISIBLE);
                                String temp = " B6 ---> B5    "+name_new+"    "+container_b5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b5_pos = true;
                                b6_pos = false;
                                container_b5 = "pawn_w";
                                container_b6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (b5_pos == true && b6_pos == true && container_b6 == "knight_w") {
                            if (container_b5 == "pawn" || container_b5 == "knight") {
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                                b6.setVisibility(View.INVISIBLE);
                                String temp = " B6 ---> B5    "+name_new+"    "+container_b5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b5_pos = true;
                                b6_pos = false;
                                container_b5 = "knight_w";
                                container_b6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b3_pos == false && b4_pos == true && container_b4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b3.setVisibility(View.VISIBLE);
                            }else{
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b3.setVisibility(View.VISIBLE);
                            }
                        } else if (b3_pos == false && b4_pos == true && container_b4 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b3.setVisibility(View.VISIBLE);
                            }else{
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b3.setVisibility(View.VISIBLE);
                            }
                        } else if (b4_pos == false && container_b5 == "knight_w") {
                            b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            b5.setVisibility(View.INVISIBLE);
                            String temp = " B5 ---> B4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b4_pos = true;
                            b5_pos = false;
                            container_b4 = "knight_w";
                            container_b5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b4_pos == false && container_b5 == "pawn_w") {
                            b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b5.setVisibility(View.INVISIBLE);
                            String temp = " B5 ---> B4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b4_pos = true;
                            b5_pos = false;
                            container_b4 = "pawn_w";
                            container_b5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b4_pos == true && b5_pos == true && container_b5 == "pawn_w") {
                            if (container_b4 == "pawn" || container_b4 == "knight") {
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b5.setVisibility(View.INVISIBLE);
                                String temp = " B5 ---> B4    "+name_new+"    "+container_b4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b4_pos = true;
                                b5_pos = false;
                                container_b4 = "pawn_w";
                                container_b5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (b4_pos == true && b5_pos == true && container_b5 == "knight_w") {
                            if (container_b4 == "pawn" || container_b4 == "knight") {
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                b5.setVisibility(View.INVISIBLE);
                                String temp = " B5 ---> B4    "+name_new+"    "+container_b4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b4_pos = true;
                                b5_pos = false;
                                container_b4 = "knight_w";
                                container_b5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b2_pos == false && b3_pos == true && container_b3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b2.setVisibility(View.VISIBLE);
                            }else{
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b2.setVisibility(View.VISIBLE);
                            }
                        } else if (b2_pos == false && b3_pos == true && container_b3 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b2.setVisibility(View.VISIBLE);
                            }else{
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b2.setVisibility(View.VISIBLE);
                            }
                        } else if (b3_pos == false && container_b4 == "knight_w") {
                            b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            b4.setVisibility(View.INVISIBLE);
                            String temp = " B4 ---> B3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b3_pos = true;
                            b4_pos = false;
                            container_b3 = "knight_w";
                            container_b4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b3_pos == false && container_b4 == "pawn_w") {
                            b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b4.setVisibility(View.INVISIBLE);
                            String temp = " B4 ---> B3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b3_pos = true;
                            b4_pos = false;
                            container_b3 = "pawn_w";
                            container_b4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b3_pos == true && b4_pos == true && container_b4 == "pawn_w") {
                            if (container_b3 == "pawn" || container_b3 == "knight") {
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b4.setVisibility(View.INVISIBLE);
                                String temp = " B4 ---> B3    "+name_new+"    "+container_b3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b3_pos = true;
                                b4_pos = false;
                                container_b3 = "pawn_w";
                                container_b4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (b3_pos == true && b4_pos == true && container_b4 == "knight_w") {
                            if (container_b3 == "pawn" || container_b3 == "knight") {
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                b4.setVisibility(View.INVISIBLE);
                                String temp = " B4 ---> B3    "+name_new+"    "+container_b3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b3_pos = true;
                                b4_pos = false;
                                container_b3 = "knight_w";
                                container_b4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b1_pos == false && b2_pos == true && container_b2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b1.setVisibility(View.VISIBLE);
                            }else{
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b1.setVisibility(View.VISIBLE);
                            }
                        } else if (b1_pos == false && b2_pos == true && container_b2 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b1.setVisibility(View.VISIBLE);
                            }else{
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b1.setVisibility(View.VISIBLE);
                            }
                        } else if (b2_pos == false && container_b3 == "knight_w") {
                            b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            b3.setVisibility(View.INVISIBLE);
                            String temp = " B3 ---> B2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b2_pos = true;
                            b3_pos = false;
                            container_b2 = "knight_w";
                            container_b3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b2_pos == false && container_b3 == "pawn_w") {
                            b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b3.setVisibility(View.INVISIBLE);
                            String temp = " B3 ---> B2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b2_pos = true;
                            b3_pos = false;
                            container_b2 = "pawn_w";
                            container_b3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (b2_pos == true && b3_pos == true && container_b3 == "pawn_w") {
                            if (container_b2 == "pawn" || container_b2 == "knight") {
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b3.setVisibility(View.INVISIBLE);
                                String temp = " B3 ---> B2    "+name_new+"    "+container_b2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b2_pos = true;
                                b3_pos = false;
                                container_b2 = "pawn_w";
                                container_b3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (b2_pos == true && b3_pos == true && container_b3 == "knight_w") {
                            if (container_b2 == "pawn" || container_b2 == "knight") {
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                b3.setVisibility(View.INVISIBLE);
                                String temp = " B3 ---> B2    "+name_new+"    "+container_b2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b2_pos = true;
                                b3_pos = false;
                                container_b2 = "knight_w";
                                container_b3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (b1_pos == false && container_b2 == "knight_w") {
                            b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            b2.setVisibility(View.INVISIBLE);
                            String temp = " B2 ---> B1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b1_pos = true;
                            b2_pos = false;
                            container_b1 = "knight_w";
                            container_b2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                            flag = 1;
                        } else if (b1_pos == false && container_b2 == "pawn_w") {
                            b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            b2.setVisibility(View.INVISIBLE);
                            String temp = " B2 ---> B1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b1_pos = true;
                            b2_pos = false;
                            container_b1 = "pawn_w";
                            container_b2 = "";
                            dialogwin();
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            flag = 1;
                        } else if (b1_pos == true && b2_pos == true && container_b2 == "pawn_w") {
                            if (container_b1 == "pawn" || container_b1 == "knight") {
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                b2.setVisibility(View.INVISIBLE);
                                String temp = " B2 ---> B1    "+name_new+"    "+container_b1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b1_pos = true;
                                b2_pos = false;
                                container_b1 = "pawn_w";
                                container_b2 = "";
                                dialogwin();
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                flag = 1;
                            }
                        } else if (b1_pos == true && b2_pos == true && container_b2 == "knight_w") {
                            if (container_b1 == "pawn" || container_b1 == "knight") {
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                b2.setVisibility(View.INVISIBLE);
                                String temp = " B2 ---> B1    "+name_new+"    "+container_b1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b1_pos = true;
                                b2_pos = false;
                                container_b1 = "knight_w";
                                container_b2 = "";
                                flag = 1;
                                dialogwin();
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                            }
                        }
                    }
                }
            });
        }
        if (container_c1 == "pawn_w" || container_c2 == "pawn_w" || container_c3 == "pawn_w" || container_c4 == "pawn_w" || container_c5 == "pawn_w" || container_c6 == "pawn_w" || container_c7 == "pawn_w" || container_c8 == "pawn_w" || container_c1 == "bishop_w" || container_c2 == "bishop_w" || container_c3 == "bishop_w" || container_c4 == "bishop_w" || container_c5 == "bishop_w" || container_c6 == "bishop_w" || container_c7 == "bishop_w" || container_c8 == "bishop_w")  {
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c7.setVisibility(View.VISIBLE);
                            }else{
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c6_pos == false && c7_pos == true && container_c7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c6.setVisibility(View.VISIBLE);
                            }else{
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c6.setVisibility(View.VISIBLE);
                            }
                        } else if (c6_pos == false && c7_pos == true && container_c7 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c6.setVisibility(View.VISIBLE);
                            }else{
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c6.setVisibility(View.VISIBLE);
                            }
                        } else if (c7_pos == false && container_c8 == "bishop_w") {
                            c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c8.setVisibility(View.INVISIBLE);
                            String temp = " C8 ---> C7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c7_pos = true;
                            c8_pos = false;
                            container_c7 = "bishop_w";
                            container_c8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c7_pos == false && container_c8 == "pawn_w") {
                            c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c8.setVisibility(View.INVISIBLE);
                            String temp = " C8 ---> C7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c7_pos = true;
                            c8_pos = false;
                            container_c7 = "pawn_w";
                            container_c8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c7_pos == true && c8_pos == true && container_c8 == "pawn_w") {
                            if (container_c7 == "pawn" || container_c7 == "bishop") {
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c8.setVisibility(View.INVISIBLE);
                                String temp = " C8 ---> C7    "+name_new+"    "+container_c7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c7_pos = true;
                                c8_pos = false;
                                container_c7 = "pawn_w";
                                container_c8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (c7_pos == true && c8_pos == true && container_c8 == "bishop_w") {
                            if (container_c7 == "pawn" || container_c7 == "bishop") {
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c8.setVisibility(View.INVISIBLE);
                                String temp = " C8 ---> C7    "+name_new+"    "+container_c7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c7_pos = true;
                                c8_pos = false;
                                container_c7 = "bishop_w";
                                container_c8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c5_pos == false && c6_pos == true && container_c6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c5.setVisibility(View.VISIBLE);
                            }else{
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c5.setVisibility(View.VISIBLE);
                            }
                        } else if (c5_pos == false && c6_pos == true && container_c6 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c5.setVisibility(View.VISIBLE);
                            }else{
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c5.setVisibility(View.VISIBLE);
                            }
                        } else if (c6_pos == false && container_c7 == "bishop_w") {
                            c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c7.setVisibility(View.INVISIBLE);
                            String temp = " C7 ---> C6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c6_pos = true;
                            c7_pos = false;
                            container_c6 = "bishop_w";
                            container_c7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c6_pos == false && container_c7 == "pawn_w") {
                            c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c7.setVisibility(View.INVISIBLE);
                            String temp = " C7 ---> C6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c6_pos = true;
                            c7_pos = false;
                            container_c6 = "pawn_w";
                            container_c7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c6_pos == true && c7_pos == true && container_c7 == "pawn_w") {
                            if (container_c6 == "pawn" || container_c6 == "bishop") {
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c7.setVisibility(View.INVISIBLE);
                                String temp = " C7 ---> C6    "+name_new+"    "+container_c6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c6_pos = true;
                                c7_pos = false;
                                container_c6 = "pawn_w";
                                container_c7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (c6_pos == true && c7_pos == true && container_c7 == "bishop_w") {
                            if (container_c6 == "pawn" || container_c6 == "bishop") {
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c7.setVisibility(View.INVISIBLE);
                                String temp = " C7 ---> C6    "+name_new+"    "+container_c6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c6_pos = true;
                                c7_pos = false;
                                container_c6 = "bishop_w";
                                container_c7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c4_pos == false && c5_pos == true && container_c5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c4.setVisibility(View.VISIBLE);
                            }else{
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c4.setVisibility(View.VISIBLE);
                            }
                        } else if (c4_pos == false && c5_pos == true && container_c5 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c4.setVisibility(View.VISIBLE);
                            }else{
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c4.setVisibility(View.VISIBLE);
                            }
                        } else if (c5_pos == false && container_c6 == "bishop_w") {
                            c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c6.setVisibility(View.INVISIBLE);
                            String temp = " C6 ---> C5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c5_pos = true;
                            c6_pos = false;
                            container_c5 = "bishop_w";
                            container_c6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c5_pos == false && container_c6 == "pawn_w") {
                            c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c6.setVisibility(View.INVISIBLE);
                            String temp = " C6 ---> C5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c5_pos = true;
                            c6_pos = false;
                            container_c5 = "pawn_w";
                            container_c6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c5_pos == true && c6_pos == true && container_c6 == "pawn_w") {
                            if (container_c5 == "pawn" || container_c5 == "bishop") {
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c6.setVisibility(View.INVISIBLE);
                                String temp = " C6 ---> C5    "+name_new+"    "+container_c5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c5_pos = true;
                                c6_pos = false;
                                container_c5 = "pawn_w";
                                container_c6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (c5_pos == true && c6_pos == true && container_c6 == "bishop_w") {
                            if (container_c5 == "pawn" || container_c5 == "bishop") {
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c6.setVisibility(View.INVISIBLE);
                                String temp = " C6 ---> C5    "+name_new+"    "+container_c5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c5_pos = true;
                                c6_pos = false;
                                container_c5 = "bishop_w";
                                container_c6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c3_pos == false && c4_pos == true && container_c4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c3.setVisibility(View.VISIBLE);
                            }else{
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c3.setVisibility(View.VISIBLE);
                            }
                        } else if (c3_pos == false && c4_pos == true && container_c4 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c3.setVisibility(View.VISIBLE);
                            }else{
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c3.setVisibility(View.VISIBLE);
                            }
                        } else if (c4_pos == false && container_c5 == "bishop_w") {
                            c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c5.setVisibility(View.INVISIBLE);
                            String temp = " C5 ---> C4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c4_pos = true;
                            c5_pos = false;
                            container_c4 = "bishop_w";
                            container_c5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c4_pos == false && container_c5 == "pawn_w") {
                            c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c5.setVisibility(View.INVISIBLE);
                            String temp = " C5 ---> C4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c4_pos = true;
                            c5_pos = false;
                            container_c4 = "pawn_w";
                            container_c5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c4_pos == true && c5_pos == true && container_c5 == "pawn_w") {
                            if (container_c4 == "pawn" || container_c4 == "bishop") {
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c5.setVisibility(View.INVISIBLE);
                                String temp = " C5 ---> C4    "+name_new+"    "+container_c4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c4_pos = true;
                                c5_pos = false;
                                container_c4 = "pawn_w";
                                container_c5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (c4_pos == true && c5_pos == true && container_c5 == "bishop_w") {
                            if (container_c4 == "pawn" || container_c4 == "bishop") {
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c5.setVisibility(View.INVISIBLE);
                                String temp = " C5 ---> C4    "+name_new+"    "+container_c4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c4_pos = true;
                                c5_pos = false;
                                container_c4 = "bishop_w";
                                container_c5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c2_pos == false && c3_pos == true && container_c3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c2.setVisibility(View.VISIBLE);
                            }else{
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c2.setVisibility(View.VISIBLE);
                            }
                        } else if (c2_pos == false && c3_pos == true && container_c3 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c2.setVisibility(View.VISIBLE);
                            }else{
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c2.setVisibility(View.VISIBLE);
                            }
                        } else if (c3_pos == false && container_c4 == "bishop_w") {
                            c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c4.setVisibility(View.INVISIBLE);
                            String temp = " C4 ---> C3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c3_pos = true;
                            c4_pos = false;
                            container_c3 = "bishop_w";
                            container_c4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c3_pos == false && container_c4 == "pawn_w") {
                            c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c4.setVisibility(View.INVISIBLE);
                            String temp = " C4 ---> C3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c3_pos = true;
                            c4_pos = false;
                            container_c3 = "pawn_w";
                            container_c4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c3_pos == true && c4_pos == true && container_c4 == "pawn_w") {
                            if (container_c3 == "pawn" || container_c3 == "bishop") {
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c4.setVisibility(View.INVISIBLE);
                                String temp = " C4 ---> C3    "+name_new+"    "+container_c3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c3_pos = true;
                                c4_pos = false;
                                container_c3 = "pawn_w";
                                container_c4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (c3_pos == true && c4_pos == true && container_c4 == "bishop_w") {
                            if (container_c3 == "pawn" || container_c3 == "bishop") {
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c4.setVisibility(View.INVISIBLE);
                                String temp = " C4 ---> C3    "+name_new+"    "+container_c3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c3_pos = true;
                                c4_pos = false;
                                container_c3 = "bishop_w";
                                container_c4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c1_pos == false && c2_pos == true && container_c2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c1.setVisibility(View.VISIBLE);
                            }else{
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c1.setVisibility(View.VISIBLE);
                            }
                        } else if (c1_pos == false && c2_pos == true && container_c2 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c1.setVisibility(View.VISIBLE);
                            }else{
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c1.setVisibility(View.VISIBLE);
                            }
                        } else if (c2_pos == false && container_c3 == "bishop_w") {
                            c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c3.setVisibility(View.INVISIBLE);
                            String temp = " C3 ---> C2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c2_pos = true;
                            c3_pos = false;
                            container_c2 = "bishop_w";
                            container_c3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c2_pos == false && container_c3 == "pawn_w") {
                            c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c3.setVisibility(View.INVISIBLE);
                            String temp = " C3 ---> C2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c2_pos = true;
                            c3_pos = false;
                            container_c2 = "pawn_w";
                            container_c3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (c2_pos == true && c3_pos == true && container_c3 == "pawn_w") {
                            if (container_c2 == "pawn" || container_c2 == "bishop") {
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c3.setVisibility(View.INVISIBLE);
                                String temp = " C3 ---> C2    "+name_new+"    "+container_c2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c2_pos = true;
                                c3_pos = false;
                                container_c2 = "pawn_w";
                                container_c3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (c2_pos == true && c3_pos == true && container_c3 == "bishop_w") {
                            if (container_c2 == "pawn" || container_c2 == "bishop") {
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c3.setVisibility(View.INVISIBLE);
                                String temp = " C3 ---> C2    "+name_new+"    "+container_c2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c2_pos = true;
                                c3_pos = false;
                                container_c2 = "bishop_w";
                                container_c3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (c1_pos == false && container_c2 == "bishop_w") {
                            c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            c2.setVisibility(View.INVISIBLE);
                            String temp = " C2 ---> C1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c1_pos = true;
                            c2_pos = false;
                            container_c1 = "bishop_w";
                            container_c2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            dialogwin();
                            bcdt.cancel();
                            wcdt.cancel();
                        } else if (c1_pos == false && container_c2 == "pawn_w") {
                            c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            c2.setVisibility(View.INVISIBLE);
                            String temp = " C2 ---> C1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c1_pos = true;
                            c2_pos = false;
                            container_c1 = "pawn_w";
                            container_c2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (c1_pos == true && c2_pos == true && container_c2 == "pawn_w") {
                            if (container_c1 == "pawn" || container_c1 == "bishop") {
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                c2.setVisibility(View.INVISIBLE);
                                String temp = " C2 ---> C1    "+name_new+"    "+container_c1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c1_pos = true;
                                c2_pos = false;
                                container_c1 = "pawn_w";
                                container_c2 = "";
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                flag = 1;
                                dialogwin();
                                bcdt.cancel();
                                wcdt.cancel();
                            }
                        } else if (c1_pos == true && c2_pos == true && container_c2 == "bishop_w") {
                            if (container_c1 == "pawn" || container_c1 == "bishop") {
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                c2.setVisibility(View.INVISIBLE);
                                String temp = " C2 ---> C1    "+name_new+"    "+container_c1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c1_pos = true;
                                c2_pos = false;
                                container_c1 = "bishop_w";
                                container_c2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                dialogwin();
                                bcdt.cancel();
                                wcdt.cancel();
                            }
                        }
                    }
                }
            });
        }
        if (container_d1 == "pawn_w" || container_d2 == "pawn_w" || container_d3 == "pawn_w" || container_d4 == "pawn_w" || container_d5 == "pawn_w" || container_d6 == "pawn_w" || container_d7 == "pawn_w" || container_d8 == "pawn_w" || container_d1 == "queen_w" || container_d2 == "queen_w" || container_d3 == "queen_w" || container_d4 == "queen_w" || container_d5 == "queen_w" || container_d6 == "queen_w" || container_d7 == "queen_w" || container_d8 == "queen_w")  {
            d8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d7.setVisibility(View.VISIBLE);
                            }else{
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            d7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d6_pos == false && d7_pos == true && container_d7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d6.setVisibility(View.VISIBLE);
                            }else{
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d6.setVisibility(View.VISIBLE);
                            }
                        } else if (d6_pos == false && d7_pos == true && container_d7 == "queen_w") {
                            if(Objects.equals(theme, "Green")){
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d6.setVisibility(View.VISIBLE);
                            }else{
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d6.setVisibility(View.VISIBLE);
                            }
                        } else if (d7_pos == false && container_d8 == "queen_w") {
                            d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d8.setVisibility(View.INVISIBLE);
                            String temp = " D8 ---> D7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d7_pos = true;
                            d8_pos = false;
                            container_d7 = "queen_w";
                            container_d8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d7_pos == false && container_d8 == "pawn_w") {
                            d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d8.setVisibility(View.INVISIBLE);
                            String temp = " D8 ---> D7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d7_pos = true;
                            d8_pos = false;
                            container_d7 = "pawn_w";
                            container_d8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d7_pos == true && d8_pos == true && container_d8 == "pawn_w") {
                            if (container_d7 == "pawn" || container_d7 == "queen") {
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d8.setVisibility(View.INVISIBLE);
                                String temp = " D8 ---> D7    "+name_new+"    "+container_d7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d7_pos = true;
                                d8_pos = false;
                                container_d7 = "pawn_w";
                                container_d8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (d7_pos == true && d8_pos == true && container_d8 == "queen_w") {
                            if (container_d7 == "pawn" || container_d7 == "queen") {
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d8.setVisibility(View.INVISIBLE);
                                String temp = " D8 ---> D7    "+name_new+"    "+container_d7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d7_pos = true;
                                d8_pos = false;
                                container_d7 = "queen_w";
                                container_d8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            d6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d5_pos == false && d6_pos == true && container_d6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d5.setVisibility(View.VISIBLE);
                            }else{
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d5.setVisibility(View.VISIBLE);
                            }
                        } else if (d5_pos == false && d6_pos == true && container_d6 == "queen_w") {
                            if(Objects.equals(theme, "Green")){
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d5.setVisibility(View.VISIBLE);
                            }else{
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d5.setVisibility(View.VISIBLE);
                            }
                        } else if (d6_pos == false && container_d7 == "queen_w") {
                            d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d7.setVisibility(View.INVISIBLE);
                            String temp = " D7 ---> D6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d6_pos = true;
                            d7_pos = false;
                            container_d6 = "queen_w";
                            container_d7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d6_pos == false && container_d7 == "pawn_w") {
                            d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d7.setVisibility(View.INVISIBLE);
                            String temp = " D7 ---> D6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d6_pos = true;
                            d7_pos = false;
                            container_d6 = "pawn_w";
                            container_d7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d6_pos == true && d7_pos == true && container_d7 == "pawn_w") {
                            if (container_d6 == "pawn" || container_d6 == "queen") {
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d7.setVisibility(View.INVISIBLE);
                                String temp = " D7 ---> D6    "+name_new+"    "+container_d6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d6_pos = true;
                                d7_pos = false;
                                container_d6 = "pawn_w";
                                container_d7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (d6_pos == true && d7_pos == true && container_d7 == "queen_w") {
                            if (container_d6 == "pawn" || container_d6 == "queen") {
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d7.setVisibility(View.INVISIBLE);
                                String temp = " D7 ---> D6    "+name_new+"    "+container_d6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d6_pos = true;
                                d7_pos = false;
                                container_d6 = "queen_w";
                                container_d7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            d5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d4_pos == false && d5_pos == true && container_d5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d4.setVisibility(View.VISIBLE);
                            }else{
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d4.setVisibility(View.VISIBLE);
                            }
                        } else if (d4_pos == false && d5_pos == true && container_d5 == "queen_w") {
                            if(Objects.equals(theme, "Green")){
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d4.setVisibility(View.VISIBLE);
                            }else{
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d4.setVisibility(View.VISIBLE);
                            }
                        } else if (d5_pos == false && container_d6 == "queen_w") {
                            d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d6.setVisibility(View.INVISIBLE);
                            String temp = " D6 ---> D5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d5_pos = true;
                            d6_pos = false;
                            container_d5 = "queen_w";
                            container_d6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d5_pos == false && container_d6 == "pawn_w") {
                            d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d6.setVisibility(View.INVISIBLE);
                            String temp = " D6 ---> D5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d5_pos = true;
                            d6_pos = false;
                            container_d5 = "pawn_w";
                            container_d6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d5_pos == true && d6_pos == true && container_d6 == "pawn_w") {
                            if (container_d5 == "pawn" || container_d5 == "queen") {
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d6.setVisibility(View.INVISIBLE);
                                String temp = " D6 ---> D5    "+name_new+"    "+container_d5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d5_pos = true;
                                d6_pos = false;
                                container_d5 = "pawn_w";
                                container_d6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (d5_pos == true && d6_pos == true && container_d6 == "queen_w") {
                            if (container_d5 == "pawn" || container_d5 == "queen") {
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d6.setVisibility(View.INVISIBLE);
                                String temp = " D6 ---> D5    "+name_new+"    "+container_d5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d5_pos = true;
                                d6_pos = false;
                                container_d5 = "queen_w";
                                container_d6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            d4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d3_pos == false && d4_pos == true && container_d4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d3.setVisibility(View.VISIBLE);
                            }else{
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d3.setVisibility(View.VISIBLE);
                            }
                        } else if (d3_pos == false && d4_pos == true && container_d4 == "queen_w") {
                            if(Objects.equals(theme, "Green")){
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d3.setVisibility(View.VISIBLE);
                            }else{
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d3.setVisibility(View.VISIBLE);
                            }
                        } else if (d4_pos == false && container_d5 == "queen_w") {
                            d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d5.setVisibility(View.INVISIBLE);
                            String temp = " D5 ---> D4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d4_pos = true;
                            d5_pos = false;
                            container_d4 = "queen_w";
                            container_d5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d4_pos == false && container_d5 == "pawn_w") {
                            d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d5.setVisibility(View.INVISIBLE);
                            String temp = " D5 ---> D4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d4_pos = true;
                            d5_pos = false;
                            container_d4 = "pawn_w";
                            container_d5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d4_pos == true && d5_pos == true && container_d5 == "pawn_w") {
                            if (container_d4 == "pawn" || container_d4 == "queen") {
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d5.setVisibility(View.INVISIBLE);
                                String temp = " D5 ---> D4    "+name_new+"    "+container_d4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d4_pos = true;
                                d5_pos = false;
                                container_d4 = "pawn_w";
                                container_d5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (d4_pos == true && d5_pos == true && container_d5 == "queen_w") {
                            if (container_d4 == "pawn" || container_d4 == "queen") {
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d5.setVisibility(View.INVISIBLE);
                                String temp = " D5 ---> D4    "+name_new+"    "+container_d4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d4_pos = true;
                                d5_pos = false;
                                container_d4 = "queen_w";
                                container_d5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            d3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d2_pos == false && d3_pos == true && container_d3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d2.setVisibility(View.VISIBLE);
                            }else{
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d2.setVisibility(View.VISIBLE);
                            }
                        } else if (d2_pos == false && d3_pos == true && container_d3 == "queen_w") {
                            if(Objects.equals(theme, "Green")){
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d2.setVisibility(View.VISIBLE);
                            }else{
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d2.setVisibility(View.VISIBLE);
                            }
                        } else if (d3_pos == false && container_d4 == "queen_w") {
                            d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d4.setVisibility(View.INVISIBLE);
                            String temp = " D4 ---> D3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d3_pos = true;
                            d4_pos = false;
                            container_d3 = "queen_w";
                            container_d4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d3_pos == false && container_d4 == "pawn_w") {
                            d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d4.setVisibility(View.INVISIBLE);
                            String temp = " D4 ---> D3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d3_pos = true;
                            d4_pos = false;
                            container_d3 = "pawn_w";
                            container_d4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d3_pos == true && d4_pos == true && container_d4 == "pawn_w") {
                            if (container_d3 == "pawn" || container_d3 == "queen") {
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d4.setVisibility(View.INVISIBLE);
                                String temp = " D4 ---> D3    "+name_new+"    "+container_d3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d3_pos = true;
                                d4_pos = false;
                                container_d3 = "pawn_w";
                                container_d4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (d3_pos == true && d4_pos == true && container_d4 == "queen_w") {
                            if (container_d3 == "pawn" || container_d3 == "queen") {
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d4.setVisibility(View.INVISIBLE);
                                String temp = " D4 ---> D3    "+name_new+"    "+container_d3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d3_pos = true;
                                d4_pos = false;
                                container_d3 = "queen_w";
                                container_d4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            d2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d1_pos == false && d2_pos == true && container_d2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d1.setVisibility(View.VISIBLE);
                            }else{
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d1.setVisibility(View.VISIBLE);
                            }
                        } else if (d1_pos == false && d2_pos == true && container_d2 == "queen_w") {
                            if(Objects.equals(theme, "Green")){
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d1.setVisibility(View.VISIBLE);
                            }else{
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d1.setVisibility(View.VISIBLE);
                            }
                        } else if (d2_pos == false && container_d3 == "queen_w") {
                            d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d3.setVisibility(View.INVISIBLE);
                            String temp = " D3 ---> D2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d2_pos = true;
                            d3_pos = false;
                            container_d2 = "queen_w";
                            container_d3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d2_pos == false && container_d3 == "pawn_w") {
                            d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d3.setVisibility(View.INVISIBLE);
                            String temp = " D3 ---> D2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d2_pos = true;
                            d3_pos = false;
                            container_d2 = "pawn_w";
                            container_d3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (d2_pos == true && d3_pos == true && container_d3 == "pawn_w") {
                            if (container_d2 == "pawn" || container_d2 == "queen") {
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d3.setVisibility(View.INVISIBLE);
                                String temp = " D3 ---> D2    "+name_new+"    "+container_d2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d2_pos = true;
                                d3_pos = false;
                                container_d2 = "pawn_w";
                                container_d3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (d2_pos == true && d3_pos == true && container_d3 == "queen_w") {
                            if (container_d2 == "pawn" || container_d2 == "queen") {
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d3.setVisibility(View.INVISIBLE);
                                String temp = " D3 ---> D2    "+name_new+"    "+container_d2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d2_pos = true;
                                d3_pos = false;
                                container_d2 = "queen_w";
                                container_d3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            d1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (d1_pos == false && container_d2 == "queen_w") {
                            d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                            d2.setVisibility(View.INVISIBLE);
                            String temp = " D2 ---> D1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d1_pos = true;
                            d2_pos = false;
                            container_d1 = "queen_w";
                            container_d2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            dialogwin();
                            bcdt.cancel();
                            wcdt.cancel();
                        } else if (d1_pos == false && container_d2 == "pawn_w") {
                            d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            d2.setVisibility(View.INVISIBLE);
                            String temp = " D2 ---> D1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d1_pos = true;
                            d2_pos = false;
                            container_d1 = "pawn_w";
                            container_d2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            dialogwin();
                            bcdt.cancel();
                            wcdt.cancel();
                        } else if (d1_pos == true && d2_pos == true && container_d2 == "pawn_w") {
                            if (container_d1 == "pawn" || container_d1 == "queen") {
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                d2.setVisibility(View.INVISIBLE);
                                String temp = " D2 ---> D1    "+name_new+"    "+container_d1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d1_pos = true;
                                d2_pos = false;
                                container_d1 = "pawn_w";
                                container_d2 = "";
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                flag = 1;
                                dialogwin();
                                bcdt.cancel();
                                wcdt.cancel();
                            }
                        } else if (d1_pos == true && d2_pos == true && container_d2 == "queen_w") {
                            if (container_d1 == "pawn" || container_d1 == "queen") {
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_w));
                                d2.setVisibility(View.INVISIBLE);
                                String temp = " D2 ---> D1    "+name_new+"    "+container_d1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d1_pos = true;
                                d2_pos = false;
                                container_d1 = "queen_w";
                                container_d2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                dialogwin();
                                bcdt.cancel();
                                wcdt.cancel();
                            }
                        }
                    }
                }
            });
        }
        if (container_e1 == "pawn_w" || container_e2 == "pawn_w" || container_e3 == "pawn_w" || container_e4 == "pawn_w" || container_e5 == "pawn_w" || container_e6 == "pawn_w" || container_e7 == "pawn_w" || container_e8 == "pawn_w" || container_e1 == "king_w" || container_e2 == "king_w" || container_e3 == "king_w" || container_e4 == "king_w" || container_e5 == "king_w" || container_e6 == "king_w" || container_e7 == "king_w" || container_e8 == "king_w")  {
            e8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e7.setVisibility(View.VISIBLE);
                            }else{
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            e7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e6_pos == false && e7_pos == true && container_e7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e6.setVisibility(View.VISIBLE);
                            }else{
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e6.setVisibility(View.VISIBLE);
                            }
                        } else if (e6_pos == false && e7_pos == true && container_e7 == "king_w") {
                            if(Objects.equals(theme, "Green")){
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e6.setVisibility(View.VISIBLE);
                            }else{
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e6.setVisibility(View.VISIBLE);
                            }
                        } else if (e7_pos == false && container_e8 == "king_w") {
                            e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e8.setVisibility(View.INVISIBLE);
                            String temp = " E8 ---> E7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e7_pos = true;
                            e8_pos = false;
                            container_e7 = "king_w";
                            container_e8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e7_pos == false && container_e8 == "pawn_w") {
                            e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e8.setVisibility(View.INVISIBLE);
                            String temp = " E8 ---> E7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e7_pos = true;
                            e8_pos = false;
                            container_e7 = "pawn_w";
                            container_e8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e7_pos == true && e8_pos == true && container_e8 == "pawn_w") {
                            if (container_e7 == "pawn" || container_e7 == "king") {
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e8.setVisibility(View.INVISIBLE);
                                String temp = " E8 ---> E7    "+name_new+"    "+container_e7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e7_pos = true;
                                e8_pos = false;
                                container_e7 = "pawn_w";
                                container_e8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (e7_pos == true && e8_pos == true && container_e8 == "king_w") {
                            if (container_e7 == "pawn" || container_e7 == "king") {
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e8.setVisibility(View.INVISIBLE);
                                String temp = " E8 ---> E7    "+name_new+"    "+container_e7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e7_pos = true;
                                e8_pos = false;
                                container_e7 = "king_w";
                                container_e8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            e6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e5_pos == false && e6_pos == true && container_e6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e5.setVisibility(View.VISIBLE);
                            }else{
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e5.setVisibility(View.VISIBLE);
                            }
                        } else if (e5_pos == false && e6_pos == true && container_e6 == "king_w") {
                            if(Objects.equals(theme, "Green")){
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e5.setVisibility(View.VISIBLE);
                            }else{
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e5.setVisibility(View.VISIBLE);
                            }
                        } else if (e6_pos == false && container_e7 == "king_w") {
                            e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e7.setVisibility(View.INVISIBLE);
                            String temp = " E7 ---> E6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e6_pos = true;
                            e7_pos = false;
                            container_e6 = "king_w";
                            container_e7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e6_pos == false && container_e7 == "pawn_w") {
                            e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e7.setVisibility(View.INVISIBLE);
                            String temp = " E7 ---> E6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e6_pos = true;
                            e7_pos = false;
                            container_e6 = "pawn_w";
                            container_e7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e6_pos == true && e7_pos == true && container_e7 == "pawn_w") {
                            if (container_e6 == "pawn" || container_e6 == "king") {
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e7.setVisibility(View.INVISIBLE);
                                String temp = " E7 ---> E6    "+name_new+"    "+container_e6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e6_pos = true;
                                e7_pos = false;
                                container_e6 = "pawn_w";
                                container_e7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (e6_pos == true && e7_pos == true && container_e7 == "king_w") {
                            if (container_e6 == "pawn" || container_e6 == "king") {
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e7.setVisibility(View.INVISIBLE);
                                String temp = " E7 ---> E6    "+name_new+"    "+container_e6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e6_pos = true;
                                e7_pos = false;
                                container_e6 = "king_w";
                                container_e7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            e5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e4_pos == false && e5_pos == true && container_e5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e4.setVisibility(View.VISIBLE);
                            }else{
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e4.setVisibility(View.VISIBLE);
                            }
                        } else if (e4_pos == false && e5_pos == true && container_e5 == "king_w") {
                            if(Objects.equals(theme, "Green")){
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e4.setVisibility(View.VISIBLE);
                            }else{
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e4.setVisibility(View.VISIBLE);
                            }
                        } else if (e5_pos == false && container_e6 == "king_w") {
                            e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e6.setVisibility(View.INVISIBLE);
                            String temp = " E6 ---> E5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e5_pos = true;
                            e6_pos = false;
                            container_e5 = "king_w";
                            container_e6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e5_pos == false && container_e6 == "pawn_w") {
                            e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e6.setVisibility(View.INVISIBLE);
                            String temp = " E6 ---> E5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e5_pos = true;
                            e6_pos = false;
                            container_e5 = "pawn_w";
                            container_e6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e5_pos == true && e6_pos == true && container_e6 == "pawn_w") {
                            if (container_e5 == "pawn" || container_e5 == "king") {
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e6.setVisibility(View.INVISIBLE);
                                String temp = " E6 ---> E5    "+name_new+"    "+container_e5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e5_pos = true;
                                e6_pos = false;
                                container_e5 = "pawn_w";
                                container_e6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (e5_pos == true && e6_pos == true && container_e6 == "king_w") {
                            if (container_e5 == "pawn" || container_e5 == "king") {
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e6.setVisibility(View.INVISIBLE);
                                String temp = " E6 ---> E5    "+name_new+"    "+container_e5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e5_pos = true;
                                e6_pos = false;
                                container_e5 = "king_w";
                                container_e6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            e4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e3_pos == false && e4_pos == true && container_e4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e3.setVisibility(View.VISIBLE);
                            }else{
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e3.setVisibility(View.VISIBLE);
                            }
                        } else if (e3_pos == false && e4_pos == true && container_e4 == "king_w") {
                            if(Objects.equals(theme, "Green")){
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e3.setVisibility(View.VISIBLE);
                            }else{
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e3.setVisibility(View.VISIBLE);
                            }
                        } else if (e4_pos == false && container_e5 == "king_w") {
                            e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e5.setVisibility(View.INVISIBLE);
                            String temp = " E5 ---> E4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e4_pos = true;
                            e5_pos = false;
                            container_e4 = "king_w";
                            container_e5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e4_pos == false && container_e5 == "pawn_w") {
                            e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e5.setVisibility(View.INVISIBLE);
                            String temp = " E5 ---> E4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e4_pos = true;
                            e5_pos = false;
                            container_e4 = "pawn_w";
                            container_e5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e4_pos == true && e5_pos == true && container_e5 == "pawn_w") {
                            if (container_e4 == "pawn" || container_e4 == "king") {
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e5.setVisibility(View.INVISIBLE);
                                String temp = " E5 ---> E4    "+name_new+"    "+container_e4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e4_pos = true;
                                e5_pos = false;
                                container_e4 = "pawn_w";
                                container_e5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (e4_pos == true && e5_pos == true && container_e5 == "king_w") {
                            if (container_e4 == "pawn" || container_e4 == "king") {
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e5.setVisibility(View.INVISIBLE);
                                String temp = " E5 ---> E4    "+name_new+"    "+container_e4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e4_pos = true;
                                e5_pos = false;
                                container_e4 = "king_w";
                                container_e5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            e3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e2_pos == false && e3_pos == true && container_e3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e2.setVisibility(View.VISIBLE);
                            }else{
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e2.setVisibility(View.VISIBLE);
                            }
                        } else if (e2_pos == false && e3_pos == true && container_e3 == "king_w") {
                            if(Objects.equals(theme, "Green")){
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e2.setVisibility(View.VISIBLE);
                            }else{
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e2.setVisibility(View.VISIBLE);
                            }
                        } else if (e3_pos == false && container_e4 == "king_w") {
                            e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e4.setVisibility(View.INVISIBLE);
                            String temp = " E4 ---> E3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e3_pos = true;
                            e4_pos = false;
                            container_e3 = "king_w";
                            container_e4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e3_pos == false && container_e4 == "pawn_w") {
                            e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e4.setVisibility(View.INVISIBLE);
                            String temp = " E4 ---> E3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e3_pos = true;
                            e4_pos = false;
                            container_e3 = "pawn_w";
                            container_e4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e3_pos == true && e4_pos == true && container_e4 == "pawn_w") {
                            if (container_e3 == "pawn" || container_e3 == "king") {
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e4.setVisibility(View.INVISIBLE);
                                String temp = " E4 ---> E3    "+name_new+"    "+container_e3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e3_pos = true;
                                e4_pos = false;
                                container_e3 = "pawn_w";
                                container_e4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (e3_pos == true && e4_pos == true && container_e4 == "king_w") {
                            if (container_e3 == "pawn" || container_e3 == "king") {
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e4.setVisibility(View.INVISIBLE);
                                String temp = " E4 ---> E3    "+name_new+"    "+container_e3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e3_pos = true;
                                e4_pos = false;
                                container_e3 = "king_w";
                                container_e4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            e2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e1_pos == false && e2_pos == true && container_e2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e1.setVisibility(View.VISIBLE);
                            }else{
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e1.setVisibility(View.VISIBLE);
                            }
                        } else if (e1_pos == false && e2_pos == true && container_e2 == "king_w") {
                            if(Objects.equals(theme, "Green")){
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e1.setVisibility(View.VISIBLE);
                            }else{
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e1.setVisibility(View.VISIBLE);
                            }
                        } else if (e2_pos == false && container_e3 == "king_w") {
                            e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e3.setVisibility(View.INVISIBLE);
                            String temp = " E3 ---> E2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e2_pos = true;
                            e3_pos = false;
                            container_e2 = "king_w";
                            container_e3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e2_pos == false && container_e3 == "pawn_w") {
                            e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e3.setVisibility(View.INVISIBLE);
                            String temp = " E3 ---> E2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e2_pos = true;
                            e3_pos = false;
                            container_e2 = "pawn_w";
                            container_e3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (e2_pos == true && e3_pos == true && container_e3 == "pawn_w") {
                            if (container_e2 == "pawn" || container_e2 == "king") {
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e3.setVisibility(View.INVISIBLE);
                                String temp = " E3 ---> E2    "+name_new+"    "+container_e2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e2_pos = true;
                                e3_pos = false;
                                container_e2 = "pawn_w";
                                container_e3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (e2_pos == true && e3_pos == true && container_e3 == "king_w") {
                            if (container_e2 == "pawn" || container_e2 == "king") {
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e3.setVisibility(View.INVISIBLE);
                                String temp = " E3 ---> E2    "+name_new+"    "+container_e2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e2_pos = true;
                                e3_pos = false;
                                container_e2 = "king_w";
                                container_e3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            e1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (e1_pos == false && container_e2 == "king_w") {
                            e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                            e2.setVisibility(View.INVISIBLE);
                            String temp = " E2 ---> E1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e1_pos = true;
                            e2_pos = false;
                            container_e1 = "king_w";
                            container_e2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (e1_pos == false && container_e2 == "pawn_w") {
                            e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            e2.setVisibility(View.INVISIBLE);
                            String temp = " E2 ---> E1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e1_pos = true;
                            e2_pos = false;
                            container_e1 = "pawn_w";
                            container_e2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (e1_pos == true && e2_pos == true && container_e2 == "pawn_w") {
                            if (container_e1 == "pawn" || container_e1 == "king") {
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                e2.setVisibility(View.INVISIBLE);
                                String temp = " E2 ---> E1    "+name_new+"    "+container_e1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e1_pos = true;
                                e2_pos = false;
                                container_e1 = "pawn_w";
                                container_e2 = "";
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        } else if (e1_pos == true && e2_pos == true && container_e2 == "king_w") {
                            if (container_e1 == "pawn" || container_e1 == "king") {
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_w));
                                e2.setVisibility(View.INVISIBLE);
                                String temp = " E2 ---> E1    "+name_new+"    "+container_e1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e1_pos = true;
                                e2_pos = false;
                                container_e1 = "king_w";
                                container_e2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
        }
        if (container_f1 == "pawn_w" || container_f2 == "pawn_w" || container_f3 == "pawn_w" || container_f4 == "pawn_w" || container_f5 == "pawn_w" || container_f6 == "pawn_w" || container_f7 == "pawn_w" || container_f8 == "pawn_w" || container_f1 == "bishop_w" || container_f2 == "bishop_w" || container_f3 == "bishop_w" || container_f4 == "bishop_w" || container_f5 == "bishop_w" || container_f6 == "bishop_w" || container_f7 == "bishop_w" || container_f8 == "bishop_w")  {
            f8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f7.setVisibility(View.VISIBLE);
                            }else{
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            f7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f6_pos == false && f7_pos == true && container_f7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f6.setVisibility(View.VISIBLE);
                            }else{
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f6.setVisibility(View.VISIBLE);
                            }
                        } else if (f6_pos == false && f7_pos == true && container_f7 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f6.setVisibility(View.VISIBLE);
                            }else{
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f6.setVisibility(View.VISIBLE);
                            }
                        } else if (f7_pos == false && container_f8 == "bishop_w") {
                            f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f8.setVisibility(View.INVISIBLE);
                            String temp = " F8 ---> F7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f7_pos = true;
                            f8_pos = false;
                            container_f7 = "bishop_w";
                            container_f8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f7_pos == false && container_f8 == "pawn_w") {
                            f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f8.setVisibility(View.INVISIBLE);
                            String temp = " F8 ---> F7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f7_pos = true;
                            f8_pos = false;
                            container_f7 = "pawn_w";
                            container_f8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f7_pos == true && f8_pos == true && container_f8 == "pawn_w") {
                            if (container_f7 == "pawn" || container_f7 == "bishop") {
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f8.setVisibility(View.INVISIBLE);
                                String temp = " F8 ---> F7    "+name_new+"    "+container_f7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f7_pos = true;
                                f8_pos = false;
                                container_f7 = "pawn_w";
                                container_f8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (f7_pos == true && f8_pos == true && container_f8 == "bishop_w") {
                            if (container_f7 == "pawn" || container_f7 == "bishop") {
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f8.setVisibility(View.INVISIBLE);
                                String temp = " F8 ---> F7    "+name_new+"    "+container_f7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f7_pos = true;
                                f8_pos = false;
                                container_f7 = "bishop_w";
                                container_f8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            f6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f5_pos == false && f6_pos == true && container_f6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f5.setVisibility(View.VISIBLE);
                            }else{
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f5.setVisibility(View.VISIBLE);
                            }
                        } else if (f5_pos == false && f6_pos == true && container_f6 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f5.setVisibility(View.VISIBLE);
                            }else{
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f5.setVisibility(View.VISIBLE);
                            }
                        } else if (f6_pos == false && container_f7 == "bishop_w") {
                            f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f7.setVisibility(View.INVISIBLE);
                            String temp = " F7 ---> F6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f6_pos = true;
                            f7_pos = false;
                            container_f6 = "bishop_w";
                            container_f7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f6_pos == false && container_f7 == "pawn_w") {
                            f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f7.setVisibility(View.INVISIBLE);
                            String temp = " F7 ---> F6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f6_pos = true;
                            f7_pos = false;
                            container_f6 = "pawn_w";
                            container_f7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f6_pos == true && f7_pos == true && container_f7 == "pawn_w") {
                            if (container_f6 == "pawn" || container_f6 == "bishop") {
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f7.setVisibility(View.INVISIBLE);
                                String temp = " F7 ---> F6    "+name_new+"    "+container_f6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f6_pos = true;
                                f7_pos = false;
                                container_f6 = "pawn_w";
                                container_f7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (f6_pos == true && f7_pos == true && container_f7 == "bishop_w") {
                            if (container_f6 == "pawn" || container_f6 == "bishop") {
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f7.setVisibility(View.INVISIBLE);
                                String temp = " F7 ---> F6    "+name_new+"    "+container_f6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f6_pos = true;
                                f7_pos = false;
                                container_f6 = "bishop_w";
                                container_f7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f4_pos == false && f5_pos == true && container_f5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f4.setVisibility(View.VISIBLE);
                            }else{
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f4.setVisibility(View.VISIBLE);
                            }
                        } else if (f4_pos == false && f5_pos == true && container_f5 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f4.setVisibility(View.VISIBLE);
                            }else{
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f4.setVisibility(View.VISIBLE);
                            }
                        } else if (f5_pos == false && container_f6 == "bishop_w") {
                            f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f6.setVisibility(View.INVISIBLE);
                            String temp = " F6 ---> F5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f5_pos = true;
                            f6_pos = false;
                            container_f5 = "bishop_w";
                            container_f6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f5_pos == false && container_f6 == "pawn_w") {
                            f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f6.setVisibility(View.INVISIBLE);
                            String temp = " F6 ---> F5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f5_pos = true;
                            f6_pos = false;
                            container_f5 = "pawn_w";
                            container_f6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f5_pos == true && f6_pos == true && container_f6 == "pawn_w") {
                            if (container_f5 == "pawn" || container_f5 == "bishop") {
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f6.setVisibility(View.INVISIBLE);
                                String temp = " F6 ---> F5    "+name_new+"    "+container_f5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f5_pos = true;
                                f6_pos = false;
                                container_f5 = "pawn_w";
                                container_f6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (f5_pos == true && f6_pos == true && container_f6 == "bishop_w") {
                            if (container_f5 == "pawn" || container_f5 == "bishop") {
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f6.setVisibility(View.INVISIBLE);
                                String temp = " F6 ---> F5    "+name_new+"    "+container_f5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f5_pos = true;
                                f6_pos = false;
                                container_f5 = "bishop_w";
                                container_f6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f3_pos == false && f4_pos == true && container_f4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f3.setVisibility(View.VISIBLE);
                            }else{
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f3.setVisibility(View.VISIBLE);
                            }
                        } else if (f3_pos == false && f4_pos == true && container_f4 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f3.setVisibility(View.VISIBLE);
                            }else{
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f3.setVisibility(View.VISIBLE);
                            }
                        } else if (f4_pos == false && container_f5 == "bishop_w") {
                            f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f5.setVisibility(View.INVISIBLE);
                            String temp = " F5 ---> F4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f4_pos = true;
                            f5_pos = false;
                            container_f4 = "bishop_w";
                            container_f5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f4_pos == false && container_f5 == "pawn_w") {
                            f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f5.setVisibility(View.INVISIBLE);
                            String temp = " F5 ---> F4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f4_pos = true;
                            f5_pos = false;
                            container_f4 = "pawn_w";
                            container_f5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f4_pos == true && f5_pos == true && container_f5 == "pawn_w") {
                            if (container_f4 == "pawn" || container_f4 == "bishop") {
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f5.setVisibility(View.INVISIBLE);
                                String temp = " F5 ---> F4    "+name_new+"    "+container_f4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f4_pos = true;
                                f5_pos = false;
                                container_f4 = "pawn_w";
                                container_f5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (f4_pos == true && f5_pos == true && container_f5 == "bishop_w") {
                            if (container_f4 == "pawn" || container_f4 == "bishop") {
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f5.setVisibility(View.INVISIBLE);
                                String temp = " F5 ---> F4    "+name_new+"    "+container_f4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f4_pos = true;
                                f5_pos = false;
                                container_f4 = "bishop_w";
                                container_f5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f2_pos == false && f3_pos == true && container_f3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f2.setVisibility(View.VISIBLE);
                            }else{
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f2.setVisibility(View.VISIBLE);
                            }
                        } else if (f2_pos == false && f3_pos == true && container_f3 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f2.setVisibility(View.VISIBLE);
                            }else{
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f2.setVisibility(View.VISIBLE);
                            }
                        } else if (f3_pos == false && container_f4 == "bishop_w") {
                            f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f4.setVisibility(View.INVISIBLE);
                            String temp = " F4 ---> F3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f3_pos = true;
                            f4_pos = false;
                            container_f3 = "bishop_w";
                            container_f4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f3_pos == false && container_f4 == "pawn_w") {
                            f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f4.setVisibility(View.INVISIBLE);
                            String temp = " F4 ---> F3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f3_pos = true;
                            f4_pos = false;
                            container_f3 = "pawn_w";
                            container_f4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f3_pos == true && f4_pos == true && container_f4 == "pawn_w") {
                            if (container_f3 == "pawn" || container_f3 == "bishop") {
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f4.setVisibility(View.INVISIBLE);
                                String temp = " F4 ---> F3    "+name_new+"    "+container_f3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f3_pos = true;
                                f4_pos = false;
                                container_f3 = "pawn_w";
                                container_f4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (f3_pos == true && f4_pos == true && container_f4 == "bishop_w") {
                            if (container_f3 == "pawn" || container_f3 == "bishop") {
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f4.setVisibility(View.INVISIBLE);
                                String temp = " F4 ---> F3    "+name_new+"    "+container_f3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f3_pos = true;
                                f4_pos = false;
                                container_f3 = "bishop_w";
                                container_f4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f1_pos == false && f2_pos == true && container_f2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f1.setVisibility(View.VISIBLE);
                            }else{
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f1.setVisibility(View.VISIBLE);
                            }
                        } else if (f1_pos == false && f2_pos == true && container_f2 == "bishop_w") {
                            if(Objects.equals(theme, "Green")){
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f1.setVisibility(View.VISIBLE);
                            }else{
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f1.setVisibility(View.VISIBLE);
                            }
                        } else if (f2_pos == false && container_f3 == "bishop_w") {
                            f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f3.setVisibility(View.INVISIBLE);
                            String temp = " F3 ---> F2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f2_pos = true;
                            f3_pos = false;
                            container_f2 = "bishop_w";
                            container_f3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f2_pos == false && container_f3 == "pawn_w") {
                            f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f3.setVisibility(View.INVISIBLE);
                            String temp = " F3 ---> F2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f2_pos = true;
                            f3_pos = false;
                            container_f2 = "pawn_w";
                            container_f3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (f2_pos == true && f3_pos == true && container_f3 == "pawn_w") {
                            if (container_f2 == "pawn" || container_f2 == "bishop") {
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f3.setVisibility(View.INVISIBLE);
                                String temp = " F3 ---> F2    "+name_new+"    "+container_f2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f2_pos = true;
                                f3_pos = false;
                                container_f2 = "pawn_w";
                                container_f3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (f2_pos == true && f3_pos == true && container_f3 == "bishop_w") {
                            if (container_f2 == "pawn" || container_f2 == "bishop") {
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f3.setVisibility(View.INVISIBLE);
                                String temp = " F3 ---> F2    "+name_new+"    "+container_f2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f2_pos = true;
                                f3_pos = false;
                                container_f2 = "bishop_w";
                                container_f3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (f1_pos == false && container_f2 == "bishop_w") {
                            f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                            f2.setVisibility(View.INVISIBLE);
                            String temp = " F2 ---> F1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f1_pos = true;
                            f2_pos = false;
                            container_f1 = "bishop_w";
                            container_f2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (f1_pos == false && container_f2 == "pawn_w") {
                            f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            f2.setVisibility(View.INVISIBLE);
                            String temp = " F2 ---> F1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f1_pos = true;
                            f2_pos = false;
                            container_f1 = "pawn_w";
                            container_f2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            flag = 1;
                            dialogwin();
                        } else if (f1_pos == true && f2_pos == true && container_f2 == "pawn_w") {
                            if (container_f1 == "pawn" || container_f1 == "bishop") {
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                f2.setVisibility(View.INVISIBLE);
                                String temp = " F2 ---> F1    "+name_new+"    "+container_f1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f1_pos = true;
                                f2_pos = false;
                                container_f1 = "pawn_w";
                                container_f2 = "";
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        } else if (f1_pos == true && f2_pos == true && container_f2 == "bishop_w") {
                            if (container_f1 == "pawn" || container_f1 == "bishop") {
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_w));
                                f2.setVisibility(View.INVISIBLE);
                                String temp = " F2 ---> F1    "+name_new+"    "+container_f1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f1_pos = true;
                                f2_pos = false;
                                container_f1 = "bishop_w";
                                container_f2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
        }
        if (container_g1 == "pawn_w" || container_g2 == "pawn_w" || container_g3 == "pawn_w" || container_g4 == "pawn_w" || container_g5 == "pawn_w" || container_g6 == "pawn_w" || container_g7 == "pawn_w" || container_g8 == "pawn_w" || container_g1 == "knight_w" || container_g2 == "knight_w" || container_g3 == "knight_w" || container_g4 == "knight_w" || container_g5 == "knight_w" || container_g6 == "knight_w" || container_g7 == "knight_w" || container_g8 == "knight_w") {
            g8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g7.setVisibility(View.VISIBLE);
                            }else{
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            g7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g6_pos == false && g7_pos == true && container_g7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g6.setVisibility(View.VISIBLE);
                            }else{
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g6.setVisibility(View.VISIBLE);
                            }
                        } else if (g6_pos == false && g7_pos == true && container_g7 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g6.setVisibility(View.VISIBLE);
                            }else{
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g6.setVisibility(View.VISIBLE);
                            }
                        } else if (g7_pos == false && container_g8 == "knight_w") {
                            g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                            g8.setVisibility(View.INVISIBLE);
                            String temp = " G8 ---> G7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g7_pos = true;
                            g8_pos = false;
                            container_g7 = "knight_w";
                            container_g8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g7_pos == false && container_g8 == "pawn_w") {
                            g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g8.setVisibility(View.INVISIBLE);
                            String temp = " G8 ---> G7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g7_pos = true;
                            g8_pos = false;
                            container_g7 = "pawn_w";
                            container_g8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g7_pos == true && g8_pos == true && container_g8 == "pawn_w") {
                            if (container_g7 == "pawn" || container_g7 == "knight") {
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g8.setVisibility(View.INVISIBLE);
                                String temp = " G8 ---> G7    "+name_new+"    "+container_g7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g7_pos = true;
                                g8_pos = false;
                                container_g7 = "pawn_w";
                                container_g8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (g7_pos == true && g8_pos == true && container_g8 == "knight_w") {
                            if (container_g7 == "pawn" || container_g7 == "knight") {
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                                g8.setVisibility(View.INVISIBLE);
                                String temp = " G8 ---> G7    "+name_new+"    "+container_g7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g7_pos = true;
                                g8_pos = false;
                                container_g7 = "knight_w";
                                container_g8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            g6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g5_pos == false && g6_pos == true && container_g6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g5.setVisibility(View.VISIBLE);
                            }else{
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g5.setVisibility(View.VISIBLE);
                            }
                        } else if (g5_pos == false && g6_pos == true && container_g6 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g5.setVisibility(View.VISIBLE);
                            }else{
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g5.setVisibility(View.VISIBLE);
                            }
                        } else if (g6_pos == false && container_g7 == "knight_w") {
                            g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                            g7.setVisibility(View.INVISIBLE);
                            String temp = " G7 ---> G6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g6_pos = true;
                            g7_pos = false;
                            container_g6 = "knight_w";
                            container_g7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g6_pos == false && container_g7 == "pawn_w") {
                            g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g7.setVisibility(View.INVISIBLE);
                            String temp = " G7 ---> G6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g6_pos = true;
                            g7_pos = false;
                            container_g6 = "pawn_w";
                            container_g7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g6_pos == true && g7_pos == true && container_g7 == "pawn_w") {
                            if (container_g6 == "pawn" || container_g6 == "knight") {
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g7.setVisibility(View.INVISIBLE);
                                String temp = " G7 ---> G6    "+name_new+"    "+container_g6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g6_pos = true;
                                g7_pos = false;
                                container_g6 = "pawn_w";
                                container_g7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (g6_pos == true && g7_pos == true && container_g7 == "knight_w") {
                            if (container_g6 == "pawn" || container_g6 == "knight") {
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                                g7.setVisibility(View.INVISIBLE);
                                String temp = " G7 ---> G6    "+name_new+"    "+container_g6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g6_pos = true;
                                g7_pos = false;
                                container_g6 = "knight_w";
                                container_g7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            g5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g4_pos == false && g5_pos == true && container_g5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g4.setVisibility(View.VISIBLE);
                            }else{
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g4.setVisibility(View.VISIBLE);
                            }
                        } else if (g4_pos == false && g5_pos == true && container_g5 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g4.setVisibility(View.VISIBLE);
                            }else{
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g4.setVisibility(View.VISIBLE);
                            }
                        } else if (g5_pos == false && container_g6 == "knight_w") {
                            g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                            g6.setVisibility(View.INVISIBLE);
                            String temp = " G6 ---> G5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g5_pos = true;
                            g6_pos = false;
                            container_g5 = "knight_w";
                            container_g6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g5_pos == false && container_g6 == "pawn_w") {
                            g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g6.setVisibility(View.INVISIBLE);
                            String temp = " G6 ---> G5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g5_pos = true;
                            g6_pos = false;
                            container_g5 = "pawn_w";
                            container_g6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g5_pos == true && g6_pos == true && container_g6 == "pawn_w") {
                            if (container_g5 == "pawn" || container_g5 == "knight") {
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g6.setVisibility(View.INVISIBLE);
                                String temp = " G6 ---> G5    "+name_new+"    "+container_g5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g5_pos = true;
                                g6_pos = false;
                                container_g5 = "pawn_w";
                                container_g6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (g5_pos == true && g6_pos == true && container_g6 == "knight_w") {
                            if (container_g5 == "pawn" || container_g5 == "knight") {
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_w));
                                g6.setVisibility(View.INVISIBLE);
                                String temp = " G6 ---> G5    "+name_new+"    "+container_g5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g5_pos = true;
                                g6_pos = false;
                                container_g5 = "knight_w";
                                container_g6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            g4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g3_pos == false && g4_pos == true && container_g4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g3.setVisibility(View.VISIBLE);
                            }else{
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g3.setVisibility(View.VISIBLE);
                            }
                        } else if (g3_pos == false && g4_pos == true && container_g4 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g3.setVisibility(View.VISIBLE);
                            }else{
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g3.setVisibility(View.VISIBLE);
                            }
                        } else if (g4_pos == false && container_g5 == "knight_w") {
                            g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            g5.setVisibility(View.INVISIBLE);
                            String temp = " G5 ---> G4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g4_pos = true;
                            g5_pos = false;
                            container_g4 = "knight_w";
                            container_g5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g4_pos == false && container_g5 == "pawn_w") {
                            g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g5.setVisibility(View.INVISIBLE);
                            String temp = " G5 ---> G4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g4_pos = true;
                            g5_pos = false;
                            container_g4 = "pawn_w";
                            container_g5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g4_pos == true && g5_pos == true && container_g5 == "pawn_w") {
                            if (container_g4 == "pawn" || container_g4 == "knight") {
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g5.setVisibility(View.INVISIBLE);
                                String temp = " G5 ---> G4    "+name_new+"    "+container_g4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g4_pos = true;
                                g5_pos = false;
                                container_g4 = "pawn_w";
                                container_g5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (g4_pos == true && g5_pos == true && container_g5 == "knight_w") {
                            if (container_g4 == "pawn" || container_g4 == "knight") {
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                g5.setVisibility(View.INVISIBLE);
                                String temp = " G5 ---> G4    "+name_new+"    "+container_g4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g4_pos = true;
                                g5_pos = false;
                                container_g4 = "knight_w";
                                container_g5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            g3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g2_pos == false && g3_pos == true && container_g3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g2.setVisibility(View.VISIBLE);
                            }else{
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g2.setVisibility(View.VISIBLE);
                            }
                        } else if (g2_pos == false && g3_pos == true && container_g3 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g2.setVisibility(View.VISIBLE);
                            }else{
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g2.setVisibility(View.VISIBLE);
                            }
                        } else if (g3_pos == false && container_g4 == "knight_w") {
                            g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            g4.setVisibility(View.INVISIBLE);
                            String temp = " G4 ---> G3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g3_pos = true;
                            g4_pos = false;
                            container_g3 = "knight_w";
                            container_g4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g3_pos == false && container_g4 == "pawn_w") {
                            g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g4.setVisibility(View.INVISIBLE);
                            String temp = " G4 ---> G3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g3_pos = true;
                            g4_pos = false;
                            container_g3 = "pawn_w";
                            container_g4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g3_pos == true && g4_pos == true && container_g4 == "pawn_w") {
                            if (container_g3 == "pawn" || container_g3 == "knight") {
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g4.setVisibility(View.INVISIBLE);
                                String temp = " G4 ---> G3    "+name_new+"    "+container_g3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g3_pos = true;
                                g4_pos = false;
                                container_g3 = "pawn_w";
                                container_g4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (g3_pos == true && g4_pos == true && container_g4 == "knight_w") {
                            if (container_g3 == "pawn" || container_g3 == "knight") {
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                g4.setVisibility(View.INVISIBLE);
                                String temp = " G4 ---> G3    "+name_new+"    "+container_g3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g3_pos = true;
                                g4_pos = false;
                                container_g3 = "knight_w";
                                container_g4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            g2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g1_pos == false && g2_pos == true && container_g2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g1.setVisibility(View.VISIBLE);
                            }else{
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g1.setVisibility(View.VISIBLE);
                            }
                        } else if (g1_pos == false && g2_pos == true && container_g2 == "knight_w") {
                            if(Objects.equals(theme, "Green")){
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g1.setVisibility(View.VISIBLE);
                            }else{
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g1.setVisibility(View.VISIBLE);
                            }
                        } else if (g2_pos == false && container_g3 == "knight_w") {
                            g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            g3.setVisibility(View.INVISIBLE);
                            String temp = " G3 ---> G2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g2_pos = true;
                            g3_pos = false;
                            container_g2 = "knight_w";
                            container_g3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g2_pos == false && container_g3 == "pawn_w") {
                            g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g3.setVisibility(View.INVISIBLE);
                            String temp = " G3 ---> G2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g2_pos = true;
                            g3_pos = false;
                            container_g2 = "pawn_w";
                            container_g3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (g2_pos == true && g3_pos == true && container_g3 == "pawn_w") {
                            if (container_g2 == "pawn" || container_g2 == "knight") {
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g3.setVisibility(View.INVISIBLE);
                                String temp = " G3 ---> G2    "+name_new+"    "+container_g2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g2_pos = true;
                                g3_pos = false;
                                container_g2 = "pawn_w";
                                container_g3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (g2_pos == true && g3_pos == true && container_g3 == "knight_w") {
                            if (container_g2 == "pawn" || container_g2 == "knight") {
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                g3.setVisibility(View.INVISIBLE);
                                String temp = " G3 ---> G2    "+name_new+"    "+container_g2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g2_pos = true;
                                g3_pos = false;
                                container_g2 = "knight_w";
                                container_g3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            g1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (g1_pos == false && container_g2 == "knight_w") {
                            g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            g2.setVisibility(View.INVISIBLE);
                            String temp = " G2 ---> G1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g1_pos = true;
                            g2_pos = false;
                            container_g1 = "knight_w";
                            container_g2 = "";
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                            flag = 1;
                        } else if (g1_pos == false && container_g2 == "pawn_w") {
                            g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            g2.setVisibility(View.INVISIBLE);
                            String temp = " G2 ---> G1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g1_pos = true;
                            g2_pos = false;
                            container_g1 = "pawn_w";
                            container_g2 = "";
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            flag = 1;
                        } else if (g1_pos == true && g2_pos == true && container_g2 == "pawn_w") {
                            if (container_g1 == "pawn" || container_g1 == "knight") {
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                g2.setVisibility(View.INVISIBLE);
                                String temp = " G2 ---> G1    "+name_new+"    "+container_g1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g1_pos = true;
                                g2_pos = false;
                                container_g1 = "pawn_w";
                                container_g2 = "";
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                flag = 1;
                            }
                        } else if (g1_pos == true && g2_pos == true && container_g2 == "knight_w") {
                            if (container_g1 == "pawn" || container_g1 == "knight") {
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                g2.setVisibility(View.INVISIBLE);
                                String temp = " G2 ---> G1    "+name_new+"    "+container_g1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g1_pos = true;
                                g2_pos = false;
                                container_g1 = "knight_w";
                                container_g2 = "";
                                flag = 1;
                                dialogwin();
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                            }
                        }
                    }
                }
            });
        }
        if (container_h1 == "pawn_w" || container_h2 == "pawn_w" || container_h3 == "pawn_w" || container_h4 == "pawn_w" || container_h5 == "pawn_w" || container_h6 == "pawn_w" || container_h7 == "pawn_w" || container_h8 == "pawn_w" || container_h1 == "castle_w" || container_h2 == "castle_w" || container_h3 == "castle_w" || container_h4 == "castle_w" || container_h5 == "castle_w" || container_h6 == "castle_w" || container_h7 == "castle_w" || container_h8 == "castle_w") {
            h8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h7_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h7.setVisibility(View.VISIBLE);
                            }else{
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h7.setVisibility(View.VISIBLE);
                            }
                        } else {

                        }
                    }
                }
            });
            h7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h6_pos == false && h7_pos == true && container_h7 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h6.setVisibility(View.VISIBLE);
                            }else{
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h6.setVisibility(View.VISIBLE);
                            }
                        } else if (h6_pos == false && h7_pos == true && container_h7 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h6.setVisibility(View.VISIBLE);
                            }else{
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h6.setVisibility(View.VISIBLE);
                            }
                        } else if (h7_pos == false && container_h8 == "castle_w") {
                            h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h8.setVisibility(View.INVISIBLE);
                            String temp = " H8 ---> H7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h7_pos = true;
                            h8_pos = false;
                            container_h7 = "castle_w";
                            container_h8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h7_pos == false && container_h8 == "pawn_w") {
                            h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h8.setVisibility(View.INVISIBLE);
                            String temp = " H8 ---> H7    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h7_pos = true;
                            h8_pos = false;
                            container_h7 = "pawn_w";
                            container_h8 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h7_pos == true && h8_pos == true && container_h8 == "pawn_w") {
                            if (container_h7 == "pawn" || container_h7 == "castle") {
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h8.setVisibility(View.INVISIBLE);
                                String temp = " H8 ---> H7    "+name_new+"    "+container_h7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h7_pos = true;
                                h8_pos = false;
                                container_h7 = "pawn_w";
                                container_h8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (h7_pos == true && h8_pos == true && container_h8 == "castle_w") {
                            if (container_h7 == "pawn" || container_h7 == "castle") {
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h8.setVisibility(View.INVISIBLE);
                                String temp = " H8 ---> H7    "+name_new+"    "+container_h7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h7_pos = true;
                                h8_pos = false;
                                container_h7 = "castle_w";
                                container_h8 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            h6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h5_pos == false && h6_pos == true && container_h6 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h5.setVisibility(View.VISIBLE);
                            }else{
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h5.setVisibility(View.VISIBLE);
                            }
                        } else if (h5_pos == false && h6_pos == true && container_h6 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h5.setVisibility(View.VISIBLE);
                            }else{
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h5.setVisibility(View.VISIBLE);
                            }
                        } else if (h6_pos == false && container_h7 == "castle_w") {
                            h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h7.setVisibility(View.INVISIBLE);
                            String temp = " H7 ---> H6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h6_pos = true;
                            h7_pos = false;
                            container_h6 = "castle_w";
                            container_h7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h6_pos == false && container_h7 == "pawn_w") {
                            h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h7.setVisibility(View.INVISIBLE);
                            String temp = " H7 ---> H6    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h6_pos = true;
                            h7_pos = false;
                            container_h6 = "pawn_w";
                            container_h7 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h6_pos == true && h7_pos == true && container_h7 == "pawn_w") {
                            if (container_h6 == "pawn" || container_h6 == "castle") {
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h7.setVisibility(View.INVISIBLE);
                                String temp = " H7 ---> H6    "+name_new+"    "+container_h6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h6_pos = true;
                                h7_pos = false;
                                container_h6 = "pawn_w";
                                container_h7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (h6_pos == true && h7_pos == true && container_h7 == "castle_w") {
                            if (container_h6 == "pawn" || container_h6 == "castle") {
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h7.setVisibility(View.INVISIBLE);
                                String temp = " H7 ---> H6    "+name_new+"    "+container_h6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h6_pos = true;
                                h7_pos = false;
                                container_h6 = "castle_w";
                                container_h7 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            h5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h4_pos == false && h5_pos == true && container_h5 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h4.setVisibility(View.VISIBLE);
                            }else{
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h4.setVisibility(View.VISIBLE);
                            }
                        } else if (h4_pos == false && h5_pos == true && container_h5 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h4.setVisibility(View.VISIBLE);
                            }else{
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h4.setVisibility(View.VISIBLE);
                            }
                        } else if (h5_pos == false && container_h6 == "castle_w") {
                            h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h6.setVisibility(View.INVISIBLE);
                            String temp = " H6 ---> H5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h5_pos = true;
                            h6_pos = false;
                            container_h5 = "castle_w";
                            container_h6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h5_pos == false && container_h6 == "pawn_w") {
                            h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h6.setVisibility(View.INVISIBLE);
                            String temp = " H6 ---> H5    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h5_pos = true;
                            h6_pos = false;
                            container_h5 = "pawn_w";
                            container_h6 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h5_pos == true && h6_pos == true && container_h6 == "pawn_w") {
                            if (container_h5 == "pawn" || container_h5 == "castle") {
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h6.setVisibility(View.INVISIBLE);
                                String temp = " H6 ---> H5    "+name_new+"    "+container_h5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h5_pos = true;
                                h6_pos = false;
                                container_h5 = "pawn_w";
                                container_h6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (h5_pos == true && h6_pos == true && container_h6 == "castle_w") {
                            if (container_h5 == "pawn" || container_h5 == "castle") {
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h6.setVisibility(View.INVISIBLE);
                                String temp = " H6 ---> H5    "+name_new+"    "+container_h5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h5_pos = true;
                                h6_pos = false;
                                container_h5 = "castle_w";
                                container_h6 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            h4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h3_pos == false && h4_pos == true && container_h4 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h3.setVisibility(View.VISIBLE);
                            }else{
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h3.setVisibility(View.VISIBLE);
                            }
                        } else if (h3_pos == false && h4_pos == true && container_h4 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h3.setVisibility(View.VISIBLE);
                            }else{
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h3.setVisibility(View.VISIBLE);
                            }
                        } else if (h4_pos == false && container_h5 == "castle_w") {
                            h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h5.setVisibility(View.INVISIBLE);
                            String temp = " H5 ---> H4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h4_pos = true;
                            h5_pos = false;
                            container_h4 = "castle_w";
                            container_h5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h4_pos == false && container_h5 == "pawn_w") {
                            h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h5.setVisibility(View.INVISIBLE);
                            String temp = " H5 ---> H4    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h4_pos = true;
                            h5_pos = false;
                            container_h4 = "pawn_w";
                            container_h5 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h4_pos == true && h5_pos == true && container_h5 == "pawn_w") {
                            if (container_h4 == "pawn" || container_h4 == "castle") {
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h5.setVisibility(View.INVISIBLE);
                                String temp = " H5 ---> H4    "+name_new+"    "+container_h4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h4_pos = true;
                                h5_pos = false;
                                container_h4 = "pawn_w";
                                container_h5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (h4_pos == true && h5_pos == true && container_h5 == "castle_w") {
                            if (container_h4 == "pawn" || container_h4 == "castle") {
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h5.setVisibility(View.INVISIBLE);
                                String temp = " H5 ---> H4    "+name_new+"    "+container_h4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h4_pos = true;
                                h5_pos = false;
                                container_h4 = "castle_w";
                                container_h5 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            h3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h2_pos == false && h3_pos == true && container_h3 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h2.setVisibility(View.VISIBLE);
                            }else{
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h2.setVisibility(View.VISIBLE);
                            }
                        } else if (h2_pos == false && h3_pos == true && container_h3 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h2.setVisibility(View.VISIBLE);
                            }else{
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h2.setVisibility(View.VISIBLE);
                            }
                        } else if (h3_pos == false && container_h4 == "castle_w") {
                            h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h4.setVisibility(View.INVISIBLE);
                            String temp = " H4 ---> H3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h3_pos = true;
                            h4_pos = false;
                            container_h3 = "castle_w";
                            container_h4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h3_pos == false && container_h4 == "pawn_w") {
                            h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h4.setVisibility(View.INVISIBLE);
                            String temp = " H4 ---> H3    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h3_pos = true;
                            h4_pos = false;
                            container_h3 = "pawn_w";
                            container_h4 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h3_pos == true && h4_pos == true && container_h4 == "pawn_w") {
                            if (container_h3 == "pawn" || container_h3 == "castle") {
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h4.setVisibility(View.INVISIBLE);
                                String temp = " H4 ---> H3    "+name_new+"    "+container_h3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h3_pos = true;
                                h4_pos = false;
                                container_h3 = "pawn_w";
                                container_h4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (h3_pos == true && h4_pos == true && container_h4 == "castle_w") {
                            if (container_h3 == "pawn" || container_h3 == "castle") {
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h4.setVisibility(View.INVISIBLE);
                                String temp = " H4 ---> H3    "+name_new+"    "+container_h3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h3_pos = true;
                                h4_pos = false;
                                container_h3 = "castle_w";
                                container_h4 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            h2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h1_pos == false && h2_pos == true && container_h2 == "pawn_w") {
                            if(Objects.equals(theme, "Green")){
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h1.setVisibility(View.VISIBLE);
                            }else{
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h1.setVisibility(View.VISIBLE);
                            }
                        } else if (h1_pos == false && h2_pos == true && container_h2 == "castle_w") {
                            if(Objects.equals(theme, "Green")){
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h1.setVisibility(View.VISIBLE);
                            }else{
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h1.setVisibility(View.VISIBLE);
                            }
                        } else if (h2_pos == false && container_h3 == "castle_w") {
                            h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h3.setVisibility(View.INVISIBLE);
                            String temp = " H3 ---> H2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h2_pos = true;
                            h3_pos = false;
                            container_h2 = "castle_w";
                            container_h3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h2_pos == false && container_h3 == "pawn_w") {
                            h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h3.setVisibility(View.INVISIBLE);
                            String temp = " H3 ---> H2    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h2_pos = true;
                            h3_pos = false;
                            container_h2 = "pawn_w";
                            container_h3 = "";
                            flag = 1;
                            bcdt.cancel();
                            wcdt.cancel();
                            startGameBlack();
                        } else if (h2_pos == true && h3_pos == true && container_h3 == "pawn_w") {
                            if (container_h2 == "pawn" || container_h2 == "castle") {
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h3.setVisibility(View.INVISIBLE);
                                String temp = " H3 ---> H2    "+name_new+"    "+container_h2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h2_pos = true;
                                h3_pos = false;
                                container_h2 = "pawn_w";
                                container_h3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        } else if (h2_pos == true && h3_pos == true && container_h3 == "castle_w") {
                            if (container_h2 == "pawn" || container_h2 == "castle") {
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h3.setVisibility(View.INVISIBLE);
                                String temp = " H3 ---> H2    "+name_new+"    "+container_h2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h2_pos = true;
                                h3_pos = false;
                                container_h2 = "castle_w";
                                container_h3 = "";
                                flag = 1;
                                bcdt.cancel();
                                wcdt.cancel();
                                startGameBlack();
                            }
                        }
                    }
                }
            });
            h1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0) {
                        if (h1_pos == false && container_h2 == "castle_w") {
                            h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                            h2.setVisibility(View.INVISIBLE);
                            String temp = " H2 ---> H1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h1_pos = true;
                            h2_pos = false;
                            container_h1 = "castle_w";
                            container_h2 = "";
                            flag = 1;
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (h1_pos == false && container_h2 == "pawn_w") {
                            h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                            h2.setVisibility(View.INVISIBLE);
                            String temp = " H2 ---> H1    "+name_new+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h1_pos = true;
                            h2_pos = false;
                            container_h1 = "pawn_w";
                            container_h2 = "";
                            flag = 1;
                            textViewDG.setText("" + name_new + " Wins");
                            textViewD.setText("" + name_new + " Wins");
                            bcdt.cancel();
                            wcdt.cancel();
                            dialogwin();
                        } else if (h1_pos == true && h2_pos == true && container_h2 == "pawn_w") {
                            if (container_h1 == "pawn" || container_h1 == "castle") {
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_w));
                                h2.setVisibility(View.INVISIBLE);
                                String temp = " H2 ---> H1    "+name_new+"    "+container_h1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h1_pos = true;
                                h2_pos = false;
                                container_h1 = "pawn_w";
                                container_h2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        } else if (h1_pos == true && h2_pos == true && container_h2 == "castle_w") {
                            if (container_h1 == "pawn" || container_h1 == "castle") {
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_w));
                                h2.setVisibility(View.INVISIBLE);
                                String temp = " H2 ---> H1    "+name_new+"    "+container_h1+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h1_pos = true;
                                h2_pos = false;
                                container_h1 = "castle_w";
                                container_h2 = "";
                                flag = 1;
                                textViewDG.setText("" + name_new + " Wins");
                                textViewD.setText("" + name_new + " Wins");
                                bcdt.cancel();
                                wcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
        }
    }
    private void moveblack() {
        if (container_a1 == "pawn" || container_a2 == "pawn" || container_a3 == "pawn" || container_a4 == "pawn" || container_a5 == "pawn" || container_a6 == "pawn" || container_a7 == "pawn" || container_a8 == "pawn" || container_a1 == "castle" || container_a2 == "castle" || container_a3 == "castle" || container_a4 == "castle" || container_a5 == "castle" || container_a6 == "castle" || container_a7 == "castle" || container_a8 == "castle") {
            a8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (a8_pos == false && container_a7 == "pawn") {
                            a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a7.setVisibility(View.INVISIBLE);
                            String temp = " A7 ---> A8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a8_pos = true;
                            a7_pos = false;
                            container_a8 = "pawn";
                            container_a7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (a8_pos == false && container_a7 == "castle") {
                            a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a7.setVisibility(View.INVISIBLE);
                            String temp = " A7 ---> A8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a8_pos = true;
                            a7_pos = false;
                            container_a8 = "castle";
                            container_a7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (a8_pos == true && a7_pos == true && container_a7 == "pawn") {
                            if (container_a8 == "pawn_w" || container_a8 == "castle_w") {
                                a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a7.setVisibility(View.INVISIBLE);
                                String temp = " A7 ---> A8    "+name+"    "+container_a8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a8_pos = true;
                                a7_pos = false;
                                container_a8 = "pawn";
                                container_a7 = "";
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (a8_pos == true && a7_pos == true && container_a7 == "castle") {
                            if ( container_a8 == "pawn_w" || container_a8 == "castle_w") {
                                a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a7.setVisibility(View.INVISIBLE);
                                String temp = " A7 ---> A8    "+name+"    "+container_a8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a8_pos = true;
                                a7_pos = false;
                                container_a8 = "castle";
                                container_a7 = "";
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            a7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (a8_pos == false && a7_pos == true && container_a7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a8.setVisibility(View.VISIBLE);
                            }else{
                                a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a8.setVisibility(View.VISIBLE);
                            }
                        } else if (a8_pos == false && a7_pos == true && container_a7 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a8.setVisibility(View.VISIBLE);
                            }else{
                                a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a8.setVisibility(View.VISIBLE);
                            }
                        } else if (a7_pos == false && container_a6 == "pawn") {
                            a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a6.setVisibility(View.INVISIBLE);
                            String temp = " A6 ---> A7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a7_pos = true;
                            a6_pos = false;
                            container_a7 = "pawn";
                            container_a6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a7_pos == false && container_a6 == "castle") {
                            a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a6.setVisibility(View.INVISIBLE);
                            String temp = " A6 ---> A7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a7_pos = true;
                            a6_pos = false;
                            container_a7 = "castle";
                            container_a6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a7_pos == true && a6_pos == true && container_a6 == "pawn") {
                            if (container_a7 == "pawn_w" || container_a7 == "castle_w") {
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a6.setVisibility(View.INVISIBLE);
                                String temp = " A6 ---> A7    "+name+"    "+container_a7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a7_pos = true;
                                a6_pos = false;
                                container_a7 = "pawn";
                                container_a6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a7_pos == true && a6_pos == true && container_a6 == "castle") {
                            if ( container_a7 == "pawn_w" || container_a7 == "castle_w") {
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a6.setVisibility(View.INVISIBLE);
                                String temp = " A6 ---> A7    "+name+"    "+container_a7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a7_pos = true;
                                a6_pos = false;
                                container_a7 = "castle";
                                container_a6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            a6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (a7_pos == false && a6_pos == true && container_a6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a7.setVisibility(View.VISIBLE);
                            }else{
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a7.setVisibility(View.VISIBLE);
                            }
                        } else if (a7_pos == false && a6_pos == true && container_a6 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a7.setVisibility(View.VISIBLE);
                            }else{
                                a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a7.setVisibility(View.VISIBLE);
                            }
                        } else if (a6_pos == false && container_a5 == "pawn") {
                            a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a5.setVisibility(View.INVISIBLE);
                            String temp = " A5 ---> A6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a6_pos = true;
                            a5_pos = false;
                            container_a6 = "pawn";
                            container_a5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a6_pos == false && container_a5 == "castle") {
                            a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a5.setVisibility(View.INVISIBLE);
                            String temp = " A5 ---> A6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a6_pos = true;
                            a5_pos = false;
                            container_a6 = "castle";
                            container_a5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a6_pos == true && a5_pos == true && container_a5 == "pawn") {
                            if (container_a6 == "pawn_w" || container_a6 == "castle_w") {
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a5.setVisibility(View.INVISIBLE);
                                String temp = " A5 ---> A6    "+name+"    "+container_a6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a6_pos = true;
                                a5_pos = false;
                                container_a6 = "pawn";
                                container_a5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a6_pos == true && a5_pos == true && container_a5 == "castle") {
                            if ( container_a6 == "pawn_w" || container_a6 == "castle_w") {
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a5.setVisibility(View.INVISIBLE);
                                String temp = " A5 ---> A6    "+name+"    "+container_a6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a6_pos = true;
                                a5_pos = false;
                                container_a6 = "castle";
                                container_a5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            a5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (a6_pos == false && a5_pos == true && container_a5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a6.setVisibility(View.VISIBLE);
                            }else{
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a6.setVisibility(View.VISIBLE);
                            }
                        } else if (a6_pos == false && a5_pos == true && container_a5 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a6.setVisibility(View.VISIBLE);
                            }else{
                                a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a6.setVisibility(View.VISIBLE);
                            }
                        } else if (a5_pos == false && container_a4 == "pawn") {
                            a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a4.setVisibility(View.INVISIBLE);
                            String temp = " A4 ---> A5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a5_pos = true;
                            a4_pos = false;
                            container_a5 = "pawn";
                            container_a4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a5_pos == false && container_a4 == "castle") {
                            a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a4.setVisibility(View.INVISIBLE);
                            String temp = " A4 ---> A5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a5_pos = true;
                            a4_pos = false;
                            container_a5 = "castle";
                            container_a4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a5_pos == true && a4_pos == true && container_a4 == "pawn" ) {
                            if (container_a5 == "pawn_w" || container_a5 == "castle_w") {
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a4.setVisibility(View.INVISIBLE);
                                String temp = " A4 ---> A5    "+name+"    "+container_a5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a5_pos = true;
                                a4_pos = false;
                                container_a5 = "pawn";
                                container_a4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a5_pos == true && a4_pos == true && container_a4 == "castle") {
                            if (container_a5 == "pawn_w" || container_a5 == "castle_w") {
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a4.setVisibility(View.INVISIBLE);
                                String temp = " A4 ---> A5    "+name+"    "+container_a5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a5_pos = true;
                                a4_pos = false;
                                container_a5 = "castle";
                                container_a4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            a4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (a5_pos == false && a4_pos == true && container_a4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a5.setVisibility(View.VISIBLE);
                            }else{
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a5.setVisibility(View.VISIBLE);
                            }
                        } else if (a5_pos == false && a4_pos == true && container_a4 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a5.setVisibility(View.VISIBLE);
                            }else{
                                a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a5.setVisibility(View.VISIBLE);
                            }
                        } else if (a4_pos == false && container_a3 == "pawn") {
                            a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a3.setVisibility(View.INVISIBLE);
                            String temp = " A3 ---> A4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a4_pos = true;
                            a3_pos = false;
                            container_a4 = "pawn";
                            container_a3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a4_pos == false && container_a3 == "castle") {
                            a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a3.setVisibility(View.INVISIBLE);
                            String temp = " A3 ---> A4    "+name+"    ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a4_pos = true;
                            a3_pos = false;
                            container_a4 = "castle";
                            container_a3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a4_pos == true && a3_pos == true && container_a3 == "pawn") {
                            if(container_a4 == "pawn_w" || container_a4 == "castle_w") {
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a3.setVisibility(View.INVISIBLE);
                                String temp = " A3 ---> A4    "+name+"    "+container_a4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a4_pos = true;
                                a3_pos = false;
                                container_a4 = "pawn";
                                container_a3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a4_pos == true && a3_pos == true && container_a3 == "castle") {
                            if(container_a4 == "pawn_w" || container_a4 == "castle_w") {
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a3.setVisibility(View.INVISIBLE);
                                String temp = " A3 ---> A4    "+name+"    "+container_a4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a4_pos = true;
                                a3_pos = false;
                                container_a4 = "castle";
                                container_a3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            a3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (a4_pos == false && a3_pos == true && container_a3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a4.setVisibility(View.VISIBLE);
                            }else{
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a4.setVisibility(View.VISIBLE);
                            }
                        } else if (a4_pos == false && a3_pos == true && container_a3 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a4.setVisibility(View.VISIBLE);
                            }else{
                                a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a4.setVisibility(View.VISIBLE);
                            }
                        } else if (a3_pos == false && container_a2 == "pawn") {
                            a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a2.setVisibility(View.INVISIBLE);
                            String temp = " A2 ---> A3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a3_pos = true;
                            a2_pos = false;
                            container_a3 = "pawn";
                            container_a2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a3_pos == false && container_a2 == "castle") {
                            a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a2.setVisibility(View.INVISIBLE);
                            String temp = " A2 ---> A3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a3_pos = true;
                            a2_pos = false;
                            container_a3 = "castle";
                            container_a2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a3_pos == true && a2_pos == true && container_a2 == "pawn") {
                            if(container_a3 == "pawn_w" || container_a3 == "castle_w") {
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a2.setVisibility(View.INVISIBLE);
                                String temp = " A2 ---> A3    "+name+"    "+container_a3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a3_pos = true;
                                a2_pos = false;
                                container_a3 = "pawn";
                                container_a2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a3_pos == true && a2_pos == true && container_a2 == "castle") {
                            if(container_a3 == "pawn_w" || container_a3 == "castle_w") {
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a2.setVisibility(View.INVISIBLE);
                                String temp = " A2 ---> A3    "+name+"    "+container_a3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a3_pos = true;
                                a2_pos = false;
                                container_a3 = "castle";
                                container_a2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            a2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (a3_pos == false && a2_pos == true && container_a2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a3.setVisibility(View.VISIBLE);
                            }else{
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a3.setVisibility(View.VISIBLE);
                            }
                        } else if (a3_pos == false && a2_pos == true && container_a2 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a3.setVisibility(View.VISIBLE);
                            }else{
                                a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a3.setVisibility(View.VISIBLE);
                            }
                        } else if (a2_pos == false && container_a1 == "castle") {
                            a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            a1.setVisibility(View.INVISIBLE);
                            String temp = " A1 ---> A2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a2_pos = true;
                            a1_pos = false;
                            container_a2 = "castle";
                            container_a1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a2_pos == false && container_a1 == "pawn") {
                            a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            a1.setVisibility(View.INVISIBLE);
                            String temp = " A1 ---> A2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            a2_pos = true;
                            a1_pos = false;
                            container_a2 = "pawn";
                            container_a1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (a2_pos == true && a1_pos == true && container_a1 == "pawn" ) {
                            if(container_a2 == "pawn_w" || container_a2 == "castle_w") {
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a1.setVisibility(View.INVISIBLE);
                                String temp = " A1 ---> A2    "+name+"    "+container_a2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a2_pos = true;
                                a1_pos = false;
                                container_a2 = "pawn";
                                container_a1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a2_pos == true && a1_pos == true && container_a2 == "castle") {
                            if (container_a2 == "pawn_w" || container_a2 == "castle_w") {
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a1.setVisibility(View.INVISIBLE);
                                String temp = " A1 ---> A2    "+name+"    "+container_a2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                a2_pos = true;
                                a1_pos = false;
                                container_a2 = "castle";
                                container_a1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            a1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (a2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                a2.setVisibility(View.VISIBLE);
                            }else{
                                a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                a2.setVisibility(View.VISIBLE);
                            }
                        } else if (a1_pos == true ){
                            if(container_a1 == "pawn_w" || container_a1 == "castle_w") {
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                a1_pos = true;
                                container_a1 = "pawn";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (a1_pos == true && container_a1 == "castle") {
                            if(container_a1 == "pawn_w" || container_a1 == "castle_w") {
                                a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                a1_pos = true;
                                container_a1 = "castle";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
        }
        if (container_b1 == "pawn" || container_b2 == "pawn" || container_b3 == "pawn" || container_b4 == "pawn" || container_b5 == "pawn" || container_b6 == "pawn" || container_b7 == "pawn" || container_b8 == "pawn" || container_b1 == "knight" || container_b2 == "knight" || container_b3 == "knight" || container_b4 == "knight" || container_b5 == "knight" || container_b6 == "knight" || container_b7 == "knight" || container_b8 == "knight") {
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (b8_pos == false && container_b7 == "pawn") {
                            b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b7.setVisibility(View.INVISIBLE);
                            String temp = " B7 ---> B8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b8_pos = true;
                            b7_pos = false;
                            container_b8 = "pawn";
                            container_b7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (b8_pos == false && container_b7 == "knight") {
                            b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b7.setVisibility(View.INVISIBLE);
                            String temp = " B7 ---> B8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b8_pos = true;
                            b7_pos = false;
                            container_b8 = "knight";
                            container_b7 = "";
                            round = false;
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (b7_pos == true && b8_pos == true && container_b7 == "pawn") {
                            if(container_b8 == "pawn_w" || container_b8 == "knight_w") {
                                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b7.setVisibility(View.INVISIBLE);
                                String temp = " B7 ---> B8   "+name+"   "+container_b8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b8_pos = true;
                                b7_pos = false;
                                container_b8 = "pawn";
                                container_b7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (b7_pos == true && b8_pos == true && container_b7 == "knight") {
                            if(container_b8 == "pawn_w" || container_b8 == "knight_w") {
                                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b7.setVisibility(View.INVISIBLE);
                                String temp = " B7 ---> B8   "+name+"   "+container_b8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b8_pos = true;
                                b7_pos = false;
                                container_b8 = "knight";
                                container_b7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (b8_pos == false && b7_pos == true && container_b7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b8.setVisibility(View.VISIBLE);
                            }else{
                                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b8.setVisibility(View.VISIBLE);
                            }
                        } else if (b8_pos == false && b7_pos == true && container_b7 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b8.setVisibility(View.VISIBLE);
                            }else{
                                b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b8.setVisibility(View.VISIBLE);
                            }
                        } else if (b7_pos == false && container_b6 == "pawn") {
                            b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b6.setVisibility(View.INVISIBLE);
                            String temp = " B6 ---> B7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b7_pos = true;
                            b6_pos = false;
                            container_b7 = "pawn";
                            container_b6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b7_pos == false && container_b6 == "knight") {
                            b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b6.setVisibility(View.INVISIBLE);
                            String temp = " B6 ---> B7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b7_pos = true;
                            b6_pos = false;
                            container_b7 = "knight";
                            container_b6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b7_pos == true && b6_pos == true && container_b6 == "pawn") {
                            if(container_b7 == "pawn_w" || container_b7 == "knight_w") {
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b6.setVisibility(View.INVISIBLE);
                                String temp = " B6 ---> B7    "+name+"    "+container_b7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b7_pos = true;
                                b6_pos = false;
                                container_b7 = "pawn";
                                container_b6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (b7_pos == true && b6_pos == true && container_b6 == "knight") {
                            if(container_b7 == "pawn_w" || container_b7 == "knight_w") {
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b6.setVisibility(View.INVISIBLE);
                                String temp = " B6 ---> B7    "+name+"    "+container_b7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b7_pos = true;
                                b6_pos = false;
                                container_b7 = "knight";
                                container_b6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (b7_pos == false && b6_pos == true && container_b6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b7.setVisibility(View.VISIBLE);
                            }else{
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b7.setVisibility(View.VISIBLE);
                            }
                        } else if (b7_pos == false && b6_pos == true && container_b6 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b7.setVisibility(View.VISIBLE);
                            }else{
                                b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b7.setVisibility(View.VISIBLE);
                            }
                        } else if (b6_pos == false && container_b5 == "pawn") {
                            b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b5.setVisibility(View.INVISIBLE);
                            String temp = " B5 ---> B6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b6_pos = true;
                            b5_pos = false;
                            container_b6 = "pawn";
                            container_b5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b6_pos == false && container_b5 == "knight") {
                            b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b5.setVisibility(View.INVISIBLE);
                            String temp = " B5 ---> B6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b6_pos = true;
                            b5_pos = false;
                            container_b6 = "knight";
                            container_b5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b6_pos == true && b5_pos == true && container_b5 == "pawn") {
                            if (container_b6 == "pawn_w" || container_b6 == "knight_w") {
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b5.setVisibility(View.INVISIBLE);
                                String temp = " B5 ---> B6    "+name+"    "+container_b6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b6_pos = true;
                                b5_pos = false;
                                container_b6 = "pawn";
                                container_b5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (b6_pos == true && b5_pos == true && container_b5 == "knight") {
                            if ( container_b6 == "pawn_w" || container_b6 == "knight_w") {
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b5.setVisibility(View.INVISIBLE);
                                String temp = " B5 ---> B6    "+name+"    "+container_b6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b6_pos = true;
                                b5_pos = false;
                                container_b6 = "knight";
                                container_b5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (b6_pos == false && b5_pos == true && container_b5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b6.setVisibility(View.VISIBLE);
                            }else{
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b6.setVisibility(View.VISIBLE);
                            }
                        } else if (b6_pos == false && b5_pos == true && container_b5 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b6.setVisibility(View.VISIBLE);
                            }else{
                                b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b6.setVisibility(View.VISIBLE);
                            }
                        } else if (b5_pos == false && container_b4 == "pawn") {
                            b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b4.setVisibility(View.INVISIBLE);
                            String temp = " B4 ---> B5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b5_pos = true;
                            b4_pos = false;
                            container_b5 = "pawn";
                            container_b4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b5_pos == false && container_b4 == "knight") {
                            b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b4.setVisibility(View.INVISIBLE);
                            String temp = " B4 ---> B5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b5_pos = true;
                            b4_pos = false;
                            container_b5 = "knight";
                            container_b4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b5_pos == true && b4_pos == true && container_b4 == "pawn" ) {
                            if (container_b5 == "pawn_w" || container_b5 == "knight_w") {
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b4.setVisibility(View.INVISIBLE);
                                String temp = " B4 ---> B5    "+name+"    "+container_b5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b5_pos = true;
                                b4_pos = false;
                                container_b5 = "pawn";
                                container_b4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (b5_pos == true && b4_pos == true && container_b4 == "knight") {
                            if (container_b5 == "pawn_w" || container_b5 == "knight_w") {
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b4.setVisibility(View.INVISIBLE);
                                String temp = " B4 ---> B5    "+name+"    "+container_b5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b5_pos = true;
                                b4_pos = false;
                                container_b5 = "knight";
                                container_b4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (b5_pos == false && b4_pos == true && container_b4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b5.setVisibility(View.VISIBLE);
                            }else{
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b5.setVisibility(View.VISIBLE);
                            }
                        } else if (b5_pos == false && b4_pos == true && container_b4 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b5.setVisibility(View.VISIBLE);
                            }else{
                                b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b5.setVisibility(View.VISIBLE);
                            }
                        } else if (b4_pos == false && container_b3 == "pawn") {
                            b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b3.setVisibility(View.INVISIBLE);
                            String temp = " B3 ---> B4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b4_pos = true;
                            b3_pos = false;
                            container_b4 = "pawn";
                            container_b3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b4_pos == false && container_b3 == "knight") {
                            b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b3.setVisibility(View.INVISIBLE);
                            String temp = " B3 ---> B4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b4_pos = true;
                            b3_pos = false;
                            container_b4 = "knight";
                            container_b3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b4_pos == true && b3_pos == true && container_b3 == "pawn") {
                            if(container_b4 == "pawn_w" || container_b4 == "knight_w") {
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b3.setVisibility(View.INVISIBLE);
                                String temp = " B3 ---> B4    "+name+"    "+container_b4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b4_pos = true;
                                b3_pos = false;
                                container_b4 = "pawn";
                                container_b3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (b4_pos == true && b3_pos == true && container_b3 == "knight") {
                            if(container_b4 == "pawn_w" || container_b4 == "knight_w") {
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b3.setVisibility(View.INVISIBLE);
                                String temp = " B3 ---> B4    "+name+"    "+container_b4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b4_pos = true;
                                b3_pos = false;
                                container_b4 = "knight";
                                container_b3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (b4_pos == false && b3_pos == true && container_b3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b4.setVisibility(View.VISIBLE);
                            }else{
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b4.setVisibility(View.VISIBLE);
                            }
                        } else if (b4_pos == false && b3_pos == true && container_b3 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b4.setVisibility(View.VISIBLE);
                            }else{
                                b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b4.setVisibility(View.VISIBLE);
                            }
                        } else if (b3_pos == false && container_b2 == "pawn") {
                            b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b2.setVisibility(View.INVISIBLE);
                            String temp = " B2 ---> B3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b3_pos = true;
                            b2_pos = false;
                            container_b3 = "pawn";
                            container_b2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b3_pos == false && container_b2 == "knight") {
                            b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b2.setVisibility(View.INVISIBLE);
                            String temp = " B2 ---> B3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b3_pos = true;
                            b2_pos = false;
                            container_b3 = "knight";
                            container_b2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b3_pos == true && b2_pos == true && container_b2 == "pawn") {
                            if(container_b3 == "pawn_w" || container_b3 == "knight_w") {
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b2.setVisibility(View.INVISIBLE);
                                String temp = " B2 ---> B3    "+name+"    "+container_b3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b3_pos = true;
                                b2_pos = false;
                                container_b3 = "pawn";
                                container_b2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (b3_pos == true && b2_pos == true && container_b2 == "knight") {
                            if(container_b3 == "pawn_w" || container_b3 == "knight_w") {
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b2.setVisibility(View.INVISIBLE);
                                String temp = " B2 ---> B3    "+name+"    "+container_b3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b3_pos = true;
                                b2_pos = false;
                                container_b3 = "knight";
                                container_b2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (b3_pos == false && b2_pos == true && container_b2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b3.setVisibility(View.VISIBLE);
                            }else{
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b3.setVisibility(View.VISIBLE);
                            }
                        } else if (b3_pos == false && b2_pos == true && container_b2 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b3.setVisibility(View.VISIBLE);
                            }else{
                                b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b3.setVisibility(View.VISIBLE);
                            }
                        } else if (b2_pos == false && container_b1 == "knight") {
                            b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            b1.setVisibility(View.INVISIBLE);
                            String temp = " B1 ---> B2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b2_pos = true;
                            b1_pos = false;
                            container_b2 = "knight";
                            container_b1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b2_pos == false && container_b1 == "pawn") {
                            b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            b1.setVisibility(View.INVISIBLE);
                            String temp = " B1 ---> B2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            b2_pos = true;
                            b1_pos = false;
                            container_b2 = "pawn";
                            container_b1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (b2_pos == true && b1_pos == true && container_b1 == "pawn" ) {
                            if(container_b2 == "pawn_w" || container_b2 == "knight_w") {
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b1.setVisibility(View.INVISIBLE);
                                String temp = " B1 ---> B2    "+name+"    "+container_b2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b2_pos = true;
                                b1_pos = false;
                                container_b2 = "knight";
                                container_b1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (b2_pos == true && b1_pos == true && container_b1 == "knight") {
                            if (container_b2 == "pawn_w" || container_b2 == "knight_w") {
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b1.setVisibility(View.INVISIBLE);
                                String temp = " B1 ---> B2    "+name+"    "+container_b2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                b2_pos = true;
                                b1_pos = false;
                                container_b2 = "knight";
                                container_b1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (b2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                b2.setVisibility(View.VISIBLE);
                            }else{
                                b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                b2.setVisibility(View.VISIBLE);
                            }
                        } else if (b1_pos == true ){
                            if(container_b1 == "pawn_w" || container_b1 == "knight_w") {
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                b1_pos = true;
                                container_b1 = "pawn";
                                flag = 0;
                            }
                        } else if (b1_pos == true && container_b1 == "knight") {
                            if(container_b1 == "pawn_w" || container_b1 == "knight_w") {
                                b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                b1_pos = true;
                                container_b1 = "knight";
                                flag = 0;
                            }
                        }
                    }
                }
            });
        }
        if (container_c1 == "pawn" || container_c2 == "pawn" || container_c3 == "pawn" || container_c4 == "pawn" || container_c5 == "pawn" || container_c6 == "pawn" || container_c7 == "pawn" || container_c8 == "pawn" || container_c1 == "bishop" || container_c2 == "bishop" || container_c3 == "bishop" || container_c4 == "bishop" || container_c5 == "bishop" || container_c6 == "bishop" || container_c7 == "bishop" || container_c8 == "bishop") {
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (c8_pos == false && container_c7 == "pawn") {
                            c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c7.setVisibility(View.INVISIBLE);
                            String temp = " C7 ---> C8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c8_pos = true;
                            c7_pos = false;
                            container_c8 = "pawn";
                            container_c7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (c8_pos == false && container_c7 == "bishop") {
                            c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c7.setVisibility(View.INVISIBLE);
                            String temp = " C7 ---> C8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c8_pos = true;
                            c7_pos = false;
                            container_c8 = "bishop";
                            container_c7 = "";
                            round = false;
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (c7_pos == true && c8_pos == true && container_c7 == "pawn") {
                            if(container_c8 == "pawn_w" || container_c8 == "bishop_w") {
                                c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c7.setVisibility(View.INVISIBLE);
                                String temp = " C7 ---> C8   "+name+"   "+container_c8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c8_pos = true;
                                c7_pos = false;
                                container_c8 = "pawn";
                                container_c7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (c7_pos == true && c8_pos == true && container_c7 == "bishop") {
                            if(container_c8 == "pawn_w" || container_c8 == "bishop_w") {
                                c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c7.setVisibility(View.INVISIBLE);
                                String temp = " C7 ---> C8   "+name+"   "+container_c8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c8_pos = true;
                                c7_pos = false;
                                container_c8 = "bishop";
                                container_c7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (c8_pos == false && c7_pos == true && container_c7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c8.setVisibility(View.VISIBLE);
                            }else{
                                c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c8.setVisibility(View.VISIBLE);
                            }
                        } else if (c8_pos == false && c7_pos == true && container_c7 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c8.setVisibility(View.VISIBLE);
                            }else{
                                c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c8.setVisibility(View.VISIBLE);
                            }
                        } else if (c7_pos == false && container_c6 == "pawn") {
                            c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c6.setVisibility(View.INVISIBLE);
                            String temp = " C6 ---> C7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c7_pos = true;
                            c6_pos = false;
                            container_c7 = "pawn";
                            container_c6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c7_pos == false && container_c6 == "bishop") {
                            c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c6.setVisibility(View.INVISIBLE);
                            String temp = " C6 ---> C7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c7_pos = true;
                            c6_pos = false;
                            container_c7 = "bishop";
                            container_c6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c7_pos == true && c6_pos == true && container_c6 == "pawn") {
                            if(container_c7 == "pawn_w" || container_c7 == "bishop_w") {
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c6.setVisibility(View.INVISIBLE);
                                String temp = " C6 ---> C7    "+name+"    "+container_c7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c7_pos = true;
                                c6_pos = false;
                                container_c7 = "pawn";
                                container_c6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (c7_pos == true && c6_pos == true && container_c6 == "bishop") {
                            if(container_c7 == "pawn_w" || container_c7 == "bishop_w") {
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c6.setVisibility(View.INVISIBLE);
                                String temp = " C6 ---> C7    "+name+"    "+container_c7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c7_pos = true;
                                c6_pos = false;
                                container_c7 = "bishop";
                                container_c6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (c7_pos == false && c6_pos == true && container_c6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c7.setVisibility(View.VISIBLE);
                            }else{
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c7.setVisibility(View.VISIBLE);
                            }
                        } else if (c7_pos == false && c6_pos == true && container_c6 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c7.setVisibility(View.VISIBLE);
                            }else{
                                c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c7.setVisibility(View.VISIBLE);
                            }
                        } else if (c6_pos == false && container_c5 == "pawn") {
                            c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c5.setVisibility(View.INVISIBLE);
                            String temp = " C5 ---> C6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c6_pos = true;
                            c5_pos = false;
                            container_c6 = "pawn";
                            container_c5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c6_pos == false && container_c5 == "bishop") {
                            c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c5.setVisibility(View.INVISIBLE);
                            String temp = " C5 ---> C6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c6_pos = true;
                            c5_pos = false;
                            container_c6 = "bishop";
                            container_c5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c6_pos == true && c5_pos == true && container_c5 == "pawn") {
                            if (container_c6 == "pawn_w" || container_c6 == "bishop_w") {
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c5.setVisibility(View.INVISIBLE);
                                String temp = " C5 ---> C6    "+name+"    "+container_c6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c6_pos = true;
                                c5_pos = false;
                                container_c6 = "pawn";
                                container_c5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (c6_pos == true && c5_pos == true && container_c5 == "bishop") {
                            if ( container_c6 == "pawn_w" || container_c6 == "bishop_w") {
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c5.setVisibility(View.INVISIBLE);
                                String temp = " C5 ---> C6    "+name+"    "+container_c6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c6_pos = true;
                                c5_pos = false;
                                container_c6 = "bishop";
                                container_c5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (c6_pos == false && c5_pos == true && container_c5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c6.setVisibility(View.VISIBLE);
                            }else{
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c6.setVisibility(View.VISIBLE);
                            }
                        } else if (c6_pos == false && c5_pos == true && container_c5 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c6.setVisibility(View.VISIBLE);
                            }else{
                                c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c6.setVisibility(View.VISIBLE);
                            }
                        } else if (c5_pos == false && container_c4 == "pawn") {
                            c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c4.setVisibility(View.INVISIBLE);
                            String temp = " C4 ---> C5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c5_pos = true;
                            c4_pos = false;
                            container_c5 = "pawn";
                            container_c4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c5_pos == false && container_c4 == "bishop") {
                            c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c4.setVisibility(View.INVISIBLE);
                            String temp = " C4 ---> C5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c5_pos = true;
                            c4_pos = false;
                            container_c5 = "bishop";
                            container_c4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c5_pos == true && c4_pos == true && container_c4 == "pawn" ) {
                            if (container_c5 == "pawn_w" || container_c5 == "bishop_w") {
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c4.setVisibility(View.INVISIBLE);
                                String temp = " C4 ---> C5    "+name+"    "+container_c5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c5_pos = true;
                                c4_pos = false;
                                container_c5 = "pawn";
                                container_c4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (c5_pos == true && c4_pos == true && container_c4 == "bishop") {
                            if (container_c5 == "pawn_w" || container_c5 == "bishop_w") {
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c4.setVisibility(View.INVISIBLE);
                                String temp = " C4 ---> C5    "+name+"    "+container_c5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c5_pos = true;
                                c4_pos = false;
                                container_c5 = "bishop";
                                container_c4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (c5_pos == false && c4_pos == true && container_c4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c5.setVisibility(View.VISIBLE);
                            }else{
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c5.setVisibility(View.VISIBLE);
                            }
                        } else if (c5_pos == false && c4_pos == true && container_c4 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c5.setVisibility(View.VISIBLE);
                            }else{
                                c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c5.setVisibility(View.VISIBLE);
                            }
                        } else if (c4_pos == false && container_c3 == "pawn") {
                            c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c3.setVisibility(View.INVISIBLE);
                            String temp = " C3 ---> C4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c4_pos = true;
                            c3_pos = false;
                            container_c4 = "pawn";
                            container_c3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c4_pos == false && container_c3 == "bishop") {
                            c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c3.setVisibility(View.INVISIBLE);
                            String temp = " C3 ---> C4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c4_pos = true;
                            c3_pos = false;
                            container_c4 = "bishop";
                            container_c3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c4_pos == true && c3_pos == true && container_c3 == "pawn") {
                            if(container_c4 == "pawn_w" || container_c4 == "bishop_w") {
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c3.setVisibility(View.INVISIBLE);
                                String temp = " C3 ---> C4    "+name+"    "+container_c4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c4_pos = true;
                                c3_pos = false;
                                container_c4 = "pawn";
                                container_c3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (c4_pos == true && c3_pos == true && container_c3 == "bishop") {
                            if(container_c4 == "pawn_w" || container_c4 == "bishop_w") {
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c3.setVisibility(View.INVISIBLE);
                                String temp = " C3 ---> C4    "+name+"    "+container_c4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c4_pos = true;
                                c3_pos = false;
                                container_c4 = "bishop";
                                container_c3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (c4_pos == false && c3_pos == true && container_c3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c4.setVisibility(View.VISIBLE);
                            }else{
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c4.setVisibility(View.VISIBLE);
                            }
                        } else if (c4_pos == false && c3_pos == true && container_c3 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c4.setVisibility(View.VISIBLE);
                            }else{
                                c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c4.setVisibility(View.VISIBLE);
                            }
                        } else if (c3_pos == false && container_c2 == "pawn") {
                            c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c2.setVisibility(View.INVISIBLE);
                            String temp = " C2 ---> C3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c3_pos = true;
                            c2_pos = false;
                            container_c3 = "pawn";
                            container_c2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c3_pos == false && container_c2 == "bishop") {
                            c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c2.setVisibility(View.INVISIBLE);
                            String temp = " C2 ---> C3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c3_pos = true;
                            c2_pos = false;
                            container_c3 = "bishop";
                            container_c2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c3_pos == true && c2_pos == true && container_c2 == "pawn") {
                            if(container_c3 == "pawn_w" || container_c3 == "bishop_w") {
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c2.setVisibility(View.INVISIBLE);
                                String temp = " C2 ---> C3    "+name+"    "+container_c3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c3_pos = true;
                                c2_pos = false;
                                container_c3 = "pawn";
                                container_c2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (c3_pos == true && c2_pos == true && container_c2 == "bishop") {
                            if(container_c3 == "pawn_w" || container_c3 == "bishop_w") {
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c2.setVisibility(View.INVISIBLE);
                                String temp = " C2 ---> C3    "+name+"    "+container_c3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c3_pos = true;
                                c2_pos = false;
                                container_c3 = "bishop";
                                container_c2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (c3_pos == false && c2_pos == true && container_c2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c3.setVisibility(View.VISIBLE);
                            }else{
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c3.setVisibility(View.VISIBLE);
                            }
                        } else if (c3_pos == false && c2_pos == true && container_c2 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c3.setVisibility(View.VISIBLE);
                            }else{
                                c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c3.setVisibility(View.VISIBLE);
                            }
                        } else if (c2_pos == false && container_c1 == "bishop") {
                            c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            c1.setVisibility(View.INVISIBLE);
                            String temp = " C1 ---> C2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c2_pos = true;
                            c1_pos = false;
                            container_c2 = "bishop";
                            container_c1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c2_pos == false && container_c1 == "pawn") {
                            c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            c1.setVisibility(View.INVISIBLE);
                            String temp = " C1 ---> C2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            c2_pos = true;
                            c1_pos = false;
                            container_c2 = "pawn";
                            container_c1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (c2_pos == true && c1_pos == true && container_c1 == "pawn" ) {
                            if(container_c2 == "pawn_w" || container_c2 == "bishop_w") {
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c1.setVisibility(View.INVISIBLE);
                                String temp = " C1 ---> C2    "+name+"    "+container_c2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c2_pos = true;
                                c1_pos = false;
                                container_c2 = "bishop";
                                container_c1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (c2_pos == true && c1_pos == true && container_c1 == "bishop") {
                            if (container_c2 == "pawn_w" || container_c2 == "bishop_w") {
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c1.setVisibility(View.INVISIBLE);
                                String temp = " C1 ---> C2    "+name+"    "+container_c2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                c2_pos = true;
                                c1_pos = false;
                                container_c2 = "bishop";
                                container_c1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (c2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                c2.setVisibility(View.VISIBLE);
                            }else{
                                c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                c2.setVisibility(View.VISIBLE);
                            }
                        } else if (c1_pos == true ){
                            if(container_c1 == "pawn_w" || container_c1 == "bishop_w") {
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                c1_pos = true;
                                container_c1 = "pawn";
                                flag = 0;
                            }
                        } else if (c1_pos == true && container_c1 == "bishop") {
                            if(container_c1 == "pawn_w" || container_c1 == "bishop_w") {
                                c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                c1_pos = true;
                                container_c1 = "bishop";
                                flag = 0;
                            }
                        }
                    }
                }
            });
        }
        if (container_d1 == "pawn" || container_d2 == "pawn" || container_d3 == "pawn" || container_d4 == "pawn" || container_d5 == "pawn" || container_d6 == "pawn" || container_d7 == "pawn" || container_d8 == "pawn" || container_d1 == "queen" || container_d2 == "queen" || container_d3 == "queen" || container_d4 == "queen" || container_d5 == "queen" || container_d6 == "queen" || container_d7 == "queen" || container_d8 == "queen") {
            d8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (d8_pos == false && container_d7 == "pawn") {
                            d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d7.setVisibility(View.INVISIBLE);
                            String temp = " D7 ---> D8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d8_pos = true;
                            d7_pos = false;
                            container_d8 = "pawn";
                            container_d7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (d8_pos == false && container_d7 == "queen") {
                            d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d7.setVisibility(View.INVISIBLE);
                            String temp = " D7 ---> D8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d8_pos = true;
                            d7_pos = false;
                            container_d8 = "queen";
                            container_d7 = "";
                            round = false;
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            dialogwin();
                        } else if (d7_pos == true && d8_pos == true && container_d7 == "pawn") {
                            if(container_d8 == "pawn_w" || container_d8 == "queen_w") {
                                d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d7.setVisibility(View.INVISIBLE);
                                String temp = " D7 ---> D8   "+name+"   "+container_d8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d8_pos = true;
                                d7_pos = false;
                                container_d8 = "pawn";
                                container_d7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (d7_pos == true && d8_pos == true && container_d7 == "queen") {
                            if(container_d8 == "pawn_w" || container_d8 == "queen_w") {
                                d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d7.setVisibility(View.INVISIBLE);
                                String temp = " D7 ---> D8   "+name+"   "+container_d8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d8_pos = true;
                                d7_pos = false;
                                container_d8 = "queen";
                                container_d7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            d7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (d8_pos == false && d7_pos == true && container_d7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d8.setVisibility(View.VISIBLE);
                            }else{
                                d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d8.setVisibility(View.VISIBLE);
                            }
                        } else if (d8_pos == false && d7_pos == true && container_d7 == "queen") {
                            if(Objects.equals(theme, "Green")){
                                d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d8.setVisibility(View.VISIBLE);
                            }else{
                                d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d8.setVisibility(View.VISIBLE);
                            }
                        } else if (d7_pos == false && container_d6 == "pawn") {
                            d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d6.setVisibility(View.INVISIBLE);
                            String temp = " D6 ---> D7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d7_pos = true;
                            d6_pos = false;
                            container_d7 = "pawn";
                            container_d6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d7_pos == false && container_d6 == "queen") {
                            d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d6.setVisibility(View.INVISIBLE);
                            String temp = " D6 ---> D7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d7_pos = true;
                            d6_pos = false;
                            container_d7 = "queen";
                            container_d6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d7_pos == true && d6_pos == true && container_d6 == "pawn") {
                            if(container_d7 == "pawn_w" || container_d7 == "queen_w") {
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d6.setVisibility(View.INVISIBLE);
                                String temp = " D6 ---> D7    "+name+"    "+container_d7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d7_pos = true;
                                d6_pos = false;
                                container_d7 = "pawn";
                                container_d6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (d7_pos == true && d6_pos == true && container_d6 == "queen") {
                            if(container_d7 == "pawn_w" || container_d7 == "queen_w") {
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d6.setVisibility(View.INVISIBLE);
                                String temp = " D6 ---> D7    "+name+"    "+container_d7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d7_pos = true;
                                d6_pos = false;
                                container_d7 = "queen";
                                container_d6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            d6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (d7_pos == false && d6_pos == true && container_d6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d7.setVisibility(View.VISIBLE);
                            }else{
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d7.setVisibility(View.VISIBLE);
                            }
                        } else if (d7_pos == false && d6_pos == true && container_d6 == "queen") {
                            if(Objects.equals(theme, "Green")){
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d7.setVisibility(View.VISIBLE);
                            }else{
                                d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d7.setVisibility(View.VISIBLE);
                            }
                        } else if (d6_pos == false && container_d5 == "pawn") {
                            d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d5.setVisibility(View.INVISIBLE);
                            String temp = " D5 ---> D6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d6_pos = true;
                            d5_pos = false;
                            container_d6 = "pawn";
                            container_d5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d6_pos == false && container_d5 == "queen") {
                            d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d5.setVisibility(View.INVISIBLE);
                            String temp = " D5 ---> D6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d6_pos = true;
                            d5_pos = false;
                            container_d6 = "queen";
                            container_d5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d6_pos == true && d5_pos == true && container_d5 == "pawn") {
                            if (container_d6 == "pawn_w" || container_d6 == "queen_w") {
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d5.setVisibility(View.INVISIBLE);
                                String temp = " D5 ---> D6    "+name+"    "+container_d6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d6_pos = true;
                                d5_pos = false;
                                container_d6 = "pawn";
                                container_d5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (d6_pos == true && d5_pos == true && container_d5 == "queen") {
                            if ( container_d6 == "pawn_w" || container_d6 == "queen_w") {
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d5.setVisibility(View.INVISIBLE);
                                String temp = " D5 ---> D6    "+name+"    "+container_d6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d6_pos = true;
                                d5_pos = false;
                                container_d6 = "queen";
                                container_d5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            d5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (d6_pos == false && d5_pos == true && container_d5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d6.setVisibility(View.VISIBLE);
                            }else{
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d6.setVisibility(View.VISIBLE);
                            }
                        } else if (d6_pos == false && d5_pos == true && container_d5 == "queen") {
                            if(Objects.equals(theme, "Green")){
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d6.setVisibility(View.VISIBLE);
                            }else{
                                d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d6.setVisibility(View.VISIBLE);
                            }
                        } else if (d5_pos == false && container_d4 == "pawn") {
                            d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d4.setVisibility(View.INVISIBLE);
                            String temp = " D4 ---> D5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d5_pos = true;
                            d4_pos = false;
                            container_d5 = "pawn";
                            container_d4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d5_pos == false && container_d4 == "queen") {
                            d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d4.setVisibility(View.INVISIBLE);
                            String temp = " D4 ---> D5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d5_pos = true;
                            d4_pos = false;
                            container_d5 = "queen";
                            container_d4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d5_pos == true && d4_pos == true && container_d4 == "pawn" ) {
                            if (container_d5 == "pawn_w" || container_d5 == "queen_w") {
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d4.setVisibility(View.INVISIBLE);
                                String temp = " D4 ---> D5    "+name+"    "+container_d5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d5_pos = true;
                                d4_pos = false;
                                container_d5 = "pawn";
                                container_d4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (d5_pos == true && d4_pos == true && container_d4 == "queen") {
                            if (container_d5 == "pawn_w" || container_d5 == "queen_w") {
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d4.setVisibility(View.INVISIBLE);
                                String temp = " D4 ---> D5    "+name+"    "+container_d5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d5_pos = true;
                                d4_pos = false;
                                container_d5 = "queen";
                                container_d4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            d4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (d5_pos == false && d4_pos == true && container_d4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d5.setVisibility(View.VISIBLE);
                            }else{
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d5.setVisibility(View.VISIBLE);
                            }
                        } else if (d5_pos == false && d4_pos == true && container_d4 == "queen") {
                            if(Objects.equals(theme, "Green")){
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d5.setVisibility(View.VISIBLE);
                            }else{
                                d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d5.setVisibility(View.VISIBLE);
                            }
                        } else if (d4_pos == false && container_d3 == "pawn") {
                            d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d3.setVisibility(View.INVISIBLE);
                            String temp = " D3 ---> D4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d4_pos = true;
                            d3_pos = false;
                            container_d4 = "pawn";
                            container_d3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d4_pos == false && container_d3 == "queen") {
                            d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d3.setVisibility(View.INVISIBLE);
                            String temp = " D3 ---> D4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d4_pos = true;
                            d3_pos = false;
                            container_d4 = "queen";
                            container_d3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d4_pos == true && d3_pos == true && container_d3 == "pawn") {
                            if(container_d4 == "pawn_w" || container_d4 == "queen_w") {
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d3.setVisibility(View.INVISIBLE);
                                String temp = " D3 ---> D4    "+name+"    "+container_d4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d4_pos = true;
                                d3_pos = false;
                                container_d4 = "pawn";
                                container_d3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (d4_pos == true && d3_pos == true && container_d3 == "queen") {
                            if(container_d4 == "pawn_w" || container_d4 == "queen_w") {
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d3.setVisibility(View.INVISIBLE);
                                String temp = " D3 ---> D4    "+name+"    "+container_d4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d4_pos = true;
                                d3_pos = false;
                                container_d4 = "queen";
                                container_d3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            d3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (d4_pos == false && d3_pos == true && container_d3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d4.setVisibility(View.VISIBLE);
                            }else{
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d4.setVisibility(View.VISIBLE);
                            }
                        } else if (d4_pos == false && d3_pos == true && container_d3 == "queen") {
                            if(Objects.equals(theme, "Green")){
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d4.setVisibility(View.VISIBLE);
                            }else{
                                d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d4.setVisibility(View.VISIBLE);
                            }
                        } else if (d3_pos == false && container_d2 == "pawn") {
                            d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d2.setVisibility(View.INVISIBLE);
                            String temp = " D2 ---> D3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d3_pos = true;
                            d2_pos = false;
                            container_d3 = "pawn";
                            container_d2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d3_pos == false && container_d2 == "queen") {
                            d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d2.setVisibility(View.INVISIBLE);
                            String temp = " D2 ---> D3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d3_pos = true;
                            d2_pos = false;
                            container_d3 = "queen";
                            container_d2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d3_pos == true && d2_pos == true && container_d2 == "pawn") {
                            if(container_d3 == "pawn_w" || container_d3 == "queen_w") {
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d2.setVisibility(View.INVISIBLE);
                                String temp = " D2 ---> D3    "+name+"    "+container_d3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d3_pos = true;
                                d2_pos = false;
                                container_d3 = "pawn";
                                container_d2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (d3_pos == true && d2_pos == true && container_d2 == "queen") {
                            if(container_d3 == "pawn_w" || container_d3 == "queen_w") {
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d2.setVisibility(View.INVISIBLE);
                                String temp = " D2 ---> D3    "+name+"    "+container_d3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d3_pos = true;
                                d2_pos = false;
                                container_d3 = "queen";
                                container_d2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            d2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (d3_pos == false && d2_pos == true && container_d2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d3.setVisibility(View.VISIBLE);
                            }else{
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d3.setVisibility(View.VISIBLE);
                            }
                        } else if (d3_pos == false && d2_pos == true && container_d2 == "queen") {
                            if(Objects.equals(theme, "Green")){
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d3.setVisibility(View.VISIBLE);
                            }else{
                                d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d3.setVisibility(View.VISIBLE);
                            }
                        } else if (d2_pos == false && container_d1 == "queen") {
                            d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                            d1.setVisibility(View.INVISIBLE);
                            String temp = " D1 ---> D2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d2_pos = true;
                            d1_pos = false;
                            container_d2 = "queen";
                            container_d1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d2_pos == false && container_d1 == "pawn") {
                            d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            d1.setVisibility(View.INVISIBLE);
                            String temp = " D1 ---> D2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            d2_pos = true;
                            d1_pos = false;
                            container_d2 = "pawn";
                            container_d1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (d2_pos == true && d1_pos == true && container_d1 == "pawn" ) {
                            if(container_d2 == "pawn_w" || container_d2 == "queen_w") {
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d1.setVisibility(View.INVISIBLE);
                                String temp = " D1 ---> D2    "+name+"    "+container_d2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d2_pos = true;
                                d1_pos = false;
                                container_d2 = "queen";
                                container_d1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (d2_pos == true && d1_pos == true && container_d1 == "queen") {
                            if (container_d2 == "pawn_w" || container_d2 == "queen_w") {
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d1.setVisibility(View.INVISIBLE);
                                String temp = " D1 ---> D2    "+name+"    "+container_d2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                d2_pos = true;
                                d1_pos = false;
                                container_d2 = "queen";
                                container_d1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            d1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (d2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                d2.setVisibility(View.VISIBLE);
                            }else{
                                d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                d2.setVisibility(View.VISIBLE);
                            }
                        } else if (d1_pos == true ){
                            if(container_d1 == "pawn_w" || container_d1 == "queen_w") {
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                d1_pos = true;
                                container_d1 = "pawn";
                                flag = 0;
                            }
                        } else if (d1_pos == true && container_d1 == "queen") {
                            if(container_d1 == "pawn_w" || container_d1 == "queen_w") {
                                d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.queen_b));
                                d1_pos = true;
                                container_d1 = "queen";
                                flag = 0;
                            }
                        }
                    }
                }
            });
        }
        if (container_e1 == "pawn" || container_e2 == "pawn" || container_e3 == "pawn" || container_e4 == "pawn" || container_e5 == "pawn" || container_e6 == "pawn" || container_e7 == "pawn" || container_e8 == "pawn" || container_e1 == "king" || container_e2 == "king" || container_e3 == "king" || container_e4 == "king" || container_e5 == "king" || container_e6 == "king" || container_e7 == "king" || container_e8 == "king") {
            e8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (e8_pos == false && container_e7 == "pawn") {
                            e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e7.setVisibility(View.INVISIBLE);
                            String temp = " E7 ---> E8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e8_pos = true;
                            e7_pos = false;
                            container_e8 = "pawn";
                            container_e7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (e8_pos == false && container_e7 == "king") {
                            e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e7.setVisibility(View.INVISIBLE);
                            String temp = " E7 ---> E8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e8_pos = true;
                            e7_pos = false;
                            container_e8 = "king";
                            container_e7 = "";
                            round = false;
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (e7_pos == true && e8_pos == true && container_e7 == "pawn") {
                            if(container_e8 == "pawn_w" || container_e8 == "king_w") {
                                e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e7.setVisibility(View.INVISIBLE);
                                String temp = " E7 ---> E8   "+name+"   "+container_e8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e8_pos = true;
                                e7_pos = false;
                                container_e8 = "pawn";
                                container_e7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (e7_pos == true && e8_pos == true && container_e7 == "king") {
                            if(container_e8 == "pawn_w" || container_e8 == "king_w") {
                                e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e7.setVisibility(View.INVISIBLE);
                                String temp = " E7 ---> E8   "+name+"   "+container_e8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e8_pos = true;
                                e7_pos = false;
                                container_e8 = "king";
                                container_e7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            e7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (e8_pos == false && e7_pos == true && container_e7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e8.setVisibility(View.VISIBLE);
                            }else{
                                e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e8.setVisibility(View.VISIBLE);
                            }
                        } else if (e8_pos == false && e7_pos == true && container_e7 == "king") {
                            if(Objects.equals(theme, "Green")){
                                e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e8.setVisibility(View.VISIBLE);
                            }else{
                                e8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e8.setVisibility(View.VISIBLE);
                            }
                        } else if (e7_pos == false && container_e6 == "pawn") {
                            e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e6.setVisibility(View.INVISIBLE);
                            String temp = " E6 ---> E7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e7_pos = true;
                            e6_pos = false;
                            container_e7 = "pawn";
                            container_e6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e7_pos == false && container_e6 == "king") {
                            e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e6.setVisibility(View.INVISIBLE);
                            String temp = " E6 ---> E7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e7_pos = true;
                            e6_pos = false;
                            container_e7 = "king";
                            container_e6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e7_pos == true && e6_pos == true && container_e6 == "pawn") {
                            if(container_e7 == "pawn_w" || container_e7 == "king_w") {
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e6.setVisibility(View.INVISIBLE);
                                String temp = " E6 ---> E7    "+name+"    "+container_e7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e7_pos = true;
                                e6_pos = false;
                                container_e7 = "pawn";
                                container_e6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (e7_pos == true && e6_pos == true && container_e6 == "king") {
                            if(container_e7 == "pawn_w" || container_e7 == "king_w") {
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e6.setVisibility(View.INVISIBLE);
                                String temp = " E6 ---> E7    "+name+"    "+container_e7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e7_pos = true;
                                e6_pos = false;
                                container_e7 = "king";
                                container_e6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            e6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (e7_pos == false && e6_pos == true && container_e6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e7.setVisibility(View.VISIBLE);
                            }else{
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e7.setVisibility(View.VISIBLE);
                            }
                        } else if (e7_pos == false && e6_pos == true && container_e6 == "king") {
                            if(Objects.equals(theme, "Green")){
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e7.setVisibility(View.VISIBLE);
                            }else{
                                e7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e7.setVisibility(View.VISIBLE);
                            }
                        } else if (e6_pos == false && container_e5 == "pawn") {
                            e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e5.setVisibility(View.INVISIBLE);
                            String temp = " E5 ---> E6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e6_pos = true;
                            e5_pos = false;
                            container_e6 = "pawn";
                            container_e5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e6_pos == false && container_e5 == "king") {
                            e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e5.setVisibility(View.INVISIBLE);
                            String temp = " E5 ---> E6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e6_pos = true;
                            e5_pos = false;
                            container_e6 = "king";
                            container_e5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e6_pos == true && e5_pos == true && container_e5 == "pawn") {
                            if (container_e6 == "pawn_w" || container_e6 == "king_w") {
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e5.setVisibility(View.INVISIBLE);
                                String temp = " E5 ---> E6    "+name+"    "+container_e6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e6_pos = true;
                                e5_pos = false;
                                container_e6 = "pawn";
                                container_e5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (e6_pos == true && e5_pos == true && container_e5 == "king") {
                            if ( container_e6 == "pawn_w" || container_e6 == "king_w") {
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e5.setVisibility(View.INVISIBLE);
                                String temp = " E5 ---> E6    "+name+"    "+container_e6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e6_pos = true;
                                e5_pos = false;
                                container_e6 = "king";
                                container_e5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            e5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (e6_pos == false && e5_pos == true && container_e5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e6.setVisibility(View.VISIBLE);
                            }else{
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e6.setVisibility(View.VISIBLE);
                            }
                        } else if (e6_pos == false && e5_pos == true && container_e5 == "king") {
                            if(Objects.equals(theme, "Green")){
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e6.setVisibility(View.VISIBLE);
                            }else{
                                e6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e6.setVisibility(View.VISIBLE);
                            }
                        } else if (e5_pos == false && container_e4 == "pawn") {
                            e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e4.setVisibility(View.INVISIBLE);
                            String temp = " E4 ---> E5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e5_pos = true;
                            e4_pos = false;
                            container_e5 = "pawn";
                            container_e4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e5_pos == false && container_e4 == "king") {
                            e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e4.setVisibility(View.INVISIBLE);
                            String temp = " E4 ---> E5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e5_pos = true;
                            e4_pos = false;
                            container_e5 = "king";
                            container_e4 = "";
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                            flag = 0;
                        } else if (e5_pos == true && e4_pos == true && container_e4 == "pawn" ) {
                            if (container_e5 == "pawn_w" || container_e5 == "king_w") {
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e4.setVisibility(View.INVISIBLE);
                                String temp = " E4 ---> E5    "+name+"    "+container_e5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e5_pos = true;
                                e4_pos = false;
                                container_e5 = "pawn";
                                container_e4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (e5_pos == true && e4_pos == true && container_e4 == "king") {
                            if (container_e5 == "pawn_w" || container_e5 == "king_w") {
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e4.setVisibility(View.INVISIBLE);
                                String temp = " E4 ---> E5    "+name+"    "+container_e5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e5_pos = true;
                                e4_pos = false;
                                container_e5 = "king";
                                container_e4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            e4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (e5_pos == false && e4_pos == true && container_e4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e5.setVisibility(View.VISIBLE);
                            }else{
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e5.setVisibility(View.VISIBLE);
                            }
                        } else if (e5_pos == false && e4_pos == true && container_e4 == "king") {
                            if(Objects.equals(theme, "Green")){
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e5.setVisibility(View.VISIBLE);
                            }else{
                                e5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e5.setVisibility(View.VISIBLE);
                            }
                        } else if (e4_pos == false && container_e3 == "pawn") {
                            e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e3.setVisibility(View.INVISIBLE);
                            String temp = " E3 ---> E4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e4_pos = true;
                            e3_pos = false;
                            container_e4 = "pawn";
                            container_e3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e4_pos == false && container_e3 == "king") {
                            e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e3.setVisibility(View.INVISIBLE);
                            String temp = " E3 ---> E4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e4_pos = true;
                            e3_pos = false;
                            container_e4 = "king";
                            container_e3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e4_pos == true && e3_pos == true && container_e3 == "pawn") {
                            if(container_e4 == "pawn_w" || container_e4 == "king_w") {
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e3.setVisibility(View.INVISIBLE);
                                String temp = " E3 ---> E4    "+name+"    "+container_e4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e4_pos = true;
                                e3_pos = false;
                                container_e4 = "pawn";
                                container_e3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (e4_pos == true && e3_pos == true && container_e3 == "king") {
                            if(container_e4 == "pawn_w" || container_e4 == "king_w") {
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e3.setVisibility(View.INVISIBLE);
                                String temp = " E3 ---> E4    "+name+"    "+container_e4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e4_pos = true;
                                e3_pos = false;
                                container_e4 = "king";
                                container_e3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            e3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (e4_pos == false && e3_pos == true && container_e3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e4.setVisibility(View.VISIBLE);
                            }else{
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e4.setVisibility(View.VISIBLE);
                            }
                        } else if (e4_pos == false && e3_pos == true && container_e3 == "king") {
                            if(Objects.equals(theme, "Green")){
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e4.setVisibility(View.VISIBLE);
                            }else{
                                e4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e4.setVisibility(View.VISIBLE);
                            }
                        } else if (e3_pos == false && container_e2 == "pawn") {
                            e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e2.setVisibility(View.INVISIBLE);
                            String temp = " E2 ---> E3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e3_pos = true;
                            e2_pos = false;
                            container_e3 = "pawn";
                            container_e2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e3_pos == false && container_e2 == "king") {
                            e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e2.setVisibility(View.INVISIBLE);
                            String temp = " E2 ---> E3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e3_pos = true;
                            e2_pos = false;
                            container_e3 = "king";
                            container_e2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e3_pos == true && e2_pos == true && container_e2 == "pawn") {
                            if(container_e3 == "pawn_w" || container_e3 == "king_w") {
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e2.setVisibility(View.INVISIBLE);
                                String temp = " E2 ---> E3    "+name+"    "+container_e3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e3_pos = true;
                                e2_pos = false;
                                container_e3 = "pawn";
                                container_e2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (e3_pos == true && e2_pos == true && container_e2 == "king") {
                            if(container_e3 == "pawn_w" || container_e3 == "king_w") {
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e2.setVisibility(View.INVISIBLE);
                                String temp = " E2 ---> E3    "+name+"    "+container_e3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e3_pos = true;
                                e2_pos = false;
                                container_e3 = "king";
                                container_e2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            e2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (e3_pos == false && e2_pos == true && container_e2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e3.setVisibility(View.VISIBLE);
                            }else{
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e3.setVisibility(View.VISIBLE);
                            }
                        } else if (e3_pos == false && e2_pos == true && container_e2 == "king") {
                            if(Objects.equals(theme, "Green")){
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e3.setVisibility(View.VISIBLE);
                            }else{
                                e3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e3.setVisibility(View.VISIBLE);
                            }
                        } else if (e2_pos == false && container_e1 == "king") {
                            e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                            e1.setVisibility(View.INVISIBLE);
                            String temp = " E1 ---> E2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e2_pos = true;
                            e1_pos = false;
                            container_e2 = "king";
                            container_e1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e2_pos == false && container_e1 == "pawn") {
                            e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            e1.setVisibility(View.INVISIBLE);
                            String temp = " E1 ---> E2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            e2_pos = true;
                            e1_pos = false;
                            container_e2 = "pawn";
                            container_e1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (e2_pos == true && e1_pos == true && container_e1 == "pawn" ) {
                            if(container_e2 == "pawn_w" || container_e2 == "king_w") {
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e1.setVisibility(View.INVISIBLE);
                                String temp = " E1 ---> E2    "+name+"    "+container_e2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e2_pos = true;
                                e1_pos = false;
                                container_e2 = "king";
                                container_e1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (e2_pos == true && e1_pos == true && container_e1 == "king") {
                            if (container_e2 == "pawn_w" || container_e2 == "king_w") {
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e1.setVisibility(View.INVISIBLE);
                                String temp = " E1 ---> E2    "+name+"    "+container_e2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                e2_pos = true;
                                e1_pos = false;
                                container_e2 = "king";
                                container_e1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            e1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (e2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                e2.setVisibility(View.VISIBLE);
                            }else{
                                e2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                e2.setVisibility(View.VISIBLE);
                            }
                        } else if (e1_pos == true ){
                            if(container_e1 == "pawn_w" || container_e1 == "king_w") {
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                e1_pos = true;
                                container_e1 = "pawn";
                                flag = 0;
                            }
                        } else if (e1_pos == true && container_e1 == "king") {
                            if(container_e1 == "pawn_w" || container_e1 == "king_w") {
                                e1.setBackgroundDrawable(getResources().getDrawable(R.drawable.king_b));
                                e1_pos = true;
                                container_e1 = "king";
                                flag = 0;
                            }
                        }
                    }
                }
            });
        }
        if (container_f1 == "pawn" || container_f2 == "pawn" || container_f3 == "pawn" || container_f4 == "pawn" || container_f5 == "pawn" || container_f6 == "pawn" || container_f7 == "pawn" || container_f8 == "pawn" || container_f1 == "bishop" || container_f2 == "bishop" || container_f3 == "bishop" || container_f4 == "bishop" || container_f5 == "bishop" || container_f6 == "bishop" || container_f7 == "bishop" || container_f8 == "bishop") {
            f8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (f8_pos == false && container_f7 == "pawn") {
                            f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f7.setVisibility(View.INVISIBLE);
                            String temp = " F7 ---> F8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f8_pos = true;
                            f7_pos = false;
                            container_f8 = "pawn";
                            container_f7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (f8_pos == false && container_f7 == "bishop") {
                            f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f7.setVisibility(View.INVISIBLE);
                            String temp = " F7 ---> F8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f8_pos = true;
                            f7_pos = false;
                            container_f8 = "bishop";
                            container_f7 = "";
                            round = false;
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (f7_pos == true && f8_pos == true && container_f7 == "pawn") {
                            if(container_f8 == "pawn_w" || container_f8 == "bishop_w") {
                                f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f7.setVisibility(View.INVISIBLE);
                                String temp = " F7 ---> F8   "+name+"   "+container_f8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f8_pos = true;
                                f7_pos = false;
                                container_f8 = "pawn";
                                container_f7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (f7_pos == true && f8_pos == true && container_f7 == "bishop") {
                            if(container_f8 == "pawn_w" || container_f8 == "bishop_w") {
                                f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f7.setVisibility(View.INVISIBLE);
                                String temp = " F7 ---> F8   "+name+"   "+container_f8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f8_pos = true;
                                f7_pos = false;
                                container_f8 = "bishop";
                                container_f7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            f7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (f8_pos == false && f7_pos == true && container_f7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f8.setVisibility(View.VISIBLE);
                            }else{
                                f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f8.setVisibility(View.VISIBLE);
                            }
                        } else if (f8_pos == false && f7_pos == true && container_f7 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f8.setVisibility(View.VISIBLE);
                            }else{
                                f8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f8.setVisibility(View.VISIBLE);
                            }
                        } else if (f7_pos == false && container_f6 == "pawn") {
                            f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f6.setVisibility(View.INVISIBLE);
                            String temp = " F6 ---> F7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f7_pos = true;
                            f6_pos = false;
                            container_f7 = "pawn";
                            container_f6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f7_pos == false && container_f6 == "bishop") {
                            f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f6.setVisibility(View.INVISIBLE);
                            String temp = " F6 ---> F7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f7_pos = true;
                            f6_pos = false;
                            container_f7 = "bishop";
                            container_f6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f7_pos == true && f6_pos == true && container_f6 == "pawn") {
                            if(container_f7 == "pawn_w" || container_f7 == "bishop_w") {
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f6.setVisibility(View.INVISIBLE);
                                String temp = " F6 ---> F7    "+name+"    "+container_f7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f7_pos = true;
                                f6_pos = false;
                                container_f7 = "pawn";
                                container_f6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (f7_pos == true && f6_pos == true && container_f6 == "bishop") {
                            if(container_f7 == "pawn_w" || container_f7 == "bishop_w") {
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f6.setVisibility(View.INVISIBLE);
                                String temp = " F6 ---> F7    "+name+"    "+container_f7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f7_pos = true;
                                f6_pos = false;
                                container_f7 = "bishop";
                                container_f6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            f6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (f7_pos == false && f6_pos == true && container_f6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f7.setVisibility(View.VISIBLE);
                            }else{
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f7.setVisibility(View.VISIBLE);
                            }
                        } else if (f7_pos == false && f6_pos == true && container_f6 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f7.setVisibility(View.VISIBLE);
                            }else{
                                f7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f7.setVisibility(View.VISIBLE);
                            }
                        } else if (f6_pos == false && container_f5 == "pawn") {
                            f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f5.setVisibility(View.INVISIBLE);
                            String temp = " F5 ---> F6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f6_pos = true;
                            f5_pos = false;
                            container_f6 = "pawn";
                            container_f5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f6_pos == false && container_f5 == "bishop") {
                            f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f5.setVisibility(View.INVISIBLE);
                            String temp = " F5 ---> F6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f6_pos = true;
                            f5_pos = false;
                            container_f6 = "bishop";
                            container_f5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f6_pos == true && f5_pos == true && container_f5 == "pawn") {
                            if (container_f6 == "pawn_w" || container_f6 == "bishop_w") {
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f5.setVisibility(View.INVISIBLE);
                                String temp = " F5 ---> F6    "+name+"    "+container_f6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f6_pos = true;
                                f5_pos = false;
                                container_f6 = "pawn";
                                container_f5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (f6_pos == true && f5_pos == true && container_f5 == "bishop") {
                            if ( container_f6 == "pawn_w" || container_f6 == "bishop_w") {
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f5.setVisibility(View.INVISIBLE);
                                String temp = " F5 ---> F6    "+name+"    "+container_f6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f6_pos = true;
                                f5_pos = false;
                                container_f6 = "bishop";
                                container_f5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (f6_pos == false && f5_pos == true && container_f5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f6.setVisibility(View.VISIBLE);
                            }else{
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f6.setVisibility(View.VISIBLE);
                            }
                        } else if (f6_pos == false && f5_pos == true && container_f5 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f6.setVisibility(View.VISIBLE);
                            }else{
                                f6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f6.setVisibility(View.VISIBLE);
                            }
                        } else if (f5_pos == false && container_f4 == "pawn") {
                            f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f4.setVisibility(View.INVISIBLE);
                            String temp = " F4 ---> F5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f5_pos = true;
                            f4_pos = false;
                            container_f5 = "pawn";
                            container_f4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f5_pos == false && container_f4 == "bishop") {
                            f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f4.setVisibility(View.INVISIBLE);
                            String temp = " F4 ---> F5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f5_pos = true;
                            f4_pos = false;
                            container_f5 = "bishop";
                            container_f4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f5_pos == true && f4_pos == true && container_f4 == "pawn" ) {
                            if (container_f5 == "pawn_w" || container_f5 == "bishop_w") {
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f4.setVisibility(View.INVISIBLE);
                                String temp = " F4 ---> F5    "+name+"    "+container_f5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f5_pos = true;
                                f4_pos = false;
                                container_f5 = "pawn";
                                container_f4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (f5_pos == true && f4_pos == true && container_f4 == "bishop") {
                            if (container_f5 == "pawn_w" || container_f5 == "bishop_w") {
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f4.setVisibility(View.INVISIBLE);
                                String temp = " F4 ---> F5    "+name+"    "+container_f5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f5_pos = true;
                                f4_pos = false;
                                container_f5 = "bishop";
                                container_f4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (f5_pos == false && f4_pos == true && container_f4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f5.setVisibility(View.VISIBLE);
                            }else{
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f5.setVisibility(View.VISIBLE);
                            }
                        } else if (f5_pos == false && f4_pos == true && container_f4 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f5.setVisibility(View.VISIBLE);
                            }else{
                                f5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f5.setVisibility(View.VISIBLE);
                            }
                        } else if (f4_pos == false && container_f3 == "pawn") {
                            f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f3.setVisibility(View.INVISIBLE);
                            String temp = " F3 ---> F4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f4_pos = true;
                            f3_pos = false;
                            container_f4 = "pawn";
                            container_f3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f4_pos == false && container_f3 == "bishop") {
                            f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f3.setVisibility(View.INVISIBLE);
                            String temp = " F3 ---> F4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f4_pos = true;
                            f3_pos = false;
                            container_f4 = "bishop";
                            container_f3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f4_pos == true && f3_pos == true && container_f3 == "pawn") {
                            if(container_f4 == "pawn_w" || container_f4 == "bishop_w") {
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f3.setVisibility(View.INVISIBLE);
                                String temp = " F3 ---> F4    "+name+"    "+container_f4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f4_pos = true;
                                f3_pos = false;
                                container_f4 = "pawn";
                                container_f3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (f4_pos == true && f3_pos == true && container_f3 == "bishop") {
                            if(container_f4 == "pawn_w" || container_f4 == "bishop_w") {
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f3.setVisibility(View.INVISIBLE);
                                String temp = " F3 ---> F4    "+name+"    "+container_f4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f4_pos = true;
                                f3_pos = false;
                                container_f4 = "bishop";
                                container_f3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (f4_pos == false && f3_pos == true && container_f3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f4.setVisibility(View.VISIBLE);
                            }else{
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f4.setVisibility(View.VISIBLE);
                            }
                        } else if (f4_pos == false && f3_pos == true && container_f3 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f4.setVisibility(View.VISIBLE);
                            }else{
                                f4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f4.setVisibility(View.VISIBLE);
                            }
                        } else if (f3_pos == false && container_f2 == "pawn") {
                            f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f2.setVisibility(View.INVISIBLE);
                            String temp = " F2 ---> F3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f3_pos = true;
                            f2_pos = false;
                            container_f3 = "pawn";
                            container_f2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f3_pos == false && container_f2 == "bishop") {
                            f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f2.setVisibility(View.INVISIBLE);
                            String temp = " F2 ---> F3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f3_pos = true;
                            f2_pos = false;
                            container_f3 = "bishop";
                            container_f2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f3_pos == true && f2_pos == true && container_f2 == "pawn") {
                            if(container_f3 == "pawn_w" || container_f3 == "bishop_w") {
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f2.setVisibility(View.INVISIBLE);
                                String temp = " F2 ---> F3    "+name+"    "+container_f3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f3_pos = true;
                                f2_pos = false;
                                container_f3 = "pawn";
                                container_f2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (f3_pos == true && f2_pos == true && container_f2 == "bishop") {
                            if(container_f3 == "pawn_w" || container_f3 == "bishop_w") {
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f2.setVisibility(View.INVISIBLE);
                                String temp = " F2 ---> F3    "+name+"    "+container_f3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f3_pos = true;
                                f2_pos = false;
                                container_f3 = "bishop";
                                container_f2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (f3_pos == false && f2_pos == true && container_f2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f3.setVisibility(View.VISIBLE);
                            }else{
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f3.setVisibility(View.VISIBLE);
                            }
                        } else if (f3_pos == false && f2_pos == true && container_f2 == "bishop") {
                            if(Objects.equals(theme, "Green")){
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f3.setVisibility(View.VISIBLE);
                            }else{
                                f3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f3.setVisibility(View.VISIBLE);
                            }
                        } else if (f2_pos == false && container_f1 == "bishop") {
                            f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                            f1.setVisibility(View.INVISIBLE);
                            String temp = " F1 ---> F2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f2_pos = true;
                            f1_pos = false;
                            container_f2 = "bishop";
                            container_f1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f2_pos == false && container_f1 == "pawn") {
                            f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            f1.setVisibility(View.INVISIBLE);
                            String temp = " F1 ---> F2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            f2_pos = true;
                            f1_pos = false;
                            container_f2 = "pawn";
                            container_f1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (f2_pos == true && f1_pos == true && container_f1 == "pawn" ) {
                            if(container_f2 == "pawn_w" || container_f2 == "bishop_w") {
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f1.setVisibility(View.INVISIBLE);
                                String temp = " F1 ---> F2    "+name+"    "+container_f2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f2_pos = true;
                                f1_pos = false;
                                container_f2 = "bishop";
                                container_f1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (f2_pos == true && f1_pos == true && container_f1 == "bishop") {
                            if (container_f2 == "pawn_w" || container_f2 == "bishop_w") {
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f1.setVisibility(View.INVISIBLE);
                                String temp = " F1 ---> F2    "+name+"    "+container_f2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                f2_pos = true;
                                f1_pos = false;
                                container_f2 = "bishop";
                                container_f1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (f2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                f2.setVisibility(View.VISIBLE);
                            }else{
                                f2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                f2.setVisibility(View.VISIBLE);
                            }
                        } else if (f1_pos == true ){
                            if(container_f1 == "pawn_w" || container_f1 == "bishop_w") {
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                f1_pos = true;
                                container_f1 = "pawn";
                                flag = 0;
                            }
                        } else if (f1_pos == true && container_f1 == "bishop") {
                            if(container_f1 == "pawn_w" || container_f1 == "bishop_w") {
                                f1.setBackgroundDrawable(getResources().getDrawable(R.drawable.bishop_b));
                                f1_pos = true;
                                container_f1 = "bishop";
                                flag = 0;
                            }
                        }
                    }
                }
            });
        }
        if (container_g1 == "pawn" || container_g2 == "pawn" || container_g3 == "pawn" || container_g4 == "pawn" || container_g5 == "pawn" || container_g6 == "pawn" || container_g7 == "pawn" || container_g8 == "pawn" || container_g1 == "knight" || container_g2 == "knight" || container_g3 == "knight" || container_g4 == "knight" || container_g5 == "knight" || container_g6 == "knight" || container_g7 == "knight" || container_g8 == "knight") {
            g8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (g8_pos == false && container_g7 == "pawn") {
                            g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g7.setVisibility(View.INVISIBLE);
                            String temp = " G7 ---> G8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g8_pos = true;
                            g7_pos = false;
                            container_g8 = "pawn";
                            container_g7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (g8_pos == false && container_g7 == "knight") {
                            g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g7.setVisibility(View.INVISIBLE);
                            String temp = " G7 ---> G8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g8_pos = true;
                            g7_pos = false;
                            container_g8 = "knight";
                            container_g7 = "";
                            round = false;
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (g7_pos == true && g8_pos == true && container_g7 == "pawn") {
                            if(container_g8 == "pawn_w" || container_g8 == "knight_w") {
                                g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g7.setVisibility(View.INVISIBLE);
                                String temp = " G7 ---> G8   "+name+"   "+container_g8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g8_pos = true;
                                g7_pos = false;
                                container_g8 = "pawn";
                                container_g7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (g7_pos == true && g8_pos == true && container_g7 == "knight") {
                            if(container_g8 == "pawn_w" || container_g8 == "knight_w") {
                                g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g7.setVisibility(View.INVISIBLE);
                                String temp = " G7 ---> G8   "+name+"   "+container_g8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g8_pos = true;
                                g7_pos = false;
                                container_g8 = "knight";
                                container_g7 = "";
                                round = false;
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            g7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (g8_pos == false && g7_pos == true && container_g7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g8.setVisibility(View.VISIBLE);
                            }else{
                                g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g8.setVisibility(View.VISIBLE);
                            }
                        } else if (g8_pos == false && g7_pos == true && container_g7 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g8.setVisibility(View.VISIBLE);
                            }else{
                                g8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g8.setVisibility(View.VISIBLE);
                            }
                        } else if (g7_pos == false && container_g6 == "pawn") {
                            g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g6.setVisibility(View.INVISIBLE);
                            String temp = " G6 ---> G7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g7_pos = true;
                            g6_pos = false;
                            container_g7 = "pawn";
                            container_g6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g7_pos == false && container_g6 == "knight") {
                            g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g6.setVisibility(View.INVISIBLE);
                            String temp = " G6 ---> G7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g7_pos = true;
                            g6_pos = false;
                            container_g7 = "knight";
                            container_g6 = "";
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                            flag = 0;
                        } else if (g7_pos == true && g6_pos == true && container_g6 == "pawn") {
                            if(container_g7 == "pawn_w" || container_g7 == "knight_w") {
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g6.setVisibility(View.INVISIBLE);
                                String temp = " G6 ---> G7    "+name+"    "+container_g7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g7_pos = true;
                                g6_pos = false;
                                container_g7 = "pawn";
                                container_g6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (g7_pos == true && g6_pos == true && container_g6 == "knight") {
                            if(container_g7 == "pawn_w" || container_g7 == "knight_w") {
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g6.setVisibility(View.INVISIBLE);
                                String temp = " G6 ---> G7    "+name+"    "+container_g7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g7_pos = true;
                                g6_pos = false;
                                container_g7 = "knight";
                                container_g6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            g6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (g7_pos == false && g6_pos == true && container_g6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g7.setVisibility(View.VISIBLE);
                            }else{
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g7.setVisibility(View.VISIBLE);
                            }
                        } else if (g7_pos == false && g6_pos == true && container_g6 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g7.setVisibility(View.VISIBLE);
                            }else{
                                g7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g7.setVisibility(View.VISIBLE);
                            }
                        } else if (g6_pos == false && container_g5 == "pawn") {
                            g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g5.setVisibility(View.INVISIBLE);
                            String temp = " G5 ---> G6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g6_pos = true;
                            g5_pos = false;
                            container_g6 = "pawn";
                            container_g5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g6_pos == false && container_g5 == "knight") {
                            g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g5.setVisibility(View.INVISIBLE);
                            String temp = " G5 ---> G6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g6_pos = true;
                            g5_pos = false;
                            container_g6 = "knight";
                            container_g5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g6_pos == true && g5_pos == true && container_g5 == "pawn") {
                            if (container_g6 == "pawn_w" || container_g6 == "knight_w") {
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g5.setVisibility(View.INVISIBLE);
                                String temp = " G5 ---> G6    "+name+"    "+container_g6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g6_pos = true;
                                g5_pos = false;
                                container_g6 = "pawn";
                                container_g5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (g6_pos == true && g5_pos == true && container_g5 == "knight") {
                            if ( container_g6 == "pawn_w" || container_g6 == "knight_w") {
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g5.setVisibility(View.INVISIBLE);
                                String temp = " G5 ---> G6    "+name+"    "+container_g6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g6_pos = true;
                                g5_pos = false;
                                container_g6 = "knight";
                                container_g5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            g5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (g6_pos == false && g5_pos == true && container_g5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g6.setVisibility(View.VISIBLE);
                            }else{
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g6.setVisibility(View.VISIBLE);
                            }
                        } else if (g6_pos == false && g5_pos == true && container_g5 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g6.setVisibility(View.VISIBLE);
                            }else{
                                g6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g6.setVisibility(View.VISIBLE);
                            }
                        } else if (g5_pos == false && container_g4 == "pawn") {
                            g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g4.setVisibility(View.INVISIBLE);
                            String temp = " G4 ---> G5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g5_pos = true;
                            g4_pos = false;
                            container_g5 = "pawn";
                            container_g4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g5_pos == false && container_g4 == "knight") {
                            g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g4.setVisibility(View.INVISIBLE);
                            String temp = " G4 ---> G5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g5_pos = true;
                            g4_pos = false;
                            container_g5 = "knight";
                            container_g4 = "";
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                            flag = 0;
                        } else if (g5_pos == true && g4_pos == true && container_g4 == "pawn" ) {
                            if (container_g5 == "pawn_w" || container_g5 == "knight_w") {
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g4.setVisibility(View.INVISIBLE);
                                String temp = " G4 ---> G5    "+name+"    "+container_g5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g5_pos = true;
                                g4_pos = false;
                                container_g5 = "pawn";
                                container_g4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (g5_pos == true && g4_pos == true && container_g4 == "knight") {
                            if (container_g5 == "pawn_w" || container_g5 == "knight_w") {
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g4.setVisibility(View.INVISIBLE);
                                String temp = " G4 ---> G5    "+name+"    "+container_g5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g5_pos = true;
                                g4_pos = false;
                                container_g5 = "knight";
                                container_g4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            g4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (g5_pos == false && g4_pos == true && container_g4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g5.setVisibility(View.VISIBLE);
                            }else{
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g5.setVisibility(View.VISIBLE);
                            }
                        } else if (g5_pos == false && g4_pos == true && container_g4 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g5.setVisibility(View.VISIBLE);
                            }else{
                                g5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g5.setVisibility(View.VISIBLE);
                            }
                        } else if (g4_pos == false && container_g3 == "pawn") {
                            g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g3.setVisibility(View.INVISIBLE);
                            String temp = " G3 ---> G4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g4_pos = true;
                            g3_pos = false;
                            container_g4 = "pawn";
                            container_g3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g4_pos == false && container_g3 == "knight") {
                            g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g3.setVisibility(View.INVISIBLE);
                            String temp = " G3 ---> G4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g4_pos = true;
                            g3_pos = false;
                            container_g4 = "knight";
                            container_g3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g4_pos == true && g3_pos == true && container_g3 == "pawn") {
                            if(container_g4 == "pawn_w" || container_g4 == "knight_w") {
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g3.setVisibility(View.INVISIBLE);
                                String temp = " G3 ---> G4    "+name+"    "+container_g4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g4_pos = true;
                                g3_pos = false;
                                container_g4 = "pawn";
                                container_g3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (g4_pos == true && g3_pos == true && container_g3 == "knight") {
                            if(container_g4 == "pawn_w" || container_g4 == "knight_w") {
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g3.setVisibility(View.INVISIBLE);
                                String temp = " G3 ---> G4    "+name+"    "+container_g4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g4_pos = true;
                                g3_pos = false;
                                container_g4 = "knight";
                                container_g3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            g3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (g4_pos == false && g3_pos == true && container_g3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g4.setVisibility(View.VISIBLE);
                            }else{
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g4.setVisibility(View.VISIBLE);
                            }
                        } else if (g4_pos == false && g3_pos == true && container_g3 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g4.setVisibility(View.VISIBLE);
                            }else{
                                g4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g4.setVisibility(View.VISIBLE);
                            }
                        } else if (g3_pos == false && container_g2 == "pawn") {
                            g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g2.setVisibility(View.INVISIBLE);
                            String temp = " G2 ---> G3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g3_pos = true;
                            g2_pos = false;
                            container_g3 = "pawn";
                            container_g2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g3_pos == false && container_g2 == "knight") {
                            g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g2.setVisibility(View.INVISIBLE);
                            String temp = " G2 ---> G3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g3_pos = true;
                            g2_pos = false;
                            container_g3 = "knight";
                            container_g2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g3_pos == true && g2_pos == true && container_g2 == "pawn") {
                            if(container_g3 == "pawn_w" || container_g3 == "knight_w") {
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g2.setVisibility(View.INVISIBLE);
                                String temp = " G2 ---> G3    "+name+"    "+container_g3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g3_pos = true;
                                g2_pos = false;
                                container_g3 = "pawn";
                                container_g2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (g3_pos == true && g2_pos == true && container_g2 == "knight") {
                            if(container_g3 == "pawn_w" || container_g3 == "knight_w") {
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g2.setVisibility(View.INVISIBLE);
                                String temp = " G2 ---> G3    "+name+"    "+container_g3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g3_pos = true;
                                g2_pos = false;
                                container_g3 = "knight";
                                container_g2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            g2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (g3_pos == false && g2_pos == true && container_g2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g3.setVisibility(View.VISIBLE);
                            }else{
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g3.setVisibility(View.VISIBLE);
                            }
                        } else if (g3_pos == false && g2_pos == true && container_g2 == "knight") {
                            if(Objects.equals(theme, "Green")){
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g3.setVisibility(View.VISIBLE);
                            }else{
                                g3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g3.setVisibility(View.VISIBLE);
                            }
                        } else if (g2_pos == false && container_g1 == "knight") {
                            g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                            g1.setVisibility(View.INVISIBLE);
                            String temp = " G1 ---> G2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g2_pos = true;
                            g1_pos = false;
                            container_g2 = "knight";
                            container_g1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g2_pos == false && container_g1 == "pawn") {
                            g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            g1.setVisibility(View.INVISIBLE);
                            String temp = " G1 ---> G2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            g2_pos = true;
                            g1_pos = false;
                            container_g2 = "pawn";
                            container_g1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (g2_pos == true && g1_pos == true && container_g1 == "pawn" ) {
                            if(container_g2 == "pawn_w" || container_g2 == "knight_w") {
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g1.setVisibility(View.INVISIBLE);
                                String temp = " G1 ---> G2    "+name+"    "+container_g2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g2_pos = true;
                                g1_pos = false;
                                container_g2 = "knight";
                                container_g1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (g2_pos == true && g1_pos == true && container_g1 == "knight") {
                            if (container_g2 == "pawn_w" || container_g2 == "knight_w") {
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g1.setVisibility(View.INVISIBLE);
                                String temp = " G1 ---> G2    "+name+"    "+container_g2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                g2_pos = true;
                                g1_pos = false;
                                container_g2 = "knight";
                                container_g1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            g1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (g2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                g2.setVisibility(View.VISIBLE);
                            }else{
                                g2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                g2.setVisibility(View.VISIBLE);
                            }
                        } else if (g1_pos == true ){
                            if(container_g1 == "pawn_w" || container_g1 == "knight_w") {
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                g1_pos = true;
                                container_g1 = "pawn";
                                flag = 0;
                            }
                        } else if (g1_pos == true && container_g1 == "knight") {
                            if(container_g1 == "pawn_w" || container_g1 == "knight_w") {
                                g1.setBackgroundDrawable(getResources().getDrawable(R.drawable.knight_b));
                                g1_pos = true;
                                container_g1 = "knight";
                                flag = 0;
                            }
                        }
                    }
                }
            });
        }
        if (container_h1 == "pawn" || container_h2 == "pawn" || container_h3 == "pawn" || container_h4 == "pawn" || container_h5 == "pawn" || container_h6 == "pawn" || container_h7 == "pawn" || container_h8 == "pawn" || container_h1 == "castle" || container_h2 == "castle" || container_h3 == "castle" || container_h4 == "castle" || container_h5 == "castle" || container_h6 == "castle" || container_h7 == "castle" || container_h8 == "castle") {
            h8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (h8_pos == false && container_h7 == "pawn") {
                            h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h7.setVisibility(View.INVISIBLE);
                            String temp = " H7 ---> H8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h8_pos = true;
                            h7_pos = false;
                            container_h8 = "pawn";
                            container_h7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (h8_pos == false && container_h7 == "castle") {
                            h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h7.setVisibility(View.INVISIBLE);
                            String temp = " H7 ---> H8    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h8_pos = true;
                            h7_pos = false;
                            container_h8 = "castle";
                            container_h7 = "";
                            flag = 0;
                            textViewDG.setText(""+name+" Wins");
                            textViewD.setText(""+name+" Wins");
                            wcdt.cancel();
                            bcdt.cancel();
                            dialogwin();
                        } else if (h8_pos == true && h7_pos == true && container_h7 == "pawn") {
                            if (container_h8 == "pawn_w" || container_h8 == "castle_w") {
                                h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h7.setVisibility(View.INVISIBLE);
                                String temp = " H7 ---> H8    "+name+"    "+container_h8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h8_pos = true;
                                h7_pos = false;
                                container_h8 = "pawn";
                                container_h7 = "";
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        } else if (h8_pos == true && h7_pos == true && container_h7 == "castle") {
                            if ( container_h8 == "pawn_w" || container_h8 == "castle_w") {
                                h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h7.setVisibility(View.INVISIBLE);
                                String temp = " H7 ---> H8    "+name+"    "+container_h8+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h8_pos = true;
                                h7_pos = false;
                                container_h8 = "castle";
                                container_h7 = "";
                                flag = 0;
                                textViewDG.setText(""+name+" Wins");
                                textViewD.setText(""+name+" Wins");
                                wcdt.cancel();
                                bcdt.cancel();
                                dialogwin();
                            }
                        }
                    }
                }
            });
            h7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (h8_pos == false && h7_pos == true && container_h7 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h8.setVisibility(View.VISIBLE);
                            }else{
                                h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h8.setVisibility(View.VISIBLE);
                            }
                        } else if (h8_pos == false && h7_pos == true && container_h7 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h8.setVisibility(View.VISIBLE);
                            }else{
                                h8.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h8.setVisibility(View.VISIBLE);
                            }
                        } else if (h7_pos == false && container_h6 == "pawn") {
                            h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h6.setVisibility(View.INVISIBLE);
                            String temp = " H6 ---> H7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h7_pos = true;
                            h6_pos = false;
                            container_h7 = "pawn";
                            container_h6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h7_pos == false && container_h6 == "castle") {
                            h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h6.setVisibility(View.INVISIBLE);
                            String temp = " H6 ---> H7    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h7_pos = true;
                            h6_pos = false;
                            container_h7 = "castle";
                            container_h6 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h7_pos == true && h6_pos == true && container_h6 == "pawn") {
                            if (container_h7 == "pawn_w" || container_h7 == "castle_w") {
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h6.setVisibility(View.INVISIBLE);
                                String temp = " H6 ---> H7    "+name+"    "+container_h7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h7_pos = true;
                                h6_pos = false;
                                container_h7 = "pawn";
                                container_h6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h7_pos == true && h6_pos == true && container_h6 == "castle") {
                            if ( container_h7 == "pawn_w" || container_h7 == "castle_w") {
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h6.setVisibility(View.INVISIBLE);
                                String temp = " H6 ---> H7    "+name+"    "+container_h7+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h7_pos = true;
                                h6_pos = false;
                                container_h7 = "castle";
                                container_h6 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            h6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (h7_pos == false && h6_pos == true && container_h6 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h7.setVisibility(View.VISIBLE);
                            }else{
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h7.setVisibility(View.VISIBLE);
                            }
                        } else if (h7_pos == false && h6_pos == true && container_h6 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h7.setVisibility(View.VISIBLE);
                            }else{
                                h7.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h7.setVisibility(View.VISIBLE);
                            }
                        } else if (h6_pos == false && container_h5 == "pawn") {
                            h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h5.setVisibility(View.INVISIBLE);
                            String temp = " H5 ---> H6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h6_pos = true;
                            h5_pos = false;
                            container_h6 = "pawn";
                            container_h5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h6_pos == false && container_h5 == "castle") {
                            h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h5.setVisibility(View.INVISIBLE);
                            String temp = " H5 ---> H6    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h6_pos = true;
                            h5_pos = false;
                            container_h6 = "castle";
                            container_h5 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h6_pos == true && h5_pos == true && container_h5 == "pawn") {
                            if (container_h6 == "pawn_w" || container_h6 == "castle_w") {
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h5.setVisibility(View.INVISIBLE);
                                String temp = " H5 ---> H6    "+name+"    "+container_h6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h6_pos = true;
                                h5_pos = false;
                                container_h6 = "pawn";
                                container_h5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h6_pos == true && h5_pos == true && container_h5 == "castle") {
                            if ( container_h6 == "pawn_w" || container_h6 == "castle_w") {
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h5.setVisibility(View.INVISIBLE);
                                String temp = " H5 ---> H6    "+name+"    "+container_h6+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h6_pos = true;
                                h5_pos = false;
                                container_h6 = "castle";
                                container_h5 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            h5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (h6_pos == false && h5_pos == true && container_h5 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h6.setVisibility(View.VISIBLE);
                            }else{
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h6.setVisibility(View.VISIBLE);
                            }
                        } else if (h6_pos == false && h5_pos == true && container_h5 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h6.setVisibility(View.VISIBLE);
                            }else{
                                h6.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h6.setVisibility(View.VISIBLE);
                            }
                        } else if (h5_pos == false && container_h4 == "pawn") {
                            h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h4.setVisibility(View.INVISIBLE);
                            String temp = " H4 ---> H5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h5_pos = true;
                            h4_pos = false;
                            container_h5 = "pawn";
                            container_h4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h5_pos == false && container_h4 == "castle") {
                            h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h4.setVisibility(View.INVISIBLE);
                            String temp = " H4 ---> H5    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h5_pos = true;
                            h4_pos = false;
                            container_h5 = "castle";
                            container_h4 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h5_pos == true && h4_pos == true && container_h4 == "pawn" ) {
                            if (container_h5 == "pawn_w" || container_h5 == "castle_w") {
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h4.setVisibility(View.INVISIBLE);
                                String temp = " H4 ---> H5    "+name+"    "+container_h5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h5_pos = true;
                                h4_pos = false;
                                container_h5 = "pawn";
                                container_h4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h5_pos == true && h4_pos == true && container_h4 == "castle") {
                            if (container_h5 == "pawn_w" || container_h5 == "castle_w") {
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h4.setVisibility(View.INVISIBLE);
                                String temp = " H4 ---> H5    "+name+"    "+container_h5+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h5_pos = true;
                                h4_pos = false;
                                container_h5 = "castle";
                                container_h4 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            h4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (h5_pos == false && h4_pos == true && container_h4 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h5.setVisibility(View.VISIBLE);
                            }else{
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h5.setVisibility(View.VISIBLE);
                            }
                        } else if (h5_pos == false && h4_pos == true && container_h4 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h5.setVisibility(View.VISIBLE);
                            }else{
                                h5.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h5.setVisibility(View.VISIBLE);
                            }
                        } else if (h4_pos == false && container_h3 == "pawn") {
                            h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h3.setVisibility(View.INVISIBLE);
                            String temp = " H3 ---> H4    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h4_pos = true;
                            h3_pos = false;
                            container_h4 = "pawn";
                            container_h3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h4_pos == false && container_h3 == "castle") {
                            h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h3.setVisibility(View.INVISIBLE);
                            String temp = " H3 ---> H4    "+name+"    ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h4_pos = true;
                            h3_pos = false;
                            container_h4 = "castle";
                            container_h3 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h4_pos == true && h3_pos == true && container_h3 == "pawn") {
                            if(container_h4 == "pawn_w" || container_h4 == "castle_w") {
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h3.setVisibility(View.INVISIBLE);
                                String temp = " H3 ---> H4    "+name+"    "+container_h4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h4_pos = true;
                                h3_pos = false;
                                container_h4 = "pawn";
                                container_h3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h4_pos == true && h3_pos == true && container_h3 == "castle") {
                            if(container_h4 == "pawn_w" || container_h4 == "castle_w") {
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h3.setVisibility(View.INVISIBLE);
                                String temp = " H3 ---> H4    "+name+"    "+container_h4+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h4_pos = true;
                                h3_pos = false;
                                container_h4 = "castle";
                                container_h3 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            h3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (h4_pos == false && h3_pos == true && container_h3 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h4.setVisibility(View.VISIBLE);
                            }else{
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h4.setVisibility(View.VISIBLE);
                            }
                        } else if (h4_pos == false && h3_pos == true && container_h3 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h4.setVisibility(View.VISIBLE);
                            }else{
                                h4.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h4.setVisibility(View.VISIBLE);
                            }
                        } else if (h3_pos == false && container_h2 == "pawn") {
                            h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h2.setVisibility(View.INVISIBLE);
                            String temp = " H2 ---> H3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h3_pos = true;
                            h2_pos = false;
                            container_h3 = "pawn";
                            container_h2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h3_pos == false && container_h2 == "castle") {
                            h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h2.setVisibility(View.INVISIBLE);
                            String temp = " H2 ---> H3    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h3_pos = true;
                            h2_pos = false;
                            container_h3 = "castle";
                            container_h2 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h3_pos == true && h2_pos == true && container_h2 == "pawn") {
                            if(container_h3 == "pawn_w" || container_h3 == "castle_w") {
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h2.setVisibility(View.INVISIBLE);
                                String temp = " H2 ---> H3    "+name+"    "+container_h3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h3_pos = true;
                                h2_pos = false;
                                container_h3 = "pawn";
                                container_h2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h3_pos == true && h2_pos == true && container_h2 == "castle") {
                            if(container_h3 == "pawn_w" || container_h3 == "castle_w") {
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h2.setVisibility(View.INVISIBLE);
                                String temp = " H2 ---> H3    "+name+"    "+container_h3+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h3_pos = true;
                                h2_pos = false;
                                container_h3 = "castle";
                                container_h2 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            h2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 1) {
                        if (h3_pos == false && h2_pos == true && container_h2 == "pawn") {
                            if(Objects.equals(theme, "Green")){
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h3.setVisibility(View.VISIBLE);
                            }else{
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h3.setVisibility(View.VISIBLE);
                            }
                        } else if (h3_pos == false && h2_pos == true && container_h2 == "castle") {
                            if(Objects.equals(theme, "Green")){
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h3.setVisibility(View.VISIBLE);
                            }else{
                                h3.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h3.setVisibility(View.VISIBLE);
                            }
                        } else if (h2_pos == false && container_h1 == "castle") {
                            h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                            h1.setVisibility(View.INVISIBLE);
                            String temp = " H1 ---> H2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h2_pos = true;
                            h1_pos = false;
                            container_h2 = "castle";
                            container_h1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h2_pos == false && container_h1 == "pawn") {
                            h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                            h1.setVisibility(View.INVISIBLE);
                            String temp = " H1 ---> H2    "+name+" ";
                            DB.insertDataMove(temp);
                            wins.add(temp);
                            adapter.notifyDataSetChanged();
                            h2_pos = true;
                            h1_pos = false;
                            container_h2 = "pawn";
                            container_h1 = "";
                            flag = 0;
                            wcdt.cancel();
                            bcdt.cancel();
                            startGameWhite();
                        } else if (h2_pos == true && h1_pos == true && container_h1 == "pawn" ) {
                            if(container_h2 == "pawn_w" || container_h2 == "castle_w") {
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h1.setVisibility(View.INVISIBLE);
                                String temp = " H1 ---> H2    "+name+"    "+container_h2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h2_pos = true;
                                h1_pos = false;
                                container_h2 = "pawn";
                                container_h1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h2_pos == true && h1_pos == true && container_h2 == "castle") {
                            if (container_h2 == "pawn_w" || container_h2 == "castle_w") {
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h1.setVisibility(View.INVISIBLE);
                                String temp = " H1 ---> H2    "+name+"    "+container_h2+"   ";
                                DB.insertDataMove(temp);
                                wins.add(temp);
                                adapter.notifyDataSetChanged();
                                h2_pos = true;
                                h1_pos = false;
                                container_h2 = "castle";
                                container_h1 = "";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
            h1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        if (h2_pos == false) {
                            if(Objects.equals(theme, "Green")){
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_green));
                                h2.setVisibility(View.VISIBLE);
                            }else{
                                h2.setBackgroundDrawable(getResources().getDrawable(R.drawable.highlight_brown));
                                h2.setVisibility(View.VISIBLE);
                            }
                        } else if (h1_pos == true ){
                            if(container_h1 == "pawn_w" || container_h1 == "castle_w") {
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.pawn_b));
                                h1_pos = true;
                                container_h1 = "pawn";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        } else if (h1_pos == true && container_h1 == "castle") {
                            if(container_h1 == "pawn_w" || container_h1 == "castle_w") {
                                h1.setBackgroundDrawable(getResources().getDrawable(R.drawable.castle_b));
                                h1_pos = true;
                                container_h1 = "castle";
                                flag = 0;
                                wcdt.cancel();
                                bcdt.cancel();
                                startGameWhite();
                            }
                        }
                    }
                }
            });
        }
    }

    private void dialogwin() {
        if (Objects.equals(theme, "Green")) {
            Boolean insert = null;
            String username = name;
            String val = ""+name+" Wins";
            String new_username = name_new;
            String outcome;
            String win_play = textViewDG.getText().toString();
            if(!val.equals(win_play)){
                outcome = ""+name+"     Loses to    "+name_new+"" ;
            }else{
                outcome = ""+name+"     Wins to    "+name_new+"";
            }
            insert = DB.insertwins(username,new_username,outcome);
            if (insert == true) {
                dialogg.show();
            }
        } else if (Objects.equals(theme, "Brown")) {
            Boolean insert = null;
            String username = name;
            String val = ""+name+" Wins";
            String new_username = name_new;
            String outcome;
            String win_play = textViewD.getText().toString();
            if(!val.equals(win_play)){
                outcome = ""+name+"     Loses to    "+name_new+"" ;
            }else{
                outcome = ""+name+"     Wins to    "+name_new+"";
            }
            insert = DB.insertwins(username,new_username,outcome);
            if (insert == true) {
                dialog.show();
            }
        }
    }

    private void greencolor() {
        activity_chess.setBackgroundResource(R.color.green_page);

//        btnundo2.setTextColor(getResources().getColor(R.color.darkgreen_text));
//        btnundo2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        btntime.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btntime.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        btnuser3.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btnuser3.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        btnuser.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btnuser.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        btntimeuser1.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btntimeuser1.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        btnback.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btnback.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        fraglayout.setBackground(getResources().getDrawable(R.drawable.frag_green));

        //listcolor.setTextColor(getResources().getColor(R.color.darkgreen_text));

        imageView.setVisibility(View.GONE);
        imageView2.setVisibility(View.VISIBLE);
    }

}