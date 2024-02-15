package LeetCode.linkedList;

public class LeetCode2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempListOne = l1;
        ListNode tempListTwo = l2;
        ListNode res = new ListNode(0);
        ListNode tempRes = res;
        int carryIn = 0;
        while (tempListTwo != null && tempListOne != null) {
            int sum = tempListOne.val + tempListTwo.val + carryIn;
            tempRes = helper(tempRes, sum);
            carryIn = sum >= 10 ? 1 : 0;
            tempListOne = tempListOne.next;
            tempListTwo = tempListTwo.next;
        }

        if (tempListOne == null && tempListTwo == null) {
            helper2(tempRes, carryIn);
        } else if (tempListOne == null) {
            while (tempListTwo != null) {
                int sum = tempListTwo.val + carryIn;
                tempRes = helper(tempRes, sum);
                carryIn = sum >= 10 ? 1 : 0;
                tempListTwo = tempListTwo.next;
            }
            helper2(tempRes, carryIn);
        } else {
            while (tempListOne != null) {
                int sum = tempListOne.val + carryIn;
                tempRes = helper(tempRes, sum);
                carryIn = sum >= 10 ? 1 : 0;
                tempListOne = tempListOne.next;
            }
            helper2(tempRes, carryIn);
        }

        return helper3(res);
    }

    private ListNode helper(ListNode tempRes, int sum) {
        if (sum >= 10) {
            tempRes.val = sum - 10;
        } else {
            tempRes.val = sum;
        }
        ListNode temp = new ListNode(0);
        tempRes.next = temp;
        tempRes = temp;
        return tempRes;
    }

    private void helper2(ListNode tempRes, int carryIn) {
        if (carryIn == 1) {
            tempRes.val = 1;
        }
    }

    private ListNode helper3(ListNode res) {
        ListNode temp = res;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        if (temp.next.val == 0) {
            temp.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode firstThree = new ListNode(3);
        ListNode firstTwo = new ListNode(4, firstThree);
        ListNode firstOne = new ListNode(2, firstTwo);
        ListNode secondThree = new ListNode(4);
        ListNode secondTwo = new ListNode(6, secondThree);
        ListNode secondOne = new ListNode(5, secondTwo);
        LeetCode2AddTwoNumbers leetCode2AddTwoNumbers = new LeetCode2AddTwoNumbers();
        ListNode res = leetCode2AddTwoNumbers.addTwoNumbers(firstOne, secondOne);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}

/**
 * Official solution
 * */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
//}



