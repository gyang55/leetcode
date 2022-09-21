package LeetCode.BinaryTree;

import datastructure.BinaryTree.TreeNode;

public class MorrisPre {
    /**
     * 没有左子树直接打印，有左子树，打印第一次*/
    public static void morrisPre(TreeNode head){
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
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right=null;
                }

            }else{
                System.out.println(cur.val);
            }


            cur=cur.right; //没有左子树，向右移动
        }
    }
}
