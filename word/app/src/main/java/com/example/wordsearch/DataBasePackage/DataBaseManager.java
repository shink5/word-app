package com.example.wordsearch.DataBasePackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {

    public static SQLiteDatabase openDataBase(Context context,String dataBaseName){
        MySqliteHelper h = new MySqliteHelper(context,dataBaseName);
        return h.getWritableDatabase();
    }

}
