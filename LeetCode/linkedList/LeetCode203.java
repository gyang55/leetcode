package LeetCode.linkedList;

public class LeetCode203 {
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return head;
//        }
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }

        }
        return dummyHead.next;
    }
}
