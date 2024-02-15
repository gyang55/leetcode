package LeetCode.dynamic;

import java.util.Arrays;

public class Leetcode213Roberr2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), myRob(Arrays.copyOfRange(nums, 1,nums.length)));
    }

    private int myRob(int[] nums) {
        int prePre = 0, pre = 0, tmp;
        for (int num : nums
        ) {
            tmp = pre;
            pre = Math.max(prePre + num, pre);
            prePre = tmp;
        }
        return pre;
    }
}
