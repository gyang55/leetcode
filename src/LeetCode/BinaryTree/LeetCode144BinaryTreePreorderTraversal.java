package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> container = new Stack<>();
        container.add(root);
        while (!container.isEmpty()) {
            TreeNode temp = container.pop();
            res.add(temp.val);
            if (temp.right != null) {
                container.add(temp.right);
            }
            if (temp.left != null) {
                container.add(temp.left);
            }
        }
        return res;
    }
}
