package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LeetCode653TwoSumIVInputIsABST {
    //bfs
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
    //dfs
//    Set<Integer> set = new HashSet<Integer>();
//
//    public boolean findTarget(TreeNode root, int k) {
//        if (root == null) {
//            return false;
//        }
//        if (set.contains(k - root.val)) {
//            return true;
//        }
//        set.add(root.val);
//        return findTarget(root.left, k) || findTarget(root.right, k);
//    }

}
