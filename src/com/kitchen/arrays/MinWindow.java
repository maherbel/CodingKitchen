package com.kitchen.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANNC";
        String t = "ABC";

        String result = minWindow(s,t);
        System.out.println("Minimum window of "+s+" / "+t+" is "+result);
    }

    private static String minWindow(String s, String t) {
        Map<Character,Integer> freq = new HashMap<>();
        // initialize frequency map for t
        for (int i=0; i<t.length(); i++){
            Integer count = freq.get(t.charAt(i));
            freq.put(t.charAt(i), count != null ? ++count : 1);
        }

        // initialize counter for the frequency map
        int counter = freq.size();

        // initialize sliding window
        int begin=0, end=0, len=Integer.MAX_VALUE;

        String res="";

        //start sliding window
        while (end < s.length()){
            char endChar = s.charAt(end);

            // if current char found in table, decrement count
            if (freq.containsKey(endChar)){
                int count = freq.get(endChar);
                freq.put(endChar, --count);
                if (count == 0){
                    counter--;
                }
            }

            end++;

            /**
             * if counter == 0, means we found an answer, now try to trim that window by sliding begin to right.
             */
            while (counter == 0){
                // store new answer if smaller than previously best
                if (end - begin < len){
                    res = s.substring(begin, end);
                    len = res.length();
                }
                // begin char could be in table or not,
                // if not then good for us, it was a wasteful char and we shortened the previously found substring.

                // if found in table increment count in table, as we are leaving it out of window and moving ahead,
                // so it would no longer be a part of the substring marked by begin-end window
                // table only has count of chars required to make the present substring a valid candidate
                // if the count goes above zero means that the current window is missing one char to be an answer candidate
                char startChar = s.charAt(begin);
                if (freq.containsKey(startChar)){
                    int count = freq.get(startChar);
                    freq.put(startChar, ++count);
                    if (count > 0){
                        counter++;
                    }
                }
                begin++;
            }
        }

        return res;
    }

}
