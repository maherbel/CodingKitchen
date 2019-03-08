package com.kitchen.graph;

import java.util.ArrayList;
import java.util.Stack;

public class PrintPaths {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'}
        };

        ArrayList<String> result = printPath2(board);
        for(String str : result){
            System.out.println(str);
        }
    }

    public static ArrayList<String> printPath2(char[][] board){
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        search(0,0, board, currentPath, result);
        return result;
    }

    private static void search(int row, int column, char[][] board, StringBuilder currentPath, ArrayList<String> result) {
        if (row == board.length-1 && column == board[0].length-1){
            result.add(currentPath.toString());
            currentPath.deleteCharAt(currentPath.length()-1);
            return;
        }

        if (row < board.length && column < board[0].length){
            currentPath.append(board[row][column]);
            search(row+1,column, board, currentPath, result);
            search(row,column+1, board, currentPath, result);
            currentPath.deleteCharAt(currentPath.length()-1);
        }
    }

    public static ArrayList<String> printPath(char[][] board){
        int rows = board.length;
        int columns = board[0].length;

        boolean[][] visited = new boolean[rows][columns];
        ArrayList<String> result = new ArrayList<String>();

        Stack<Point> pointQueue = new Stack<Point>();
        Point start = new Point(0,0,"");

        pointQueue.push(start);
        Point tmpPoint = null;
        int tmpRow, tmpColumn;
        String tmpChar;

        while(!pointQueue.isEmpty()){
            tmpPoint = pointQueue.pop();
            tmpRow = tmpPoint.row;
            tmpColumn = tmpPoint.column;

            // We've arrived at the last cell at rightsome
            if (tmpRow == rows-1 && tmpColumn == columns-1){
                result.add(tmpPoint.path + String.valueOf(board[tmpRow][tmpColumn]));
                continue;
            }

            if (tmpRow >= rows || tmpColumn >= columns){
                continue;
            }

            tmpChar = String.valueOf(board[tmpRow][tmpColumn]);
            visited[tmpRow][tmpColumn] = true;
            Point rightPoint = new Point(tmpRow+1, tmpColumn, tmpPoint.path + tmpChar);
            Point downPoint = new Point(tmpRow, tmpColumn+1, tmpPoint.path + tmpChar);


            pointQueue.push(rightPoint);
            pointQueue.push(downPoint);
        }

        return result;

    }

    public static class Point{
        public int row;
        public int column;
        public String path;

        public Point(int row, int column, String path){
            this.row = row;
            this.column = column;
            this.path = path;
        }
    }
}
