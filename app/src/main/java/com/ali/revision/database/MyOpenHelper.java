package com.ali.revision.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String USER_COL_ID = "id";
    private static final String USER_COL_NOM = "nom";
    private static final String USER_COL_EMAIL = "email";
    private static final String USER_COL_PASSWORD = "password";
    private static final String USER_TABLE_NAME = "users";
    private static final String USER_TABLE_CREATION =
            "CREATE TABLE "+USER_TABLE_NAME+"( "
            +USER_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +USER_COL_NOM+" TEXT NOT NULL, "
            +USER_COL_EMAIL+" TEXT NOT NULL, "
            +USER_COL_PASSWORD+" TEXT NOT NULL);";

    private static final String ROLE_COL_ID = "id";
    private static final String ROLE_COL_NOM = "nom";
    private static final String ROLE_COL_USER_ID = "user_id";
    private static final String ROLE_TABLE_NAME = "roles";
    private static final String ROLE_TABLE_CREATION =
            "CREATE TABLE "+ROLE_TABLE_NAME+"( "
                    +ROLE_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +ROLE_COL_NOM+" TEXT NOT NULL, "
                    +ROLE_COL_USER_ID+" INTEGER NOT NULL);";

    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATION);
        db.execSQL(ROLE_TABLE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+USER_TABLE_NAME+";");
        db.execSQL(USER_TABLE_CREATION);
        db.execSQL("DROP TABLE "+ROLE_TABLE_NAME+";");
        db.execSQL(ROLE_TABLE_CREATION);
    }
}
