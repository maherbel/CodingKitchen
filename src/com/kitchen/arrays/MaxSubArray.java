package com.kitchen.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an Array of Integers
 * return the maximum sub array
 */

public class MaxSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();

        Integer[] array = { 24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671 };
        /*A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(3);*/

        /*A.add(756898537);
        A.add(-1973594324);
        A.add(-2038664370);
        A.add(-184803526);
        A.add(1424268980);*/

        /*A.add(336465782);
        A.add(-278722862);
        A.add(-2145174067);
        A.add(1101513929);
        A.add(1315634022);
        A.add(-1369133069);
        A.add(1059961393);
        A.add(628175011);
        A.add(-1131176229);
        A.add(-859484421);*/

        maxset(new ArrayList<Integer>(Arrays.<Integer>asList(array)));
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()){
            return new ArrayList<Integer>();
        }
        long maxSum = Long.MIN_VALUE;
        int maxStart = -1, maxEnd = -1, tmpStart = 0, tmpEnd = 0;
        long tmpSum = 0;
        boolean startFound = false;

        for (int i=0; i < A.size(); i++){
            int currentNumber = A.get(i);
            if (currentNumber >= 0){
                if (i == 0 || !startFound){
                    tmpStart = i;
                    startFound = true;
                }
                tmpSum += currentNumber;
                if (i == A.size()-1){
                    if (tmpSum > maxSum || (tmpSum == maxSum &&
                            ((tmpEnd-tmpStart > maxEnd-maxStart) || tmpStart < maxStart))){
                        maxSum = tmpSum;
                        maxStart = tmpStart;
                        maxEnd = tmpEnd;
                        startFound = false;
                        tmpSum =0;
                        tmpEnd = i+1;
                    }
                }
            } else if (i > 0 && currentNumber < 0 && A.get(i-1) >= 0){
                tmpEnd = i;
                startFound = false;
                if (tmpSum > maxSum || (tmpSum == maxSum &&
                        ((tmpEnd-tmpStart > maxEnd-maxStart) || tmpStart < maxStart))){
                    maxSum = tmpSum;
                    maxStart = tmpStart;
                    maxEnd = tmpEnd;
                    tmpSum =0;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = maxStart; i < maxEnd; i++){
            result.add(A.get(i));
        }
        return result;
    }
}
