package com.kitchen.dp;

/**
 * Fiven two array of integers
 * return the longest common subsequence
 */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 1};
        int[] b = {3, 4, 1, 2, 1, 3};

        // Init the memoization array to store sub problems results
        int[][] memo = new int[a.length+1][b.length+1];
        for(int i=0; i < a.length; i++){
            for(int j=0; j < b.length; j++){
                memo[i][j] = -1;
            }
        }
        int lis = lis(a, b, a.length-1, b.length-1, memo);
        System.out.println(reconstructLIS(a,b,memo, lis));
    }

    private static String reconstructLIS(int[] a, int[] b, int[][] memo, int lis) {
        StringBuilder result = new StringBuilder();
        int i = memo.length-1;
        int j = memo[0].length-1;
        while (i >= 0 && j >= 0){
            if (memo[i][j] == memo[i-1][j]) {
                i--;
            } else if (memo[i][j] == memo[i][j-1]){
                j--;
            } else if (memo[i][j] == memo[i-1][j-1]+1){
                result.append(a[i]);
                i--;
                j--;
            }
        }


        return result.reverse().toString();
    }

    public static int lis(int[] a, int[] b, int i, int j, int[][] memo){
        if (i == -1 || j == -1){
            return 0;
        } else if (a[i] == b[j]){
            memo[i+1][j+1] = 1 + lis(a, b, i-1, j-1, memo);
        } else {
            memo[i+1][j+1] = Math.max(lis(a, b, i-1, j, memo), lis(a, b, i, j-1, memo));
        }
        return memo[i+1][j+1];
    }
}
