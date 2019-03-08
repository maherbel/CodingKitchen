package com.kitchen.strings;

public class RobinKarp {

    public static void main(String[] args) {
        System.out.println(robinKarpPatternSearch("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
        System.out.println(robinKarpPatternSearch("bababacd", "bacd"));
    }

    private static int robinKarpPatternSearch(String text, String pattern) {
        if (pattern == null || pattern.isEmpty() || text == null || text.isEmpty()) return -1;
        if (pattern.length() > text.length()) return -1;

        int patternHash = rkHashCode(pattern);
        String textWindow = text.substring(0, pattern.length());
        int windowHash = rkHashCode(textWindow);
        int i = textWindow.length();
        int windowLength = pattern.length();

        while (i < text.length()){
            if (windowHash == patternHash && textWindow.equals(pattern)){
                // the pattern was found so we return its starting index
                System.out.println("Pattern found at index : " + (i - textWindow.length()));
                return i - textWindow.length();
            } else {
                // slide the window
                char oldChar = textWindow.charAt(0);
                textWindow = text.substring(i-windowLength+1, i+1);
                windowHash = recompteHash(oldChar, textWindow.charAt(textWindow.length()-1), windowLength, windowHash);

            }
            i++;
        }

        if (windowHash == patternHash && textWindow.equals(pattern)){
            // the pattern was found so we return its starting index
            System.out.println("Pattern found at index : " + (i - textWindow.length()));
            return i - textWindow.length();
        }

        return -1;
    }

    private static int recompteHash(char oldChar, char newIndexChar, int windowLength, int windowHash) {
        int oldCharHash = 0;
        oldCharHash += ((oldChar-96) * (Math.pow(10,windowLength-1))) % Integer.MAX_VALUE;

        int newCharHash = 0;
        newCharHash += ((newIndexChar-96) * (Math.pow(10,0))) % Integer.MAX_VALUE;

        return newCharHash + ((windowHash - oldCharHash)*10);
    }

    private static int rkHashCode(String pattern) {
        int hash = 0;
        int length = pattern.length();
        for (int i=0; i < length; i++){
            hash += ((pattern.charAt(i)-96) * (Math.pow(10,length-i-1))) % Integer.MAX_VALUE;
        }
        return hash;
    }
}
