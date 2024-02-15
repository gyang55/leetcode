package LeetCode.linkedList;

public class JZ18 {
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode root = head;
        ListNode next = null;
        while ( root.next!=null&&root.next.val != val ) root = root.next;
        if(root.next!=null){
            next = root.next;
            root.next = next.next;
            next.next = null;
        }

        return head;
    }
}
