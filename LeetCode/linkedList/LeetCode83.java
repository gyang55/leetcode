package LeetCode.linkedList;

public class LeetCode83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = deleteDuplicates(head.next);
        if (head.val == lastNode.val) {
            head.next = lastNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        first.next = second;
        second.next = third;
        ListNode head = deleteDuplicates(first);
        System.out.print(head.val + " " + head.next.val);
    }
}
