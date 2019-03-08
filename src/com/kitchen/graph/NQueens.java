package com.kitchen.graph;

import com.Utils.PrintUtil;

import java.util.ArrayList;

public class NQueens {
    public static void main(String[] args) {
        PrintUtil<String> printer = new PrintUtil<>();
        ArrayList<ArrayList<String>> result = solveNQueens(12);
        for (ArrayList<String> comb : result){
            printer.print(comb);
        }
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        boolean[][] visited = new boolean[a][a];
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int queensRemaining = a;
        computeCombinaisons(result, visited, a, queensRemaining, 0, new ArrayList<String>());
        return result;
    }

    public static void computeCombinaisons(ArrayList<ArrayList<String>> result, boolean[][] visited, int chessSize, int queensRemaining, int currentRow, ArrayList<String> currentCombinaison){
        if (queensRemaining == 0){
            ArrayList<String> completeCombinaison = new ArrayList<>();
            for(String item : currentCombinaison){
                completeCombinaison.add(item);
            }
            result.add(completeCombinaison);
            return;
        }

        for (int i=currentRow; i < chessSize; i++){
            for (int j=0; j < chessSize; j++){
                if (isPossibleComb(visited, chessSize, i, j)){
                    continue;
                }
                visited[i][j] = true;
                addNewPosition(currentCombinaison, i, j, chessSize);
                computeCombinaisons(result, visited, chessSize, queensRemaining-1, i+1, currentCombinaison);
                visited[i][j] = false;
                currentCombinaison.remove(currentCombinaison.size()-1);
            }
        }
    }

    public static boolean isPossibleComb(boolean[][] visited, int chessSize, int row, int column){
        int i=0;
        while (i < chessSize){
            if (row+i < chessSize && visited[row+i][column]) return true;
            else if (column+i < chessSize && visited[row][column+i]) return true;
            else if (row+i < chessSize && column+i < chessSize && visited[row+i][column+i]) return true;
            else if (row-i >= 0 && visited[row-i][column]) return true;
            else if (column-i >= 0 && visited[row][column-i]) return true;
            else if (row-i >= 0 && column-i >= 0 && visited[row-i][column-i]) return true;
            else if (row-i >= 0 && column+i < chessSize && visited[row-i][column+i]) return true;
            else if (row+i < chessSize && column-i >= 0 && visited[row+i][column-i]) return true;
            i++;
        }
        return false;
    }

    public static void addNewPosition(ArrayList<String> currentCombinaison, int row, int column, int chessSize){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i < chessSize){
            if (i == column){
                sb.append("Q");
            } else {
                sb.append(".");
            }
            i++;
        }
        currentCombinaison.add(sb.toString());
    }
}
