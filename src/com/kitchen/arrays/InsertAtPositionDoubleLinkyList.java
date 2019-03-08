package com.kitchen.arrays;

import com.kitchen.datastructures.DoublyListNode;

public class InsertAtPositionDoubleLinkyList {

    public static void main(String[] args) {

    }

    public DoublyListNode insertAtPos(DoublyListNode head, int data, int pos) {

        DoublyListNode toInsert = new DoublyListNode(data);
        if (pos == 1){
            toInsert.next = head;
            if (head != null) head.prev = toInsert;
            return toInsert;
        }

        if (head == null && pos > 1){
            return null;
        }

        DoublyListNode current = head;
        int counter = 1;

        while (counter < pos-1 && current != null){
            current = current.next;
            counter++;
        }

        if (current != null){
            toInsert.prev = current;
            toInsert.next = current.next;
            current.next = toInsert;
        }

        return head;
    }
}
