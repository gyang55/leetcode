package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    /**
     * 把每一层的node都加入到queue，每一层遍历一遍。每一层最右边，也就是queue的第一个node可以看到。
     * */
//    public List<Integer> rightSideView(TreeNode root) {
//        // reverse level traversal
//        List<Integer> result = new ArrayList();
//        Queue<TreeNode> queue = new LinkedList();
//        if (root == null) return result;
//
//        queue.offer(root);
//        while (queue.size() != 0) {
//            int size = queue.size();
//            for (int i=0; i<size; i++) {
//                TreeNode cur = queue.poll();
//                if (i == 0) result.add(cur.val);
//                if (cur.right != null) queue.offer(cur.right);
//                if (cur.left != null) queue.offer(cur.left);
//            }
//
//        }
//        return result;
//    }
}
