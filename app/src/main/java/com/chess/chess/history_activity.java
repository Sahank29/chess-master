package com.chess.chess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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

public class history_activity extends AppCompatActivity {

    Button btn,btnclear;
    String theme;
    ListView list;
    ArrayList<String> listitem,listitem2,listitem3;
    ArrayAdapter<String> adapter;
    Animation scale_up,scale_down;
    FrameLayout fragment;
    TextView textView,textView2;
    ImageView image1,image2,image3,image4;
    SharedPreferences sharedPreferences;
    ConstraintLayout activity_history;
    DBHelper DB;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String MODE_THEME = "theme";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        theme = sharedPreferences.getString(MODE_THEME,null);

        btn =(Button) findViewById(R.id.buttonback);
        btnclear = findViewById(R.id.btnclear);

        DB = new DBHelper(this);

        textView = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView4);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView5);
        image4 = findViewById(R.id.imageView6);

        activity_history = findViewById(R.id.activity_history);

        list = findViewById(R.id.list);

        listitem = new ArrayList<>();
        listitem2 = new ArrayList<>();
        listitem3 = new ArrayList<>();

        fragment = findViewById(R.id.fragment);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        viewHistory();
        if(Objects.equals(theme, "Green")){
            greencolor();
            adapter = new ArrayAdapter<>(history_activity.this, R.layout.listcolor_green, listitem);
            list.setAdapter(adapter);
        }else{
            adapter = new ArrayAdapter<>(history_activity.this, R.layout.listcolor, listitem);
            list.setAdapter(adapter);
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
        btnclear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    btnclear.startAnimation(scale_up);
                    //}else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    btnclear.startAnimation(scale_down);
                }
                return false;
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.clearhistory();
                adapter.notifyDataSetChanged();
                Toast.makeText(history_activity.this, "History Cleared", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(history_activity.this,menu_activity.class);
                startActivity(in);
                finishAffinity();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history_menu = new Intent(history_activity.this,menu_activity.class);
                startActivity(history_menu);
                finishAffinity();
            }
        });
    }
    private void viewHistory(){
        Cursor cursor = DB.viewHistory();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listitem.add(cursor.getString(2));
            }
        }
    }
    private void greencolor() {
        image1.setImageResource(R.drawable.ellipse_green2);
        image2.setImageResource(R.drawable.ellipse_green1);
        image3.setImageResource(R.drawable.ellipse_green4);
        image4.setImageResource(R.drawable.ellipse_green3);

        fragment.setBackground(getResources().getDrawable(R.drawable.frag_green));

        activity_history.setBackgroundResource(R.color.green_page);

        btn.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));
        btnclear.setTextColor(getResources().getColor(R.color.darkgreen_text));
        btnclear.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_bordergreen));

        textView.setTextColor(getResources().getColor(R.color.darkgreen_text));
        textView2.setTextColor(getResources().getColor(R.color.green_text));
    }
}