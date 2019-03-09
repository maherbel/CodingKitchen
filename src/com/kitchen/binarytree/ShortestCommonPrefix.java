package com.kitchen.binarytree;

import com.Utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of strings (words)
 * find the shortest common prefix of all these words
 */

public class ShortestCommonPrefix {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();
        input.add("zebra");
        input.add("dog");
        input.add("duck");
        input.add("dove");

        ArrayList<String> result = prefix(input);
        PrintUtil<String> printUtil = new PrintUtil<>();
        printUtil.print(result);
    }

    public static ArrayList<String> prefix(ArrayList<String> A) {
        if (A == null || A.isEmpty()) return null;
        Trie trie = new Trie(new TrieNode());
        for (String word : A){
            trie.insertWord(word);
        }

        ArrayList<String> result = new ArrayList<String>();
        for (String word : A){
            result.add(traverse(trie, word));
        }
        //traverseTrie(trie.root, result, "");
        return result;
    }

    public  static  String traverse(Trie trie, String word){
        int i=0;
        TrieNode current = trie.root;
        HashMap<Character,TrieNode> rootChildren = current.children;
        StringBuilder prefixBuilder = new StringBuilder();
        while (i < word.length()){
            prefixBuilder.append(word.charAt(i));
            current = rootChildren.get(word.charAt(i));
            rootChildren = current.children;
            if (current.frequency == 1){
                break;
            }
            i++;
        }
        return prefixBuilder.toString();
    }

    public static void traverseTrie(TrieNode currNode, ArrayList<String> result, String currWord){
        if (currNode.children.size() <= 1){
            result.add(currWord);
        } else {
            for (Map.Entry<Character,TrieNode> entry : currNode.children.entrySet()){
                traverseTrie(entry.getValue(), result, currWord + String.valueOf(entry.getKey()));
            }
        }
    }

    public static class Trie{
        public TrieNode root;
        public Trie(TrieNode root){
            this.root = root;
        }

        public boolean insertWord(String word){
            TrieNode current = root;
            boolean isNewWord = false;
            for(int i=0; i < word.length(); i++){
                if (isNewWord || !current.children.keySet().contains(word.charAt(i))){
                    isNewWord = true;
                    current.children.put(word.charAt(i), new TrieNode());
                    current = current.children.get(word.charAt(i));
                } else {
                    current = current.children.get(word.charAt(i));
                    current.frequency++;
                }
            }
            current.isLeaf = true;
            return isNewWord;
        }
    }

    public static class TrieNode{
        public HashMap<Character,TrieNode> children;
        public int frequency;
        public boolean isLeaf;
        public TrieNode(){
            children = new HashMap<Character,TrieNode>();
            isLeaf = false;
            frequency = 1;
        }
    }
}
