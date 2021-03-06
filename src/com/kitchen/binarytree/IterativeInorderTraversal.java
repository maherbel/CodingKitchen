package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.right = new TreeNode(25);
        root.left = new TreeNode(10);

        root.left.right = new TreeNode(13);
        root.left.left = new TreeNode(5);

        root.right.right = new TreeNode(35);
        root.right.left = new TreeNode(20);

        List<Integer> datas = iterativeInorderTraversal(root);
        for(Integer data : datas){
            System.out.print(" " + data);
        }
    }

    private static List<Integer> iterativeInorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> datas = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            datas.add(p.data); // adding the value after all left children are treated
                               // the while p!=null will be false when we dont have any false no more
            p = p.right;
        }
        return datas;
    }
}
