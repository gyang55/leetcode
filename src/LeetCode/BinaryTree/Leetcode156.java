package LeetCode.BinaryTree;

import LeetCode.arrays.Leetcode350;
import com.sun.source.tree.Tree;
import datastructure.BinaryTree.TreeNode;

public class Leetcode156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = three;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        two.left = four;
        two.right = five;

        System.out.println(new Leetcode156().upsideDownBinaryTree(root).left);

    }

}
