package com.example.tabbartest.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {

    public static SQLiteDatabase openDataBase(Context context, String dataBaseName){
        MyDatabaseHelper h = new MyDatabaseHelper(context,dataBaseName);
        return h.getWritableDatabase();
    }

}
