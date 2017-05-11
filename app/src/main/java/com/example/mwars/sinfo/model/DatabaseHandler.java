package com.example.mwars.sinfo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mwars on 10.05.2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SUBJECT_MANAGER";

    private static final String SUBJECT_TABLE = "SUBJECT_TABLE";
    private static final String TASK_TABLE = "TASK_TABLE";


    private static final String KEY_ID = "ID";
    private static final String KEY_SEM = "SENESTER";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_DETAILS = "DETAILS";
    private static final String KEY_DESC = "DESC";

    private static final String KEY_ID_SUB = "ID_SUB";
    private static final String KEY_ID_TASK_GROUP = "ID_TASK_GROUP";

    private static final String KEY_IS_FAV = "IS_FAVORITE";
    private static final String KEY_IS_DONE = "IS_DONE";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SUBJECT_TABLE = "CREATE TABLE " + SUBJECT_TABLE + "(" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_SEM + " INTEGER, " +
                KEY_NAME + " TEXT, " +
                KEY_DETAILS + " TEXT, " +
                KEY_IS_FAV + " BOOLEAN " + ")";
        String CREATE_TASK_TABLE = "CREATE TABLE " + TASK_TABLE + "(" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_ID_SUB + " INTEGER FOREGIN KEY, " +
                KEY_ID_TASK_GROUP + " INTEGER FOREGIN KEY, " +
                KEY_NAME + " TEXT, " +
                KEY_DESC + " TEXT, " +
                KEY_IS_FAV + " BOOLEAN, " +
                KEY_IS_DONE + " BOOLEAN " + ")";

        db.execSQL(CREATE_SUBJECT_TABLE);
        db.execSQL(CREATE_TASK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + SUBJECT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TASK_TABLE);
    }

    public int addSubject(Subject subject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues conVal = new ContentValues();

        conVal.put(KEY_ID, subject.get_id());
        conVal.put(KEY_SEM, subject.get_sem());
        conVal.put(KEY_NAME, subject.get_name());
        conVal.put(KEY_DETAILS, subject.get_details());
        conVal.put(KEY_IS_FAV, subject.isFavorite());

        long lastID = db.insert(SUBJECT_TABLE, null, conVal);
        db.close();

        return Integer.parseInt(String.valueOf(lastID));
    }




}
