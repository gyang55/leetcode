package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class Morris {
    public static void morris(TreeNode head){
        if (head==null){
            return;
        }

        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur!=null){
            mostRight =cur.left;
            if (mostRight!=null){ //有左子树
                while (mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }

                //mostright 变成了cur左子树上，最右的节点
                if (mostRight.right==null) { //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right=null;
                }

            }


            cur=cur.right; //没有左子树，向右移动
        }
    }
}
