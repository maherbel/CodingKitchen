package com.futurejob.test.sort;

public class Matrix2D {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 60;
        System.out.println("Result : "+ searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int rSize = matrix.length;
        int cSize = matrix[0].length;
        return binaryMatrixSearch(matrix, cSize, 0, rSize*cSize-1, target);
    }

    public static boolean binaryMatrixSearch(int[][] matrix, int cSize, int low, int high, int target){
        int mid,rMid,cMid,midValue;
        while (low <= high){
            mid = (low + high) / 2;
            rMid = mid / cSize;
            cMid = mid % cSize;
            midValue = matrix[rMid][cMid];
            if (midValue == target){
                return true;
            } else if (midValue < target){
                low = mid+1;
            } else if (midValue > target){
                high = mid-1;
            }
        }
        return false;
    }

    public static boolean binaryIterativeMatrixSearch(int[][] matrix, int cSize, int low, int high, int target) {
        if (high < low){
            return false;
        }
        int mid, rMid, cMid, midValue;
        mid = (low + high) / 2;
        rMid = mid / cSize;
        cMid = mid % cSize;
        midValue = matrix[rMid][cMid];
        if (midValue == target) {
            return true;
        } else if (midValue < target) {
            return binaryMatrixSearch(matrix, cSize, mid+1, high, target);
        } else if (midValue > target) {
            return binaryMatrixSearch(matrix, cSize, low, mid-1, target);
        }
        return false;
    }
}
