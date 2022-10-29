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

public class reset_activity extends AppCompatActivity {

    Button btn;
    TextView textView1,textView2,textView3,textView4,textView5;
    EditText editText,editText2,editText3,editText4;
    Animation scale_up,scale_down;
    String theme;
    SharedPreferences sharedPreferences;
    DBHelper DB;
    SessionManager sessionManager;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        btn =findViewById(R.id.btnback);

        DB = new DBHelper(this);

        textView2 = findViewById(R.id.textView3);
        textView3 = findViewById(R.id.textView);
        textView5 = findViewById(R.id.textView4);

        ImageView image1 = findViewById(R.id.imageView);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView5);
        ImageView image4 = findViewById(R.id.imageView6);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.pass);
        editText3 = findViewById(R.id.pass2);

        ConstraintLayout reset_activity = findViewById(R.id.activity_reset);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        theme = sharedPreferences.getString(MODE_THEME,null);

        if(Objects.equals(theme, "Green")) {
            image1.setImageResource(R.drawable.ellipse_green2);
            image2.setImageResource(R.drawable.ellipse_green1);
            image3.setImageResource(R.drawable.ellipse_green4);
            image4.setImageResource(R.drawable.ellipse_green3);

            textView2.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView3.setTextColor(getResources().getColor(R.color.darkgreen_text));
            textView5.setTextColor(getResources().getColor(R.color.green_text));

            editText.setTextColor(getResources().getColor(R.color.darkgreen_text));
            editText.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
            editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

            editText2.setTextColor(getResources().getColor(R.color.darkgreen_text));
            editText2.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
            editText2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

            editText3.setTextColor(getResources().getColor(R.color.darkgreen_text));
            editText3.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
            editText3.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

            reset_activity.setBackgroundResource(R.color.green_page);

            btn.setTextColor(getResources().getColor(R.color.darkgreen_text));
            btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        }else{

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText.getText().toString();
                String password = editText2.getText().toString();
                String passcon = editText3.getText().toString();

                if (!passcon.equals(password)) {
                    Toast.makeText(reset_activity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserdata = DB.forgotpass(email,password);
                    if (checkuserdata == true){
                        Toast.makeText(reset_activity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                        Intent forgot_login = new Intent(reset_activity.this,login_Activity.class);
                        startActivity(forgot_login);
                        finishAffinity();
                    }else{
                        Toast.makeText(reset_activity.this, "Not Updated", Toast.LENGTH_SHORT).show();
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