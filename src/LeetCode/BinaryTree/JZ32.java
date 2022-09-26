package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class JZ32 {
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                List<Integer> subList = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.pollFirst();
                    subList.add(temp.val);
                    if (temp.left != null) {
                        queue.addLast(temp.left);
                    }
                    if (temp.right != null) {
                        queue.addLast(temp.right);
                    }
                }
                res.add(subList);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        head.left = nine;
        head.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        new JZ32().new Solution().levelOrder(head);
    }
}
