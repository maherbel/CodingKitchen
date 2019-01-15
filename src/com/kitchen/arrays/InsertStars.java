package com.kitchen.arrays;

public class InsertStars {
    public static void main(String[] args) {

    }

    public static String insertPairStar(String s) {
        if (s == null || "".equals(s)){
            return s;
        }

        char firstChar = s.charAt(0);
        return String.valueOf(firstChar) + insertPaisStarRecurs(s, firstChar, 1);

    }

    public static String insertPaisStarRecurs(String s, char lastChar, int index) {
        if (index == s.length()){
            return "";
        }
        char currChar = s.charAt(index);

        return (lastChar==currChar? "*" + String.valueOf(currChar) : String.valueOf(currChar)) + insertPaisStarRecurs(s, currChar, ++index);
    }
}
