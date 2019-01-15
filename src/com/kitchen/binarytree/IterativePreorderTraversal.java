package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.right = new TreeNode(25);
        root.left = new TreeNode(10);

        root.left.right = new TreeNode(13);
        root.left.left = new TreeNode(5);

        root.right.right = new TreeNode(35);
        root.right.left = new TreeNode(20);

        List<Integer> datas = iterativePreorderTraversal(root);
        for(Integer data : datas){
            System.out.print(" " + data);
        }
    }

    private static List<Integer> iterativePreorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                res.add(p.data); // Add the value before going to the children
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }

        return res;
    }
}
