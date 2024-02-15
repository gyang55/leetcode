package LeetCode.DFSBFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode117PopulatingNextRightPointersInEachNode2 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node temp = deque.poll();
                if (temp.left!=null){
                    deque.offer(temp.left);
                }
                if (temp.right!=null){
                    deque.offer(temp.right);
                }
                if (i == (size - 1)) {
                    temp.next = null;
                    break;
                }
                temp.next = deque.peek();
            }
        }
    return root;

    }
}
