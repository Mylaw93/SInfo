package com.example.mwars.sinfo.model;

import android.content.ContentProvider;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;

/**
 * Created by mwars on 10.05.2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper implements ContentProvider.PipeDataWriter {


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void writeDataToPipe(ParcelFileDescriptor parcelFileDescriptor, Uri uri, String s, Bundle bundle, Object o) {

    }
}
