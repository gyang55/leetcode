package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.*;

public class LeetCode94InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> container = new ArrayDeque<>();

        while (!container.isEmpty() || root != null) {
            if (root != null) {
                container.push(root);
                root = root.left;
            } else {
                TreeNode temp = container.pop();
                res.add(temp.val);
                root = temp.right;
            }
        }
        return res;
    }
}
