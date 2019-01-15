package com.exams;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPathToDestination {

    public static void main(String[] args) {
        int[][] area = {{1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0},
                        {1, 0, 1, 1, 9, 1, 0},
                        {1, 0, 1, 1, 1, 0, 0},
                        {1, 1, 1, 0, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0}};

        int minPathStepsBfs = minPathDeliveries(area.length, area[0].length, area);
        System.out.println("Min Path : "+minPathStepsBfs);
    }

    static class Point{
        int x;
        int y;
        int stepsDone;
        public Point(int x, int y, int stepsDone){
            this.x = x;
            this.y = y;
            this.stepsDone = stepsDone;
        }
    }

    private static int minPathDeliveries(int rows, int columns, int[][] area) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visitedCells = new boolean[rows][columns];
        queue.add(new Point(0,0, 0));
        Point tmpPoint;
        int currentRow, currentColumn;
        int stepsDone = 0;
        int minSteps = Integer.MAX_VALUE;
        QueueLoop : while(!queue.isEmpty()){
            tmpPoint = ((LinkedList<Point>) queue).pop();
            currentRow = tmpPoint.x;
            currentColumn = tmpPoint.y;
            stepsDone = tmpPoint.stepsDone;
            if (currentRow < 0 || currentColumn < 0 || currentRow >= rows || currentColumn >= columns || visitedCells[currentRow][currentColumn]){
                continue;
            }
            visitedCells[currentRow][currentColumn] = true;
            if (area[currentRow][currentColumn] == 0){
                continue;
            } else if (area[currentRow][currentColumn] == 9){
                visitedCells[currentRow][currentColumn] = false;
                if (minSteps > stepsDone){
                    minSteps = stepsDone;
                    continue;
                }
            } else {
                stepsDone++;
                queue.add(new Point(currentRow+1, currentColumn, stepsDone));
                queue.add(new Point(currentRow, currentColumn+1, stepsDone));
                queue.add(new Point(currentRow-1, currentColumn, stepsDone));
                queue.add(new Point(currentRow, currentColumn-1, stepsDone));
            }

        }
        return minSteps;
    }





















    private static int minPath(int rows, int columns, int[][] area) {
        boolean[][] visited = new boolean[rows][columns];
        int[] result = new int[1];
        result[0] = -1;
        visited[0][0] = true;
        backtracking(result, visited, 0, 0, area, 0);
        return result[0];
    }

    private static void backtracking(int[] result, boolean[][] visited, int currentRow, int currentColumn, int[][] area, int steps) {

        for (int i=0; i < area.length; i++){
            for (int j=0; j < area[0].length; j++){
                if (!cellCanBeVisited(i, j, area) || visited[i][j] || !isNeighbour(i, j, currentRow, currentColumn)){
                    continue;
                } else if (area[i][j] == 0){
                    return;
                } else if (area[i][j] == 9 && (result[0] == -1 || result[0] > steps+1)){
                    System.out.println("\nArrive at 9 ! ["+i+","+j+"], Steps : "+(steps+1)+"\n");
                    result[0] = steps+1;
                    //System.out.println("\nNew min is "+steps+"\n");
                    return;
                }
                visited[i][j] = true;
                System.out.println("Visiting ["+i+","+j+"] and current Steps are "+steps);
                backtracking(result, visited, i+1, j, area, steps +1);
                backtracking(result, visited, i, j+1, area, steps +1);
                backtracking(result, visited, i-1, j, area, steps +1);
                backtracking(result, visited, i, j-1, area, steps +1);
                visited[i][j] = false;
            }
        }

    }

    private static boolean isNeighbour(int i, int j, int currentRow, int currentColumn) {
        if (i == currentRow+1 && j == currentColumn){
            System.out.println("["+i+","+j+"]is neighbour of "+"["+currentRow+","+currentColumn+"]");
            return true;
        }
        if (i == currentRow && j == currentColumn+1){
            System.out.println("["+i+","+j+"]is neighbour of "+"["+currentRow+","+currentColumn+"]");
            return true;
        }
        if (i == currentRow-1 && j == currentColumn){
            System.out.println("["+i+","+j+"]is neighbour of "+"["+currentRow+","+currentColumn+"]");
            return true;
        }
        if (i == currentRow && j == currentColumn-1){
            System.out.println("["+i+","+j+"]is neighbour of "+"["+currentRow+","+currentColumn+"]");
            return true;
        }
        System.out.println("["+i+","+j+"]is not neighbour of "+"["+currentRow+","+currentColumn+"]");
        return false;
    }

    private static boolean cellCanBeVisited(int currentRow, int currentColumn, int[][] area) {
        if (currentRow < 0 || currentRow >= area.length){
            return false;
        } else if (currentColumn < 0 || currentColumn >= area[0].length){
            return false;
        }
        return true;
    }
}
