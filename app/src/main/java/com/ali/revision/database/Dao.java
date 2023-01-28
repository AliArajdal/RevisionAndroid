package com.ali.revision.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ali.revision.model.User;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static final String DB_NAME = "user_database";

    private static final String USER_COL_ID = "id";
    private static final String USER_COL_NOM = "nom";
    private static final String USER_COL_EMAIL = "email";
    private static final String USER_COL_PASSWORD = "password";
    private static final String USER_TABLE_NAME = "users";

    private static final String ROLE_COL_ID = "id";
    private static final String ROLE_COL_NOM = "nom";
    private static final String ROLE_COL_USER_ID = "user_id";
    private static final String ROLE_TABLE_NAME = "roles";
    private static final String USER_ = "id";

    private SQLiteDatabase db;
    private MyOpenHelper openHelper;

    public Dao(Context c) {
        openHelper = new MyOpenHelper(c, DB_NAME, null, 1);
    }

    public void open(){
        db = openHelper.getWritableDatabase();
    }
    public void close(){
        db.close();
    }

    public long insertUser(User user){
        ContentValues values = new ContentValues();
        values.put(USER_COL_NOM, user.getNom());
        values.put(USER_COL_EMAIL, user.getEmail());
        values.put(USER_COL_PASSWORD, user.getPassword());
        return db.insert(USER_TABLE_NAME, null, values);
    }

    public List<User> allUsers(){
        List<User> liste = new ArrayList<User>();
        Cursor c = db.query(USER_TABLE_NAME, null,
                null, null, null, null, null);
        while (c.moveToNext()){
            liste.add(new User(c));
        }
        return liste;
    }
    public boolean userExist(String email, String password){
        Cursor c = db.query(USER_TABLE_NAME, null,
                USER_COL_EMAIL+" = ? AND "+USER_COL_PASSWORD+" = ?",
                new String[] {email, password}, null, null, null);
        if(c.moveToFirst()){
            return true;
        }
        return false;
    }
}
