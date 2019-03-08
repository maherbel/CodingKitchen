package com.kitchen.datastructures;

import java.util.HashMap;

public class TrieNode {
    public char value;
    public HashMap<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode(char value){
        this.value = value;
    }

    public TrieNode(char value, boolean isEndOfWord){
        this.value = value;
        children = new HashMap<>();
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode() {
    }
}
