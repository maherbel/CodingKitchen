package com.kitchen.binarytree;

import com.kitchen.datastructures.SinglyLinkedList;
import com.kitchen.datastructures.TreeNode;

import java.util.Stack;

public class ConvertBSTtoLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.right = new TreeNode(25);
        root.left = new TreeNode(10);

        root.left.right = new TreeNode(13);
        root.left.left = new TreeNode(5);

        root.right.right = new TreeNode(35);
        root.right.left = new TreeNode(20);

        SinglyLinkedList<Integer> result = convertToLinkedList(root);
        root.print();
        System.out.println("Converted !");
        result.print();

    }

    private static SinglyLinkedList<Integer> convertToLinkedList(TreeNode root) {
        TreeNode tmp;
        Stack<TreeNode> stack = new Stack<>();
        SinglyLinkedList<Integer> result = null;
        SinglyLinkedList<Integer> tmpResult = null;
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                tmp = stack.pop();
                if (result == null){
                    result = new SinglyLinkedList<>(tmp.data);
                    tmpResult = result;
                } else {
                    SinglyLinkedList<Integer> newItem = new SinglyLinkedList<>(tmp.data);
                    tmpResult.next = newItem;
                    tmpResult = newItem;
                }
                root = tmp.right;
            }
        }
        return result;
    }

    private static SinglyLinkedList<Integer> addItemToLL(SinglyLinkedList<Integer> tmpResult, int data) {
        SinglyLinkedList<Integer> newItem = new SinglyLinkedList<>(data);
        tmpResult.next = newItem;
        return newItem;
    }

}
