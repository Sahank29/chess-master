package com.chess.chess;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class register_activity extends AppCompatActivity {

    Button btn;
    Animation scale_up,scale_down;
    String theme;
    SharedPreferences sharedPreferences;
    DBHelper DB;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ConstraintLayout register_activity = findViewById(R.id.activity_register);

        btn =findViewById(R.id.btnback);

        DB = new DBHelper(this);

        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image1 = findViewById(R.id.imageView);
        ImageView image3 = findViewById(R.id.imageView5);
        ImageView image4 = findViewById(R.id.imageView6);
        ImageView image5 = findViewById(R.id.imageView4);

        EditText editText = findViewById(R.id.editTextTextPersonName);
        EditText editText2 = findViewById(R.id.editTextTextPersonName2);
        EditText editText3 = findViewById(R.id.pass);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        theme = sharedPreferences.getString(MODE_THEME,null);

        if(Objects.equals(theme, "Green")) {
            //Toast.makeText(register_activity.this, "green", Toast.LENGTH_SHORT).show();

            image1.setImageResource(R.drawable.ellipse_green2);
            image2.setImageResource(R.drawable.ellipse_green1);
            image3.setImageResource(R.drawable.ellipse_green4);
            image4.setImageResource(R.drawable.ellipse_green3);
            image5.setImageResource(R.drawable.usergreen);

            textView.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView2.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView3.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView6.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView5.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView4.setTextColor(getResources().getColor(R.color.green_text));

            editText.setTextColor(getResources().getColor(R.color.darkgreen_text));
            editText.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
            editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

            editText2.setTextColor(getResources().getColor(R.color.darkgreen_text));
            editText2.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
            editText2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

            editText3.setTextColor(getResources().getColor(R.color.darkgreen_text));
            editText3.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
            editText3.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

            register_activity.setBackgroundResource(R.color.green_page);

            btn.setTextColor(getResources().getColor(R.color.darkgreen_text));
            btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        }

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(register_activity.this,login_Activity.class);
                startActivity(in);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText.getText().toString();
                String user = editText2.getText().toString();
                String pass = editText3.getText().toString();

                if(user.equals("")||pass.equals("")||email.equals("")){
                    Toast.makeText(com.chess.chess.register_activity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuser = DB.checkusername(user);
                    Boolean insert = null;
                    if (checkuser == false) {
                        insert = DB.insertData(email, user, pass);
                        if (insert == true) {
                            Toast.makeText(com.chess.chess.register_activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent register_login = new Intent(register_activity.this, login_Activity.class);
                            startActivity(register_login);
                            finishAffinity();
                        } else {
                            Toast.makeText(com.chess.chess.register_activity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(com.chess.chess.register_activity.this,"User Already Exists!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btn.startAnimation(scale_up);
                    //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btn.startAnimation(scale_down);
                }
                return false;
            }
        });
    }
}