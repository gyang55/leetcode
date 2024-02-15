package LeetCode.linkedList;

public class BinarySearchCentralLinkedListAndLeetCode876 {
    /**
     * Given a singly linked list node, return the value of the middle node. If there's two middle nodes, then return the second one.
     * <p>
     * Bonus: Solve using \mathcal{O}(1)O(1) space.
     * <p>
     * Constraints
     * <p>
     * n ≤ 100,000 where n is the number of nodes in node
     */
    class LLNode {
        int val;
        LLNode next;
    }

    public int solve(LLNode node) {
        int n = 0;
        LLNode cur = node;
        while (cur!=null){
            n++;
            cur=cur.next;
        }
        int k=0;
        cur=node;
        while (k<n/2){
            k++;
            cur=cur.next;
        }
        return cur.val;
    }
}
