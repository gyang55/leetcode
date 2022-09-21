package LeetCode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode300LongestInceasingSubsequence {

    /**
     * DP
     */
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        int res = 0;
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    /**
     * 贪心+二分法
     * */
    private static int peek() {
        return tail.get(tail.size() - 1);
    }

    private static ArrayList<Integer> tail;

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int last = nums[0];
        int max = 1;

        tail = new ArrayList<Integer>(len);
        tail.add(nums[0]);

        for (int i = 1; i < len; ++i) {
            if (nums[i] > peek())
                tail.add(nums[i]);
            else {
                int l = 0, r = tail.size() - 1, mid = 0;
                while (l <= r) {
                    mid = l + ((r - l) >> 1);
                    if (nums[i] > tail.get(mid))
                        l = mid + 1;

                    else if (nums[i] < tail.get(mid))
                        r = mid - 1;
                    else {
                        l = mid;
                        break;
                    }
                }
                tail.set(l, nums[i]);
            }
            System.out.println(tail);
        }

        return tail.size();
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 0, 1};
        lengthOfLIS(arr);
    }

}
