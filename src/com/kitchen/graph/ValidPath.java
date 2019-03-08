package com.kitchen.graph;

import java.util.*;

public class ValidPath {

    public static void main(String[] args) {
        int X=29, Y=23, nbrCircles=5, radius=4;
        Integer[] arrayX = {5, 6, 20, 16, 26, 11};
        Integer[] arrayY = {5, 4, 0, 15, 2, 19};
        ArrayList<Integer> circlesX = new ArrayList<>(Arrays.asList(arrayX));
        ArrayList<Integer> circlesY = new ArrayList<>(Arrays.asList(arrayY));

        System.out.println(solve(X, Y, nbrCircles, radius, circlesX, circlesY));
    }

    public static String solve(int X, int Y, int nbrCircles, int radius, ArrayList<Integer> circlesX, ArrayList<Integer> circlesY) {
        if (nbrCircles == 0) return "YES";
        Queue<Point> queue = new LinkedList<Point>();
        boolean[][] visitedPoints = new boolean[X+1][Y+1];
        Point origin = new Point(0,0);
        queue.add(origin);

        Point current;
        Integer currX;
        Integer currY;

        while (!queue.isEmpty()){
            current = queue.poll();
            currX = current.x;
            currY = current.y;

            if (currX<0 || currX>X || overlapCircles(currX, currY, circlesX, circlesY, radius) ||
                    currY<0 || currY>Y || visitedPoints[currX][currY]){
                continue;
            }

            visitedPoints[currX][currY] = true;

            if (currX == X && currY == Y) return "YES";

            queue.add(new Point(currX+1, currY));
            queue.add(new Point(currX, currY+1));
            queue.add(new Point(currX+1, currY+1));
            queue.add(new Point(currX-1, currY));
            queue.add(new Point(currX, currY-1));
            queue.add(new Point(currX-1, currY-1));
            queue.add(new Point(currX-1, currY+1));
            queue.add(new Point(currX+1, currY-1));

        }
        return "NO";
    }

    private static boolean overlapCircles(Integer currX, Integer currY, ArrayList<Integer> circlesX, ArrayList<Integer> circlesY, int radius) {
        Integer circleX;
        Integer circleY;
        CircleCenter currCirclePoint;
        for (int i=0; i < circlesX.size(); i++){
            circleX = circlesX.get(i);
            circleY = circlesY.get(i);
            currCirclePoint = new CircleCenter(circleX, circleY, radius);
            if (currCirclePoint.containsPoint(new Point(currX, currY))) return true;
        }
        return false;
    }

    public static class Point{
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class CircleCenter extends Point{

        int radius;
        public CircleCenter(int x, int y, int radius) {
            super(x, y);
            this.radius = radius;
        }

        public boolean containsPoint(Point p){
            Integer currX = p.x;
            Integer currY = p.y;
            double distance = Math.sqrt(Math.pow(currX-x, 2) + Math.pow(currY-y, 2));
            return distance <= radius;
        }
    }
}
