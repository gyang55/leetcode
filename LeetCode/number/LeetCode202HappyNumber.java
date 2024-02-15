package LeetCode.number;

import java.util.HashSet;

public class LeetCode202HappyNumber {
    /**
     * 用hashset，如果不是happynumber，则数字会已经出现在set中过，不然会一直到1
     */
//    public boolean isHappy(int n) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(n);
//        while (n != 1) {
//            n = nextInt(n);
//            if (!hashSet.add(n)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private int nextInt(int n) {
//        int sum = 0;
//        while (n != 0) {
//            int temp = n % 10;
//            sum += temp * temp;
//            n = n / 10;
//        }
//        return sum;
//    }

    /**
     * 快慢指针，快指针一次走两个数，慢指针一次一个数
     * 如果不是happynumber，快慢指针最终相遇
     * 不然快指针先到到1
     */

    public boolean isHappy(int n) {
        int slower = n;
        int fast = nextInt(n);
        while (fast != 1 && slower != fast) {
            slower = nextInt(slower);
            fast = nextInt(nextInt(fast));
        }
        return fast == 1;
    }

    private int nextInt(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
}
