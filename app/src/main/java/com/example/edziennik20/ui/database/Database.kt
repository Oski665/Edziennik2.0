package com.example.edziennik20.ui.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import com.example.edziennik20.ui.database.Database

class Database(context: Context?) : SQLiteOpenHelper(context, "E-dziennik", null, 1) {
    private val context: Context? = null
    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE " + TABLE_NAME_UCZNIOWIE +
                "(" + COLUMN_ID_UCZNIOWIE + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_LAST_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_ISLOGGED + " INTEGER, " +
                COLUMN_PASSWORD + " TEXT);"
        val query2 = "CREATE TABLE " + TABLE_NAME_UWAGI +
                "(" + COLUMN_ID_UWAGI + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ID_UCZNIA + " INTEGER, " +
                COLUMN_TRESC + " TEXT);"
        val query3 = "CREATE TABLE " + TABLE_NAME_OCENY +
                "(" + COLUMN_ID_OCENY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_OCENA + " INTEGER);"
        val query4 = "CREATE TABLE " + TABLE_NAME_TEST +
                "(" + COLUMN_ID_TEST + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATA + " TEXT);"
        val query6 = "INSERT INTO " + TABLE_NAME_UCZNIOWIE + " VALUES(1,'Piotr','Piotrowski','username', 0, 'password')"

        val query7 = "INSERT INTO " + TABLE_NAME_UWAGI + " VALUES(1,1,'Piotr snie słucha nauczycielki')"

        val query8 = "INSERT INTO " + TABLE_NAME_UWAGI + " VALUES(2,1,'Pobił kolegę')"

        val query9 = "INSERT INTO " + TABLE_NAME_TEST + " VALUES(2,'10.02.2022')"

        val query11 = "INSERT INTO " + TABLE_NAME_DODA + " VALUES(1,1,'Pomógł w strojeniu sali')"
        val query10 = "CREATE TABLE " + TABLE_NAME_DODA +
                " ( " + COLUMN_ID_DODA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ID_UCZNIA_Z_DODA + " INTEGER, " +
                COLUMN_TRESC_DODA + " TEXT);"
        db.execSQL(query)
        db.execSQL(query2)
        db.execSQL(query3)
        db.execSQL(query4)
        db.execSQL(query6)
        db.execSQL(query7)
        db.execSQL(query8)
        db.execSQL(query9)
        db.execSQL(query10)
        db.execSQL(query11)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UCZNIOWIE)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UWAGI)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_OCENY)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TEST)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DODA)
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
    fun getStudentData(): Cursor? {
        val db = this.writableDatabase
        val cursor = db.rawQuery(
            "Select * from "+ TABLE_NAME_UCZNIOWIE +" WHERE "+ COLUMN_ISLOGGED + " = 1",null);

        return cursor
    }
    fun getTest(): Cursor? {
        val db = this.writableDatabase
        val cursor = db.rawQuery(
            "Select * from "+ TABLE_NAME_TEST ,null);

        return cursor
    }
    fun getUwaga(): Cursor? {
        val db = this.writableDatabase
        val cursor = db.rawQuery(
            "Select "+ COLUMN_TRESC+" from "+ TABLE_NAME_UWAGI+ " , "+ TABLE_NAME_UCZNIOWIE +" WHERE "+ COLUMN_ID_UCZNIA + " = "+ COLUMN_ID_UCZNIOWIE +" AND "+ COLUMN_ISLOGGED + " = 1",null);

        return cursor
    }
    fun getDodA(): Cursor? {
        val db = this.writableDatabase
        val cursor = db.rawQuery(
            "Select "+ COLUMN_TRESC_DODA+" from "+ TABLE_NAME_DODA+ " , "+ TABLE_NAME_UCZNIOWIE +" WHERE "+ COLUMN_ID_UCZNIA_Z_DODA + " = "+ COLUMN_ID_UCZNIOWIE +" AND "+ COLUMN_ISLOGGED + " = 1",null);

        return cursor
    }
    fun checkusernamepassword(Email: String, Password: String): Boolean {
        val db = this.writableDatabase
        val cursor = db.rawQuery(
            "Select * from "+ TABLE_NAME_UCZNIOWIE +" where "+COLUMN_EMAIL+" = ? and "+COLUMN_PASSWORD +" = ?",
            arrayOf(Email, Password)
        )
        if (cursor.count > 0){
            val cursor = db.execSQL(
                "Update "+ TABLE_NAME_UCZNIOWIE +" SET "+ COLUMN_ISLOGGED +" = 1 WHERE "+ COLUMN_EMAIL +" = '"+ Email+"';",
//                arrayOf(Email)
            )
         return true
        }else{
           return false
        }
    }

    companion object {
        const val DATABASE_NAME = "E-dziennik"
        const val DATABASE_VERSION = 1

        //Encje
        //Uczniowie
        const val TABLE_NAME_UCZNIOWIE = "Uczniowie"
        const val COLUMN_ID_UCZNIOWIE = "_id_ucznia"
        const val COLUMN_NAME = "imie"
        const val COLUMN_LAST_NAME = "nazwisko"
        const val COLUMN_EMAIL = "Email"
        const val COLUMN_ISLOGGED = "Zalogowany"
        const val COLUMN_PASSWORD = "Password"

        //Uwagi
        const val TABLE_NAME_UWAGI = "Uwagi"
        const val COLUMN_ID_UCZNIA = "_id_ucznia_z_uwaga"
        const val COLUMN_ID_UWAGI = "_id_uwagi"
        const val COLUMN_TRESC = "treść"

        //Oceny
        const val TABLE_NAME_OCENY = "Oceny"
        const val COLUMN_ID_OCENY = "_id_oceny"
        const val COLUMN_OCENA = "Ocena"

        //Sprawdziany
        const val TABLE_NAME_TEST = "Sprawdziany"
        const val COLUMN_ID_TEST = "_id_sprawdzianu"
        const val COLUMN_DATA = "Data"

        //Dodatkowe aktywności
        const val TABLE_NAME_DODA = "Dodatkowe_aktywnosci"
        const val COLUMN_ID_UCZNIA_Z_DODA = "_id_ucznia_z_DodAkt"
        const val COLUMN_ID_DODA = "_id_DodAkt"
        const val COLUMN_TRESC_DODA = "tresc_dodAkt"

//        //User
//        const val TABLE_NAME_USER = "USER"
//        const val COLUMN_USERNAME = "Email"
//        const val COLUMN_PASSWORD = "Password"
    }
}