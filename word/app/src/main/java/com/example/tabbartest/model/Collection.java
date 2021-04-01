package com.example.tabbartest.model;

public class Collection {
    public  static  final String TABLE_NAME = "collections";

    public static final String COLUME_ID = "id";
    public static final String COLUME_WORD = "word";
    public static final String COLUME_MEANING = "meaning";

    private int id;
    private String word;
    private String meaning;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME +"("
                    + COLUME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUME_WORD + " TEXT,"
                    + COLUME_MEANING + " TEXT "
                    + ")";

    public Collection() {
    }

    public Collection(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setId(int id) {
        this.id = id;
    }
}
