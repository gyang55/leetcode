package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;
import jdk.dynalink.beans.StaticClass;

public class MaxDistanceInTree {
    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static int maxDiatance(TreeNode head) {
        return process(head).maxDistance;
    }

    //返回以X为头的整棵树的两个信息
    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);

        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        // info
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + 1 + rightInfo.height;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height);
        return new Info(maxDistance, height);
    }


}
