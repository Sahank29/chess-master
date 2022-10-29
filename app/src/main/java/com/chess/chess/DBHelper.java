package com.chess.chess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final  String DBNAME = "chess.db";
    public static final  String history = "winning";
    public static final  String chessmove = "chessmove";

    public DBHelper(Context context) {

        super(context, "chess.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(email TEXT,username TEXT PRIMARY KEY,password TEXT )");
        String table = "CREATE TABLE "+history+"(username TEXT,new_username TEXT ,outcome TEXT)";
        myDB.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {

        myDB.execSQL("drop Table if exists users");
        myDB.execSQL("drop Table if exists history");
        onCreate(myDB);
    }

    public Boolean insertData(String email,String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = myDB.insert("users",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return  true;
        }
    }

    public Boolean insertwins(String username,String new_username,String outcome){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("new_username",new_username);
        contentValues.put("outcome",outcome);
        long result = myDB.insert("winning",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return  true;
        }
    }

    public Cursor viewHistory(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String query = "Select * from "+history;
        Cursor cursor = myDB.rawQuery(query,null);
        return cursor;
    }

    public Boolean forgotpass(String email,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("username",username);
        contentValues.put("password",password);
        Cursor cursor = myDB.rawQuery("select * from users where email = ?",new String[]{email});
        if (cursor.getCount()>0){
            long result =myDB.update("users",contentValues,"email=?",new String[]{email});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }else {
            return false;
        }

    }

    public Boolean clearhistory(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        myDB.execSQL("delete from "+ history);
        myDB.execSQL("delete from "+ chessmove);
        Cursor cursor = myDB.rawQuery("delete from "+ history,null);
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?",new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean dbmove(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        myDB.execSQL("drop Table if exists chessmove");
        Cursor cursor = myDB.rawQuery("create Table chessmove(moves TEXT)",null);
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean insertDataMove(String moves){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("moves",moves);
        long result = myDB.insert("chessmove",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return  true;
        }
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean updateusernamepassword(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("username",username);
        contentValues.put("password",password);
        Cursor cursor = myDB.rawQuery("select * from users where username = ?",new String[]{username});
        if (cursor.getCount()>0){
            long result =myDB.update("users",contentValues,"username=?",new String[]{username});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }else {
            return false;
        }
    }
}
