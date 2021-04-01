package com.example.tabbartest.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tabbartest.model.Collection;

import java.util.ArrayList;
import java.util.List;


public class CollectionHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "collections_db";

    public CollectionHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Collection.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Collection.TABLE_NAME);

//        Create table again
        onCreate(db);
    }

    public long insertWord(String word, String meaning) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        id and timestamp will be inserted automatically.

        values.put(Collection.COLUME_WORD, word);
        values.put(Collection.COLUME_MEANING, meaning);

        long id = db.insert(Collection.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public Collection getCollection(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Collection.TABLE_NAME,
                new String[]{Collection.COLUME_ID, Collection.COLUME_WORD, Collection.COLUME_MEANING},
                Collection.COLUME_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Collection collection = new Collection(
                cursor.getInt(cursor.getColumnIndex(Collection.COLUME_ID)),
                cursor.getString(cursor.getColumnIndex(Collection.COLUME_WORD)),
                cursor.getString(cursor.getColumnIndex(Collection.COLUME_MEANING))
        );

        cursor.close();

        return collection;
    }
    public List<Collection> getAllCollections() {
        List<Collection> collections = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Collection.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Collection collection = new Collection();
                collection.setId(cursor.getInt(cursor.getColumnIndex(Collection.COLUME_ID)));
                collection.setWord(cursor.getString(cursor.getColumnIndex(Collection.COLUME_WORD)));
                collection.setMeaning(cursor.getString(cursor.getColumnIndex(Collection.COLUME_MEANING)));

                collections.add(collection);
            } while (cursor.moveToNext());

            db.close();


        }
        return collections;
    }

    public int getCollectionsCount() {
        String countQuery = "SELECT * FROM " + Collection.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public  int updateCollection(Collection collection) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Collection.COLUME_WORD, collection.getWord());
        values.put(Collection.COLUME_MEANING, collection.getMeaning());

        return db.update(Collection.TABLE_NAME, values, Collection.COLUME_ID + " = ?",
                new String[]{String.valueOf(collection.getId())});
    }

    public void deleteCollection(Collection collection) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(collection.TABLE_NAME, collection.COLUME_ID + " = ?",
                new String[]{String.valueOf(collection.getId())});
        db.close();
    }
}

