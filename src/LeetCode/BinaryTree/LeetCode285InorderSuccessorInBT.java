package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class LeetCode285InorderSuccessorInBT {
    public TreeNode solution(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMostSuccessor(node.right);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // find the right most child of right tree
    private TreeNode getLeftMostSuccessor(TreeNode right) {
        if (right == null) {
            return right;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
