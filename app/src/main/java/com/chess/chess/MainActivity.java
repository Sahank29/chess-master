package com.chess.chess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    SessionManager sessionManager;
    Button buttonPlay;
    TextView textView,textView2;
    Animation scale_up,scale_down;
    SharedPreferences sharedPreferences;
    ConstraintLayout activity_main;
    ImageView image1,image2,image3,image4;
    String theme;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.isloggedIn();

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(settings_activity.class);

        activity_main = findViewById(R.id.activity_main);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);

        buttonPlay =findViewById(R.id.btnback);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        theme=sharedPreferences.getString("theme","Brown");

        if(Objects.equals(theme, "Green")){
            greencolor();
        }

        buttonPlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    buttonPlay.startAnimation(scale_up);
                //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    buttonPlay.startAnimation(scale_down);
                }
                return false;
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager = new SessionManager(getApplicationContext());
                sessionManager.checklogin();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(theme == "Brown") {
            editor.putString(MODE_THEME, "Brown");
        }else {
            editor.putString(MODE_THEME,"Green");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        theme = sharedPreferences.getString(MODE_THEME,"Brown");
        outState.putString("mysavedata",theme);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        theme = savedInstanceState.getString("mysavedata");
        editor.putString(MODE_THEME,theme);
        editor.apply();
    }

    private void greencolor() {
        image1.setImageResource(R.drawable.ellipse_green2);
        image2.setImageResource(R.drawable.ellipse_green1);

        activity_main.setBackgroundResource(R.color.green_page);

        buttonPlay.setTextColor(getResources().getColor(R.color.darkgreen_text));
        buttonPlay.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        textView.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView2.setTextColor(getResources().getColor(R.color.darkgreen_text));
    }
}