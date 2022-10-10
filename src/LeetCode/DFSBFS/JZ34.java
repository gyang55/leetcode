package LeetCode.DFSBFS;

import datastructure.BinaryTree.TreeNode;

import java.util.*;

public class JZ34 {
    //给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    //
    //叶子节点 是指没有子节点的节点。
    Deque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path)); // 细节：为什么我要通过构造方法传入path，不能直接res.add(path)
            //      因为直接加入，加入的是引用(指向的堆中数据会变化)，需要克隆一份加入  The Linked List is a linear data structure,
            //      in which the elements are not stored at contiguous memory locations. The elements in a linked
            //      list are linked using pointers. It is implemented on the heap memory rather than the stack memory
        }

        dfs(root.left, target);
        dfs(root.right, target);
        path.removeLast();
    }
}
