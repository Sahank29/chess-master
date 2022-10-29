package com.chess.chess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class menu_activity extends AppCompatActivity {

    Button btn2,btn4,btn5,btn6,btn7;
    ImageView image1,image2,image3,image4,image5;
    Animation scale_up,scale_down;
    SharedPreferences sharedPreferences;
    ConstraintLayout activity_menu;
    TextView textView1,textView2,textView3,textView9,textView10;
    EditText editText;
    SessionManager sessionManager;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_SECUSER = "sec_user";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String theme = sharedPreferences.getString(MODE_THEME,null);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        activity_menu = findViewById(R.id.activity_menu);

        editText = findViewById(R.id.button3);

        btn2 =findViewById(R.id.btnback);
        btn4 =findViewById(R.id.button4);
        btn5 =findViewById(R.id.button5);
        btn6 =findViewById(R.id.button6);
        btn7 =findViewById(R.id.button7);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView5);
        image4 = findViewById(R.id.imageView6);

        textView1 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView7);
        textView3 = findViewById(R.id.textView4);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        if(Objects.equals(theme, "Green")){
            greencolor();
        }

        sessionManager = new SessionManager(getApplicationContext());

        textView10.setText(sharedPreferences.getString(KEY_USERNAME,null));

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();
                if(val.equals("")) {
                    Toast.makeText(getApplicationContext(), "Should not be Empty", Toast.LENGTH_SHORT).show();
                }else {
                    Intent menu_chess = new Intent(menu_activity.this, chess_activity.class);
                    startActivity(menu_chess);
                    editor.putString(KEY_SECUSER,val);
                    editor.commit();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu_profile = new Intent(menu_activity.this,profile_activity.class);
                startActivity(menu_profile);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu_history = new Intent(menu_activity.this,history_activity.class);
                startActivity(menu_history);
                finishAffinity();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu_setting = new Intent(menu_activity.this,settings_activity.class);
                startActivity(menu_setting);
                finishAffinity();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutUser();
                Intent menu_login = new Intent(menu_activity.this,login_Activity.class);
                startActivity(menu_login);
                finishAffinity();
            }
        });

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

        btn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn5.startAnimation(scale_up);
                //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn5.startAnimation(scale_down);
                }
                return false;
            }
        });

        btn6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn6.startAnimation(scale_up);
                //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn6.startAnimation(scale_down);
                }
                return false;
            }
        });

        btn7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn7.startAnimation(scale_up);
                //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn7.startAnimation(scale_down);
                }
                return false;
            }
        });
    }

    private void greencolor() {

        image1.setImageResource(R.drawable.ellipse_green2);
        image2.setImageResource(R.drawable.ellipse_green1);
        image3.setImageResource(R.drawable.ellipse_green4);
        image4.setImageResource(R.drawable.ellipse_green3);

        btn2.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btn4.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btn5.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn5.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btn6.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn6.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btn7.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn7.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        activity_menu.setBackgroundResource(R.color.green_page);

        textView1.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView2.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView3.setTextColor(getResources().getColor(R.color.green_text));
        textView9.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView10.setTextColor(getResources().getColor(R.color.darkgreen_text));

        editText.setTextColor(getResources().getColor(R.color.darkgreen_text));
        editText.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
        editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));
    }
}