package LeetCode.linkedList;

public class Leetcode83RemoveDuplicatesFromSortedList {
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) return head;
//        ListNode p = head;
//        while (p.next != null) {
//            if (p.next.val == p.val) {
//                p.next = p.next.next;
//            } else {
//                p = p.next;
//            }
//
//        }
//        return head;
//    }

    //LeetCode.recursive
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;

    }
}
