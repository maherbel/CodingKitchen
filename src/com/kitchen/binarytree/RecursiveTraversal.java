package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.right = new TreeNode(25);
        root.left = new TreeNode(10);

        root.left.right = new TreeNode(13);
        root.left.left = new TreeNode(5);

        root.right.right = new TreeNode(35);
        root.right.left = new TreeNode(20);

        List<Integer> datas = new ArrayList<>();
        recursiveInorderTraversal(root, datas);
        for(Integer data : datas){
            System.out.print(" " + data);
        }
    }

    private static void recursiveInorderTraversal(TreeNode root, List<Integer> datas) {

    }


}
