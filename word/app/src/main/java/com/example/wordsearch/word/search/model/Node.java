package com.example.wordsearch.word.search.model;

import java.util.HashMap;

public class Node {
    //private static final long serialVersionUID = 1L;
    private Character character;
    private HashMap<Character, Node> childMap;
    private Word word;//只有叶子才有此成员
    private boolean isLeaf;//叶子为True

    public Node() {
        setLeaf(false);
        setChildMap(new HashMap<Character, Node>());
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public HashMap<Character, Node> getChildMap() {
        return childMap;
    }

    public void setChildMap(HashMap<Character, Node> childMap) {
        this.childMap = childMap;
    }

    public void setCharacter(Character C){
        this.character=C;
    }

    public Character getCharacter(){
        return this.character;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
