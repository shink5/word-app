package com.example.wordsearch.word.search.model;

import java.util.HashSet;
import java.util.Map;

public class WordTree {
    private static final int maxStr = 100;
    private Node root;

    public WordTree() {
        root = new Node();
    }

    public void insert(Word word) {
        insert(this.root, word);
    }

    //插入单词
    private void insert(Node root, Word word) {
        if (word.isNull()) return;
        char[] chars = word.getWordspell().toLowerCase().toCharArray();
        for (int i = 0, length = chars.length; i < length; i++) {
            if (!root.getChildMap().containsKey(chars[i]))
                root.getChildMap().put(chars[i], new Node());
            if (i == length - 1) {
                root.getChildMap().get(chars[i]).setLeaf(true);
                root.getChildMap().get(chars[i]).setWord(word);
            }
            root = root.getChildMap().get(chars[i]);
        }
    }

    //（配合getWordsForTrie，遍历满足条件的单词并全部输出）
    private HashSet<Word> preTraversal(Node root, String preStr) {
        HashSet<Word> set = new HashSet<>();
        if (root != null) {
            if (root.isLeaf()) {
                set.add(root.getWord());
            }
            for (Map.Entry<Character, Node> chr : root.getChildMap().entrySet()) {
                String tempStr = preStr + chr.getKey();
                if (set.size() > maxStr) return set;
                set.addAll(preTraversal(chr.getValue(), tempStr));
            }
        }
        return set;
    }

    public HashSet<Word> searchWordsbyPreString(String word) {
        return getWordsForTrie(this.root, word);
    }

    //根据前缀搜索到满足条件的单词
    private HashSet<Word> getWordsForTrie(Node root, String word) {
        char[] chars = word.toLowerCase().toCharArray();
        for (int i = 0, length = chars.length; i < length; i++) {
            if (!root.getChildMap().containsKey(chars[i])) {
                break;
            }
            root = root.getChildMap().get(chars[i]);
        }
        return preTraversal(root, word);
    }
}
