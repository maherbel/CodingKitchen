package com.kitchen.strings;

public class PatternSearchNaive {
    public static void main(String[] args) {
        String txt =  "AABAACAADAABAABA";
        String pat =  "AABA";

        naivePatternSearch(txt, pat);
    }

    private static void naivePatternSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        for (int i=0; i <= n-m; i++){
            boolean patternFound = true;
            for (int j=i; j < i+m; j++){
                if (txt.charAt(j) != pat.charAt(j-i)){
                    patternFound = false;
                    break;
                }
            }
            if (patternFound){
                System.out.println("Pattern found at index : "+i);
            }
        }
    }

}
