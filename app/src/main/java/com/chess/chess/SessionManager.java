package com.chess.chess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences mypref;
    SharedPreferences.Editor editor;
    Context context;
    int private_mode =0;


    private static final String SHARED_PREF_NAME = "mypref";
    private static final String is_login = "IsLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    public SessionManager(Context context){
        this.context = context;
        mypref = context.getSharedPreferences(SHARED_PREF_NAME,private_mode);
        editor = mypref.edit();
    }

    public void createLoginSession(String username,String password){
        editor.putBoolean(is_login,true);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_PASSWORD,password);
        editor.commit();
    }

    public void UpdateLoginSession(String username,String password){
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_PASSWORD,password);
        editor.commit();
    }

    public boolean isloggedIn(){
        return mypref.getBoolean(is_login,false);
    }

    public void checklogin(){
        if (this.isloggedIn() == true){
            Intent in = new Intent(context,menu_activity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(in);
        }else {
            Intent in = new Intent(context,login_Activity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(in);
        }
    }
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String>user =new HashMap<String,String>();
        user.put(KEY_USERNAME,mypref.getString(KEY_USERNAME,null));
        user.put(KEY_PASSWORD,mypref.getString(KEY_PASSWORD,null));
        return user;
    }

    public void logoutUser(){
        editor.remove(KEY_PASSWORD);
        editor.remove(KEY_USERNAME);
        editor.putBoolean(is_login,false);
        editor.commit();

        Intent i = new Intent(context,login_Activity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
