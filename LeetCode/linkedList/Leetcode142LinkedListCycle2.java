package LeetCode.linkedList;

public class Leetcode142LinkedListCycle2 {
    //intersect
    //a+n(b+c)+b=a+(n+1)b+nc
    //a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slower = head;
        ListNode faster = head;
        boolean loopExists = false;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slower = head;
            while (slower != faster) {
                slower = slower.next;
                faster = faster.next;
            }
            return slower;
        }
        return null;
    }
}
