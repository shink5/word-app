package com.example.tabbartest.model;

public class Learnedword {
    public  static  final String TABLE_NAME = "learnedwords";

    public static final String COLUME_ID = "id";
    public static final String COLUME_WORD = "word";
    public static final String COLUME_LEARNED_TIMES = "learned_times";
    public static final String COLUME_MEANING = "meaning";
    public static final String COLUME_TIMESTAMP = "timestamp";

    private int id;
    private String word;
    private int learned_times;
    private String meaning;
    private String timestamp;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME +"("
                + COLUME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUME_WORD + " TEXT,"
                + COLUME_MEANING + " TEXT,"
                + COLUME_LEARNED_TIMES + " INTEGER DEFAULT 1,"
                + COLUME_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                + ")";

    public Learnedword() {
    }

    public Learnedword(int id, String word, String meaning, int learned_times, String timestamp) {
        this.id = id;
        this.word = word;
        this.learned_times = learned_times;
        this.meaning = meaning;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public int getLearned_times() {
        return learned_times;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setLearned_times(int learned_times) {
        this.learned_times = learned_times;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
