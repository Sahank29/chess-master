package com.chess.chess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class settings_activity extends AppCompatActivity {

    Button btn2,btn3,btn4,def,green,btnback,btn10,btn20,btn30,btnclosetimer,btntimer;
    String theme;
    Animation scale_up,scale_down;
    Dialog dialog;
    Dialog dialogabt,dialogmove;
    TextView textView3,textView4;
    ImageView image1,image2,image3,image4;
    ConstraintLayout setting_page,custom_theme,timer;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";
    private static final String TIMER = "timerval";

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        theme = sharedPreferences.getString(MODE_THEME,"");

        btn2 =findViewById(R.id.btnback);
        //btn3 =findViewById(R.id.button3);
        btn4 =findViewById(R.id.button4);
        btntimer =findViewById(R.id.btntimer);

        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        TextView textView8 = findViewById(R.id.textView8);

        setting_page = findViewById(R.id.activity_settings);
        custom_theme = findViewById(R.id.custom_theme);
        timer = findViewById(R.id.timer);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView5);
        image4 = findViewById(R.id.imageView6);

        if(Objects.equals(theme, "Green")){
            greencolor();

        }else if (Objects.equals(theme, "Brown")){

            browncolor();
        }

        dialog = new Dialog(settings_activity.this);
        dialog.setContentView(R.layout.custom_theme);
        if(Objects.equals(theme, "Brown") || Objects.equals(theme, "")) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }else if(Objects.equals(theme, "Green")) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_green));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        def = dialog.findViewById(R.id.btnthemedefault);
        green = dialog.findViewById(R.id.btnthemeGreen);
        btnback = dialog.findViewById(R.id.btnclose);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);
//        Button btnabtback = dialogabt.findViewById(R.id.btnabtbck);

//        dialogabt = new Dialog(settings_activity.this);
//        dialogabt.setContentView(R.layout.custom_about);
//        dialogabt.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
//        dialogabt.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialogabt.setCancelable(true);
//        dialogabt.getWindow().getAttributes().windowAnimations = R.style.animation;

        dialogmove = new Dialog(settings_activity.this);
        dialogmove.setContentView(R.layout.timer);
        if(Objects.equals(theme, "Brown") || Objects.equals(theme, "")) {
            dialogmove.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }else if(Objects.equals(theme, "Green")) {
            dialogmove.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_green));
        }
        dialogmove.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogmove.setCancelable(false);
        dialogmove.getWindow().getAttributes().windowAnimations = R.style.animation;

        btn10 = dialogmove.findViewById(R.id.btn10);
        btn20 = dialogmove.findViewById(R.id.btn20);
        btn30 = dialogmove.findViewById(R.id.btn30);
        btnclosetimer = dialogmove.findViewById(R.id.btnclosetimer);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TIMER,"10000");
                editor.apply();
                editor.commit();
                dialogmove.dismiss();
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TIMER,"20000");
                editor.apply();
                editor.commit();
                dialogmove.dismiss();
            }
        });

        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TIMER,"30000");
                editor.apply();
                editor.commit();
                dialogmove.dismiss();
            }
        });

        btnclosetimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                dialogmove.dismiss();
            }
        });

        btntimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(theme, "Green")){
                    btn10.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    btn10.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                    btn20.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    btn20.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                    btn30.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    btn30.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                    btnclosetimer.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    btnclosetimer.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                }else{
                    btn10.setTextColor(getResources().getColor(R.color.text_color));
                    btn10.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                    btn20.setTextColor(getResources().getColor(R.color.text_color));
                    btn20.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                    btn30.setTextColor(getResources().getColor(R.color.text_color));
                    btn30.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                    btnclosetimer.setTextColor(getResources().getColor(R.color.text_color));
                    btnclosetimer.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                }
                dialogmove.show();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

