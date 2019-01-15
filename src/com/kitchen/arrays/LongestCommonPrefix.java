package com.kitchen.arrays;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        ArrayList<Character> result = new ArrayList<>();

        int currentCharIndex = 0;
        whileLoop : while(true){
            for (int i=0; i < strs.length; i++){
                String currentStr = strs[i];
                if (currentStr.length() == currentCharIndex){
                    break whileLoop;
                }
                char currentChar = currentStr.charAt(currentCharIndex);
                if (result.isEmpty() || result.size() == currentCharIndex) {
                    result.add(currentChar);
                }
                else if (result.get(currentCharIndex) != currentChar){
                    break whileLoop;
                }
            }
            currentCharIndex++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < result.size(); i++){
            sb.append(result.get(i));
        }
        return sb.toString();

    }
}
