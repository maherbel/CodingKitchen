package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.right = new TreeNode(25);
        root.left = new TreeNode(10);

        root.left.right = new TreeNode(13);
        root.left.left = new TreeNode(5);

        root.right.right = new TreeNode(35);
        root.right.left = new TreeNode(20);

        List<Integer> datas = postorderTraversalTwoStack(root);
        for (Integer data : datas) {
            System.out.print(" " + data);
        }

        System.out.println();
    }

    public static ArrayList<Integer> postorderTraversalTwoStack(TreeNode A) {
        TreeNode currNode = A;
        if (currNode == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(currNode);
        Stack<TreeNode> reverseStack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
            if (reverseStack.peek().left != null) stack.push(reverseStack.peek().left);
            if (reverseStack.peek().right != null) stack.push(reverseStack.peek().right);
        }

        while (!reverseStack.isEmpty()) {
            result.add(reverseStack.pop().data);
        }
        return result;
    }

}

