package com.futurejob.test;


import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.binarySearch;

public class Main {


    public static void main(String[] args) {

        Random randNumGenerator = new Random();
        /*int[] array = new int[9];
        for (int i=0; i<array.length; i++)
        {
            array[i] = (randNumGenerator.nextInt(10));
            System.out.println(array[i]);
        }*/

        int[] array = {1, 20, 30, 50, 60, 70, 100, 105, 120};

        int index = binarySearchTree(array, 55, 0, array.length-1);

        System.out.println("Index is " + index);

       /* System.out.println("Now Sorting with CountingSort");
        countingSort(array, 1, 10);*/

        /*System.out.println("Now Sorting with QuickSort");
        quickSort(array, 0, array.length);*/

        /*System.out.println("Now Sorting with MergeSort");
        mergeSort(array, 0, array.length);*/

        for( int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    private static int binarySearchTree(int[] array, int value, int start, int end) {
        if (end - start < 2){
            return array[start] == value ? start : -1;
        }
        int mid = (start + end)/2;
        return array[mid] < value ?
                binarySearchTree(array, value, mid+1, end) : binarySearchTree(array, value, start, mid);
    }

    private static void countingSort(int[] array, int min, int max){
        int[] tmpArray = new int[max-min+1];
        for (int i=0; i<array.length; i++){
            tmpArray[array[i]]++;
        }
        int arrayIndex=0;
        for (int i=0; i<tmpArray.length; i++){
            int counter=tmpArray[i];
            while(counter>0){
                array[arrayIndex]=i;
                arrayIndex++;
                counter--;
            }
        }
    }

    private static void mergeSort(int[] array, int start, int end){
        if (end - start <= 1){
            return;
        }

        int mid = (start + end)/ 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);

    }

    private static void merge(int[] array, int start, int mid, int end) {
        if (array[mid-1] <= array[mid]){
            return;
        }

        int[] tmpArray = new int[end - start + 1];
        int tmpIndex = 0;
        int i=start, j=mid;

        while (i<mid && j<end){
            tmpArray[tmpIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start+tmpIndex, mid - i);
        System.arraycopy(tmpArray, 0, array, start, tmpIndex);

    }

    private static void quickSort(int[] array, int start, int end) {
        if (end - start < 2){
            return;
        }

        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex +1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivotIndex = (start + end) / 2;
        int pivot = array[pivotIndex];
        int i = start;
        int j = end;

        while (i<j){
            // If the values on the left are lesser than pivot check again
            while (i<j && array[--j] > pivot);
            if (i<j){
                array[i] = array[j];
            }

            // If the values on the right are greater than pivot check again
            while (i<j && array[++i] < pivot);
            if (i<j){
                array[j] = array[i];
            }

        }

        array[j] = pivot;
        return j;
    }


}
