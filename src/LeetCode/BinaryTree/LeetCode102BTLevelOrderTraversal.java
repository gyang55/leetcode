package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.*;

public class LeetCode102BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
