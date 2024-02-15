package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckWhetherATreeIsACompletedBinaryTree {
    /**
     * 1. width iterate the tree
     * 2. if a node has right child but dose not have left child, false
     * 3. if 2 is true, the first node who either only has left child or doesnt have child at all,
     * the following nodes must be leaves.
     */

    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // check the node without both children
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
