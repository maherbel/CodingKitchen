package com.kitchen.sort;

import java.util.ArrayList;
import java.util.List;

public class Rotation2 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(4);
        input.add(6);
        input.add(7);
        input.add(0);
        input.add(1);
        input.add(2);

        System.out.println(search(input, 1));
    }

    public static int search(final List<Integer> a, int b) {
        if (a == null || a.isEmpty()){
            return -1;
        } else if (a.get(0) <= a.get(a.size()-1)){
            return binarySearch(a, 0, a.size()-1, b);
        } else {
            int pivotIndex = searchPivotIndex(a, 0, a.size()-1);
            if (a.get(0) <= b && a.get(pivotIndex) >= b){
                return binarySearch(a, 0, pivotIndex, b);
            } else if (a.get(pivotIndex+1) <= b && a.get(a.size()-1) >= b){
                return binarySearch(a, pivotIndex, a.size()-1, b);
            } else {
                return -1;
            }
        }
    }

    public static int searchPivotIndex(List<Integer> a, int left, int right){
        if (right - left > 1){
            int mid = (right+left)/2;
            if (a.get(mid) < a.get(right)){
                return searchPivotIndex(a, left, mid);
            }else {
                return searchPivotIndex(a, mid, right);
            }
        }

        return left;
    }

    public static int binarySearch(List<Integer> a, int left, int right, int target){
        if (left <= right){
            int mid = (right+left)/2;
            if (a.get(mid) == target) return mid;
            else if (a.get(mid) < target){
                return binarySearch(a, mid+1, right, target);
            } else{
                return binarySearch(a, left, mid-1, target);
            }
        }

        return -1;
    }
}
