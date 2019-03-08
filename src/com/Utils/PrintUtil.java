package com.Utils;

import java.util.List;

public class PrintUtil<T> {

    public void print(T[] array){
        System.out.println("------Starting Printing------");
        for (int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("------Finished Printing------");
    }

    public void print(List<T> array){
        System.out.println("------Starting Printing------");
        for (T item : array){
            System.out.print(item + " ");
        }
        System.out.println("");
        System.out.println("------Finished Printing------");
    }
}
