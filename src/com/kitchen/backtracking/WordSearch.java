package com.kitchen.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        String input  = "ABCCED";
        char[][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        exist(board, input);
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] letters = new char[word.length()];
        for (int i=0; i < word.length(); i++){
            letters[i] = word.charAt(i);
        }

        return backtrack(visited, board, letters, 0, 0, 0);
    }

    public static boolean backtrack(boolean[][] visited, char[][] board, char[] letters, int letterNumber, int lastR, int lastC){
        if (letterNumber == letters.length){
            return true;
        }

        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                if (visited[i][j] || board[i][j] != letters[letterNumber]){
                    continue;
                } else if (letterNumber > 0 && (!aroundLastVisit(i,j,lastR,lastC))){
                    continue;
                }
                visited[i][j] = true;
                if (backtrack(visited, board, letters, letterNumber+1, i, j)) return true;
                visited[i][j] = false;
            }
        }

        return false;
    }

    public static boolean aroundLastVisit(int currR, int currC, int row, int column){
        if (currR == row-1 && currC == column) return true;
        if (currR == row && currC == column-1) return true;
        if (currR == row && currC == column+1) return true;
        if (currR == row+1 && currC == column) return true;
        return false;
    }
}
