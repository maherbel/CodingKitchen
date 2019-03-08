package com.kitchen.datastructures;

public class SinglyLinkedList<T> {
    public T data;
    public SinglyLinkedList<T> next;

    public SinglyLinkedList(T data){
        this.data = data;
    }

    public SinglyLinkedList() {

    }

    public void print(){
        SinglyLinkedList<T> tmp = new SinglyLinkedList<>();
        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
