package com.kitchen.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxDistanceBetweenNodes {
    public static void main(String[] args) {
        //Integer[] tree = {-1, 0, 0, 1, 2, 1, 5}; // 5
        //Integer[] tree = {-1, 0, 0, 0, 3}; // 3
        Integer[] tree = {-1, 0, 1, 1, 3, 0, 4, 0, 2, 8, 9, 0, 4, 6, 12, 14, 7, 9, 6, 4, 14, 13, 1, 9, 16, 17, 17, 0, 21, 10, 13, 14, 25, 28, 27, 0, 35, 20, 34, 23, 37, 3, 6, 25, 30, 22, 15, 37, 8, 6, 11, 22, 50, 12, 4, 2, 54, 23, 18, 52, 34, 49, 61, 8, 15, 63, 31, 51, 48, 41, 26, 37, 30, 15, 59, 12, 0, 40, 37, 73, 32, 19, 70, 29, 8, 21, 83, 33, 7, 13, 12, 82, 43, 86, 38, 31, 1, 84, 62, 83};
        System.out.println(solve(new ArrayList<>(Arrays.asList(tree))));
    }

    public static int solve(ArrayList<Integer> A) {
        if (A == null || A.size() == 0 || A.size() == 1) return 0;
        TreeNode root = constructTree(A);
        if (root.childs == null) return 0;
        int max1 = 0;
        int max2 = 0;
        int temp;
        for (int i=0; i < root.childs.size(); i++){
            temp = maxDistance(root.childs.get(i));
            if (max1 < temp){
                max2 = max1;
                max1 = temp;
            } else if (max2 < temp){
                max2 = temp;
            }
        }
        return max1+max2;
    }

    public static int maxDistance(TreeNode root){
        if (root == null){
            return 0;
        }

        int maxFromChilds = 0;
        if (root.childs != null){
            for (int i=0; i < root.childs.size(); i++){
                maxFromChilds = Math.max(maxFromChilds, maxDistance(root.childs.get(i)));
            }
        }

        return 1 + maxFromChilds;
    }

    public static TreeNode constructTree(ArrayList<Integer> treeAsArray){
        Map<Integer,TreeNode> nodesByData = new HashMap<Integer,TreeNode>();
        TreeNode root = null;

        for (int i=0; i < treeAsArray.size(); i++){
            TreeNode childNode = new TreeNode(i);
            nodesByData.put(i, childNode);

            TreeNode parentNode = nodesByData.get(treeAsArray.get(i) == -1 ? i : treeAsArray.get(i));
            if (parentNode == null){
                parentNode = new TreeNode(treeAsArray.get(i));
                nodesByData.put(treeAsArray.get(i), parentNode);
            }

            if (treeAsArray.get(i) != -1) {
                parentNode.addChild(childNode);
            } else {
                root = childNode;
            }
        }
        return root;
    }

    public static class TreeNode{
        public int data;
        public ArrayList<TreeNode> childs;

        public TreeNode(int data){
            this.data = data;
        }

        public void addChild(TreeNode newChild){
            if (this.childs == null){
                this.childs = new ArrayList<TreeNode>();
            }
            this.childs.add(newChild);
        }
    }
}
