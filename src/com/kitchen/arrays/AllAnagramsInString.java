package com.kitchen.arrays;

import java.util.HashMap;
import java.util.Map;

public class AllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";

        Map<Integer,String> result = allAnagramsInString(s,t);
    }

    private static Map<Integer, String> allAnagramsInString(String s, String t) {
        Map<Integer, String> result = new HashMap<>();
        Map<Character,Integer> freq = new HashMap<>();
        // initialize frequency map for t
        for (int i=0; i<t.length(); i++){
            Integer count = freq.get(t.charAt(i));
            freq.put(t.charAt(i), count != null ? ++count : 1);
        }

        // initialize counter for the frequency map
        int counter = freq.size();

        // initialize sliding window
        int begin=0, end=0;


        //start sliding window
        while (end < s.length()) {
            char endChar = s.charAt(end);

            // if current char found in table, decrement count
            if (freq.containsKey(endChar)) {
                int count = freq.get(endChar);
                freq.put(endChar, --count);
                if (count == 0) {
                    counter--;
                }
            }

            end++;

            while (counter == 0){
                if (end - begin == t.length()){
                    result.put(begin, s.substring(begin, end));
                }
                char beginChar = s.charAt(begin);
                if (freq.containsKey(beginChar)) {
                    int count = freq.get(beginChar);
                    freq.put(beginChar, ++count);
                    if (count > 0) {
                        counter++;
                    }
                }
                begin++;
            }

        }

        return result;
    }
}
