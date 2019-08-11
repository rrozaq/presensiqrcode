package org.tubanjogja.qrcodescanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "presensi";

    // Table Names
    private static final String TABLE_PRESENSI = "presensi";
    public static final String TABLE_ADMIN = "user";
    private static final String TABLE_MAHASISWA = "mahasiswa";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_NPM = "npm";
    public static final String KEY_USERNAME = "user";
    public static final String KEY_PASSWORD = "pass";
    private static final String KEY_NAME = "nama";
    private static final String KEY_JURUSAN = "jurusan";


    // Table Create Statements
    private static final String CREATE_TABLE_PRESENSI = "CREATE TABLE "
            + TABLE_PRESENSI + "("
            + KEY_NPM + " STRING" +
            ")";

    // Tag table create statement
    private static final String CREATE_TABLE_MAHASISWA = "CREATE TABLE "
            + TABLE_MAHASISWA + "("
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_NPM + " STRING, "
            + KEY_NAME + " TEXT,"
            + KEY_JURUSAN + "TEXT"
            + ")";

    // Table Create Statements
    public static final String CREATE_TABLE_ADMIN = "CREATE TABLE "
            + TABLE_ADMIN + "("
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + "TEXT"
            + ")";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_PRESENSI);
        db.execSQL(CREATE_TABLE_MAHASISWA);
        db.execSQL(CREATE_TABLE_ADMIN);

        db.execSQL("INSERT INTO " + TABLE_ADMIN+ " VALUES ('rozaq','123')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRESENSI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAHASISWA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);

        // create new tables
        onCreate(db);
    }



//    private static final String DATABASE_NAME = "biodatadiri.db";
//    private static final int DATABASE_VERSION = 1;
//    public DataHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        // TODO Auto-generated constructor stub
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        // TODO Auto-generated method stub
//        db.execSQL("create table mahasiswa (id INTEGER PRIMARY KEY AUTOINCREMENT, npm String, nama text, jurusan)");
//        db.execSQL("create table biodata (id INTEGER PRIMARY KEY AUTOINCREMENT, npm String)");
//    }

//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }

}