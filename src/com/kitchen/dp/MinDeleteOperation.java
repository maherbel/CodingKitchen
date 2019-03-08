package com.kitchen.dp;

import java.util.HashMap;
import java.util.Map;

public class MinDeleteOperation {

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        else if (word1 == null || word1.length() == 0) return word2.length();
        else if (word2 == null || word2.length() == 0) return word1.length();
        else if (word1.equals(word2)){
            return 0;
        }

        Map<String,Map<String,Integer>> memo = new HashMap<>();
        return minDelOperations(word1, word2, memo);
    }

    public static int minDelOperations(String word1, String word2, Map<String, Map<String, Integer>> memo){
        if (word1.equals(word2)) return 0;
        else if (word1.length() == 0) return word2.length();
        else if (word2.length() == 0) return word1.length();

        int min = Integer.MAX_VALUE;
        StringBuilder subWord1 = new StringBuilder(word1);
        StringBuilder subWord2 = new StringBuilder(word2);

        // For every iteration of i and j we will remove an element from word1 and word2
        for (int i=0; i < word1.length(); i++){
            for (int j=0; j < word2.length(); j++){
                subWord1.deleteCharAt(i);
                int min1 = minDelOperations(subWord1.toString(), subWord2.toString(), memo);

                subWord2.deleteCharAt(j);
                int min2 = minDelOperations(subWord1.toString(), subWord2.toString(), memo);

                min = Math.min(min,1 + Math.min(min1,min2));
            }
        }

        return min;
    }

}
