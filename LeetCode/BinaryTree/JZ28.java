package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class JZ28 {
    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     */
    class Solution {

//        public boolean isSymmetric(TreeNode root) {
//            return check(root, root);
//        }
//
//        private boolean check(TreeNode a, TreeNode b) {
//            Deque<TreeNode> deque = new LinkedList<>();
//            deque.offer(a);
//            deque.offer(b);
//
//            while (!deque.isEmpty()) {
//                a = deque.poll();
//                b = deque.poll();
//                if (a == null && b == null) continue;
//
//                if ((a == null || b == null) || (a.val != b.val)) {
//                    return false;
//                }
//
//                deque.offer(a.left);
//                deque.offer(b.right);
//
//                deque.offer(a.right);
//                deque.offer(b.left);
//            }
//            return true;
//        }


        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }
        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }


    }
}
