package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class LeetCode701InsertIntoABST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val && cur.left == null) {
                cur.left = new TreeNode(val);
            }
            if (val > cur.val && cur.right == null) {
                cur.right = new TreeNode(val);
            }
            cur = cur.val > val ? cur.left : cur.right;
        }
        return root;
    }
}
