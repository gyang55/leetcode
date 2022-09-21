package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode112PathSum {
    /***
     * Iterate through tree, keep sum when iterate each node, when reach leaf,
     * see if sum is equals target
     *
     */

//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        Queue<TreeNode> queueNode = new LinkedList<>();
//        Queue<Integer> queVal = new LinkedList<>();
//        queueNode.offer(root);
//        queVal.offer(root.val);
//        while (!queueNode.isEmpty()) {
//            TreeNode now = queueNode.poll();
//            int temp = queVal.poll();
//            if (now.left == null && now.right == null) {
//                if (temp == sum) {
//                    return true;
//                }
//                continue;
//            }
//            if (now.left != null) {
//                queueNode.offer(now.left);
//                queVal.offer(now.left.val + temp);
//            }
//
//            if (now.right != null) {
//                queueNode.offer(now.right);
//                queVal.offer(now.right.val + temp);
//            }
//        }
//        return false;
//    }

    /**
     * recursion
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}
