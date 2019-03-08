package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

public class DistanceNodeFromRoot {

    public int pathLengthFromRoot(TreeNode root, int n1) {
        if (root == null){
            return 0;
        }
        return pathFromRootDfs(root, n1, 1);
    }

    public int pathFromRootDfs(TreeNode root, int n1, int currentPathLength){
        if (root.data == n1){
            return currentPathLength;
        }

        int leftPathLength = root.left != null ? pathFromRootDfs(root.left, n1, 1 + currentPathLength) : 0;
        int rightPathLength = root.right != null ? pathFromRootDfs(root.right, n1, 1 + currentPathLength) : 0;

        return leftPathLength != 0 ? (rightPathLength != 0 ? Math.min(leftPathLength,rightPathLength) : leftPathLength) : rightPathLength;
    }
}
