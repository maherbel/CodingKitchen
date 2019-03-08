package com.kitchen.dp;

import java.util.ArrayList;

public class MinPathSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> A1 = new ArrayList<>();
        ArrayList<Integer> A2 = new ArrayList<>();
        ArrayList<Integer> A3 = new ArrayList<>();

        A1.add(6);A1.add(4);A1.add(63);
        A2.add(14);A2.add(95);A2.add(20);
        A3.add(31);A3.add(85);A3.add(6);

        A.add(A1);
        A.add(A2);
        A.add(A3);

        System.out.println(minPathSum(A));
    }

    public static int minPathSum(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0) return 0;
        int[][] memo = new int[A.size()][A.get(0).size()];
        for (int i=0; i < A.size(); i++){
            for (int j=0; j < A.get(0).size(); j++){
                memo[i][j] = -1;
            }
        }
        return minPathSum(A, A.size()-1, A.get(0).size()-1, memo);
    }

    public static int minPathSum(ArrayList<ArrayList<Integer>> matrix, int row, int column, int[][] memo){
        if (row == 0 && column == 0){
            return matrix.get(0).get(0);
        }
        if (memo[row][column] >= 0){
            System.out.println("Result found for ("+row+","+column+") = " +memo[row][column]);
            return memo[row][column];
        }

        int result = 0;
        if (row > 0 && column > 0){
            result = Math.min(minPathSum(matrix, row-1, column, memo), minPathSum(matrix, row, column-1, memo));
        } else if (row > 0 && column == 0){
            result = minPathSum(matrix, row-1, column, memo);
        } else {
            result = minPathSum(matrix, row, column-1, memo);
        }

        memo[row][column] = matrix.get(row).get(column) + result;
        return memo[row][column];
    }
}
