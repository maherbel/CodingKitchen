package com.kitchen.datastructures;

import java.util.HashMap;

public class Trie {
    public TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        HashMap<Character, TrieNode> children;
        for (int i=0; i < word.length(); i++){
            char currC = word.charAt(i);
            children = current.children;
            if (children == null){
                children = new HashMap<>();
            }
            TrieNode trieNode = children.get(currC);
            if (trieNode == null){
                trieNode = new TrieNode(currC);
                children.put(currC, trieNode);
            }
            current = trieNode;
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        HashMap<Character, TrieNode> children;
        for(int i=0; i < word.length(); i++){
            char currC = word.charAt(i);
            children = current.children;
            TrieNode currTrieNode = children.get(currC);
            if (currTrieNode == null){
                return false;
            } else {
                current = currTrieNode;
            }
        }
        return true;
    }
}
