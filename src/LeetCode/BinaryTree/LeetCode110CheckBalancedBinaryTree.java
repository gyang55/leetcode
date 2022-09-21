package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class LeetCode110CheckBalancedBinaryTree {
    public static boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei) {
            isBalanced = isB;
            height = hei;
        }
    }

    public static ReturnType process(TreeNode x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;

        boolean isBalanced = leftData.isBalanced && rightData.isBalanced &&
                Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced, height);
    }
}
