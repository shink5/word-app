package com.example.wordsearch.word.search.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wordsearch.DataBasePackage.DataBaseManager;

import java.util.HashSet;
import java.util.Set;

public class WordSearchManager {

    private WordTree wordTree;
    private String dataBaseName = "word.db";
    private SQLiteDatabase db;
    private Set<String> pakage = new HashSet<String>();/**搜索词汇包*/
    private Context context;

    private static final String[] Allcolumns = {"word","ph","trans"};


    public WordSearchManager addPakage(String[] EnglishWordPak){
        for (String s:EnglishWordPak
            ) {
            this.pakage.add(s);
        }
        return this;
    }

    public WordSearchManager removedPakage(String[] EnglishWordPak){
        for (String s:EnglishWordPak
            ) {
            this.pakage.remove(s);
        }
        return this;
    }

    public Set<String> showPakage(){
        return this.pakage;
    }

    public Boolean isInit(){
        if (context!=null && !pakage.isEmpty()) {return Boolean.TRUE;}
        else {return Boolean.FALSE;}
    }

    public Boolean isStart(){
        if (!this.isInit()){return Boolean.FALSE;}
        if (wordTree!=null){return Boolean.TRUE;}
        else {return Boolean.FALSE;}
    }

    public static WordSearchManager initManager(Context context, String[] EnglishWordPak){

        WordSearchManager manager = new WordSearchManager();

        manager.context = context;
        manager.addPakage(EnglishWordPak);

        return manager;
    }

    public void startManager(){
        db = DataBaseManager.openDataBase(context,dataBaseName);
        wordTree = new WordTree();

        if (pakage.size()!=1) return;/**之后要去掉的！*/
        /**
         * 早晚得改！！
         */
        for (String pak:pakage
             ) {
            buildTree(pak);
        }
    }

    private void buildTree(String pak){
        Cursor cursor = this.db.query(pak, Allcolumns,
                null, null, null, null, null);
        if (cursor.moveToFirst()) {//判断数据表里有数据
            while (cursor.moveToNext()) {//遍历数据表中的数据
                /**通过列名获取该列索引，再根据索引获取对应的数据。*/
                String wordspell = cursor.getString(cursor.getColumnIndex("word"));
                String pronunciation = cursor.getString(cursor.getColumnIndex("ph"));
                String meaning = cursor.getString(cursor.getColumnIndex("trans"));

                Word word = new Word(wordspell, pronunciation, meaning);
                this.wordTree.insert(word);
            }
            cursor.close();
        }
    }

    public HashSet<Word> searchWord(String inputStr){
        if (this.isStart()){
            HashSet<Word> words = wordTree.searchWordsbyPreString(inputStr);
            return words;
        }else return null;
    }

    public void closeManager(){
        db.close();
        db = null;
        wordTree = null;
    }
}
