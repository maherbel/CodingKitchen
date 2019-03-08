package com.kitchen.strings;

public class KMP {

    public static void main(String[] args) {
        System.out.println(strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
    }

    public static int strStr(final String text, final String pattern) {
        if (pattern == null || pattern.length() == 0) return -1;
        else if (text == null || text.length() == 0) return -1;
        else if (text == pattern) return 0;

        int[] prefixArray = computePrefixArray(pattern);
        return computeFirstMatch(prefixArray, text, pattern);
    }

    public static int computeFirstMatch(int[] prefixArray, final String text, final String pattern){
        int i=0;
        int j=0;

        // Iterate until there is no possible number of characters to search
        while (i < text.length()){
            // if we have the same character from text/pattern
            if (text.charAt(i) == pattern.charAt(j)){
                // if we proessed all the pattern characters return the index of the first char in the text
                // else we continue
                if (j == pattern.length()-1){
                    return i-pattern.length()+1;
                } else {
                    i++;
                    j++;
                }
            } else {
                // The characters are different (i,j) from (text,pattern)
                // so we want to backtrack j to a certain p where we know that 0->p-1 is matching with the j-p last characters
                while (j>0 && text.charAt(i) != pattern.charAt(j)){
                    j = prefixArray[prefixArray[j-1]];
                }
                // once we have the final j index (can be 0 or superior to 0) we compare it to the i'th char in text
                // if there are different we stay at the first character in the pattern and go to next char in the text
                if (text.charAt(i) != pattern.charAt(j)){
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        // if the pattern was not found we just return -1
        return -1;
    }

    public static int[] computePrefixArray(final String pattern){
        int[] prefixArray = new int[pattern.length()];
        int i=1;
        int j=0;

        while(i < pattern.length()){
            if (pattern.charAt(i) == pattern.charAt(j)){
                prefixArray[i] = j+1;
                i++;
                j++;
            } else {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                    j = prefixArray[prefixArray[j-1]];
                }
                if (pattern.charAt(i) == pattern.charAt(j)){
                    prefixArray[i] = j+1;
                    i++;
                    j++;
                } else {
                    prefixArray[i] = 0;
                    i++;
                }
            }
        }
        return prefixArray;
    }
}
