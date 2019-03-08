package com.kitchen.map;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public class ListNode{
        public int value;
        public ListNode previous;
        public ListNode next;

        public ListNode(){}

        public ListNode(int value){
            this.value = value;
        }
    }

    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new ListNode();
        this.tail = new ListNode();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            ListNode existingNode = moveModifiedNodeToHead(key);
            return existingNode.value;
        }
        return -1;
    }

    private void placeNodeAtHead(ListNode newHead){
        newHead.next = head.next;
        newHead.previous = head;
        if (head.next != null){
            head.next.previous = newHead;
        }
        head.next = newHead;
    }

    private ListNode moveModifiedNodeToHead(int key){
        ListNode existingNode = cache.get(key);
        if (existingNode.next != null){
            existingNode.next.previous = existingNode.previous;
        }
        if (existingNode.previous != null){
            existingNode.previous.next = existingNode.next;
        }
        placeNodeAtHead(existingNode);
        return existingNode;
    }

    public void set(int key, int value) {
        if (cache.size() < capacity){
            if (!cache.containsKey(key)){
                ListNode newNode = new ListNode(value);
                placeNodeAtHead(newNode);
                cache.put(key, newNode);
            } else {
                ListNode existingNode = moveModifiedNodeToHead(key);
                existingNode.value = value;
            }
        } else {
            if (!cache.containsKey(key)){
                ListNode lastNode = tail.previous;
                cache.values().remove(lastNode);
                if (lastNode.previous != null){
                    lastNode.previous.next = tail;
                    tail.previous = lastNode.previous;
                }
                ListNode newNode = new ListNode(value);
                placeNodeAtHead(newNode);
                cache.put(key, newNode);
            } else {
                ListNode existingNode = moveModifiedNodeToHead(key);
                existingNode.value = value;
            }
        }
    }
}