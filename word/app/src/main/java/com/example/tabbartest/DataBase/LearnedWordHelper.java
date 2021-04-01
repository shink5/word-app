package com.example.tabbartest.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tabbartest.model.Learnedword;

import java.util.ArrayList;
import java.util.List;

public class LearnedWordHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "learnedwords_db";

    public LearnedWordHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Learnedword.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Learnedword.TABLE_NAME);

//        Create table again
        onCreate(db);
    }

    public long insertWord(String word, String meaning) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        id and timestamp will be inserted automatically.

        values.put(Learnedword.COLUME_WORD, word);
        values.put(Learnedword.COLUME_MEANING, meaning);

        long id = db.insert(Learnedword.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public Learnedword getLearnedword(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Learnedword.TABLE_NAME,
                new String[]{Learnedword.COLUME_ID, Learnedword.COLUME_WORD, Learnedword.COLUME_MEANING, Learnedword.COLUME_LEARNED_TIMES, Learnedword.COLUME_TIMESTAMP},
                Learnedword.COLUME_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

        if(cursor.getCount() == 0){
            return null;
        }

        else {
            cursor.moveToFirst();
//            Log.d("Mainactivity2","TAG:" + String.valueOf(cursor.getCount()));
//            Log.d("Mainactivity","TAG:" + String.valueOf(cursor.getInt(cursor.getColumnIndex(Learnedword.COLUME_ID))));


            Learnedword learnedword = new Learnedword(
                    cursor.getInt(cursor.getColumnIndex(Learnedword.COLUME_ID)),
                    cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_WORD)),
                    cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_MEANING)),
                    cursor.getInt(cursor.getColumnIndex(Learnedword.COLUME_LEARNED_TIMES)),
                    cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_TIMESTAMP))
            );

            cursor.close();
            return learnedword;
        }
    }
    public List<Learnedword> getAllLearnedwords() {
        List<Learnedword> learnedwords = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Learnedword.TABLE_NAME + " ORDER BY "+
                Learnedword.COLUME_TIMESTAMP + " DESC ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Learnedword learnedword = new Learnedword();
                learnedword.setId(cursor.getInt(cursor.getColumnIndex(Learnedword.COLUME_ID)));
                learnedword.setWord(cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_WORD)));
                learnedword.setMeaning(cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_MEANING)));
                learnedword.setLearned_times(cursor.getInt(cursor.getColumnIndex(Learnedword.COLUME_LEARNED_TIMES)));
                learnedword.setTimestamp(cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_TIMESTAMP)));

                learnedwords.add(learnedword);
            } while (cursor.moveToNext());

            db.close();


        }
        return learnedwords;
    }

    public int getLearnedwordsCount() {
        String countQuery = "SELECT * FROM " + Learnedword.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public  int updateLearnedword(Learnedword learnedword) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Learnedword.COLUME_LEARNED_TIMES, learnedword.getWord());
        values.put(Learnedword.COLUME_TIMESTAMP, learnedword.getMeaning());

        return db.update(Learnedword.TABLE_NAME, values, Learnedword.COLUME_ID + " = ?",
                new String[]{String.valueOf(learnedword.getId())});
    }

    public void deleteLearnedword(Learnedword learnedword) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Learnedword.TABLE_NAME, Learnedword.COLUME_ID + " = ?",
                new String[]{String.valueOf(learnedword.getId())});
        db.close();
    }
}
