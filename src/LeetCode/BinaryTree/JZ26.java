package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class JZ26 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        private boolean check(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null || A.val != B.val) return false;

            return check(A.left, B.left) && check(A.right, B.right);
        }
    }
}
