package com.kitchen.datastructures;

import java.util.Stack;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode(int data){
        this.data = data;
    }

    public void print() {
        iterativeInorderTraversal(this);
    }

    private void iterativeInorderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.data);
            // the while p!=null will be false when we dont have any false no more
            p = p.right;
        }
    }
}
