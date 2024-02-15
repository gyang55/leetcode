package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode662MaximumWidthOfBinaryTree {
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            HashMap<TreeNode, Integer> levelMap = new HashMap<>();
            levelMap.put(root, 1);
            int curLevel = 1;
            int curLevelNodes = 0;
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int curNodeLevel = levelMap.get(cur);
                if (curNodeLevel == curLevel) {
                    curLevelNodes++;
                } else {
                    max = Math.max(max, curLevelNodes);
                    curLevel++;
                    curLevelNodes = 1;
                }

                if (cur.left != null) {
                    levelMap.put(cur.left, curNodeLevel + 1);
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    levelMap.put(cur.right, curNodeLevel + 1);
                    queue.add(cur.right);
                }
            }
            return max;
        }
    }

    /**
     * Official solution, this solution counts the null between start and end
     * node in each level
     * */
//    public int widthOfBinaryTree(TreeNode root) {
//        if(root == null) return 0;
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
//        q.offer(root);
//        m.put(root, 1);
//        int curW = 0;
//        int maxW = 0;
//        while(!q.isEmpty()){
//            int size = q.size();
//            int start = 0;
//            int end = 0;
//            for(int i = 0; i < size; i++){
//                TreeNode node = q.poll();
//                if(i == 0) start = m.get(node);
//                if(i == size - 1) end = m.get(node);
//                if(node.left != null){
//                    m.put(node.left, m.get(node) * 2);
//                    q.offer(node.left);
//                }
//                if(node.right != null){
//                    m.put(node.right, m.get(node) * 2 + 1);
//                    q.offer(node.right);
//                }
//            }
//            curW = end - start + 1;
//            maxW = Math.max(curW, maxW);
//        }
//        return maxW;
   // }
}
