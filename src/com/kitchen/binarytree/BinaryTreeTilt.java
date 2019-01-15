package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTilt {

    public static void main(String[] args) throws IOException {
        String line = "[1,2,3,4,null,5]";
            TreeNode root = MainClass.stringToTreeNode(line);

            int ret = new Solution().findTilt(root);

            String out = String.valueOf(ret);

            System.out.print(out);
    }

    static class Solution {
        public int findTilt(TreeNode root) {
            if (root == null){
                return 0;
            }
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;
            int currentTilt = (rightChild == null ? 0 : rightChild.data) -
                    (leftChild == null ? 0 : leftChild.data);

            return Math.abs(currentTilt) + (findTilt(rightChild) + findTilt(leftChild));
        }
    }

    public static class MainClass {
        public  static  TreeNode stringToTreeNode(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return null;
            }

            String[] parts = input.split(",");
            String item = parts[0];
            TreeNode root = new TreeNode(Integer.parseInt(item));
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);

            int index = 1;
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int leftNumber = Integer.parseInt(item);
                    node.left = new TreeNode(leftNumber);
                    nodeQueue.add(node.left);
                }

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int rightNumber = Integer.parseInt(item);
                    node.right = new TreeNode(rightNumber);
                    nodeQueue.add(node.right);
                }
            }
            return root;
        }


    }

}
