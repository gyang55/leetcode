package LeetCode.linkedList;

public class LeetCode876MiddleOfTheLinkedList {
    /**
     * <p> Logic
     * kth next to last is the n-k +1
     * use dual pointers
     * move the faster pointer to position n-1 and when then move the dual pointers together. When the
     * faster pointer moves to the end, the slower one is pointing at the position we want
     * </p>
     */


    public static ListNode middleNode(ListNode head, int kthNode) {
        if (kthNode <= 0 || head == null) return null;

        ListNode pTemp = head, pKthNode = null;

        // move k-1 times
        for (int count = 1; count < kthNode; count++) {
            if (pTemp != null) {
                pTemp = pTemp.next;
            }
        }

        while (pTemp != null) {
            if (pKthNode == null) {
                pKthNode = head;
            } else {
                pKthNode = pKthNode.next;
            }
            pTemp = pTemp.next;
        }
        if (pKthNode != null) {
            return pKthNode;
        }
        return null;
    }

}
