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

public class login_Activity extends AppCompatActivity {

    ImageView image1,image2,image3,image4,image5;
    Button btn;
    EditText editText,editText2;
    TextView textView,textviewpass,textView3,textView1,textView2,textView5,textView7,textView4;
    Animation scale_up,scale_down;
    SharedPreferences sharedPreferences;
    ConstraintLayout activity_login;
    DBHelper DB;
    SessionManager sessionManager;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String theme = sharedPreferences.getString(MODE_THEME,null);

        btn =findViewById(R.id.btnback);

        sessionManager = new SessionManager(getApplicationContext());

        activity_login = findViewById(R.id.activity_login);

        DB = new DBHelper(this);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView5);
        image4 = findViewById(R.id.imageView6);
        image5 = findViewById(R.id.imageView4);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.pass);

        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView2);
        textView1 = findViewById(R.id.textView);
        textView = findViewById(R.id.textView6);
        textviewpass = findViewById(R.id.textView7);
        textView3 = findViewById(R.id.textView3);
        textView7 = findViewById(R.id.textView2);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        if(Objects.equals(theme, "Green")){
            greencolor();
        }else if (Objects.equals(theme, "Brown")){
            browncolor();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = editText.getText().toString();
                String password = editText2.getText().toString();

                if(user.equals("")||password.equals("")){
                    Toast.makeText(login_Activity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,password);
                    if (checkuserpass == true){

                        sessionManager.createLoginSession(user,password);

                        Toast.makeText(login_Activity.this,"Log in Successful",Toast.LENGTH_SHORT).show();
                        Intent login_menu = new Intent(login_Activity.this,menu_activity.class);
                        startActivity(login_menu);
                        finishAffinity();
                    }else {
                        Toast.makeText(login_Activity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(login_Activity.this,register_activity.class);
                startActivity(in);
            }
        });
        textviewpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inn = new Intent(login_Activity.this,reset_activity.class);
                startActivity(inn);
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

    private void browncolor() {
    }

    private void greencolor() {

        image1.setImageResource(R.drawable.ellipse_green2);
        image2.setImageResource(R.drawable.ellipse_green1);
        image3.setImageResource(R.drawable.ellipse_green4);
        image4.setImageResource(R.drawable.ellipse_green3);
        image5.setImageResource(R.drawable.usergreen);

        textviewpass.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView3.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView1.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView5.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView7.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView4.setTextColor(getResources().getColor(R.color.green_text));

        editText.setTextColor(getResources().getColor(R.color.darkgreen_text));
        editText.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
        editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));
        editText2.setTextColor(getResources().getColor(R.color.darkgreen_text));
        editText2.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
        editText2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

        btn.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        activity_login.setBackgroundResource(R.color.green_page);
    }
}