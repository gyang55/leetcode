package LeetCode.DFSBFS;

import LeetCode.linkedList.CountBSTNodesinaRange;
import datastructure.BinaryTree.TreeNode;

public class JZ54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        //reverse inorder
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);

    }
}
