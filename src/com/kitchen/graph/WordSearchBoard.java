package com.kitchen.graph;

import java.util.ArrayList;

public class WordSearchBoard {
    public static void main(String[] args) {
        ArrayList<String> matrix = new ArrayList<>();
        matrix.add("FEDCBECD");
        matrix.add("FABBGACG");
        matrix.add("CDEDGAEC");
        matrix.add("BFFEGGBA");
        matrix.add("FCEEAFDA");
        matrix.add("AGFADEAC");
        matrix.add("ADGDCBAA");
        matrix.add("EAABDDFF");

        System.out.println(exist(matrix, "BCDCB"));
    }

    public static int exist(ArrayList<String> matrix, String word) {
        if (matrix == null || matrix.isEmpty()) return 0;
        int rows = matrix.size();
        int columns = matrix.get(0).length();
        for (int i=0; i < rows; i++){
            for (int j=0; j < columns; j++){
                if (existWord(matrix, rows, columns, i, j, word, 0)) return 1;
            }
        }
        return 0;
    }

    public static boolean existWord(ArrayList<String> matrix, int rows, int columns, int currRow, int currColumn, String word, int charIndex){
        if (currRow < 0 || currRow >= rows || currColumn < 0 || currColumn >= columns || matrix.get(currRow).charAt(currColumn) != word.charAt(charIndex)){
            return false;
        }

        if (charIndex+1 == word.length()) return true;

        boolean result = existWord(matrix, rows, columns, currRow+1, currColumn, word, charIndex+1) ||
                existWord(matrix, rows, columns, currRow-1, currColumn, word, charIndex+1) ||
                existWord(matrix, rows, columns, currRow, currColumn+1, word, charIndex+1) ||
                existWord(matrix, rows, columns, currRow, currColumn-1, word, charIndex+1);

        return result;
    }
}
