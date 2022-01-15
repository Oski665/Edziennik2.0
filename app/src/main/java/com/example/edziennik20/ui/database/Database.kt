package com.example.edziennik20.ui.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "E-dziennik";
    public static final int DATABASE_VERSION = 1;
    //Encje
    //Uczniowie
    public static final String TABLE_NAME_UCZNIOWIE = "Uczniowie";
    public static final String COLUMN_ID_UCZNIOWIE = "_id_ucznia";
    public static final String COLUMN_NAME = "imie";
    public static final String COLUMN_LAST_NAME = "nazwisko";
    public static final String COLUMN_EMAIL = "email";

    //Uwagi
    public static final String TABLE_NAME_UWAGI = "Uwagi";
    public static final String COLUMN_ID_UWAGI = "_id_uwagi";
    public static final String COLUMN_TRESC = "treść";


    //Oceny
    public static final String TABLE_NAME_OCENY = "Oceny";
    public static final String COLUMN_ID_OCENY = "_id_oceny";
    public static final String  COLUMN_OCENA = "Ocena";

    //Sprawdziany
    public static final String TABLE_NAME_TEST= "Sprawdziany";
    public static final String COLUMN_ID_TEST = "_id_sprawdzianu";
    public static final String COLUMN_DATA = "Data";

    //User
    public static final String TABLE_NAME_USER= "USER";
    public static final String COLUMN_USERNAME= "Email";
    public static final String COLUMN_PASSWORD = "Password";




    public Database(Context context) {
        super(context, "E-dziennik", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME_UCZNIOWIE +
                        "(" + COLUMN_ID_UCZNIOWIE + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_LAST_NAME + " TEXT, " +
                        COLUMN_EMAIL + " TEXT);";


        String query2 =
                "CREATE TABLE " + TABLE_NAME_UWAGI +
                        "(" + COLUMN_ID_UWAGI + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TRESC + " TEXT);";
        String query3 =
                "CREATE TABLE " + TABLE_NAME_OCENY +
                        "(" + COLUMN_ID_OCENY + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_OCENA + " INTEGER);";
        String query4 =
                "CREATE TABLE " + TABLE_NAME_TEST +
                        "(" + COLUMN_ID_TEST + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_DATA+ " TEXT);";
        String query5 =
                "CREATE TABLE " + TABLE_NAME_USER +
                        "(" + COLUMN_USERNAME + "TEXT PRIMARY KEY, " +
                        COLUMN_PASSWORD+ " TEXT);";
        String query6 =
                "INSERT INTO " + TABLE_NAME_USER + " VALUES('username', 'password')";


        db.execSQL(query);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UCZNIOWIE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UWAGI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_OCENY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);

    }
//    public Boolean insertData(String username, String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues= new ContentValues();
//        contentValues.put("username", username);
//        contentValues.put("password", password);
//        long result = db.insert("USER", null, contentValues);
//        if(result==-1) return false;
//        else
//            return true;
//    }
    public Boolean checkusernamepassword(String Email, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USER where Email = ? and Password = ?", new String[] {Email,Password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
