package datastructure.BinaryTree;

import java.util.Stack;
import java.util.stream.Stream;

class printOrders {
    public static void preOrderRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void postOrderRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().val + " ");
            }
        }
    }

    public static void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(9);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);

        head.left=four;
        head.right = seven;
        seven.left = six;
        four.left=three;
        three.right=two;

        inOrderUnRecur(head);

    }
}
