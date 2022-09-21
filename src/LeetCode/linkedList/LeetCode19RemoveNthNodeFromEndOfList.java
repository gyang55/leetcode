package LeetCode.linkedList;

import java.util.List;
import java.util.Stack;

public class LeetCode19RemoveNthNodeFromEndOfList {
    /**
     * stack
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int count = 1;
        while (!stack.isEmpty()) {
            if (count - n == 1) {
                cur = stack.pop();
                cur.next = cur.next.next;
                return head;
            }
            stack.pop();
            count++;
        }
        return head.next;
    }
}
