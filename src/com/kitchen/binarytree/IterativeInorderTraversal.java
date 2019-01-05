package com.futurejob.test.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.right = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.right.left = new TreeNode(20);

        root.left = new TreeNode(10);
        root.left.right = new TreeNode(13);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);

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
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            datas.add(root.data);
            root = root.right;
        }
        return datas;
    }
}
