package LeetCode.BinaryTree;

import com.sun.source.tree.Tree;
import datastructure.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode919CompleteBTInserter {
    Queue<TreeNode> candidate;
    TreeNode root;

    public LeetCode919CompleteBTInserter(TreeNode root) {
        candidate = new ArrayDeque<>();
        Queue<TreeNode> iterate = new ArrayDeque<>();
        this.root = root;
        iterate.offer(root);
        while (!iterate.isEmpty()) {
            TreeNode node = iterate.poll();
            if (node.left != null) {
                iterate.offer(node.left);
            }
            if (node.right != null) {
                iterate.offer(node.right);
            }
            if (node.left == null || node.right == null) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode insertedVal = new TreeNode(val);
        TreeNode parent = candidate.peek();
        int parentVal = parent.val;
        if (parent.left == null) {
            parent.left = insertedVal;
        } else {
            parent.right = insertedVal;
            candidate.poll();
        }
        candidate.offer(insertedVal);
        return parentVal;
    }

    public TreeNode get_root() {
        return root;
    }
}
