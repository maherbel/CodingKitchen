package com.kitchen.sort;

import com.Utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 4, 1, 3, 5);
        List<Integer> input2 = Arrays.asList(84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60);
        System.out.println(countInversions(input));
        PrintUtil<Integer> printUtil = new PrintUtil<>();
        printUtil.print(input);
    }

    public static int countInversions(List<Integer> A) {
        if (A == null || A.size() < 2) return 0;
        int[] result = new int[1];
        countWhenMerge(A, 0, A.size()-1, result);
        return result[0];
    }

    public static void countWhenMerge(List<Integer> input, int left, int right, int[] result){
        if (left < right){
            int mid = (right - left)/2 + left;
            countWhenMerge(input, left, mid, result);
            countWhenMerge(input, mid+1, right, result);
            countMerge(input, left, mid+1, right, result);
        }
    }

    public static void countMerge(List<Integer> input, int left, int mid, int right, int[] result){
        int i = left;
        int j = mid+1;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(i <= mid && j <= right){
            if (input.get(i) <= input.get(j)){
                temp.add(input.get(i));
                i++;
            } else{
                temp.add(input.get(j));
                j++;
                result[0]+= mid - i;
            }
        }
        while (i <= mid) temp.add(input.get(i++));
        while (j <= right) temp.add(input.get(j++));

        int p=left;
        while (p <= right){
            input.set(p, temp.get(p-left));
            p++;
        }
    }
}
