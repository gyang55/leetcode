package LeetCode.linkedList;

import java.util.List;

public class Leetcode82RemoveDuplicatesFromSortedList2 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummyHead = new ListNode(-101);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        ListNode next = head.next;
        int count = 0;
        while (next != null) {
            if (next.val != cur.val && count == 0) {
                pre = cur;
                cur = next;
                next = next.next;
                continue;
            }
            if (next.val == cur.val) {
                count++;
                next = next.next;
                continue;
            }
            if (next.val != cur.val && count != 0) {
                pre.next = next;
                cur = next;
                next = next.next;
                count = 0;
            }
        }
        if(count!=0){
            pre.next=null;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode thirdSecond = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fourthSecond = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = thirdSecond;
        thirdSecond.next = fourth;
        fourth.next = fourthSecond;
        fourthSecond.next = fifth;
        deleteDuplicates(head);
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur=cur.next;
        }
    }
}
