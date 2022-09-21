package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1302DeepestLeavesSum {
    /**
     * DFS find the maxlevel
     * if a node is in maxlevel, add its val
     * */
//    int maxLevel = -1;
//    int sum = 0;
//
//    public int deepestLeavesSum(TreeNode root) {
//        dfs(root, 0);
//        return sum;
//    }
//
//    public void dfs(TreeNode node, int level) {
//        if (node == null) {
//            return;
//        }
//        if (level > maxLevel) {
//            maxLevel = level;
//            sum = node.val;
//        } else if (level == maxLevel) {
//            sum += node.val;
//        }
//        dfs(node.left, level + 1);
//        dfs(node.right, level + 1);
//    }

    /**
     * bfs
     */

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int sum = 0;
        while (!deque.isEmpty()) {
            sum=0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                if (temp.left != null) {
                    deque.offer(temp.left);
                }
                if (temp.right != null) {
                    deque.offer(temp.right);
                }
                sum += temp.val;
            }
        }
        return sum;
    }
}

