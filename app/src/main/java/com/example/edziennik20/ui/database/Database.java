package com.example.edziennik20.ui.database;

import android.content.Context;
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
    public static final int COLUMN_OCENA = 1;

    //Sprawdziany
    public static final String TABLE_NAME_TEST= "Sprawdziany";
    public static final String COLUMN_ID_TEST = "_id_sprawdzianu";
    public static final String COLUMN_DATA = "Data";





    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
