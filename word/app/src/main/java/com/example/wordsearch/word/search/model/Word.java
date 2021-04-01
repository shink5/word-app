package com.example.wordsearch.word.search.model;

public class Word {
    private int id;
    private String wordspell;
    private String pronunciation;
    private String meaning;

    public Word(){
        super();
    }

    public Word(String wordspell,String pronunciation,String meaning){
        super();
        this.wordspell = wordspell;
        this.pronunciation = pronunciation;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public String getMaining() {
        return meaning;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getWordspell() {
        return wordspell;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public void setWordspell(String wordspell) {
        this.wordspell = wordspell;
    }

    public Boolean isNull(){
        if (wordspell==null||"".equals(wordspell)){
            if (pronunciation==null||"".equals(pronunciation)){
                if (meaning==null||"".equals(meaning)){
                    return Boolean.TRUE;
                }else return Boolean.FALSE;
            }else return Boolean.FALSE;
        }else return Boolean.FALSE;
    }
}