//        btnabtback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogabt.dismiss();
//            }
//        });

        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(settings_activity.this,"default",Toast.LENGTH_SHORT).show();
                theme="Brown";
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(MODE_THEME,"Brown");
                editor.apply();
                editor.commit();
                browncolor();
                dialog.dismiss();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(settings_activity.this,"Green",Toast.LENGTH_SHORT).show();
                theme="Green";
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(MODE_THEME,"Green");
                editor.apply();
                editor.commit();
                greencolor();
                dialog.dismiss();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(theme, "Green")){
                    def.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    def.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                    green.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    green.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                    btnback.setTextColor(getResources().getColor(R.color.darkgreen_text));
                    btnback.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
                    dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_green));
                }else{
                    def.setTextColor(getResources().getColor(R.color.text_color));
                    def.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                    green.setTextColor(getResources().getColor(R.color.text_color));
                    green.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                    btnback.setTextColor(getResources().getColor(R.color.text_color));
                    btnback.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
                    dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
                    //custom_theme.setBackgroundColor(R.color.page_color);
                }
                dialog.show();
            }
        });

//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(theme == "Green"){
//                    dialogabt.show();
//                    btnabtback.setTextColor(getResources().getColor(R.color.darkgreen_text));
//                    btnabtback.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
//                    //textView8.setTextColor(getResources().getColor(R.color.darkgreen_text));
//                    //textView8.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
//                }else {
//                    dialogabt.show();
//                    btnabtback.setTextColor(getResources().getColor(R.color.text_color));
//                    btnabtback.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
//                    //textView8.setTextColor(getResources().getColor(R.color.green_text));
//                    //textView8.setBackground(getResources().getDrawable(R.drawable.round_border));
//                }
//            }
//        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting_menu = new Intent(settings_activity.this,menu_activity.class);
                startActivity(setting_menu);
                finish();
            }
        });

        btn10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn10.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn10.startAnimation(scale_down);
                }
                return false;
            }
        });

        btn20.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn20.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn20.startAnimation(scale_down);
                }
                return false;
            }
        });

        btn30.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn30.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn30.startAnimation(scale_down);
                }
                return false;
            }
        });

        btnclosetimer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnclosetimer.startAnimation(scale_up);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnclosetimer.startAnimation(scale_down);
                }
                return false;
            }
        });

        def.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    def.startAnimation(scale_up);
                        }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    def.startAnimation(scale_down);
                }
                return false;
            }
        });

        green.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    green.startAnimation(scale_up);
                        }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    green.startAnimation(scale_down);
                }
                return false;
            }
        });

        btnback.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnback.startAnimation(scale_up);
                        }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnback.startAnimation(scale_down);
                }
                return false;
            }
        });

//        btnabtback.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
//                    btnabtback.startAnimation(scale_up);
//                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
//                    btnabtback.startAnimation(scale_down);
//                }
//                return false;
//            }
//        });

        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn2.startAnimation(scale_up);
                    //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn2.startAnimation(scale_down);
                }
                return false;
            }
        });

        btntimer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btntimer.startAnimation(scale_up);
                    //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btntimer.startAnimation(scale_down);
                }
                return false;
            }
        });

//        btn3.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
//                    btn3.startAnimation(scale_up);
//                    //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
//                    btn3.startAnimation(scale_down);
//                }
//                return false;
//            }
//        });

        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn4.startAnimation(scale_up);
                    //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn4.startAnimation(scale_down);
                }
                return false;
            }
        });
    }

    private void greencolor() {
        textView4.setTextColor(getResources().getColor(R.color.green_text));
        textView3.setTextColor(getResources().getColor(R.color.darkgreen_text));
        image1.setImageResource(R.drawable.ellipse_green2);
        image2.setImageResource(R.drawable.ellipse_green1);
        image3.setImageResource(R.drawable.ellipse_green4);
        image4.setImageResource(R.drawable.ellipse_green3);
        setting_page.setBackgroundResource(R.color.green_page);
        btn2.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btntimer.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btntimer.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btn4.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

    }

    private void browncolor() {
        textView4.setTextColor(getResources().getColor(R.color.text_color2));
        textView3.setTextColor(getResources().getColor(R.color.text_color));
        image1.setImageResource(R.drawable.ellipse_48);
        image2.setImageResource(R.drawable.ellipse_47);
        image3.setImageResource(R.drawable.ellipse_49);
        image4.setImageResource(R.drawable.ellipse_50);
        setting_page.setBackgroundResource(R.color.page_color);
        btn2.setTextColor(getResources().getColor(R.color.text_color));
        btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
        btntimer.setTextColor(getResources().getColor(R.color.text_color));
        btntimer.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
        btn4.setTextColor(getResources().getColor(R.color.text_color));
        btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_border));
    }
}