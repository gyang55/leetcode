package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class JZ32 {
    /**
     * || 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            List<List<Integer>> res = new LinkedList<>();
//            if (root == null) {
//                return res;
//            }
//
//            Deque<TreeNode> queue = new LinkedList<>();
//            queue.addLast(root);
//            while (!queue.isEmpty()) {
//                List<Integer> subList = new LinkedList<>();
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    TreeNode temp = queue.pollFirst();
//                    subList.add(temp.val);
//                    if (temp.left != null) {
//                        queue.addLast(temp.left);
//                    }
//                    if (temp.right != null) {
//                        queue.addLast(temp.right);
//                    }
//                }
//                res.add(subList);
//            }
//            return res;
//        }
//    }

    /**
     * |||请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            int row = 1;
            while (!deque.isEmpty()) {
                List<Integer> subList = new LinkedList<>();
                if (row % 2 != 0) {
                    for (int i = deque.size(); i > 0; i--) {
                        TreeNode temp = deque.removeFirst();
                        subList.add(temp.val);
                        if (temp.left != null) {
                            deque.addLast(temp.left);
                        }
                        if (temp.right != null) {
                            deque.addLast(temp.right);
                        }

                    }
                } else {
                    for (int i = deque.size(); i > 0; i--) {
                        TreeNode temp = deque.removeLast();
                        subList.add(temp.val);
                        if (temp.right != null) {
                            deque.addFirst(temp.right);
                        }
                        if (temp.left != null) {
                            deque.addFirst(temp.left);
                        }

                    }
                }
                res.add(subList);
                System.out.println(res);
                row++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        head.left = nine;
        head.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        new JZ32().new Solution().levelOrder(head);
    }


}
