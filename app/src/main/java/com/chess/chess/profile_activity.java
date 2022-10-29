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

public class profile_activity extends AppCompatActivity {

    TextView textView,textView3,textView4;
    ImageView image5,image1,image2,image3,image4;
    EditText editText,editText2,editText3;
    Button btn;
    Animation scale_up,scale_down;
    String theme;
    ConstraintLayout activity_profile;
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
        setContentView(R.layout.activity_profile);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        theme = sharedPreferences.getString(MODE_THEME,null);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.pass3);
        editText3 = findViewById(R.id.passcon);

        editText.setText(sharedPreferences.getString(KEY_USERNAME,null));

        btn =findViewById(R.id.btnback);

        image5 = findViewById(R.id.imageView4);
        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView5);
        image4 = findViewById(R.id.imageView6);

        DB = new DBHelper(this);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        activity_profile = findViewById(R.id.activity_profile);

        if(Objects.equals(theme, "Green")){
            greencolor();
        }

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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editText.getText().toString();
                String password = editText3.getText().toString();
                String passcon = editText2.getText().toString();

                String val = sharedPreferences.getString(KEY_PASSWORD,null);

                if (!passcon.equals(val)) {
                    Toast.makeText(profile_activity.this, "Old password is incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserdata = DB.updateusernamepassword(user,password);
                    if (checkuserdata == true){
                        sessionManager = new SessionManager(getApplicationContext());
                        sessionManager.UpdateLoginSession(user,password);
                        Toast.makeText(profile_activity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                        Intent profile_menu = new Intent(profile_activity.this,menu_activity.class);
                        startActivity(profile_menu);
                        finishAffinity();
                    }else{
                        Toast.makeText(profile_activity.this, "Not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void greencolor() {
        textView.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView3.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView4.setTextColor(getResources().getColor(R.color.green_text));

        image1.setImageResource(R.drawable.ellipse_green2);
        image2.setImageResource(R.drawable.ellipse_green1);
        image3.setImageResource(R.drawable.ellipse_green4);
        image4.setImageResource(R.drawable.ellipse_green3);
        image5.setImageResource(R.drawable.usergreen);

        editText.setTextColor(getResources().getColor(R.color.darkgreen_text));
        editText.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
        editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));
        editText2.setTextColor(getResources().getColor(R.color.darkgreen_text));
        editText2.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
        editText2.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));
        editText3.setTextColor(getResources().getColor(R.color.darkgreen_text));
        editText3.setHintTextColor(getResources().getColor(R.color.darkgreen_text));
        editText3.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_edittextgreen));

        activity_profile.setBackgroundResource(R.color.green_page);

        btn.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

    }
}