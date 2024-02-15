package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class isFullBinaryTree {

    public static boolean isFullBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Info data = process(head);
        return data.nodes == (1 << data.height) - 1;
    }

    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }

        Info leftData = process(x.left);
        Info rightData = process(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height, nodes);
    }
}
