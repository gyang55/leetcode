package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class isSearchBinaryTree {

    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData process(TreeNode x) {
        if (x == null) {
            return null;
        }

        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);


        int min = x.val;
        int max = x.val;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= x.val)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= x.val)) {
            isBST = false;
        }

        return new ReturnData(isBST, min, max);

    }
}
