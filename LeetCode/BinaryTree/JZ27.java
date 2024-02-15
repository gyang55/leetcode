package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class JZ27 {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
     */
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                TreeNode tempRoot = deque.removeFirst();
                if (tempRoot.right != null) {
                    deque.addLast(tempRoot.right);
                }
                if (tempRoot.left != null) {
                    deque.addLast(tempRoot.left);
                }
                TreeNode temp = tempRoot.left;
                tempRoot.left = tempRoot.right;
                tempRoot.right = temp;
            }
            return root;
        }
    }
}
