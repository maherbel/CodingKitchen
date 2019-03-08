package com.kitchen.binarytree;

import com.kitchen.datastructures.TreeNode;

public class IdenticalBinaryTrees {

    public static void main(String[] args) {

    }

    public boolean isIdentical(TreeNode root1, TreeNode root2) {

        boolean isIdentical = root1 == null ? root2 == null : (root2 == null ? false : root1.data == root2.data);

        if (root1 != null){
            return isIdentical && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }

        return isIdentical;
    }
}
