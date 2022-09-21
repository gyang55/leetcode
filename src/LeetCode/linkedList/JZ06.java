package LeetCode.linkedList;


import java.util.Deque;
import java.util.LinkedList;

public class JZ06 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode c = head;
            Deque<Integer> temp = new LinkedList<>();
            while (c != null) {
                temp.push(c.val);
                c = c.next;
            }

            int[] res = new int[temp.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = temp.pop();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        JZ06 s = new JZ06();
        JZ06.Solution s1 = s.new Solution();
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(3);
        ListNode third = new ListNode(2);
        head.next = sec;
        sec.next = third;

        int[] res = s1.reversePrint(head);
        for (int n : res
        ) {
            System.out.println(n);
        }
    }


}
