package LeetCode.linkedList;

public class Leetcode141LinkedListCycle {
    //floyd two pointers
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slower = head;
        ListNode faster = head;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }
}
