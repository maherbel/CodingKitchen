package com.kitchen.arrays;

/**
 * given an array of integer
 * return the max sum of k adjacent elements
 */

public class MaxSumKthElements {
    public static void main(String[] args) {
        int[] array =  {100, 200, 300, 100, 400, 50, 600, 150};
        int elements = 2;
        int maxBruteForce = maxBruteForce(array, elements);
        System.out.println("Brute Force Max is : "+ maxBruteForce);
        int maxSlidingWindow = maxSlidingWindow(array, elements);
        System.out.println("Sliding Window Max is : "+ maxSlidingWindow);
    }

    private static int maxSlidingWindow(int[] array, int k) {
        int maxSum = 0;
        /**
         * Sum the first "elements"
         */
        for (int i=0; i<k; i++) maxSum+=array[i];

        /**
         * Slide and remove the leftsome while adding the rightsome
         */
        int windowSum = maxSum;
        for (int i=k; i<array.length; i++){
            windowSum += array[i] - array[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    private static int maxBruteForce(int[] array, int k) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<array.length-k+1; i++){
            int currentMax = 0;
            for (int j=0; j<k; j++){
                currentMax += array[i+j];
            }
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
