package LeetCode.backtracking;

public class JZ42 {
//    输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//    要求时间复杂度为O(n)。


    /**
     * 思路：：前一个点总和如果为负数，则对当前连续区间有负影响，则只取当前数
     * 如果前一个数的总和为正，则连续加下去。
     * 遍历一遍数组后，则有连续最大值
     */
    public int maxSubArray(int[] nums) {
        int total = 0, max = Integer.MIN_VALUE;
        for (int n : nums
        ) {
            total = total > 0 ? total + n : n;
            max = Math.max(max, total);
        }
        return max;
    }
}
