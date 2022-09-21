package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode236LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        process(root, fatherMap);
        HashSet<TreeNode> setp = new HashSet<>();
        setp.add(p);
        TreeNode cur = p;
        while (cur != fatherMap.get(cur)) {
            setp.add(cur);
            cur = fatherMap.get(cur);
        }
        setp.add(root);
        cur = q;
        while (q != fatherMap.get(cur)) {
            if (setp.contains(fatherMap.get(cur))) {
                return fatherMap.get(cur);
            }
            q = fatherMap.get(cur);
        }
        return root;
    }

    public static void process(TreeNode head, HashMap fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);

    }

    /***/

    public static TreeNode lcaSolution2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lcaSolution2(root.left, p, q);
        TreeNode right = lcaSolution2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
