package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101SymmetricTree {
    /**
     * recursion
     * */
//    public boolean isSymmetric(TreeNode root) {
//        return check(root, root);
//    }
//
//    private boolean check(TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null) {
//            return false;
//        }
//
//        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
//    }

    /**
     * queue
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        Queue<TreeNode> twoTreeNodes = new LinkedList<>();
        twoTreeNodes.offer(left);
        twoTreeNodes.offer(right);
        while (!twoTreeNodes.isEmpty()) {
            left = twoTreeNodes.poll();
            right = twoTreeNodes.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }
            twoTreeNodes.add(left.left);
            twoTreeNodes.add(right.right);
            twoTreeNodes.add(left.right);
            twoTreeNodes.add(right.left);
        }
        return true;
    }
}
