package com.kitchen.arrays;

import com.kitchen.datastructures.ListNode;

public class NthElementFromLinkedList {

    public ListNode findNthNodeFromEnd(ListNode head, int n) {

        if (head == null || n <= 0){
            return null;
        }

        // Compute the size of the LinkedList
        int size = computeLinkedListSize(head);

        if (size < n){
            return null;
        }

        // Fetch the Nth node using the size
        return fetchNthNode(head, size, n);

    }

    public int computeLinkedListSize(ListNode head){
        int size = 0;

        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }

    public ListNode fetchNthNode(ListNode head, int size, int n){
        int counter = 0;

        ListNode temp = head;
        while (counter < size-n) {
            temp = temp.next;
            counter++;
        }

        return temp;
    }
}
