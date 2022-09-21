package LeetCode.linkedList;


import java.util.ArrayDeque;
import java.util.Queue;

public class CountBSTNodesinaRange {

    public class Tree {
        int val;
        Tree left;
        Tree right;
    }

    public int solve(Tree root, int lo, int hi) {
        if (root==null){
            return 0;
        }
        Queue<Tree> iterate = new ArrayDeque<>();
        iterate.offer(root);
        int count = 0;
        while (!iterate.isEmpty()) {
            Tree temp = iterate.poll();
            if (temp.left != null) {
                iterate.offer(temp.left);
            }
            if (temp.right != null) {
                iterate.offer(temp.right);
            }
            if (temp.val >= lo && temp.val <= hi) {
                count++;
            }
        }
        return count;
    }
}
