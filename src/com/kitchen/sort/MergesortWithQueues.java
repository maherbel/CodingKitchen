package com.kitchen.sort;

import com.Utils.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class MergesortWithQueues {
    public static void main(String[] args) {
        Integer[] array = {5, 4, 25, 10, 15, 35, 12, 6, 7};
        PrintUtil<Integer> pu = new PrintUtil<>();
        pu.print(array);
        mergeSort(array, 0, array.length-1);
        pu.print(array);
    }

    private static void mergeSort(Integer[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle+1, high);
            merge(array, low, middle, high);
        }
    }

    private static void merge(Integer[] array, int low, int middle, int high) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i=low; i <= middle; i++) queue1.add(array[i]);
        for (int i=middle+1; i <= high; i++) queue2.add(array[i]);

        int i=low;
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            if (queue1.peek() <= queue2.peek()){
                array[i] = queue1.poll();
                i++;
            } else {
                array[i] = queue2.poll();
                i++;
            }
        }
        while (!queue1.isEmpty()) array[i++] = queue1.poll();
        while (!queue2.isEmpty()) array[i++] = queue2.poll();
    }
}
