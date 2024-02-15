package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class LeetCode700SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode cur = root;

        return searchBST(val < root.val ? root.left : root.right, val);
    }
}
