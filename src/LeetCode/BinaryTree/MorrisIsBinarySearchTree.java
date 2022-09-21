package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.IllegalFormatCodePointException;

public class MorrisIsBinarySearchTree {
    public static boolean morris(TreeNode head) {
        if (head == null) {
            return true;
        }

        TreeNode cur = head;
        TreeNode mostRight = null;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { //有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //mostright 变成了cur左子树上，最右的节点
                if (mostRight.right == null) { //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            if (cur.val <= preValue) {
                return false;
            }
            preValue = cur.val;
            cur = cur.right; //没有左子树，向右移动
        }
        return true;
    }
}
